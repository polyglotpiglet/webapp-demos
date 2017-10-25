package com.ojha;


import com.codahale.metrics.annotation.Timed;
import com.ojha.providers.FrenchVocabularyProvider;
import com.ojha.providers.VocabularyProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/verb")
@Produces(MediaType.APPLICATION_JSON)
public class VocabularyResource {

    private VocabularyProvider vocabularyProvider;

    VocabularyResource(VocabularyProvider vocabularyProvider) {
        this.vocabularyProvider = vocabularyProvider;
    }

    @GET
    @Timed
    public Verb getRandomVerb() {
        return new Verb("etre");
    }
}
