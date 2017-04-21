(function(){
var CompanyDataModule = angular.module('CompanyDataModule',['ui.select2']);
CompanyDataModule.controller('companycontroller', function($scope, $http) {
	$scope.onchangecompany=function()
	{
		$http.get("http://localhost:8080/stocks/getAllDate?companyname="+$scope.select.company)
	    .then(function (response) 
	    		{
	    $scope.tags = response.data;
	   /* alert(JSON.stringify(response));*/
	    	});
		/*alert($scope.select.company)*/
		$http.get("http://localhost:8080/stocks/getAllStockPriceOpen?companyname="+$scope.select.company)
	    .then(function (response) 
	    		{
	    $scope.Open = response.data;
	   /* alert(JSON.stringify(response));*/
	    	});
		 $http.get("http://localhost:8080/stocks/getAllStockPriceHigh?companyname="+$scope.select.company)
		    .then(function (response) 
		    		{
		    $scope.High = response.data;
		   /* alert(JSON.stringify(response));*/
		    	});
		 $http.get("http://localhost:8080/stocks/getAllStockPriceLow?companyname="+$scope.select.company)
		    .then(function (response) 
		    		{
		    $scope.Low = response.data;
		   /* alert(JSON.stringify(response));*/
		    	});
		
	}
	  
    $http.get("http://localhost:8080/stocks/getAllCompany")
    .then(function (response) 
    		{
    $scope.data = response.data;
  /*  alert(JSON.stringify(response));*/
    	});
    $scope.submitcompany=function()
    {
    	var sum =0;
    	
    	for(var i=0;i<$scope.select_price_open.length;i++)
    		{
    		    if($scope.select_price_open[i]!= null)
    		    	{
    		            sum+=parseFloat($scope.select_price_open[i]);
    		    	}
    		
    		}
     	var avg=sum/$scope.select_price_open.length
    	
           
       	var sum1 =0;
       	for(var j=0;j<$scope.select_price_high.length;j++)
    		{
    		    if($scope.select_price_high[j]!= null)
    		    	{
    		            sum1+=parseFloat($scope.select_price_high[j]);
    		    	}
    		
    		}
       	var avg1=sum1/$scope.select_price_high.length
       	
       	
       	var sum2=0;
       	for(var k=0;k<$scope.select_price_low.length;k++)
    		{
    		    if($scope.select_price_low[k]!= null)
    		   {
    		            sum2+=parseFloat($scope.select_price_low[k]);
    		    	}
    		
    		}
      
    	
       	var avg2=sum2/$scope.select_price_low.length
    	
       $http.get("http://localhost:8080/stocks/submit?company="+$scope.select.company+"&stock_price_open="+avg+"&stock_price_high="+avg1+"&stock_price_low="+avg2)
       .then(function (response) 
    		{
       $scope.submitdata = response.data;
  
    	})
    	
  /*alert(avg)
  alert(avg1)
  alert(avg2)*/
     }
    
});
     
})();
