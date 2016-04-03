app.controller('niveauController', [
		'$scope',
		'NiveauService',
		'FormationDService',
		'$http',
		'$q',
		function($scope, NiveauService, FormationDService, $http,$q) {
			var self = this;
			self.niveau = {
				idNiveau : '',
				nomNiveau : '',
				labelNiveau : '',
				prix : '',
				formations:[]
			};
			self.niveaushow = {
				idNiveau : '',
				nomNiveau : '',
				labelNiveau : '',
				prix : '',
				formations:[]
			};
			self.niveaux = [];
			self.formations = [];
			self.formation = {
				idFormation : null,
				nomFormation : ''
			};
			self.idformation = '';
			self.nformation = '';
			self.idniveau='';
			$scope.showMe = false;

			self.fetchAllFormations = function() {
				FormationDService.fetchAllFormations().then(function(d) {
					self.formations = d;

					console.error('formation a inserer:' + self.formations);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.getOneNiveau = function(id) {
				NiveauService.getOneNiveau(id).then(function(d) {
					self.niveaushow = d;
					console.log(self.niveaushow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllNiveaux = function() {
				NiveauService.fetchAllNiveaux().then(function(d) {
					self.niveaux = d;

				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createNiveau = function() {
				NiveauService.createNiveau(self.niveau)
				.then(
						function(d) {
							self.niveau = d;
			                console.log(' id de formation a ajouter:'+ self.idformation+' au niveau '+self.niveau.idNiveau);
			                self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
						
						}, function(errResponse) {
							console.error('Error while creating niveau.');
						});
			};
//				*
//				  
//				NiveauService.createNiveau(self.niveau).then(
//						function(response) {
//							self.niveau = response.data;
//							self.fetchAllNiveaux();
//						}, function(errResponse) {
//							console.error('Error while creating niveau.');
//						});
		

			self.updateNiveau = function(niveau, id) {
				NiveauService.updateNiveau(niveau, id).then(
						self.fetchAllNiveaux, function(errResponse) {
							console.error('Error while updating niveau.');
						});
			};

			self.deleteNiveau = function(id) {
				NiveauService.deleteNiveau(id).then(self.fetchAllNiveaux,
						function(errResponse) {
							console.error('Error while deleting niveau.');
						});
			};

			self.addFornationToNiveau = function(idF, idN) {
				NiveauService.addFormationToNiveau(idF, idN).then(function(d) {
					self.fetchAllNiveaux(); 
					self.reset();
				},function(errResponse) {
							console.error('Error while adding formation.');
						});
			};

			self.update = function() {
				console.log('updating d\'un niveau' + self.niveau.idNiveau);
				self.updateNiveau(self.niveau, self.niveau.idNiveau);
				
				self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
				self.fetchAllNiveaux();
				self.fetchAllFormations();
				self.reset();
			};
			
	
			
			self.add = function() {
				self.createNiveau(self.niveau);
				self.reset();
			};

			self.edit = function(id) {
				for (var i = 0; i < self.niveaux.length; i++) {
					if (self.niveaux[i].idNiveau == id) {
						self.niveau = angular.copy(self.niveaux[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteNiveau(id);
			};

			self.show = function(id) {
				self.getOneNiveau(id);
				$scope.showMe = !$scope.showMe;

			};

			self.reset = function() {
				self.niveau = {
					idNiveau : null,
					nomNiveau : '',
					labelNiveau : '',
					prix : '',
					
				};
				self.formation = {
					idFormation : null,
					nomFormation : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllNiveaux();
			self.fetchAllFormations();
		} ]);