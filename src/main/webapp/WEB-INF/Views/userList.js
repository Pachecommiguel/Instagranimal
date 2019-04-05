$(document).ready(function() {
    getUsers();
});


function getUsers() {

    $.ajax({
        url: 'http://localhost:8080/instagranimal/api/user/list', //url to request
        async: true,
        success: function(response) {
            addData(response)
        }, //if success invoke this function, otherwise invoke the error one
        error: function() {
            console.log('error', arguments);
        } 
    });

};


function addData(array) {

    var node = array.map(function (element) {
        return '<tr><td>' + element.username + '</td><td>' + element.firstName + '</td><td>' + element.lastName + '</td><td>'
            + element.rating + '</td><td>' + '<button class="btn btn-primary" onClick="getUser(\'' + element.username + '\')">Check Collection</button></td></tr>'
    }).join('');
    $(node).appendTo('#users-table');
};


function getUser(username) {

    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/' + username,
        async: true,
        success: function(response) {
            console.log(response);
            window.localStorage.setItem('user', JSON.stringify(response));
            window.location.replace("./index.html");
            showHome(response);
            addPhotos(response.animals);
        },
        error: function() {
            console.log('error', arguments);
        } 
    });
}
