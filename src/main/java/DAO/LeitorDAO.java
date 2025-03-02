package DAO;

import Model.Leitor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorDAO {
    public Leitor buscar(String cpf) {
        Leitor leitor = null;
        String query = "SELECT * FROM leitor WHERE cpf = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String dataNascimento = resultSet.getString("data_nascimento");
                String telefone = resultSet.getString("telefone");
                leitor = new Leitor(cpf, nome, endereco, email, dataNascimento, telefone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leitor;
    }

    public List<Leitor> listarLeitores() {
        List<Leitor> leitores = new ArrayList<>();
        String query = "SELECT cpf, nome, endereco, email, data_nascimento, telefone FROM leitor";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String dataNascimento = resultSet.getString("data_nascimento");
                String telefone = resultSet.getString("telefone");
                leitores.add(new Leitor(cpf, nome, endereco, email, dataNascimento, telefone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leitores;
    }
}