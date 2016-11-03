/**
 * @name: header controller
 * @description: process the logic for the header
 */

angular.module('citizen')

.controller('HeaderCtrl', function ($state, $scope, $rootScope, $http, cookieFactory) {

    $scope.isUserLogin = function () {

        if (cookieFactory.getUserCookieData() == false) {
            return true;
        } else {
            return false;
        }
    };
    
    $scope.customerName = "";

    $scope.getCustomerName = function (accessToken) {

        var urlGetCustomerName = "https://citizen-app.herokuapp.com/getcustomer?token=" + accessToken;

        $http.get(urlGetCustomerName)
            .success(function (customerDetails) {
                alert(customerDetails.name);
                cookieFactory.setUserCookieData(customerDetails.name);
                $scope.customerName = cookieFactory.getUserCookieData();
            })
            .error(function () {
                $scope.customerName = cookieFactory.getUserCookieData();
            });
            
    };

    $scope.getAccessToken = function () {

        var url = document.URL;
        var access_token = "";

        if (url.indexOf("code") !== -1) {
            access_token = url.substring(url.indexOf("code") + 5, url.indexOf("&state"));

            alert(access_token);
            $scope.getCustomerName();
        }
    };

    $scope.getAccessToken();

});