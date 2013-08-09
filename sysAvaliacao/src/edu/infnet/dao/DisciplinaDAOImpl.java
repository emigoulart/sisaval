package edu.infnet.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.infnet.model.Disciplina;
import edu.infnet.model.Usuario;

public class DisciplinaDAOImpl extends DaoGenericoImp<Disciplina,Serializable> implements DisciplinaDAO {

	private static final long serialVersionUID = 1L;

	//private static final Logger log = Logger.getLogger(DisciplinaDAOImpl.class);
			
	@Override
	public Disciplina consultar(Integer codigo) {
		return null;
	}

	@Override
	public Disciplina atualizar(Disciplina disiciplina) {
		return super.atualizar(disiciplina);
	}

	@Override
	public void inserir(Disciplina disiciplina) {
		super.salvar(disiciplina);
	}

	@Override
	public void excluir(Disciplina disiciplina) {
		super.excluir(disiciplina);

	}

	@Override
	public Disciplina consultarPorNome(String nome) {
		return new Disciplina();
	}

	@Override
	public List<Disciplina> listar() {	
		return super.todos();
	}
	
	@Override
	public List<Disciplina> listarDisciplinasPorAluno(Usuario aluno) {
		List<Disciplina> disciplinas= new ArrayList<Disciplina>();
		
		String sqlQuery = "from Disciplina as disc where "
				+ " disc.disId not in ( select a.disciplina.disId from Avaliacao a where a.aluno.matricula = :aluno )";
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aluno", aluno.getMatricula());
	
		 if(!super.listPesqParam(sqlQuery, parameters).isEmpty()){
			 disciplinas= super.listPesqParam(sqlQuery, parameters);
		 }
		 return disciplinas;
	}

}	