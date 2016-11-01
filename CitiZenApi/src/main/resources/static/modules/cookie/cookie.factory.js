/**
 * @name: cookie service
 * @description: single responsibility of persisting user cookie data
 */

angular.module('citizen')
    .factory('cookieFactory', function ($cookies) {

        var page = "";
        var username = "";

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
            }

        }

    });