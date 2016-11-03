/**
 * @name: cookie service
 * @description: single responsibility of persisting user cookie data
 */

angular.module('citizen')
    .factory('cookieFactory', function ($cookies) {

        var page = "";
        var username = "";
        var accessToken = "";
        var type = "";
        var amt = "";

        return {

            setCookieData: function (page) {
                page = page;
                $cookies.put("page", page);
            },

            getCookieData: function () {
                page = $cookies.get("page");
                return page;
            },

            clearCookieData: function () {
                page = "";
                $cookies.remove("page");
            },
            
            setUserCookieData: function (username) {
                username = username;
                $cookies.put("username", username);
            },

            getUserCookieData: function () {
                username = $cookies.get("username");
                return username;
            },

            clearUserCookieData: function () {
                username = "";
                $cookies.remove("username");
            },
            
            setAccessTokenCookieData: function (accessToken) {
                accessToken = accessToken;
                $cookies.put("accessToken", accessToken);
            },

            getAccessTokenCookieData: function () {
                accessToken = $cookies.get("accessToken");
                return accessToken;
            },

            clearAccessTokenCookieData: function () {
                accessToken = "";
                $cookies.remove("accessToken");
            },
            
            setDonationType: function (type) {
                type = type;
                $cookies.put("type", type);
            },

            getDonationType: function () {
                type = $cookies.get("type");
                return type;
            },

            clearDonationType: function () {
                type = "";
                $cookies.remove("type");
            },
            
            setAmount: function (amt) {
                amt = amt;
                $cookies.put("amt", amt);
            },

            getAmount: function () {
                amt = $cookies.get("amt");
                return amt;
            },

            clearAmount: function () {
                amt = "";
                $cookies.remove("amt");
            }

        }

    });