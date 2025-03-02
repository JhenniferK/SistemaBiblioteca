package Service;

import DAO.MultaDAO;
import Model.Multa;
import java.util.List;

public class MultaService {
    private MultaDAO multaDAO;

    public MultaService() {
        this.multaDAO = new MultaDAO();
    }

    public Multa buscarMulta(int id) {
        return multaDAO.buscar(id);
    }

    public List<Multa> listarMultas() {
        return multaDAO.listarMultas();
    }
}