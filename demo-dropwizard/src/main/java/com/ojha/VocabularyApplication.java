package com.ojha;


import com.ojha.configuration.AppConfiguration;
import com.ojha.configuration.DataSourceFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.flywaydb.core.Flyway;

public class VocabularyApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new VocabularyApplication().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        final VocabularyResource resource = new VocabularyResource();
        environment.jersey().register(resource);
        DataSourceFactory dataSourceFactory = configuration.getDataSource();
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSourceFactory.getUrl(), dataSourceFactory.getUser(), dataSourceFactory.getPassword());
        flyway.migrate();

    }
}
