<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="exame.codAgendamento != null">
	<s:set var="title" value="%{'Alterar Exame'}" />
</s:if>
<s:else>
	<s:set var="title" value="%{'Adicionar novo Exame'}" />
</s:else>
<!DOCTYPE html>
<html lang="pt-BR">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>
			<s:property value="#title" />
		</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="css/main.css">
	</head>

	<body>
		<div class="container">
			<h1 class="title">
				<s:property value="#title" />
			</h1>

			<form action="salvarExame" onsubmit="return validarForm()" class="needs-validation" novalidate>
				<s:if test="exame.codAgendamento != null">
					<div class="mb-3">
						<label class="form-label">Código agendamento</label>
						<s:textfield class="form-control" name="exame.codAgendamento" readonly="true" />
					</div>
				</s:if>
				<div class="mb-3">
					<label class="form-label">Paciente</label>
					<s:textfield id="paciente" maxlength="60" class="form-control to-check" name="exame.paciente" />
					<div class="invalid-feedback">
						Favor preencher o nome do paciente.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Exame</label>
					<s:textfield id="exame" maxlength="50" class="form-control to-check" name="exame.exame" />
					<div class="invalid-feedback">
						Favor preencher o nome do exame.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Data</label>
					<s:if test="exame.codAgendamento == null">
						<s:textfield type="date" maxlength="10" class="form-control to-check" id="data-exame"
						name="exame.dataExame" />
					</s:if>
					<s:else>
						<s:textfield type="date" maxlength="10" class="form-control to-check" id="data-exame"
						name="exame.dataExame" value="%{exame.dataFormatadaENG}"/>
					</s:else>
					<div class="invalid-feedback">
						A data deve ser maior que a data atual.
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label">Observação / Resultado:</label>
					<s:textarea maxlength="250" class="form-control" rows="10" cols="30" name="exame.observacaoResultado" />
				</div>
				<a class="btn btn-primary" href="listarExame">
					<i class="bi bi-arrow-return-left"></i> Exames
				</a>
				<button class="btn btn-success" type="submit" id="salvar-exame">
					<i class="bi bi-save"></i> Salvar
				</button>
			</form>
		</div>

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
	</body>
</html>