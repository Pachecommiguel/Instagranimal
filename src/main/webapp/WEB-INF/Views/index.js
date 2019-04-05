$(document).ready(function () {
    refreshHomePage();
    var button = '<button class="btn btn-success" id="add" onclick="addAnimal()>Add Animal</button>';
    $(button).appendTo('.addAnimal');
});

function refreshHomePage() {


    function successCallback(response) {
        showHome(response)
        addPhotos(response.animals)
    }

    function errorCallback(request, status, error) { }

    var user = JSON.parse(window.localStorage.getItem('myUser'));

    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/' + user.username,
        async: true,
        success: successCallback,
        error: errorCallback
    });

}

function showHome(response) {

    showUserHome(response)
}

function showUserHome(user) {
    $('.profile-user-name').append('<p id="' + user.username + '">' + user.username + '</p>')
    $('.profile-user-rating').append('<p>Rating ' + user.rating + '</p>');
}

function addPhotos(animals) {

    $('.gallery').append(animals.map(function (value, index) {
        return '<div class="gallery-item" id="tabindex' + index + '"><img src="' + value.photoLink + '" class="gallery-image">' +
            '<div class="gallery-item-info">' +
            '<ul><li class="gallery-item-location"><span class="visually-hidden"></span><i aria-hidden="true"></i>' + value.photoLocation + '</li>'
            + '<li class="gallery-item-family"><span class="visually-hidden"></span><i aria-hidden="true"></i>' + value.family + '</li></ul></div></div>'
    }).join(''))
}


function addAnimal() {

    function successCallback(response) {
        $('.profile-user-name').empty();
        $('.profile-user-rating').empty();
        $('.gallery').empty()

        showHome(response);
        addPhotos(response.animals);
    }

    function errorCallback(request, status, error) {
        console.log(request)
        console.log(status)
        console.log(error)
    }

    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/animal/add',
        type: 'POST',
        data: JSON.stringify({
            username: user,
            [$('#species').prop('id')]: $('#species').val(),
            [$('#photoLink').prop('id')]: $('#photoLink').val(),
            [$('#photoLocation').prop('id')]: $('#photoLocation').val(),
            [$('#rarity').prop('id')]: $('#rarity').val(),
            [$('#family').prop('id')]: $('#family').val()
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });
}
