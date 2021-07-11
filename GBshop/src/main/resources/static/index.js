angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/market';

    $scope.p =[];
    $scope.currentPage = 0;
    $scope.pageSize = 10;

    $scope.pageCount = function (){
        return (window.Math.ceil($scope.p.length/$scope.pageSize));
    }

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    };

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                // console.log('sended:');
                // console.log($scope.newProduct);
                // console.log('received');
                // console.log(response.data);
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProductById = function (id){
        $http({
            url: contextPath + '/products',
            method: 'DELETE',
            params: {
                id: id
            }
        }).then(function (response) {
            $scope.fillTable();
        });
    };

    $scope.fillTable();
});



