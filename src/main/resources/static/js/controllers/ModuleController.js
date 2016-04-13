app.controller('ModuleController', [
		'$scope',
		'ModuleService',
		'SemestreService',
		'$http',
		'$q',
		function($scope, ModuleService,SemestreService, $http, $q) {
			var self = this;
			self.module = {
				idModule : null,
				nomModule : '',
				descModule : ''
			};
			self.moduleshow = {
				idModule : null,
				nomModule : '',
				descModule : ''
			};
			self.modules = [];
			self.semestres=[];
			$scope.showMe = false;
			self.idSelectedSemestre ='';
			self.getAllsemestres=function(){
            	SemestreService.fetchAllSemestre().then(function(d) {
					self.semestres = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
            }; 
			self.fetchAllModules = function() {
				ModuleService.fetchAllModules().then(function(d) {
					self.formations = d;
					console.error('modules a inserer:' + self.modules);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.getOneModule = function(id) {
				ModuleService.getOneModule(id).then(function(d) {
					self.moduleshow = d;
					console.log(self.moduleshow);
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.fetchAllModules = function() {
				ModuleService.fetchAllModules().then(function(d) {
					self.modules = d;

				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createModule = function() {
				ModuleService.createModule(self.module).then(function(d) {
					self.module = d;
					console.log(' id de module a ajouter:'+self.module.idModule +' au semestre ' +self.idSelectedSemestre);
	                self.addModuleToSemestre(self.module.idModule,self.idSelectedSemestre);
					self.fetchAllModules;

				}, function(errResponse) {
					console.error('Error while creating module.');
				});
			};

			self.updateModule = function(module, id) {
				ModuleService.updateModule(module, id).then(
						self.fetchAllModules, function(errResponse) {
							console.error('Error while updating module.');
						});
			};

			self.deleteModule = function(id) {
				ModuleService.deleteModule(id).then(self.fetchAllModules,
						function(errResponse) {
							console.error('Error while deleting module.');
						});
			};

			 self.addModuleToSemestre = function(idM, idS) {
			 ModuleService.addModuleToSemestre(idM, idS).then(function(d) {
			 self.fetchAllModules();
			 self.reset();
			 },function(errResponse) {
			 console.error('Error while adding formation.');
			 });
			 };

			self.update = function() {
				console.log('updating d\'un module' + self.module.idModule);
				self.updateModule(self.module, self.module.idModule);

				// self.addFornationToNiveau(self.idformation,self.niveau.idNiveau);
				self.fetchAllModules();
				// self.fetchAllFormations();
				self.reset();
			};

			self.add = function() {

				if (self.module.idModule === null) {

					self.createModule(self.module);

				} else {
					self.updateModule(self.module, self.module.idModule);
					console.log('formation updated with id ',
							self.module.idModule);
				}
				self.reset();

			};

			self.edit = function(id) {
				for (var i = 0; i < self.modules.length; i++) {
					if (self.modules[i].idModule == id) {
						self.module = angular.copy(self.modules[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				self.deleteModule(id);
			};

			self.show = function(id) {
				self.getOneModule(id);
				$scope.showMe = !$scope.showMe;

			};

			self.reset = function() {
				self.module = {
					idModule : null,
					nomModule : '',
					descModule : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};
			self.fetchAllModules();
			self.getAllsemestres();
		} ]);