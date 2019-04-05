$(document).ready(function () {

    var user = JSON.parse(window.localStorage.getItem('user'));

    if (!user) {
        window.location.replace('./userList.html');
        return;
    }

    showHome(user);
    addPhotos(user.animals);

});


function refreshHomePage() {


    function successCallback(response) {
        showHome(response)
        addPhotos(response.animals)
    }

    function errorCallback(request, status, error) { }


<<<<<<< HEAD
    //getUser(successCallback, errorCallback)
};

=======
    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/magno',
        async: true,
        success: successCallback,
        error: errorCallback
    });
>>>>>>> master


function showHome(response) {

    showUserHome(response)
}

function showUserHome(user) {
    $('.profile-user-name').append('<p id="' + user.username + '">' + user.username + '</p>')
    $('.fa').append(user.rating + '</p>');
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
        console.log(response);

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
            username: JSON.parse(window.localStorage.getItem('user')).username,
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


function successCallback(response) { //the data I'm requesting with the get comes already in array format
    console.log(response);
    // this should be renamed, can not use the same for all requests and in here it should render the user profile???
}
function errorCallback(request, status, error) {

}