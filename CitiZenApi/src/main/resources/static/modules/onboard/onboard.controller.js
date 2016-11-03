/**
 * @name: onboard controller
 * @description: process the logic for the onboard page
 */

angular.module('citizen')

.controller('OnboardCtrl', function ($state, $scope, $http, $rootScope, $window, cookieFactory) {

    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });

    
    /**
     * @name: retrieveCardDetails
     * @type: function
     * @description: retrieve a sumamry of cards from citi api
     */
    
    $scope.retrieveCardDetails = function () {

        var urlCardDetails = "https://citizen-app.herokuapp.com/getprodcat";

        $http.get(urlCardDetails)

        .success(function (cardDetails) {
                console.log(cardDetails);
                $scope.listOfCards = cardDetails.products;
                console.log($scope.listOfCards);
            })
            .error(function () {
                console.log("There is an error retrieving card details");
            });

    };

    /**
     * @name: applyForCard
     * @type: function
     * @description: sends a post to help customer apply for selected citi credit card
     */
    
    $scope.applyForCard = function () {
        
        $scope.sending = {
            "productCode": "VC030",
            "productDescription": "Citi PremierMiles Visa Card",
            "sourceCode": "WW5ARCE1",
            "logo": "030",
            "organisation": "888",
            "productType": "CC",
            "minimumCreditLimitAmount": 800,
            "maximumCreditLimitAmount": 150000,
            "annualFeeAmount": 700,
            "currencyCode": "SGD",
            "interestRate": 20.99,
            "latePaymentFee": 0,
            "importantInformations": "Placeholder for Show Details",
            "termsAndConditions": "By clicking \"submit\", you consent to (i) Citibank disclosing your information to Credit Bureau Singapore; and (ii) any such bureau to transfer and disclose to Citibank, any information relating to you and/or any of your account(s) (and for such purposes) as may be permitted under or pursuant to the Banking Act of Singapore",
            "agreementStartDate": "2016-11-02-04:00",
            "agreementExpiryDate": "2016-12-02-04:00",
            "additionalProperties": { }
        };
        
        var req = {
            method: 'POST',
            url: 'https://citizen-app.herokuapp.com/onboardcard/',
            headers: {
                'Content-Type': 'application/json'
            },
            data: $scope.sending
        };
        
        console.log("I am sending in");
        console.log($scope.sending);
        
        $http(req)
            .success(function (response) {
                console.log(response);
                
            }).error(function (error) {
                console.log("There is an error applying for card");
            });

    };



});