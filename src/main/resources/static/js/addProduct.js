$(document).ready(function() {

    $('#submit').click(function () {
        formData = $('form').serializeArray();
        formAttr = ["name", "description"];
        formName =
        jsonObj = {};
        for (i = 0; i < formAttr.length; i++) {
            jsonObj[formAttr[i]] = formData[i]["value"];
        }
        $.ajax({
            url: "http://localhost:8080/products",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(jsonObj),
        }).done(function(data, status) {
            alert("successfully added product");
        }).fail(function(data, status) {
            alert("failed to add product");
        });
    });
});