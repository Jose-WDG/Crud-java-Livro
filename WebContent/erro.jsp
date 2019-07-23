<%@page import="br.com.caelum.agenda.Dao.DaoContato"%>
<%@page import="java.util.*"%>
<%@page import="br.com.caelum.agenda.entidades.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro!</title>
<link rel="stylesheet" type="text/css"
	href="./style/bootstrap/bootstrap.min.css">
<style>
h1 {
	border-bottom: solid 7px #000;
	text-align: center;
	margin-top: 10%;
}
</style>
</head>
<body>
<div class="container-fluid">
<jstl:if test="mensagemErro">
	<div class="alert alert-danger" role="alert">${mensagemErro}</div>
</jstl:if>
	<h1>ERRO !!!</h1>
</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>