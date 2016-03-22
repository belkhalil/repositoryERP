App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllStudents: function() {
                    return $http.get('http://localhost:8080/students/')
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
                    return $http.post('http://localhost:8080/save/', etudiant)
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
                    return $http.put('http://localhost:8080//updateStudent/'+id, etudiant)
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
                    return $http.delete('http://localhost:8080/deleteStudent/'+id)
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
