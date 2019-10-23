var app = angular.module("page1", []);

app.controller("Page1Ctrl", function ($http) {
    var controller = this;
    controller.users = [];

    controller.newUser = function () {

        var firstName = $('#firstName').val();
        var lastName = $('#lastName').val();

        var newUser = {
            firstName: firstName,
            lastName: lastName
        };
        $http.post("/newUser", newUser).then(function () {
            console.log("Success")
        }, function (reason) {
            console.log("Error")
        })
    };

});