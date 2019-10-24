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
            controller.success();
            controller.getAllUsers();
            console.log("Success");
            $('#firstName').val("");
            $('#lastName').val("");
        }, function (reason) {
            console.log("Error")
        })
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
            controller.getAllUsers();
        }, function (reason) {
            window.alert("Error");
        })
    };

    controller.success = function () {
        $("#alert").append("<div class='alert alert-success alert-dismissible'>" +
            "<strong>Success!</strong> User has been added</div>");
        setTimeout(function () {
            $("#alert").empty();
        }, 4000)
    };

});