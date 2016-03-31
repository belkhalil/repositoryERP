
app.controller('niveauController', ['$scope', 'NiveauService','FormationDService', function($scope, NiveauService,FormationDService) {
    var self = this;
    self.niveau={idNiveau:null,nomNiveau:'',labelNiveau:''};
    self.niveaushow={idNiveau:null,nomNiveau:'',labelNiveau:''};
    self.niveaux=[];
    self.formations=[];
    self.formation={idFormation:null,nomFormation:''};
    $scope.showMe = false;
    
    
    self.fetchAllFormations = function(){
    	FormationDService.fetchAllFormations()
            .then(
                         function(d) {
                              self.formations = d;
                              
                              console.error('formation a inserer:'+ self.formations); 
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
    self.getOneNiveau = function(id){
    	NiveauService.getOneNiveau(id)
    	 .then(
                function(d) {
                     self.niveaushow = d;
                     console.log(self.niveaushow);
                },
                 function(errResponse){
                     console.error('Error while fetching Currencies');
                 }
        );
    };
    
    self.fetchAllNiveaux = function(){
    	NiveauService.fetchAllNiveaux()
            .then(
                         function(d) {
                              self.niveaux = d;
                              
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
     
      
    self.createNiveau = function(){
    	NiveauService.createNiveau(self.niveau)
                .then(
                self.fetchAllNiveaux, 
                        function(errResponse){
                             console.error('Error while creating User.');
                        } 
            );
    };

   self.updateNiveau = function(niveau, id){
	   NiveauService.updateNiveau(niveau, id)
                .then(
                        self.fetchAllNiveaux, 
                        function(errResponse){
                             console.error('Error while updating niveau.');
                        } 
            );
    };

   self.deleteNiveau = function(id){
	   NiveauService.deleteNiveau(id)
                .then(
                        self.fetchAllNiveaux, 
                        function(errResponse){
                             console.error('Error while deleting niveau.');
                        } 
            );
    };

    self.addFornationToNiveau= function(idN,idN)
    {
    	NiveauService.addFormationToNiveau(idN,idF)
    	.then(
    			self.fetchAllNiveaux, 
    			function(errResponse){
                    console.error('Error while deleting niveau.');
               }
    			);
    	
    };
    
   
   self.fetchAllFormations();
   self.fetchAllNiveaux();
    self.update = function(){
    	console.log('updating d\'un niveau'+self.niveau.idNiveau);
    	self.updateNiveau(self.niveau, self.niveau.idNiveau);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.niveau.idNiveau===null){
            console.log('Saving New niveau', self.niveau);
            
           self.createNiveau(self.niveau);
           self.addFornationToNiveau(self.niveau.idNiveau,$scope.selectedformation.idFormation); 
           
        }else{
            self.updateNiveau(self.niveau, self.niveau.idNiveau);
            console.log('niveau updated with id ', self.niveau.idNiveau);
        }
        self.reset();
    };
    
         
    self.edit = function(id){
        for(var i = 0; i < self.niveaux.length; i++){
            if(self.niveaux[i].idNiveau == id) {
               self.niveau = angular.copy(self.niveaux[i]);
               break;
            }
        }
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        self.deleteNiveau(id);
    };

     self.show=function(id){
    	 self.getOneNiveau(id);
    	 $scope.showMe = !$scope.showMe;
     };
     
    self.reset = function(){
        self.niveau={idNiveau:null,nomNiveau:'',labelNiveau:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);