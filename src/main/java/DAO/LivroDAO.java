package DAO;

import Model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public Livro buscar(int id) {
        Livro livro = null;
        String query = "SELECT * FROM livro WHERE id_livro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String autor = resultSet.getString("autor");
                String editora = resultSet.getString("editora");
                int anoPublicacao = resultSet.getInt("ano_publicacao");
                String edicao = resultSet.getString("edicao");
                int numPaginas = resultSet.getInt("numero_paginas");
                String genero = resultSet.getString("genero");
                String status = resultSet.getString("status_livro");
                livro = new Livro(id, nome, autor, editora, anoPublicacao, edicao, numPaginas, genero, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livro;
    }

    public static List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String query = "SELECT id_livro, nome, autor, editora, ano_publicacao, edicao, numero_paginas, genero, status_livro FROM livro";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_livro");
                String nome = resultSet.getString("nome");
                String autor = resultSet.getString("autor");
                String editora = resultSet.getString("editora");
                int anoPublicacao = resultSet.getInt("ano_publicacao");
                String edicao = resultSet.getString("edicao");
                int numPaginas = resultSet.getInt("numero_paginas");
                String genero = resultSet.getString("genero");
                String status = resultSet.getString("status_livro");
                livros.add(new Livro(id, nome, autor, editora, anoPublicacao, edicao, numPaginas, genero, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }
}