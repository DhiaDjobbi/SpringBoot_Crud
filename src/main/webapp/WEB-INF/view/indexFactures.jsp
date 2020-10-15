<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script type="text/javascript"src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Liste Factures</title>
	</head>
	<body>
		<div class="container">
			<div class="card">
			<div class="card-header">
				Liste des Factures
			</div>
			<div class="card-body">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nom Societe</th>
						<th>Montant</th>
						<th>Date Expiration</th>
						<th>Suppression</th>
						<th>Edition</th>
					</tr>
			
			
			         <c:forEach items="${facts}" var="f">
			           <tr>
			              <td>${f.idFacture }</td>
			              <td>${f.nomSociete }</td>
			              <td>${f.getMontant() }</td>
			              <td><fmt:formatDate pattern="dd/MM/yyyy" value="${f.dateExpiration}" /></td>
			              <td><a onclick="return confirm('Etes-vous sûr ?')" class="btn btn-danger"  href="delete?id=${f.idFacture }">Supprimer</a></td>
			              <td><a class="btn btn-secondary" href="edit?id=${f.idFacture }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
			<a href="new" class="btn btn-info" >Liste des Factures</a>
		</div>
	</body>
</html>

