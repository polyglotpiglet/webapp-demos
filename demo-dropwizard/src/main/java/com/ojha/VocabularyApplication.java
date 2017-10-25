package com.ojha;


import com.ojha.configuration.AppConfiguration;
import com.ojha.configuration.PostgresConnectionDetails;
import com.ojha.providers.FrenchVocabularyProvider;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGSimpleDataSource;

import static com.ojha.db.DataSourceProvider.createDataSourceWithConfig;

public class VocabularyApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new VocabularyApplication().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {

        PostgresConnectionDetails postgresConnectionDetails = configuration.getPostgresConnectionDetails();
        PGSimpleDataSource dataSource = createDataSourceWithConfig(postgresConnectionDetails);

        migratePostgres(postgresConnectionDetails);

        final VocabularyResource resource = new VocabularyResource(new FrenchVocabularyProvider(dataSource));
        environment.jersey().register(resource);

    }

    private void migratePostgres(PostgresConnectionDetails postgresConnectionDetails) {
        Flyway flyway = new Flyway();
        String url = String.format("jdbc:postgresql://%s:%d/%s",
                postgresConnectionDetails.getHost(),
                postgresConnectionDetails.getPort(),
                postgresConnectionDetails.getDbName());
        flyway.setDataSource(url, postgresConnectionDetails.getUser(), null);
        flyway.migrate();
    }


}
