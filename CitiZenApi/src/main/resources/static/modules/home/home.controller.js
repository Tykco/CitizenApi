/**
 * @name: home controller
 * @description: process the logic for the home page
 */

angular.module('citizen')

.controller('HomeCtrl', function ($state, $scope, $rootScope, $http, cookieFactory) {

    angular.element(document).ready(function () {

        $('.navbar .ui.dropdown').dropdown({
            on: 'hover'
        });

        $('.my-slider').unslider({
            autoplay: true,
            arrows: false,
            infinite: true,
            delay: 6000
        });

    });

    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });

    $scope.causeList = [
        {
            name: "Save the Elephants",
            org: "Animal Planet",
            numberOfDonors: 102,
            numberOfLikes: 204,
            image: "/assets/img/african_elephant.jpg",
            citiPoints: 50,
            avatar: "/assets/img/animal_planet.png"
        },
        {
            name: "Adopt an African Child",
            org: "Unicef",
            numberOfDonors: 259,
            numberOfLikes: 108,
            image: "/assets/img/african_children.jpg",
            citiPoints: 100,
            avatar: "/assets/img/unicef.jpg"
        },
        {
            name: "Fight Elderly Depression",
            org: "Touch Community",
            numberOfDonors: 301,
            numberOfLikes: 82,
            image: "/assets/img/elderly_care.jpg",
            citiPoints: 85,
            avatar: "/assets/img/touch_community.png"
        },
        {
            name: "Raise Ebola Awareness",
            org: "World Health Organization",
            numberOfDonors: 87,
            numberOfLikes: 58,
            image: "/assets/img/stop_ebola.jpg",
            citiPoints: 69,
            avatar: "/assets/img/world_health_org.jpg"
        },
        {
            name: "Plant a Tree Project",
            org: "World Wide Fund for Nature",
            numberOfDonors: 51,
            numberOfLikes: 71,
            image: "/assets/img/plant_a_tree.jpg",
            citiPoints: 25,
            avatar: "/assets/img/world_wide_fund.png"
        }
    ];

    $scope.setPageCookie = function (pageNumber) {
        cookieFactory.setCookieData(pageNumber);
        $state.go('cause');
    };

    $scope.isUserLogin = function () {

        if (cookieFactory.getUserCookieData() == false) {
            return true;
        } else {
            return false;
        }
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

    $scope.customerName = "";

    $scope.getCustomerName = function (accessToken) {

        var urlGetCustomerName = "https://citizen-app.herokuapp.com/getcustomer?token=" + accessToken;

        $http.get(urlGetCustomerName)
            .success(function (customerDetails) {
                alert(customerDetails.name);
                cookieFactory.setUserCookieData(customerDetails.name);
                $scope.customerName = customerDetails.name;
            })

    };

});