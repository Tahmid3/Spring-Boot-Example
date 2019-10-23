var app = angular.module("page2", []);

app.controller("Page2Ctrl", function ($http) {
    var controller = this;
    controller.users = [];

    controller.loadCon = function () {
        controller.getAllUsers();
    };

    controller.getAllUsers = function () {
        $http.get("/getAllUsers").then(function (value) {
            controller.users = value.data;
        }, function (reason) {
            window.alert("Error");
        })
    };

    controller.delUser = function (firstName) {
        console.log(firstName);
        $http.put("/delUser/" + firstName).then(function () {
            controller.loadCon();
        }, function (reason) {
            window.alert("Error");
        })
    };
});