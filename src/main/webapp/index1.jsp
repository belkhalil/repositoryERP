<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body   ng-app="MyApp" ng-controller="EtudiantController as ctrl">
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">ajouter un etudiant </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.etudiant.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="cin">cin</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.etudiant.cin" id="cin"
									class=" form-control input-sm" placeholder=" cin"
									required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.cin.$error.required">This is a
										required field</span> <span ng-show="myForm.cin.$error.minlength">Minimum
										length required is 3</span> <span ng-show="myForm.cin.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="cne">cne</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.etudiant.cne" id="cne"
									class="form-control input-sm" placeholder="cne" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="nom">Nom</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.etudiant.nom" id="nom"
									class="form-control input-sm" placeholder="Nom" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="address">Prenom</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.etudiant.prenom" id="prenom"
									class="form-control input-sm" placeholder="prenom" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.etudiant.email" id="email"
									class="email form-control input-sm" placeholder=" Email"
									required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="adresse">Adresse</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.etudiant.adresse"
									id="adresse" class="email form-control input-sm"
									placeholder="adresse" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.adresse.$error.required">This is a
										required field</span> <span ng-show="myForm.adresse.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.etudiant.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>CIN</th>
							<th>CNE</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Address</th>
							<th>Email</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="e in ctrl.etudiants">
							<td>{{e.cinUtilisateur}}</td>
							<td>{{e.cne}}</td>
							<td>{{e.nonUtilisateur}}</td>
							<td>{{e.prenomUtilisateur}}</td>
							<td>{{e.emailUtilisateur}}</td>
							<td>{{e.adresseUtilisateur}}</td>
							<td>
								<button type="button" ng-click="ctrl.edit(e.idUtilisateur)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(e.idUtilisateur)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/EtudiantController.js' />"></script>
	
</body>
</html>