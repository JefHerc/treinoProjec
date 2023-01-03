package br.com.treino.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame {

	private Integer codAgendamento;
	private String paciente;
	private String exame;
	private Date dataExame;
	private String observacaoResultado;
	
	public Exame() {
		super();
	}
	
	public Exame(Integer codAgendamento, String paciente, String exame, Date dataExame, String observacaoResultado) {
		super();
		this.codAgendamento = codAgendamento;
		this.paciente = paciente;
		this.exame = exame;
		this.dataExame = dataExame;
		this.observacaoResultado = observacaoResultado;
	}
	
	public Integer getCodAgendamento() {
		return codAgendamento;
	}
	public void setCodAgendamento(Integer codAgendamento) {
		this.codAgendamento = codAgendamento;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getExame() {
		return exame;
	}
	public void setExame(String exame) {
		this.exame = exame;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public String getObservacaoResultado() {
		return observacaoResultado;
	}
	public void setObservacaoResultado(String observacaoResultado) {
		this.observacaoResultado = observacaoResultado;
	}
	
	public String getDataFormatada() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(getDataExame());
	}
	
	@Override
	public String toString() {
		return "Exame [codAgendamento=" + codAgendamento + ", paciente=" + paciente + ", exame=" + exame
				+ ", dataExame=" + dataExame + ", observacaoResultado=" + observacaoResultado + "]";
	}
}
