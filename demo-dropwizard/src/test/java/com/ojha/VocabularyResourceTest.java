package com.ojha;

import com.ojha.configuration.AppConfiguration;
import com.ojha.configuration.PostgresConnectionDetails;
import com.ojha.db.DataSourceProvider;
import com.ojha.providers.FrenchVocabularyProvider;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.Set;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;

public class VocabularyResourceTest {

    @ClassRule
    public static final DropwizardAppRule<AppConfiguration> RULE =
            new DropwizardAppRule<>(VocabularyApplication.class, resourceFilePath("config/dev.yml"));
    private FrenchVocabularyProvider provider;

    @Before
    public void setup() {
        AppConfiguration configuration = RULE.getConfiguration();
        PGSimpleDataSource dataSource = DataSourceProvider.createDataSourceWithConfig(configuration.getPostgresConnectionDetails());
        this.provider = new FrenchVocabularyProvider(dataSource);
    }

    @Test
    public void canAddAndRetrieveAVerb() {
        Verb etre = new Verb("etre");
        provider.addVerb(etre);
        Set<Verb> allVerbs = provider.getAllVerbs();
        Assertions.assertThat(allVerbs).containsExactly(etre);
    }


}