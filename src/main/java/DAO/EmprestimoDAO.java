package DAO;

import Model.Emprestimo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    public Emprestimo buscar(int id) {
        Emprestimo emprestimo = null;
        String query = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idLivro = resultSet.getInt("id_livro");
                String idLeitor = resultSet.getString("id_leitor");
                String dataRetirada = resultSet.getString("data_retirada");
                String dataPrevDevolucao = resultSet.getString("data_prevista_devolucao");
                double valor = resultSet.getDouble("valor_emprestimo");
                String dataDevolucao = resultSet.getString("data_devo_real");
                String status = resultSet.getString("status");
                emprestimo = new Emprestimo();
                emprestimo.setId(id);
                emprestimo.setIdLivro(idLivro);
                emprestimo.setIdLeitor(idLeitor);
                emprestimo.setDataRetirada(dataRetirada);
                emprestimo.setDataPrevDevolucao(dataPrevDevolucao);
                emprestimo.setDataDevolucao(dataDevolucao);
                emprestimo.setValor(valor);
                emprestimo.setStatus(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimo;
    }

    public List<Emprestimo> listarEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String query = "SELECT id_emprestimo, id_livro, id_leitor, data_retirada, data_prevista_devolucao, valor_emprestimo, data_devo_real, status FROM emprestimo";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_emprestimo");
                int idLivro = resultSet.getInt("id_livro");
                String idLeitor = resultSet.getString("id_leitor");
                String dataRetirada = resultSet.getString("data_retirada");
                String dataPrevDevolucao = resultSet.getString("data_prevista_devolucao");
                double valor = resultSet.getDouble("valor_emprestimo");
                String dataDevolucao = resultSet.getString("data_devo_real");
                String status = resultSet.getString("status");

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(id);
                emprestimo.setIdLivro(idLivro);
                emprestimo.setIdLeitor(idLeitor);
                emprestimo.setDataRetirada(dataRetirada);
                emprestimo.setDataPrevDevolucao(dataPrevDevolucao);
                emprestimo.setDataDevolucao(dataDevolucao);
                emprestimo.setValor(valor);
                emprestimo.setStatus(status);
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emprestimos;
    }
}