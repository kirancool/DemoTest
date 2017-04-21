(function(){
var DataModule = angular.module('DataModule', ["ngTable"]);
DataModule.controller('datacontroller', function($scope, $http,NgTableParams) {
    $http.get("http://localhost:8080/stocks/getTableData")
    .then(function (response) 
    		{
    	/*$scope.data = response.data;*/
    	$scope.data = new NgTableParams({}, { dataset: response.data });
    
    	});
});
})();