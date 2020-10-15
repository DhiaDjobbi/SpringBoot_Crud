<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="windows-1256">
		<title>Créer une Facture</title>
	</head>
	<body>
		<form action="saveFacture" method="post">
			<pre>
				nom Societe : <input type="text" required name="nomSociete">
				Montant : <input type="text" required name="Montant">
				date Expiration : <input type="date" required name="date">
				<input type="submit" value="ajouter">
			</pre>
		</form>
				${msg}
				<br/>
				<br/>
			<a href="/factures">Liste des Factures</a>
	</body>
</html>