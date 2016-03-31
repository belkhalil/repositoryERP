/**
 * 
 */
'use strict';
app.factory('NiveauService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneNiveau: function(id){
    	    	return $http.get("/getOneNiveau/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching niveau');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllNiveaux: function() {
                    return $http.get("/niveaux")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching niveaux');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createNiveau: function(niveau){
                    return $http.post("/saveNiveau", niveau)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateNiveau: function(niveau, id){
                    return $http.put("/updateNiveau/"+id, niveau)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteNiveau: function(id){
                    return $http.delete("/deleteNiveau/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting niveau');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
    
    self.addFormationToNiveau =function(idN,idF){
    	   
      	 return $http.post("/addFormationToNiveau"+"?idN="+idN+"&idF="+idF)
      	 		.then(function(response){		
   				return response.data ;
   				
   			},
   			function(errResponse){
   				console.error('Error while deleting niveau');
                return $q.reject(errResponse);
   			});
    };
 
}]);