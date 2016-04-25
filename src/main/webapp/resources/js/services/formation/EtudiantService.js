/**
 * 
 */

'use strict';

app.factory('EtudiantService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneStudent: function(id){
    	    	return $http.get("/getOneStudent/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching etudiant');
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
                                        console.error('Error while fetching etudiants');
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