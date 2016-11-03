/**
 * @name: cause controller
 * @description: process the logic for the cause page
 */

angular.module('citizen')

.controller('CauseCtrl', function ($state, $scope, $rootScope, $window, cookieFactory) {

    $scope.pointsDonated;
    $scope.percentageDonated;

    // click secondary menu tab
    $scope.secMenu = function (element, $event) {

        $(".secondary.menu").children(".item").removeClass("active");
        $($event.target).addClass("active");

        if (element == "about") {
            $(".organization-container").addClass("hide");
            $(".points-container").addClass("hide");
            $(".about-container").removeClass("hide");

        } else if (element == "organization") {
            $(".about-container").addClass("hide");
            $(".points-container").addClass("hide");
            $(".organization-container").removeClass("hide");

        } else if (element == "points") {
            $(".about-container").addClass("hide");
            $(".organization-container").addClass("hide");
            $(".points-container").removeClass("hide");
        }

    }

    $rootScope.$on('$stateChangeSuccess', function () {
        document.body.scrollTop = document.documentElement.scrollTop = 0;
    });

    $scope.map = {
        center: {
            latitude: 1.314251,
            longitude: 103.766082
        },
        zoom: 12
    };

    $scope.marker = {
        id: 0,
        coords: {
            latitude: 1.314251,
            longitude: 103.766082
        }
    };

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
            ],
            eventName: "Elephant Charity Run Event",
            eventDate: "20 February 2017",
            eventTime: "12pm - 6pm",
            eventVenue: "Capsicum Island",
            eventDesc: "Come join us to participate in this awesome charity event to help raise fund for the elephants. It will be a 15km run and for each km, $1 will be donated to the cause to help the elephants. So what are you waiting for? Join us in making a difference to these elephants!",
            about: "Saving the elephants is an international project started in 2009 by 2 American Vets. Since then, they have saved more than hundreds of elephants from being hunt and killed by those who seek their husks. Thank you for the support!",
            theOrganisation: "Animal Planet is a non-profit organization that aims to conserve the habitat of all endangered animals. It is funded by a group of humanitarian societies and a strong group of volunteers.",
            website: "www.animalplanet.com",
            email: "animal.planet@am.us",
            points: "100 Citipoints = 1 meal for an elephant"
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
            ],
            eventName: "Teach the Kids Day",
            eventDate: "4 March 2017",
            eventTime: "8am - 3pm",
            eventVenue: "Long Town School",
            eventDesc: "Come join us to participate in this awesome charity event to help teach the kids. It will be a day of fun filled activities lined up for the kids as well as you. So what are you waiting for? Join us in making a difference to these lovely kids!",
            about: "Adopt a child is an international project started in 2006 by 2 American humanitarians. Since then, they have supported the lives and daily needs of more than 1000 African Kids. Thank you for the support!",
            theOrganisation: "Unicef is a non-profit organization that aims to provide support to the poor and disadvantaged. It is sponsored by a group of humanitarian societies and a strong group of volunteers.",
            website: "www.unicef.com",
            email: "unicef.volunteers@as.bt",
            points: "500 Citipoints = A week of school fee per child"
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
            ],
            eventName: "Raise Awareness on Elderly Depression",
            eventDate: "28 December 2016",
            eventTime: "3pm - 5pm",
            eventVenue: "St John Center for the Elderly",
            eventDesc: "Come join us to participate in this awesome charity event to help raise awareness on elderly depression. There will be informative talks, event booths and games to help educate the public on this matter. So what are you waiting for? Join us in raising awareness on elderly depression!",
            about: "Fighting Elderly Depression is an international project started in 2002 by 3 nurses. Since then, they have made a difference to the lives of more than 2000 elderly folks suffering from depression. Thank you for the support!",
            theOrganisation: "Touch Community is a non-profit organization that aims to provide care and support to the underpriveleged in our community. It is funded by a group of humanitarian societies and a strong group of volunteers.",
            website: "www.touchcommunity.com",
            email: "touch.community@gmail.com",
            points: "200 Citipoints = Help support 1 counselling session for an elderly"
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
            ],
            eventName: "Ebola Gift Campaign",
            eventDate: "23 May 2017",
            eventTime: "9am - 7pm",
            eventVenue: "South Island Cantava",
            eventDesc: "Come join us to participate in this awesome charity event to help collect gifts for the ebola victims. It will be a day of raising awareness on ebola, and to encourage the public to give generously. So what are you waiting for? Join us in making a difference!",
            about: "Raising Ebola Awareness is an international project started in 2016 by 3 British Doctors. Since then, they have spread the knowledge about this disease to more than 10 countries worldwide. Thank you for the support!",
            theOrganisation: "World Health Organization is a non-profit organization that seeks to maintain high medical standards and take sanitary measures across the globe. It is funded by a group of countries and health organizations.",
            website: "www.worldhealth.com",
            email: "world.healthorg@am.us",
            points: "300 Citipoints =  Advertise/Educate on Ebola to 100 people"
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
            ],
            eventName: "Nature Conservation Trekking",
            eventDate: "6 April 2017",
            eventTime: "9am - 12pm",
            eventVenue: "Bayfront Trekking Route",
            eventDesc: "Come join us to participate in this awesome charity event to help raise fund and help in conserving our nature. It will be a 10km trek and upon completion, $10 will be donated to the cause by our sponsors. So what are you waiting for? Join us in making a difference to nature!",
            about: "Plant a Tree is an international project started in 2006 by 3 Nature Lovers. Since then, they have planted more than 5000 trees across 20 different countries. Thank you for the support!",
            theOrganisation: "World Wide Fund for Nature is a non-profit organization that aims to conserve the habitat of all living things. It is funded by a group of humanitarian societies and a strong group of volunteers.",
            website: "www.wwf.com",
            email: "worldwidefund@wwf.com",
            points: "150 Citipoints = Plantation of 1 tree"
        }
    ];

    $scope.getCurrentPage = function () {
        return cookieFactory.getCookieData();
    };

});