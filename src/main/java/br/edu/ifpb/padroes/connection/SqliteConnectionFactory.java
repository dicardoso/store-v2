package br.edu.ifpb.padroes.connection;

public class SqliteConnectionFactory implements ConnectionFactory {
    @Override
    public DatabaseConnection getConnection() {
        return new SqliteConnection();
    }
}
