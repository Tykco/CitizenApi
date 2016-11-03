/**
 * @name: confirmation controller
 * @description: process the logic for the confirmation page
 */

angular.module('citizen')

.controller('ConfirmationCtrl', function ($state, $scope, $rootScope, cookieFactory) {

    $scope.causeList = [
        {
            name: "Save the Elephants",
            org: "Animal Planet",
            numberOfDonors: 102,
            numberOfLikes: 204,
            image: "/assets/img/african_elephant.jpg",
            citiPoints: 50,
            avatar: "/assets/img/animal_planet.png",
            categories: [
                {
                    name: "Animals",
                    color: "lightblue"
                },
                {
                    name: "Conservation",
                    color: "orange"
                }
            ]
        },
        {
            name: "Adopt an African Child",
            org: "Unicef",
            numberOfDonors: 259,
            numberOfLikes: 108,
            image: "/assets/img/african_children.jpg",
            citiPoints: 100,
            avatar: "/assets/img/unicef.jpg",
            categories: [
                {
                    name: "Children & Youth",
                    color: "lightgreen"
                },
                {
                    name: "Homeless",
                    color: "#F5CBA7"
                }
            ]
        },
        {
            name: "Fight Elderly Depression",
            org: "Touch Community",
            numberOfDonors: 301,
            numberOfLikes: 82,
            image: "/assets/img/elderly_care.jpg",
            citiPoints: 85,
            avatar: "/assets/img/touch_community.png",
            categories: [
                {
                    name: "Seniors",
                    color: "#ff99ff"
                }
            ]
        },
        {
            name: "Raise Ebola Awareness",
            org: "World Health Organization",
            numberOfDonors: 87,
            numberOfLikes: 58,
            image: "/assets/img/stop_ebola.jpg",
            citiPoints: 69,
            avatar: "/assets/img/world_health_org.jpg",
            categories: [
                {
                    name: "Health & Wellness",
                    color: "#33cccc"
                },
                {
                    name: "Humanitarian",
                    color: "#ff9999"
                }
            ]
        },
        {
            name: "Plant a Tree Project",
            org: "World Wide Fund for Nature",
            numberOfDonors: 51,
            numberOfLikes: 71,
            image: "/assets/img/plant_a_tree.jpg",
            citiPoints: 25,
            avatar: "/assets/img/world_wide_fund.png",
            categories: [
                {
                    name: "Conservation",
                    color: "orange"
                }
            ]
        }
    ];
    
    $scope.getCurrentPage = function() {
        return cookieFactory.getCookieData();
    };
    
    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });

});