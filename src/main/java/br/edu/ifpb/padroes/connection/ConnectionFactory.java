package br.edu.ifpb.padroes.connection;

import br.edu.ifpb.padroes.connection.DatabaseConnection;

public interface ConnectionFactory {
    DatabaseConnection getConnection();
}
