package View;

import DAO.LeitorDAO;
import Model.Leitor;

import java.util.List;

public class TelaListarLeitores extends TelaListagem<Leitor> {

    public TelaListarLeitores(GerenciadorDeTelas gerenciador) {
        super(gerenciador);
    }

    @Override
    protected String getTitle() {
        return "Leitores";
    }

    @Override
    protected String[] getColunas() {
        return new String[]{"CPF", "Nome", "Endereço", "Email", "Data de Nascimento", "Telefone"};
    }

    @Override
    protected List<Leitor> listarItens() {
        return new LeitorDAO().listarLeitores();
    }

    @Override
    protected void preencherDados(String[] dados, Leitor leitor) {
        dados[0] = leitor.getCpf();
        dados[1] = leitor.getNome();
        dados[2] = leitor.getEndereco();
        dados[3] = leitor.getEmail();
        dados[4] = leitor.getDataNascimento();
        dados[5] = leitor.getTelefone();
    }
}