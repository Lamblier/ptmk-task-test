package ru.nonoka.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConnectionFactory {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/employees");
            config.setUsername("postgres");
            config.setPassword("postgres");

            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }
}
