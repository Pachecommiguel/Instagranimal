var user;

/*
var animalArr = [
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    { "species": "Batrachoseps campi", "photoLink": "http://www.californiaherps.com/salamanders/images/bcampi2bs604.jpg", "photoLocation": "California", "family": "Amphibian", "rarity": "Rare" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    {  "species": "Athene blewitti", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/8/83/Forest_Owlet_Athene_blewitti_by_Ashahar_alias_Krishna_Khan.jpeg", "photoLocation": "India", "family": "Bird", "rarity": "Common" },
    {  "species": "Chelonia mydas", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Chelonia_mydas_%28Hawaiian_variety%29.jpg/1280px-Chelonia_mydas_%28Hawaiian_variety%29.jpg", "photoLocation": "Hawaii", "family": "Reptile", "rarity": "Epic" },
    {  "species": "Panthera tigris altaica", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/P.t.altaica_Tomak_Male.jpg/1024px-P.t.altaica_Tomak_Male.jpg", "photoLocation": "Russia", "family": "Mammal", "rarity": "Legendary" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
    {  "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary" },
];

var userArr = [
    { "id": 1, "username": "david1", "firstName": "David", "lastName": "Vaz", "email": "david@gmail.com", "phone": "912345678", "animalSet": new Set(animalArr), "rating": 50 },
    { "id": 2, "username": "magno2", "firstName": "Magno", "lastName": "Matos", "email": "magno@gmail.com", "phone": "913456789", "animalSet": new Set(animalArr), "rating": 30 },
    { "id": 3, "username": "miguel3", "firstName": "Miguel", "lastName": "Pacheco", "email": "miguel@gmail.com", "phone": "914567898", "animalSet": new Set(animalArr), "rating": 40 },
    { "id": 4, "username": "xinadas69", "firstName": "Francisco", "lastName": "Inacio", "email": "xinadanobucho@sapo.net", "phone": "931234567", "animalSet": new Set(animalArr), "rating": 100 }
];
*/

$(document).ready(function () {

    refreshHomePage()
});

function refreshHomePage() {


    function successCallback(response) {
        console.log(response)
        user=response.username
        console.log(response.username)
        showHome(response)
        addPhotos(response.animals)
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/david',
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
        return '<div class="gallery-item" tabindex="' + index + '"><img src="' + value.photoLink + '" class="gallery-image">' +
            '<div class="gallery-item-info">' +
            '<ul><li class="gallery-item-likes"><span class="visually-hidden"></span><i aria-hidden="true"></i>' + value.photoLocation + '</li>'
            + '<li class="gallery-item-comments"><span class="visually-hidden"></span><i aria-hidden="true"></i>' + value.family + '</li></ul></div></div>'

    }).join(''))
}


function showAnimalsHome(animal) {

    return '<img src="' + animal.photoLink + '" class="gallery-image" alt="">';
}

function addAnimal() {
console.log($('#species').prop('id') + ":"+ $('#species').val()+ ":" + $('#photoLink').val())
    function successCallback(response) {
        refreshHomePage(response)
    }

    function errorCallback(request, status, error) {
        console.log(request + status + error)
    }

    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/animal/add',
        type: 'POST',
        data: JSON.stringify({
            username: user.username,
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

//showHome( userArr[1])
//addPhotos(Array.from(userArr[1].animalSet))