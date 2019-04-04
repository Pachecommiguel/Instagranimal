

/*
$(document).ready(function () {

    refreshHomePage ()
});
*/

var animalArr = [
    { "id": 1, "species": "Panthera tigris altaica", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/P.t.altaica_Tomak_Male.jpg/1024px-P.t.altaica_Tomak_Male.jpg", "photoLocation": "Russia", "family": "Mammal", "rarity": "Legendary"},
    { "id": 2, "species": "Athene blewitti", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/8/83/Forest_Owlet_Athene_blewitti_by_Ashahar_alias_Krishna_Khan.jpeg", "photoLocation": "India", "family": "Bird", "rarity": "Common"},
    { "id": 3, "species": "Chelonia mydas", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Chelonia_mydas_%28Hawaiian_variety%29.jpg/1280px-Chelonia_mydas_%28Hawaiian_variety%29.jpg", "photoLocation": "Hawaii", "family": "Reptile", "rarity": "Epic"},
    { "id": 4, "species": "Batrachoseps campi", "photoLink": "http://www.californiaherps.com/salamanders/images/bcampi2bs604.jpg", "photoLocation": "California", "family": "Amphibian", "rarity": "Rare"},
    { "id": 5, "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary"},
    { "id": 6, "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary"},
    { "id": 7, "species": "Chamaetylas choloensis", "photoLink": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg/800px-Cholo_Alethe_-_Malawi_S4E4612_%2817234917695%29.jpg", "photoLocation": "Mozambique", "family": "Bird", "rarity": "Legendary"},

    ];

var userArr = [
    { "id": 1, "username": "david1", "firstName": "David", "lastName": "Vaz", "email": "david@gmail.com", "phone": "912345678", "animalSet": new Set(animalArr), "rating": 50},
    { "id": 2, "username": "magno2","firstName": "Magno", "lastName": "Matos", "email": "magno@gmail.com", "phone": "913456789","animalSet": new Set(animalArr), "rating":  30},
    { "id": 3, "username": "miguel3","firstName": "Miguel", "lastName": "Pacheco", "email": "miguel@gmail.com", "phone": "914567898", "animalSet": new Set(animalArr) , "rating": 40 },
    { "id": 4, "username": "xinadas69","firstName": "Francisco", "lastName": "Inacio", "email": "xinadanobucho@sapo.net", "phone": "931234567","animalSet": new Set(animalArr), "rating": 100}
];



function refreshHomePage (){

    function successCallback(response) {
        showHome(response)
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://localhost:8080/',
        async: true,
        success: successCallback,
        error: errorCallback
    });
}

function showHome(response) {

    showUserHome(response)
}

function showUserHome(user) {
    $('#User').append('<p id="user"' + user.username + '>' + user.username + '</p>' +
        '<p id="rating">' + user.rating + '</p>')
}

function addPhotos(animals) {

    var row = 0;
    $('#table').append('<tr id="row' + row++ + '">' + animals.map(function (value, index) {
       return index % 3 != 0 || index == 0 ? 
        showAnimalsHome(value) : '</tr><tr>' + showAnimalsHome(value) }).join('') + '</tr>')
}

function showAnimalsHome(animal) {

    return'<td><img id="animal' + animal.id + '" src="' + animal.photoLink +'" width="200" height="240"></td>';
}


showHome (userArr[1])
addPhotos(Array.from(userArr[1].animalSet))