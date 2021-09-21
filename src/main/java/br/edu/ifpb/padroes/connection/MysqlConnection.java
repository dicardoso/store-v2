package br.edu.ifpb.padroes.connection;

import br.edu.ifpb.padroes.configuration.ApplicationConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection implements DatabaseConnection {

    Connection jdbcConnection;

    ApplicationConfiguration applicationConfiguration;

    public MysqlConnection() {
        applicationConfiguration = ApplicationConfiguration.getInstance();
    }

    @Override
    public void connect() {
        try {
            // db parameters

            String host = applicationConfiguration.getProperties().get("mysql.database.host");
            String database = applicationConfiguration.getProperties().get("mysql.database.database");
            String username = applicationConfiguration.getProperties().get("mysql.database.username");
            String password = applicationConfiguration.getProperties().get("mysql.database.password");
            String url = String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s", host, database, username, password);
            jdbcConnection = DriverManager.getConnection(url);

            System.out.println("Connection to Mysql has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (jdbcConnection != null) {
                    jdbcConnection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public Connection sqlConnection() {
        return jdbcConnection;
    }
}
