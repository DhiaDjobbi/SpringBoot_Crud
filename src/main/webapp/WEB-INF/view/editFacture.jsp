<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
	<title>Modifier une Facture</title>
</head>
	<body>
		<form action="updateFacture" method="post">
			<div class="container">
				<div class="card-body">
					<form action="updateProduit" method="post">
						<div class="form-group">
							<label class="control-label">ID Facture :</label>
							<input type="text" name="idFacture" value="${fact.idFacture}" readonly class="form-control"/>
						</div>
						
						<div class="form-group">
							<label class="control-label">Nom Societet :</label>
							<input type="text" name="nomSociete" value="${fact.nomSociete}" class="form-control"/>
						</div>
				
						<div class="form-group">
							<label class="control-label">Montant :</label>
							<input type="text" ame="Montant" value="${fact.getMontant()}" class="form-control"/>
						</div>
						
						<div class="form-group">
							<label class="control-label"> Date Expiration : :</label>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${fact.dateExpiration}" var="formatDate" />
							<input type="date" name="date" value="${formatDate}" class="formcontrol"/>
						</div>
						
						<div>
							<button type="submit" class="btn btn-primary">Modifier</button>
						</div>
			</form>
		</div>
	<br/>
	<br/>
<a href="/factures" class="btn btn-success" >Liste Factures</a>
</div>
</body>
</html>