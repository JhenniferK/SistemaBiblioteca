package Service;

import DAO.LeitorDAO;
import Model.Leitor;

import java.util.List;

public class LeitorService {
    private LeitorDAO leitorDAO;

    public LeitorService() {
        this.leitorDAO = new LeitorDAO();
    }

    public Leitor buscarLeitor(String cpf) {
        return leitorDAO.buscar(cpf);
    }

    public List<Leitor> listarLeitores() {
        return leitorDAO.listarLeitores();
    }
}