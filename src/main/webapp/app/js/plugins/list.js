var myApp = angular.module('CompanyDataModule', ['ui.select2']);

function MyCtrl($scope, $compile, $timeout) {
    $scope.noResultsTag = null;
    $scope.tags = [
        {id: 0, name: "Zero"},
        {id: 1, name: "One"},
        {id: 2, name: "Two"}, 
        {id: 3, name: "Three"}, 
        {id: 4, name: "Four"}, 
    ];
    $scope.select2Options = {
        formatNoMatches: function(term) {
            console.log("Term: " + term);
            var message = '<a ng-click="addTag()">Add tag:"' + term + '"</a>';
            if(!$scope.$$phase) {
                $scope.$apply(function() {
                    $scope.noResultsTag = term;
                });
            }
            return message;
        }
    };
    
    $scope.addTag = function() {
        $scope.tags.push({
            id: $scope.tags.length,
            name: $scope.noResultsTag
        });
    };
    
    $scope.$watch('noResultsTag', function(newVal, oldVal) {
        if(newVal && newVal !== oldVal) {
            $timeout(function() {
                var noResultsLink = $('.select2-no-results');
                console.log(noResultsLink.contents());
                $compile(noResultsLink.contents())($scope);
            });
        }
    }, true);
}