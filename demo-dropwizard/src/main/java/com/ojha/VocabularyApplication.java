package com.ojha;


import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class VocabularyApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new VocabularyApplication().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        final VocabularyResource resource = new VocabularyResource();
        environment.jersey().register(resource);
    }
}
