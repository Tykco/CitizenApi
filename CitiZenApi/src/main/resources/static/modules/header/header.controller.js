/**
 * @name: header controller
 * @description: process the logic for the header
 */

angular.module('citizen')

.controller('HeaderCtrl', function ($state, $scope, $rootScope, $http, $timeout, $window, cookieFactory) {

    $scope.isUserLogin = function () {

        if (cookieFactory.getUserCookieData() == undefined) {

            return false;
            
        } else {

            return true;
        }
    };
    
    $scope.customerName = "";

    $scope.getCustomerName = function (accessToken) {

        var urlGetCustomerName = "https://citizen-app.herokuapp.com/getcustomer?token=" + accessToken;

        $http.get(urlGetCustomerName)
            .success(function (customerDetails) {
                //alert(customerDetails.name);
                cookieFactory.setUserCookieData(customerDetails.name);
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

            //alert(access_token);
            $scope.getCustomerName(access_token);
        }
    };

    $scope.getAccessToken();
    
    $scope.getUsernameCookie = function () {
        return cookieFactory.getUserCookieData();
    };
    
    $scope.logout = function () {
        
        cookieFactory.clearUserCookieData();
        $timeout(function(){ 
            $window.location.reload();
        }, 1000);
    };

});