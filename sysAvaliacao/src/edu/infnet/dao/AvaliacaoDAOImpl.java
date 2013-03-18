package edu.infnet.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.infnet.model.Avaliacao;
import edu.infnet.model.Turma;
import edu.infnet.model.Usuario;

public class AvaliacaoDAOImpl extends DaoGenericoImp<Avaliacao, Serializable>  implements AvaliacaoDAO {

	@Override
	public Avaliacao consultar(Integer codigo) {
		return super.pesquisarPorId(codigo);
	}

	@Override
	public void incluirAvaliacao(Avaliacao avaliacao) {
		super.salvar(avaliacao);

	}

	@Override
	public List<Avaliacao> consultarAvaliacoesAluno(Usuario aluno) {

		String sqlQuery = "from Avaliacao where fk_aluno = :aluno";
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aluno", aluno.getMatricula());
		//parameters.put("senha", usuario.getSenha());

		return super.listPesqParam(sqlQuery, parameters);
	}

	@Override
	public List<Avaliacao> consultarAvaliacoesTurma(Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Avaliacao> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
