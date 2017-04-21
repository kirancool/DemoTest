/**
 * 
 */

(function(){
	
 var LoginModule= angular.module('LoginModule');
 
 LoginModule.controller('LoginController',['$scope','LoginService','$window', function ($scope,LoginService,$window) {
	  $scope.statusForgetFrom=false;
       $scope.message="Enter your e-mail address and username below to reset your password."
	    
		$scope.login=function(){
			
			LoginService.getLogin($scope.username,$scope.password).then(function(response){onSuccess(response)})

			var onSuccess = function (response) {
	          
					$window.location.href = 'index.html';	
				
	       };
		}
		
			
	$scope.showForgetFrom=function(){
		$scope.statusForgetFrom=true;
		
	}	
	
	$scope.showLoginForm =function(){	
		$scope.statusForgetFrom=false;
	}
	$scope.submitForgetForm=function(){
		
		$scope.message="Verification Email has been sent to your email Id "
	}
	
	}]);
 
})();