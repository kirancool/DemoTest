(function () {
    'use strict';
var dapp = angular.module("linechart_app", ['datatables','ngMaterial']);

dapp.controller('line_controller',locationLineChart);
function locationLineChart($http,$scope){
	$http.get("http://localhost:8080/stocks/getAllPrice")
	  .success( function(response) {    
	     $scope.locationLineData=response;
	     locationLine(response)
	     
  	});
	
	
function locationLine(data){
		
	
var datajson={};
datajson.json=data;
var key={};
var  value=[];
key.x='company';
value[0]='stock_price_open';
value[1]='stock_price_high';
value[2]='stock_price_low';
key.value=value;
datajson.type="line";
datajson.keys=key;		
var chart = c3.generate({
    bindto: '#locationline',
    data: datajson,
    zoom: {
        enabled: true
    },
    axis: {
            x: {
               type: 'category',
               tick: {
                  rotate: 10,
                  multiline: false
                },
            }      
        },
        grid: {
            x: {
                show: true
            },
            y: {
                show: true
            }
        }
})
/*dapp.controller('scatter_controller',twitterScatterChart);
function twitterScatterChart($http,$scope){
	
	$http.get("http://localhost:8080/stocks/getAllPrice")
	  .success( function(response) {    
	   
	     $scope.dashbordtwidata=response;
	     scatterData(response)
	   
	     
  	});
	
	function scatterData(data){
		var datajson={};
		datajson.json=data;
		var color = {};
		var key={};
		var  value=[];
		key.x='company';
		value[0]='stock_price_open';
		value[1]='stock_price_high';
		value[2]='stock_price_low';
		key.value=value;
		datajson.type="scatter";
		datajson.keys=key;
		color["date"] = 'red';
		datajson.colors = color;
		var chart = c3.generate({
		    bindto: '#twitterscatter',
		    zoom: {
		        enabled: true
		    },
		    data: datajson,
		    axis: {
		            x: {
		               type: 'category',
		               tick: {
		                  rotate: 10,
		                  multiline: false
		                },
		            }      
		        },
		})*/
		
}
}
})();