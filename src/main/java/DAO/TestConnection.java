package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Conexão com o DB bem-sucedida!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o DB: " + e.getMessage());
        }
    }
}
