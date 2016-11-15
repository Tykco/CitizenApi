/**
 * @name: profile controller
 * @description: process the logic for the profile page
 */

angular.module('citizen')

.controller('ProfileCtrl', function ($state, $scope, $http, $rootScope, cookieFactory) {

    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });


    /**
     * @name: listOfCards
     * @type: variable
     * @description: retrieve a list of user's cards
     */

    $scope.listOfCards = [
        {
            name: "Citibank Premier Miles",
            enrolled: false,
            lastFourDigits: 6764
        }/*,
        {
            name: "Citibank SMRT Credit Card",
            enrolled: false,
            lastFourDigits: 3243
        },
        {
            name: "Citibank Rewards Card",
            enrolled: false,
            lastFourDigits: 4353
        }*/
    ];


    /**
     * @name: toggleEnrollment
     * @type: method
     * @description: toggle enrollment button for each card
     */

    $scope.toggleEnrollment = function (index, lastFourDigits) {

        $scope.listOfCards[index].enrolled = !$scope.listOfCards[index].enrolled;

        if ($scope.listOfCards[index].enrolled) {

            var url = "https://citizen-app.herokuapp.com/enrolcard?cardNumber=" + lastFourDigits + "&phoneNumber=82652930&token=" + cookieFactory.getAccessTokenCookieData();

            $http.get(url)

                .success(function (enrolResponse) {
                    console.log("Reward Link Code is: " + enrolResponse);

                    //var cardBalance = $scope.retrieveCardBalance(lastFourDigits);
                    var currentTotalCitiPoints = parseInt(cookieFactory.getTotalCitiPoints());
                    var pointsToBeSet = currentTotalCitiPoints + 500;
                    console.log("Points to be set: " + pointsToBeSet);
                    cookieFactory.setTotalCitiPoints(pointsToBeSet);
                })
                .error(function () {
                    console.log("There is an error enrolling card");
                });
            
        } else {
            
            var currentTotalCitiPoints = cookieFactory.getTotalCitiPoints();
            cookieFactory.setTotalCitiPoints(currentTotalCitiPoints - 500);
            
        }

    };


    /**
     * @name: retrieveCardBalance
     * @type: method
     * @description: retrieve the amount of citipoints for the card upon enrollment
     */

    $scope.retrieveCardBalance = function (lastFourDigits) {

        var url = "https://citizen-app.herokuapp.com/getbalance?cardNumber=" + lastFourDigits + "&phoneNumber=82652930&token=" + cookieFactory.getAccessTokenCookieData();;

        $http.get(url)

        .success(function (retrieveBalanceResponse) {
                return parseInt(retrieveBalanceResponse);
                console.log("Retrieved Balance is: " + retrieveBalanceResponse);
            })
            .error(function () {
                console.log("There is an error retrieving card balance");
            });

    };



});