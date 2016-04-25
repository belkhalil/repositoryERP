/**
 * 
 */

'use strict';
app.factory('ensvService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneEnsv: function(id){
    	    	return $http.get("/getOneEnsv/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensv');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	   
            fetchEnsvs: function() {
                    return $http.get("/ensVacatires")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching ensv');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createEnsv: function(ensv){
                    return $http.post("/saveEnsv", ensv)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating ensv');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateEnsv: function(ensv, id){
                    return $http.put("/updateEnsV/"+id, ensv)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating ensv');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteEnsv: function(id){
                    return $http.delete("/deleteEnsV/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting ensv');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
     
}]);
