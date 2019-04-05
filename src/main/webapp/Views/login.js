
function homePage() {

    function successCallback(response) {
        window.location.replace = "file:///Users/codecadet/Desktop/Hackathon/hack/src/main/webapp/Views/index.html";
    }

    function errorCallback(request, status, error) { }


    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/' + $('#login').val(),
        async: true,
        success: successCallback,
        error: errorCallback
    });
}