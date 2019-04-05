$(document).ready(function () {

    showPage()
});

function showPage() {



    function successCallback(response) {
        $('.animalName').append('<p id="id"><img src="' + animal.photo + '"></p>')
        $('.photoLocation').append('<img src="' + animal.photoLocation + '">')
        $('.animalSpecies').append('<p id="specie">' + animal.species + '</p>')
        $('.family').append('<p id="family">' + animal.family + '</p>')
        $('.rarity').append('<p id=rarity">' + animal.rarity + '</p>')
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/username/animal/',
        async: true,
        success: successCallback,
        error: errorCallback
    });
}