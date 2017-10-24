package com.ojha;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {

    private String dbName;

    @JsonProperty
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @JsonProperty
    public String getDbName() {
        return dbName;
    }
}
