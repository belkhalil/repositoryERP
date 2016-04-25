/**
 * 
 */
'use strict';

app.factory('EnsPService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneEnsp: function(id){
    	    	return $http.get("/getOneEnsp/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensp');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	   
            fetchEnsps: function() {
                    return $http.get("/ensPermanents")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createEnsp: function(ensp){
                    return $http.post("/saveEnsp", ensp)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateEnsp: function(ensP, id){
                    return $http.put("/updateEnsP/"+id, ensP)
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
             
            deleteEnsp: function(id){
                    return $http.delete("/deleteEnsP/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting ensp');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
     
}]);
