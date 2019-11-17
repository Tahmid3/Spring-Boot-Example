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

    controller.newBeitrag = function () {
        var landName = $('#landName').val();
        var produktName = $('#produktName').val();

        var newBeitrag = {
            landName: landName,
            produktName: produktName
        };
        $http.post("/newBeitrag", newBeitrag).then(function () {
            window.location.assign("/login/login.html")
        })
    };

});