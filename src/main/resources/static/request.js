var app = angular.module("request", []);

app.controller("RequestCtrl", function ($http) {
    var controller = this;
    controller.persons = [];


    controller.getAllPersons = function () {
        $http.get("/getAllPersons").then(function (value) {
            controller.persons = value.data;
        }, function (reason) {
            window.alert("Error");
        })
    };

});