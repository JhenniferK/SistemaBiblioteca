package View;

import DAO.MultaDAO;
import Model.Multa;

import java.util.List;

public class TelaListarMultas extends TelaListagem<Multa> {

    public TelaListarMultas(GerenciadorDeTelas gerenciador) {
        super(gerenciador);
    }

    @Override
    protected String getTitle() {
        return "Multas";
    }

    @Override
    protected String[] getColunas() {
        return new String[]{"ID da Multa", "ID do Empréstimo", "Motivo da Multa", "Valor da Multa", "Status de Pagamento"};
    }

    @Override
    protected List<Multa> listarItens() {
        return new MultaDAO().listarMultas();
    }

    @Override
    protected void preencherDados(String[] dados, Multa multa) {
        dados[0] = String.valueOf(multa.getId());
        dados[1] = String.valueOf(multa.getIdEmprestimo());
        dados[2] = multa.getMotivo();
        dados[3] = String.valueOf(multa.getValor());
        dados[4] = multa.getStatus();
    }
}