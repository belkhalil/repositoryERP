
'use strict';
app.factory('FormationDService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneFormation: function(id){
    	    	return $http.get("/getOneFormationD/"+id)
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
                    return $http.get("/formationsD")
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
                    return $http.post("/saveformationD", formation)
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
                    return $http.put("/updateFormationD/"+id, formation)
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
                    return $http.delete("/deleteformationD/"+id)
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