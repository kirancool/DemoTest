(function(){
var ResultModule = angular.module('ResultModule', ["ngTable"]);
ResultModule.controller('resultcontroller', function($scope, $http,NgTableParams) {
    $http.get("http://localhost:8080/stocks/getAllPrice")
    .then(function (response) 
    		{
    	/*$scope.data = response.data;*/
    	$scope.data = new NgTableParams({}, { dataset: response.data });
    
    	});
});
})();