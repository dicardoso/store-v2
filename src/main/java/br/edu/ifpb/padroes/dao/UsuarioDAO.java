package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.configuration.ApplicationConfiguration;
import br.edu.ifpb.padroes.connection.ConnectionFactory;
import br.edu.ifpb.padroes.connection.MysqlConnectionFactory;
import br.edu.ifpb.padroes.connection.SqliteConnectionFactory;
import br.edu.ifpb.padroes.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    ConnectionFactory connectionFactory;

    ApplicationConfiguration applicationConfiguration;

    public UsuarioDAO() {
        String database = applicationConfiguration.getProperties().get("database.active");
        if (database.equals("sqlite")) {
            connectionFactory = new SqliteConnectionFactory();
        } else if (database.equals("mysql")) {
            connectionFactory = new MysqlConnectionFactory();
        }
    }

    public void cadastrarEndereco(Endereco endereco) {
        connectionFactory.getConnection().connect();
        Connection connection = connectionFactory.getConnection().sqlConnection();
        try {
            // Roda SQL para cadastrar endereços...
            PreparedStatement st = connection.prepareStatement("INSERT INTO endereco VALUES (?, ?, ?, ?, ?)");
            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getCidade().getNome());
            st.setString(3, endereco.getEstado().getSigla());
            st.setString(4, endereco.getPais().getNome());
            st.setString(5, endereco.getComplemento());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
