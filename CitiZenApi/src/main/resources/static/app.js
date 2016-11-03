/**
 * @name: citizen
 * @description: main module of the application
 */

var app = angular.module('citizen', [
    'ui.router',
    //'uiGmapgoogle-maps',
    'ezfb',
    'ngCookies'
])

.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider

    .state('home', {
        url: '/',
        controller: 'HomeCtrl',
        templateUrl: 'modules/home/home.html'
    })

    .state('cause', {
        url: '/cause',
        controller: 'CauseCtrl',
        templateUrl: 'modules/cause/cause.html',
        resolve: {
            hasPageSession: function (cookieFactory) {
                if (cookieFactory.getCookieData("page") == undefined) {
                    $state.go('home');
                }
            }
        }
    })
          
    .state('confirmation', {
        url: '/confirmation',
        controller: 'ConfirmationCtrl',
        templateUrl: 'modules/confirmation/confirmation.html'
    })
    
    .state('reward', {
        url: '/reward',
        controller: 'RewardCtrl',
        templateUrl: 'modules/reward/reward.html'
    })
    
    .state('onboard', {
        url: '/onboard',
        controller: 'OnboardCtrl',
        templateUrl: 'modules/onboard/onboard.html'
    })
    
    .state('landing', {
        url: '/landing',
        templateUrl: 'modules/landing/landing.html'
    });

    $urlRouterProvider.otherwise('/');

})

/*.config(function (uiGmapGoogleMapApiProvider) {

    uiGmapGoogleMapApiProvider.configure({
        key: 'AIzaSyCMfUTuwNO1AOdymd_efJzwYuYmNVKpncY',
        v: '3.20',
        libraries: 'weather,geometry,visualization'
    });

})*/

.config(function (ezfbProvider) {

    // Default init function
    var _defaultInitFunction = ['$window', 'ezfbInitParams', function ($window, ezfbInitParams) {
        // Initialize the FB JS SDK
        $window.FB.init(ezfbInitParams);
    }];
    ezfbProvider.setInitFunction(_defaultInitFunction);

})

.config(function ($httpProvider) {
    
    $httpProvider.defaults.headers.common = {};
    $httpProvider.defaults.headers.post = {};
    $httpProvider.defaults.headers.put = {};
    $httpProvider.defaults.headers.patch = {};
    
});