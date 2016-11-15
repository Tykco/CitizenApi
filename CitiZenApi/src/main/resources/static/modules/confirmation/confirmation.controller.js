/**
 * @name: confirmation controller
 * @description: process the logic for the confirmation page
 */

angular.module('citizen')

.controller('ConfirmationCtrl', function ($state, $scope, $rootScope, $http, cookieFactory, ngNotify) {

    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });
    
    
    /**
     * @name: causeList
     * @type: variable
     * @description: summary of causes
     */
    
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
    
    
    /**
     * @name: getCurrentPage
     * @type: function
     * @description: display based on the cause chosen
     */
    
    $scope.getCurrentPage = function() {
        return cookieFactory.getCookieData();
    };
    
    
    /**
     * @name: getDonationType
     * @type: function
     * @description: retrieve the donation type whether it is pledged or donate
     */
    
    $scope.getDonationType = function() {
        return cookieFactory.getDonationType();
    };
    
    
    /**
     * @name: getAmount
     * @type: function
     * @description: get donation/pledged amount
     */
    
    $scope.getAmount = function() {
        return cookieFactory.getAmount();
    };

    
    /**
     * @name: sendOtp
     * @type: function
     * @description: sends otp through sms
     */
    
    $scope.sendOtp = function() {
        
        $scope.otpNumber = "";
        
        $('.ui.modal').modal('show');
        
        var urlSendOtp = "https://citizen-app.herokuapp.com/sendotp?cardNumber=6764&phoneNumber=82652930&token=" + cookieFactory.getAccessTokenCookieData();

        $http.get(urlSendOtp)

        .success(function (OtpResponse) {
                console.log("Send SMS: " + OtpResponse);
            })
            .error(function () {
                console.log("There is an error sending the otp through sms");
            });
        
    };
    
    
    /**
     * @name: confirmOtp
     * @type: function
     * @description: confirms the otp is correct
     */
    
    $scope.confirmOtp = function(otpNumber) {
        
        // valid otp: 735937
        
        var urlConfirmOtp = "https://citizen-app.herokuapp.com/activatepayment?otp=" + otpNumber + "&cardNumber=6764&phoneNumber=82652930&token=" + cookieFactory.getAccessTokenCookieData();
        
        $http.get(urlConfirmOtp)

        .success(function (OtpConfirmation) {
                console.log("Confirm OTP: " + OtpConfirmation);
            
                if (OtpConfirmation == "success") {
                    
                    $('.ui.modal').modal('hide');
                        $state.go('home');
                        ngNotify.set("Transfer successful. Thank you for your kind contributions!", {
                            //position: 'top',
                            sticky: true,
                            error: true,
                            type: 'success'
                    });
                    
                    var citiPointsToBeDeducted = parseInt($scope.getAmount());
                    var currentTotalCitiPoints = cookieFactory.getTotalCitiPoints();
                    cookieFactory.setTotalCitiPoints(currentTotalCitiPoints - citiPointsToBeDeducted);
                    var currentDonatedCitiPoints = parseInt(cookieFactory.getCitiPointsDonated());
                    console.log("current donated citi points: " + currentDonatedCitiPoints);
                    console.log("Citi points to be deducted: " + citiPointsToBeDeducted);
                    cookieFactory.setCitiPointsDonated(currentDonatedCitiPoints + citiPointsToBeDeducted);
                    
                } else {
                    
                    $('.ui.modal').modal('hide');
                        ngNotify.set("Transfer unsuccessful. You have entered an incorrect OTP.", {
                            //position: 'top',
                            sticky: true,
                            error: true,
                            type: 'error'
                    });
                    
                }
            })
        
            .error(function () {
                console.log("There is an error confirming the otp");
            });
        
    };
    
});