package br.edu.ifpb.padroes.connection;

public class MysqlConnectionFactory implements ConnectionFactory {
    @Override
    public DatabaseConnection getConnection() {
        return new MysqlConnection();
    }
}
