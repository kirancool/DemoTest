/**
 * 
 */
$('.table').DataTable();
RegisterModule= angular.module('RegisterModule');

RegisterModule.controller('RegisterController', function($stateParams,$rootScope,$scope,RegisterSourceService) {
	
	$scope.sourceTypes=["FILE","HIVE"];
	$scope.sourcedetail=[];
	$scope.isSubmitEnable=true;
	$scope.onChangeSourceType=function(){
		RegisterSourceService.getDatasourceByType($scope.sourcetype).then(function(response){onSuccessGetDatasourceByType(response.data)})
		var onSuccessGetDatasourceByType=function(response){
			
			$scope.alldatasource=response
		}
	}
	$scope.selectDataSource=function(){
		
		if($scope.datasourcedata !=null){
		RegisterSourceService.getRegistryByDatasource($scope.datasourcedata.uuid).then(function(response){onSuccessGetRegistryByDatasource(response.data)});
		var onSuccessGetRegistryByDatasource=function(response){
			console.log(JSON.stringify(response))
			//$scope.data=response;
			$scope.sourecedata=response
		}
		}
	}
	
  $scope.selectAllRegisterSource=function(){
	  $scope.isSubmitEnable=!$scope.allselect;
	  angular.forEach($scope.sourecedata, function(source) {
		  source.selected =$scope.allselect;
	        });
  }
  $scope.selectRegisterSource=function(index,data){
	 var result=true;
	 for(var i=0;i<$scope.sourecedata.length;i++){
		 if($scope.sourecedata[i].selected == true){
			
			 result=false
			 i=$scope.sourecedata.length;
		 }
		 }
	 $scope.isSubmitEnable=result
  }
  
  $scope.submitRegisgterSource=function(){
	  $scope.isSubmitEnable=true;
	  $scope.dataLoading=true;
	 var sourcearray=[];
	 var count=0;
	 for(var i=0;i<$scope.sourecedata.length;i++){
		 var sourcejson={};
		 if($scope.sourecedata[i].selected == true){
		 sourcejson.id=$scope.sourecedata[i].id
		 sourcejson.name=$scope.sourecedata[i].name;
		 sourcejson.dese=$scope.sourecedata[i].dese;
		 sourcejson.registeredOn=$scope.sourecedata[i].registeredOn;
		 sourcejson.status=$scope.sourecedata[i].status
		 sourcearray[count]=sourcejson;
		 count=count+1;
		 }
		
	 }
	
	 console.log(JSON.stringify(sourcearray))
	 RegisterSourceService.getRegister($scope.datasourcedata.uuid,$scope.datasourcedata.version,sourcearray,$scope.sourcetype).then(function(response){onSuccessGetcreateAndLoad(response.data)});
		var onSuccessGetcreateAndLoad=function(response){
			console.log(JSON.stringify(response))
			 $scope.dataLoading=false;

			
			for (var i=0;i<response.length;i++){
				var id=response[i].id-1
				$scope.sourecedata[id].selected="false"
				$scope.sourecedata[id].registeredOn=response[i].registeredOn;
				$scope.sourecedata[id].desc=response[i].desc;
				$scope.sourecedata[id].status=response[i].status;
			}
			
		}
  }
});