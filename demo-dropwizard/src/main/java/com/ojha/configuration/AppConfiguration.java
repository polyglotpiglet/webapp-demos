package com.ojha.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {

    private DataSourceFactory dataSource;

    @JsonProperty
    public void setDataSource(DataSourceFactory dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty
    public DataSourceFactory getDataSource() {
        return dataSource;
    }
}
