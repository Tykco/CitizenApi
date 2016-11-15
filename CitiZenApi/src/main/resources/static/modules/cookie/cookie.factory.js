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
        var totalCitiPoints = 0;
        var citiPointsDonated = 0;

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
            },
            
            setTotalCitiPoints: function (totalCitiPoints) {
                totalCitiPoints = totalCitiPoints;
                $cookies.put("totalCitiPoints", totalCitiPoints);
            },

            getTotalCitiPoints: function () {
                totalCitiPoints = $cookies.get("totalCitiPoints");
                if (totalCitiPoints == undefined || totalCitiPoints == null) {
                    return 0;
                } else {
                    return totalCitiPoints;
                }
            },

            clearTotalCitiPoints: function () {
                totalCitiPoints = "";
                $cookies.remove("totalCitiPoints");
            },
            
            setCitiPointsDonated: function (citiPointsDonated) {
                citiPointsDonated = citiPointsDonated;
                $cookies.put("citiPointsDonated", citiPointsDonated);
            },

            getCitiPointsDonated: function () {
                citiPointsDonated = $cookies.get("citiPointsDonated");
                if (citiPointsDonated == undefined || citiPointsDonated == null) {
                    return 0;
                } else {
                    return citiPointsDonated;
                }
            },

            clearCitiPointsDonated: function () {
                citiPointsDonated = "";
                $cookies.remove("citiPointsDonated");
            }

        }

    });