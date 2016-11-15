/**
 * @name: header controller
 * @description: process the logic for the header
 */

angular.module('citizen')

.controller('HeaderCtrl', function ($state, $scope, $rootScope, $http, $timeout, $window, cookieFactory) {

    
    $scope.customerName = "";
    
    
    /**
     * @name: isUserLogin
     * @type: method
     * @description: checks if the user is login
     */
    
    $scope.isUserLogin = function () {

        if (cookieFactory.getUserCookieData() == undefined) {

            return false;
            
        } else {

            return true;
        }
    };
    
    
    /**
     * @name: getCustomerName
     * @type: method
     * @description: get user's name
     */
    
    $scope.getCustomerName = function (accessToken) {

        var urlGetCustomerName = "https://citizen-app.herokuapp.com/getcustomer?token=" + accessToken;

        $http.get(urlGetCustomerName)
            .success(function (customerDetails) {
                //alert(customerDetails.name);
                cookieFactory.setUserCookieData(customerDetails.name);
                cookieFactory.setTotalCitiPoints(0);
            })
            .error(function () {
                $scope.customerName = cookieFactory.getUserCookieData();
            });
            
    };
    
    
    /**
     * @name: getAccessToken
     * @type: method
     * @description: get access token
     */

    $scope.getAccessToken = function () {

        var url = document.URL;
        var access_token = "";

        if (url.indexOf("code") !== -1) {
            access_token = url.substring(url.indexOf("code") + 5, url.indexOf("&state"));
            cookieFactory.setAccessTokenCookieData(access_token);
            //alert(access_token);
            
            $scope.getCustomerName(access_token);
        }
    };

    $scope.getAccessToken();
    
    
    /**
     * @name: getUsernameCookie
     * @type: method
     * @description: get user's username
     */
    
    $scope.getUsernameCookie = function () {
        return cookieFactory.getUserCookieData();
    };
    
    
    /**
     * @name: logout
     * @type: method
     * @description: log the user out, clearing his username cookie
     */
    
    $scope.logout = function () {
        
        cookieFactory.clearUserCookieData();
        cookieFactory.clearAmount();
        cookieFactory.clearAccessTokenCookieData();
        cookieFactory.clearCookieData();
        cookieFactory.clearDonationType();
        cookieFactory.clearTotalCitiPoints();
        cookieFactory.clearCitiPointsDonated();
        /*$timeout(function(){ 
            $window.location.reload();
        }, 1000);*/
    };

});