package br.edu.ifpb.padroes.connection;

import java.sql.Connection;

public interface DatabaseConnection {

    public void connect();

    public Connection sqlConnection();

}
