/**
 * @name: reward controller
 * @description: process the logic for the reward page
 */

angular.module('citizen')

.controller('RewardCtrl', function ($state, $scope, $rootScope, cookieFactory) {

    $scope.rewardList = [
        {
            name: "Level 1",
            desc: "$50 Dining Voucher at Fish & Co",
            numberOfPointsRequired: 0,
            sponsor: "Fish & Co",
            image: "/assets/img/fish_and_co.JPG",
            avatar: "/assets/img/fish_and_co_logo.jpg"
        },
        {
            name: "Level 2",
            desc: "Earn 5000 Citi Miles",
            numberOfPointsRequired: 2000,
            sponsor: "Citi",
            image: "/assets/img/citi_miles.jpg",
            avatar: "/assets/img/citi_miles_icon.png"
        },
        {
            name: "Level 3",
            desc: "$100 Shopping Voucher at Takashimaya",
            numberOfPointsRequired: 4000,
            sponsor: "Takashimaya",
            image: "/assets/img/takashimaya_shopping.jpg",
            avatar: "/assets/img/takashimaya_shopping_icon.png"
        },
        {
            name: "Level 4",
            desc: "4 x Passes to Universal Studio",
            numberOfPointsRequired: 8000,
            sponsor: "Universal Studio",
            image: "/assets/img/universal_studio.jpg",
            avatar: "/assets/img/universal_studio_icon.jpg"
        },
        {
            name: "Level 5",
            desc: "Weekend Staycation at Marriott Hotel",
            numberOfPointsRequired: 16000,
            sponsor: "Marriott Group",
            image: "/assets/img/marriott_hotel.jpg",
            avatar: "/assets/img/marriott_hotel_logo.png"
        }
    ];
    
    $scope.getCurrentPage = function() {
        return cookieFactory.getCookieData();
    };
    
    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });
    
    $scope.getCitiPointsDonated = function() {
        return cookieFactory.getCitiPointsDonated();
    };

});