
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

function createUser() {
    
console.log(JSON.stringify({
    [$('#username').prop('id')]: $('#username').val(),
    [$('#firstName').prop('id')]: $('#firstName').val(),
    [$('#lastName').prop('id')]: $('#lastName').val(),
    [$('#email').prop('id')]: $('#email').val(),
    [$('#phone').prop('id')]: $('#phone').val(),
}))
    function successCallback(response) {
    }

    function errorCallback(request, status, error) {
        console.log(request + status + error)
    }

    $.ajax({
        url: 'http://192.168.1.28:8080/instagranimal/api/user/create',
        type: 'POST',
        data: JSON.stringify({
            [$('#username').prop('id')]: $('#username').val(),
            [$('#firstName').prop('id')]: $('#firstName').val(),
            [$('#lastName').prop('id')]: $('#lastName').val(),
            [$('#email').prop('id')]: $('#email').val(),
            [$('#phone').prop('id')]: $('#phone').val(),
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });
}