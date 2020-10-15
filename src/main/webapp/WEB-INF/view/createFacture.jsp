<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
		<c:url value="/css/main.css" var="jstlCss" />
		<link href="${jstlCss}" rel="stylesheet" />
		
		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Créer une Facture</title>
	</head>
	<body>
		<div class="container">
			<div class="card-body">
				<form action="saveFacture" method="post">
				
					<div class="form-group">
						<label class="control-label">Nom Societe :</label>
						<input type="text" class="form-control" required name="nomSociete">
					</div>
					
					<div class="form-group">
						<label class="control-label">Montant :</label>
					 	<input type="text" class="form-control" required name="Montant">
					</div>	
					
					<div class="form-group">
						<label class="control-label">Date Expiration</label>
						<input type="date"  class="form-control" required name="date">
					</div>	
							
					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
					
				</form>
				</div>
				
				<div class="alert alert-success" role="alert">
					${msg}
				</div>				
				
				<br/>
				<br/>
				
			<a href="/factures" class="btn btn-info" >Liste des Factures</a>
			</div>

	</body>
</html>