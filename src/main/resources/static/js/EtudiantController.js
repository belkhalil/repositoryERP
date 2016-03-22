var app=angular.module("MyApp",[]);

app.factory('EtudiantService', ['$http', '$q', function($http, $q){
	 
    return {
            fetchAllStudents: function() {
                    return $http.get("/students/")
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
                    return $http.delete("http://localhost:8080/empsiErp/deleteStudent/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);

app.controller('EtudiantController', ['$scope', 'EtudiantService', function($scope, EtudiantService) {
    var self = this;
    self.etudiant={id:null,cin:'',cne:'',nom:'',prenom:'', adresse:'',email:''};
    self.etudiants=[];
         
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
                             console.error('Error while deleting User.');
                        } 
            );
    };

    self.fetchAllStudents();

    self.submit = function() {
        if(self.etudiant.id===null){
            console.log('Saving New User', self.etudiant);    
            self.createStudent(self.etudiant);
        }else{
            self.updateStudent(self.etudiant, self.etudiant.id);
            console.log('User updated with id ', self.etudiant.id);
        }
        self.reset();
    };
         
    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.etudiants.length; i++){
            if(self.etudiants[i].id === id) {
               self.etudiant = angular.copy(self.etudiants[i]);
               break;
            }
        }
    };
         
    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.etudiant.id === id) {//clean form if the user to be deleted is shown there.
           self.reset();
        }
        self.deleteStudent(id);
    };

     
    self.reset = function(){
        self.etudiant={id:null,cin:'',cne:'',nom:'',prenom:'', adresse:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);