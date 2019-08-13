function reg1() {
    $('#register').modal('show');
}

function log_in() {
    $('#log_in').modal('show');
}

var userRegUrl = 'registerUser/';

function addUser() {
    var form = $('#registration');
    $.ajax({
        type: 'POST',
        url: userRegUrl,
        data: form.serialize(),
        success: function (data) {
            $('#register').modal('hide');
            success('add user');
        }
    });
}

function logIn() {
    var form = $('#enterForm');
    $.ajax({
        type: 'POST',
        url: 'spring_security_check',
        success: function (data) {
            $('#log_in').modal('hide');
            window.location.href = 'start';
        }

    });
}