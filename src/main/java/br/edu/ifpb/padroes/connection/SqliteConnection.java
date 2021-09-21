package br.edu.ifpb.padroes.connection;

import br.edu.ifpb.padroes.configuration.ApplicationConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection implements DatabaseConnection {

    Connection jdbcConnection;

    ApplicationConfiguration applicationConfiguration;

    public SqliteConnection() {
        applicationConfiguration = ApplicationConfiguration.getInstance();
    }

    @Override
    public void connect() {
        jdbcConnection = null;
        try {
            // db parameters
            String filePath = applicationConfiguration.getProperties().get("sqlite.database.filePath");
            String url = String.format("jdbc:sqlite:%s", filePath);
            jdbcConnection = DriverManager.getConnection(url);

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
