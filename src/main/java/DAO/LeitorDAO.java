package DAO;

import Model.Leitor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorDAO {
    private Connection connection;
    public List<Leitor> listarLeitores() {
        List<Leitor> leitores = new ArrayList<Leitor>();
        String query = "SELECT cpf, nome FROM leitor";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                leitores.add(new Leitor(cpf, nome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return leitores;
    }

    public static void main(String[] args) {
        LeitorDAO leitorDAO = new LeitorDAO();
        List<Leitor> leitores = leitorDAO.listarLeitores();

        for (Leitor leitor : leitores) {
            System.out.println(leitor);
        }
    }

    //criar outros métodos (buscar, atualizar, remover)
}
