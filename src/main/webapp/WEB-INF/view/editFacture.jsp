<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="windows-1256">
		<title>Modifier une Facture</title>
	</head>
	<body>
		<form action="updateProduit" method="post">
			<pre>
				id : <input type="text" name="idFacture" value="${fact.idFacture}">
				nom Societe :<input type="text" name="nomSociete" value="${fact.nomSociete}">
				Montant :<input type="text" name="Montant" value="${fact.getMontant()}">
				Date Expiration :
				<fmt:formatDate pattern="yyyy-MM-dd" value="${fact.dateExpiration}" var="formatDate" />
				<input type="date" name="date" value="${formatDate}"></input>
				<input type="submit" value="Modifier">
			</pre>
		</form>
		<br/>
		<br/>
		<a href="/factures">Liste Factures</a>
	</body>
</html>