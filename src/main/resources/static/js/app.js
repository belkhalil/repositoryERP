//
//
//var app=angular.module("MyApp",[]);
//app.controller("StudentController",function($scope,$http){
//	$scope.nom = '';
//	$scope.prenom = '';
//	$scope.cin = '';
//	$scope.cne = '';
//	$scope.nom = '';
//	$scope.adresse = '';
//	$scope.email = '';
//	$scope.passw2 = '';
//	$scope.etudiants=[];
//	
//	$http.get("/students").success(function(data){
//		$scope.etudiants=data;
//	});
//	
//	$scope.edit = true;
//	$scope.error = false;
//	$scope.incomplete = false; 
//	$scope.hideform = true; 
//	
//	$scope.editEtudiant = function(id) {
//		  $scope.hideform = false;
//		  if (id == 'new') {
//		    $scope.edit = true;
//		    $scope.incomplete = true;
//		    $scope.cin = '';
//		    $scope.cne = '';
//		    $scope.nom = '';
//		    $scope.prenom = '';
//		    $scope.adresse = '';
//		    $scope.email = '';
//		    } else {
//		    $scope.edit = false;
//		    $scope.fName = $scope.users[id-1].fName;
//		    $scope.lName = $scope.users[id-1].lName; 
//		  }
//		};
//});
