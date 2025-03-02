package Service;

import DAO.LeitorDAO;
import Model.Leitor;

public class LeitorService {
    private LeitorDAO leitorDAO;

    public LeitorService(LeitorDAO leitorDAO) {
        this.leitorDAO = leitorDAO;
    }

    //outros méodos
}
