package com.ojha.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {

    private PostgresConnectionDetails postgresConnectionDetails;

    @JsonProperty
    public void setPostgresConnectionDetails(PostgresConnectionDetails postgresConnectionDetails) {
        this.postgresConnectionDetails = postgresConnectionDetails;
    }

    @JsonProperty
    public PostgresConnectionDetails getPostgresConnectionDetails() {
        return postgresConnectionDetails;
    }
}
