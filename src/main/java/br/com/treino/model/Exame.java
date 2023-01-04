package br.com.treino.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exame {

	private Integer codAgendamento;
	private String paciente;
	private String exame;
	private LocalDate dataExame;
	private String observacaoResultado;
	
	public Exame() {
		super();
	}
	
	public Exame(Integer codAgendamento, String paciente, String exame, LocalDate dataExame, String observacaoResultado) {
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
	public LocalDate getDataExame() {
		return dataExame;
	}
	public void setDataExame(LocalDate dataExame) {
		this.dataExame = dataExame;
	}
	public String getObservacaoResultado() {
		return observacaoResultado;
	}
	public void setObservacaoResultado(String observacaoResultado) {
		this.observacaoResultado = observacaoResultado;
	}
	
	 public String getDataFormatadaBR() {
	    	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        return formatador.format(getDataExame());
	    }

	
	@Override
	public String toString() {
		return "Exame [codAgendamento=" + codAgendamento + ", paciente=" + paciente + ", exame=" + exame
				+ ", dataExame=" + dataExame + ", observacaoResultado=" + observacaoResultado + "]";
	}
}
