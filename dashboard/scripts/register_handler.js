$("#buyer_registration_form").submit(function (event) {
    event.preventDefault();

    if ($("#registration_inputProfilepicture").prop('files')[0].size / 1024 / 1024 > 1) {
        alert('Please use an image less than 1MB')
    } else {
        var reader = new FileReader();
        reader.readAsDataURL($("#registration_inputProfilepicture").prop('files')[0]);
        reader.onload = function () {
            data = {
                "contactNo": $("#registration_inputContactnumber").val(),
                "email": $("#registration_inputEmail").val(),
                "passwordHash": $("#registration_inputPassword").val(),
                "profilePicture": reader.result,
                "username": $("#registration_inputUsername").val()
            }

            $.ajax("http://localhost:8080/sellnbye/api/user", {
                data: JSON.stringify(data),
                contentType: 'application/json',
                type: 'POST'
            }).done(function (response) {
                console.log(response)
            });
        };


    }


});