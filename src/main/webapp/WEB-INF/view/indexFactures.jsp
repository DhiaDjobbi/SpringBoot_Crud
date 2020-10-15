<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Liste Factures</title>
	</head>
	<body>
		<h1>Liste des Factures</h1>
		<table >
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
              <td><a onclick="return confirm('Etes-vous sûr ?')" href="delete?id=${f.idFacture }">Supprimer</a></td>
               <td><a href="edit?id=${f.idFacture }">Edit</a></td>
           </tr>
         </c:forEach>  
         
         			
			
		</table>
	</body>
</html>