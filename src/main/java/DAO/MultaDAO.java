package DAO;

import Model.Multa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MultaDAO {
    public Multa buscar(int id) {
        Multa multa = null;
        String query = "SELECT * FROM multa WHERE id_multa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idEmprestimo = resultSet.getInt("id_emprestimo");
                String motivo = resultSet.getString("motivo_multa");
                double valor = resultSet.getDouble("valor_multa");
                String status = resultSet.getString("status_multa");
                multa = new Multa();
                multa.setId(id);
                multa.setIdEmprestimo(idEmprestimo);
                multa.setValor(valor);
                multa.setMotivo(motivo);
                multa.setStatus(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return multa;
    }

    public List<Multa> listarMultas() {
        List<Multa> multas = new ArrayList<>();
        String query = "SELECT id_multa, id_emprestimo, motivo_multa, valor_multa, status_multa FROM multa";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_multa");
                int idEmprestimo = resultSet.getInt("id_emprestimo");
                String motivo = resultSet.getString("motivo_multa");
                double valor = resultSet.getDouble("valor_multa");
                String status = resultSet.getString("status_multa");
                Multa multa = new Multa();
                multa.setId(id);
                multa.setIdEmprestimo(idEmprestimo);
                multa.setValor(valor);
                multa.setMotivo(motivo);
                multa.setStatus(status);
                multas.add(multa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return multas;
    }
}