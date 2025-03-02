package Controller;

import Model.Leitor;
import Service.LeitorService;

import java.util.List;

public class LeitorController {
    private LeitorService leitorService;

    public LeitorController() {
        this.leitorService = new LeitorService();
    }

    public Leitor buscarLeitor(String cpf) {
        return leitorService.buscarLeitor(cpf);
    }

    public List<Leitor> listarLeitores() {
        return leitorService.listarLeitores();
    }
}