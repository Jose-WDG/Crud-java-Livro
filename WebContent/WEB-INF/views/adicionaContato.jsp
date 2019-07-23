<%@page import="br.com.caelum.agenda.Dao.DaoContato"%>
<%@page import="java.util.*"%>
<%@page import="br.com.caelum.agenda.entidades.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Agenda - Adicionar novo contato</title>
<link rel="stylesheet" type="text/css"
	href="./style/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<div class="container-fluid contact-form">
		<div class="contact-image">
			<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
				alt="rocket_contact" />
		</div>
		<jstl:if test="mensagemErro != NULL">
			<div class="alert alert-danger" role="alert">${mensagemErro}</div>
		</jstl:if>
		<jstl:if test="messageSusses != NULL">
			<div class="alert alert-success" role="alert">${messageSusses }</div>
		</jstl:if>
		<form action="http://localhost:8080/AgendaCaelum/AdicionarContato"
			method="post">

			<div class="row">

				<div class="col-md-4 ">
					<h1>Novo contato</h1>
					<div class="formNewContato">
						<div class="form-group">
							<input type="text" name="nome" class="form-control"
								placeholder="Seu Nome *" value="" />
						</div>
						<div class="form-group">
							<input type="text" name="email" class="form-control"
								placeholder="Seu Email *" value="" />
						</div>
						<div class="form-group">
							<input type="text" name="endereco" class="form-control"
								placeholder="Seu endereço*" value="" />
						</div>
						<div class="form-group">
							<input type="date" name="dataNascimento" class="form-control" />
						</div>
						<button type="submit" class="btnContactSubmit">Enviar</button>
					</div>
				</div>

				<div class="col-md-8">
					<h1>Contatos</h1>
			
				<table class="table table-striped"  style="display: block;overflow-y: scroll;height: 30%;width: 1050px;">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">Nome</th>
								<th scope="col">Email</th>
								<th scope="col">Endereço</th>
								<th scope="col">Data de nascimento</th>
								<th scope="col">Ações</th>
							</tr>
						</thead>
						<tbody>

							<jstl:forEach items="${listaContatos}" var="contato">
								<tr>
									<th scope="row">${ contato.getId() }</th>
									<td>${ contato.getNome() }</td>
									<td>${ contato.getEmail() }</td>
									<td>${ contato.getEndereco() }</td>
									<td>${ contato.getDataNascimento() }</td>
									<td><a
										href="${pageContext.request.contextPath}/alterarContato?id=${contato.getId() }">Editar</a>
										<a
										href="${pageContext.request.contextPath}/excluirContato?id=${contato.getId() }">Deletar</a>
								</tr>
							</jstl:forEach>
						</tbody>
					</table>
			</div>
	</div>

	</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>