package br.com.treino.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.treino.business.ExameBusiness;
import br.com.treino.model.Exame;

public class ExameAction extends ActionSupport {
	
	private ExameBusiness exameBusiness = new ExameBusiness();
	private Exame exame = new Exame();
	private List<Exame> exames = new ArrayList<>();
	private String parametro = null;
	
	public String listar() {
		exames.addAll(exameBusiness.listarExames());
		return "listar";
	}
	
	public String salvar() {
		
		try {
			exameBusiness.salvarAgendamento(exame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String alterar() {
		this.exame = exameBusiness.carregarDados(exame.getCodAgendamento());
		return "alterar";
	}
	
	public String deletar() {
		exameBusiness.excluirExame(exame.getCodAgendamento());
		return SUCCESS;
	} 
	
	public String procurar() {
		exames.addAll(exameBusiness.pesquisar(getParametro()));
		return "pesquisar";
	}
	
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public ExameBusiness getExameBusiness() {
		return exameBusiness;
	}

	public void setExameBusiness(ExameBusiness exameBusiness) {
		this.exameBusiness = exameBusiness;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
}
