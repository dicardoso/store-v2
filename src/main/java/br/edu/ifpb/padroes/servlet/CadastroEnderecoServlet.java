package br.edu.ifpb.padroes.servlet;

import br.edu.ifpb.padroes.dao.UsuarioDAO;
import br.edu.ifpb.padroes.model.EnderecoCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/CadastroServlet"})
public class CadastroEnderecoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String rua = request.getParameter("rua");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String estadoSigla = request.getParameter("estadoSigla");
        String complemento = request.getParameter("complemento");
        String pais = request.getParameter("pais");
        String paisSigla = request.getParameter("paisSigla");

        EnderecoCreator enderecoCreator = new EnderecoCreator()
                .setRua(rua)
                .setCidade(cidade)
                .setEstado(estado, estadoSigla)
                .setComplemento(complemento)
                .setPais(pais, paisSigla);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrarEndereco(enderecoCreator.getResult());
        response.sendRedirect("RegisterSuccess.jsp");

    }
}
