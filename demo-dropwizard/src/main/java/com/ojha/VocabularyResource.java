package com.ojha;


import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/verb")
@Produces(MediaType.APPLICATION_JSON)
public class VocabularyResource {

    public VocabularyResource() {
    }

    @GET
    @Timed
    public Verb getRandomVerb() {
        return new Verb("etre");
    }
}
