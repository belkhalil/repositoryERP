var app=angular.module("MyApp",[]);

app.factory('EtudiantService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneStudent: function(id){
    	    	return $http.get("/getOneStudent/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
            fetchAllStudents: function() {
                    return $http.get("/students")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createStudent: function(etudiant){
                    return $http.post("/save", etudiant)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateStudent: function(etudiant, id){
                    return $http.put("/updateStudent/"+id, etudiant)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteStudent: function(id){
                    return $http.delete("/deleteStudent/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting student');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
    
   
    
 
}]);

app.controller('EtudiantController', ['$scope', 'EtudiantService', function($scope, EtudiantService) {
    var self = this;
    self.etudiant={idUtilisateur:null,cinUtilisateur:'',cne:'',nomUtilisateur:'',prenomUtilisateur:'', adresseUtilisateur:'',emailUtilisateur:''};
    self.etudiants=[];
         
    self.getOneStudent = function(id){
    	EtudiantService.getOneStudent(self.etudiant.idUtilisateur)
    	 .then(
                function(d) {
                     self.etudiant = d;
                     console.log(self.etudiant);
                },
                 function(errResponse){
                     console.error('Error while fetching Currencies');
                 }
        );
    };
    
    self.fetchAllStudents = function(){
    	EtudiantService.fetchAllStudents()
            .then(
                         function(d) {
                              self.etudiants = d;
                              
                         },
                          function(errResponse){
                              console.error('Error while fetching Currencies');
                          }
                 );
    };
    
    
      
    self.createStudent = function(){
    	EtudiantService.createStudent(self.etudiant)
                .then(
                self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while creating User.');
                        } 
            );
    };

   self.updateStudent = function(etudiant, id){
	   EtudiantService.updateStudent(etudiant, id)
                .then(
                        self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while updating User.');
                        } 
            );
    };

   self.deleteStudent = function(id){
	   EtudiantService.deleteStudent(id)
                .then(
                        self.fetchAllStudents, 
                        function(errResponse){
                             console.error('Error while deleting student.');
                        } 
            );
    };

    self.fetchAllStudents();
    
    self.update = function(){
    	console.log('updating d\'un etudiant'+self.etudiant.idUtilisateur);
    	self.updateStudent(self.etudiant, self.etudiant.idUtilisateur);
    	self.reset();
    };
    
    self.add=function(){
    	if(self.etudiant.idUtilisateur===null){
            console.log('Saving New student', self.etudiant);    
            self.createStudent(self.etudiant);
        }else{
            self.updateStudent(self.etudiant, self.etudiant.idUtilisateur);
            console.log('student updated with id ', self.etudiant.idUtilisateur);
        }
        self.reset();
    };
    
//    self.submit = function() {
//        if(self.etudiant.id===null){
//            console.log('Saving New student', self.etudiant);    
//            self.createStudent(self.etudiant);
//        }else{
//            self.updateStudent(self.etudiant, self.etudiant.id);
//            console.log('student updated with id ', self.etudiant.id);
//        }
//        self.reset();
//    };
         
    self.edit = function(id){
        for(var i = 0; i < self.etudiants.length; i++){
            if(self.etudiants[i].idUtilisateur == id) {
               self.etudiant = angular.copy(self.etudiants[i]);
               break;
            }
        }
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        self.deleteStudent(id);
    };

     
    self.reset = function(){
        self.etudiant={idUtilisateur:null,cinUtilisateur:'',cne:'',nomUtilisateur:'',prenomUtilisateur:'', adresseUtilisateur:'',emailUtilisateur:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);