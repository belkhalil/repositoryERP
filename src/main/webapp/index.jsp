<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body ng-app="myApp" ng-controller="MyController">
		<table class="w3-table w3-bordered w3-striped w3-card-4">
			<tr class="w3-blue">
				<th>CIN</th>
				<th>CNE</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date naissance</th>
				<th>Email</th>
			</tr>
			<tr ng-repeat="e in etudiants">
				<td>{{e.cinUtilisateur}}</td>
				<td>{{e.cne}}</td>
				<td>{{e.nonUtilisateur}}</td>
				<td>{{e.prenomUtilisateur}}</td>
				<td>{{e.dateNaissance}}</td>
				<td>{{e.emailUtilisateur}}</td>

				<td><a th:href="${'/student/' + student.idUtilisateur}">View</a></td>
				<td><a th:href="${'/student/edit/' + student.idUtilisateur}">Edit</a></td>
				<td><a th:href="${'/student/delete/' + student.idUtilisateur}">Delete</a></td>
			</tr>
		</table>
</div>
<script type="text/javascript" src="js/app.js"></script>

</body>

</body>
</html>