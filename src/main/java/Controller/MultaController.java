package Controller;

import Model.Multa;
import Service.MultaService;

import java.util.List;

public class MultaController {
    private MultaService multaService;

    public MultaController() {
        this.multaService = new MultaService();
    }

    public Multa buscarMulta(int id) {
        return multaService.buscarMulta(id);
    }

    public List<Multa> listarMultas() {
        return multaService.listarMultas();
    }
}
