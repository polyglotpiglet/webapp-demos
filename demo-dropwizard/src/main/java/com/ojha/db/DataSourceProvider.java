package com.ojha.db;

import com.ojha.configuration.PostgresConnectionDetails;
import org.postgresql.ds.PGSimpleDataSource;

public class DataSourceProvider {

    public static PGSimpleDataSource createDataSourceWithConfig(PostgresConnectionDetails dataConnectionDetails) {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setServerName(dataConnectionDetails.getHost());
        dataSource.setPortNumber(dataConnectionDetails.getPort());
        dataSource.setDatabaseName(dataConnectionDetails.getDbName());
        dataSource.setUser(dataConnectionDetails.getUser());

        return dataSource;
    }

}
