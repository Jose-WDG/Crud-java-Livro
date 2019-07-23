<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar contato</title>
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

		<form action="${pageContext.request.contextPath}/alterarContato" method="post">

			<div class="row">

				<div align="center" class="col-md-6 ">
					<h1>Alterar contato</h1>
					<div class="formNewContato">
						<div class="form-group">
							<input type="text" name="nome" class="form-control"
								placeholder="Seu Nome *" value="${contato.getNome()}" />
						</div>
						<div class="form-group">
							<input type="text" name="email" class="form-control"
								placeholder="Seu Email *" value="${contato.getEmail()}" />
						</div>
						<div class="form-group">
							<input type="text" name="endereco" class="form-control"
								placeholder="Seu endereço*" value="${contato.getEndereco()}" />
						</div>
						<div class="form-group">
							dd-mm-yyyy
							<input type="text" name="dataNascimento" class="form-control" value="${contato.getDataNascimento()}"  required pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"/>
						</div>
						
						<input type="hidden" name="id" value="${contato.getId() }">
						<button type="submit" class="btnContactSubmit">Enviar</button>
					</div>
				</div>

				<div class="col-md-6">	</div>
	</div>

	</form>
	</div>
</body>
</html>