package com.ojha.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostgresConnectionDetails {

    private String host;
    private int port;
    private String dbName;
    private String user;
    private String password;

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty
    public String getUser() {
        return user;
    }

    @JsonProperty
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(int port) {
        this.port = port;
    }

    @JsonProperty
    public String getDbName() {
        return dbName;
    }

    @JsonProperty
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
