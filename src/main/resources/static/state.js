var app = angular.module('state', ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/home");

    $stateProvider
        .state('home', {
            url: "/home",
            templateUrl: "home/home.html"
        })
        .state('page1', {
            url: "/page1",
            templateUrl: "page1/page1.html"
        })
        .state('page2', {
            url: "/page2",
            templateUrl: "page2/page2.html"
        })
});