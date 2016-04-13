/**
 * 
 */
'use strict';
app.factory('ModuleService', ['$http', '$q', function($http, $q){
	 
    return {
    	    getOneModule: function(id){
    	    	return $http.get("/getOneModule/"+id)
    	    	.then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching module');
                                        return $q.reject(errResponse);
                                    }
    	    	);
    	    },
    	    
            fetchAllModules: function() {
                    return $http.get("/modules")
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createModule: function(module){
                    return $http.post("/saveModule", module)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateModule: function(module, id){
                    return $http.put("/updateModule/"+id, module)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteModule: function(id){
                    return $http.delete("/deleteModule/"+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting module');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
         
    
         addModuleToSemestre : function(idM,idS){
      	 return $http.post("/addModuleToSemestre/"+"?idm="+idM+"&ids="+idS)
      	 		.then(function(response){		
   				return response.data ;
   			},
   			function(errResponse){
   				console.error('Error while adding module to semestre (service)');
                return $q.reject(errResponse);
   			});
         },   
//        addSemestreTomodule : function(idS,idN){
//         	   
//             	 return $http.post("/addSemestreTomodule/"+"?ids="+idS+"&idn="+idN)
//             	 		.then(function(response){		
//          				return response.data ;
//          			},
//          			function(errResponse){
//          				console.error('Error while adding semestre to module');
//                       return $q.reject(errResponse);
//          			});
//        },
//        removeFormationFrommodule : function() {
//        	return $http.delete("/removeFormationFrommodule/"+"?idf="+idF+"&idn="+idN)
// 	 		.then(function(response){		
//				return response.data ;
//			},
//			function(errResponse){
//				console.error('Error while removing formation from module');
//           return $q.reject(errResponse);
//			});
//		}
    };
 }]);