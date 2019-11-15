var app = angular.module('state', ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('request', {
            url: "/request",
            templateUrl: "request.html"
        })
});