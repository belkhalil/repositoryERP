/**
 * 
 */

'use strict';


app.factory('FormationService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneFormation: function(id){
    	    	return $http.get("/getOneFormation/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching formation');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
            fetchAllFormations: function() {
                    return $http.get("/formations")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching formations');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
             
            createFormation: function(formation){
                    return $http.post("/saveformation", formation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateFormation: function(formation, id){
                    return $http.put("/updateFormation/"+id, formation)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteFormation: function(id){
                    return $http.delete("/deleteformation/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting formation');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
    
   
    
 
}]);
