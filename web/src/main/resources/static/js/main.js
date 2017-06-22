function uploadImage(fileUpload, imageIdField, imageSRC, csrfName, token) {
    var fd = new FormData;

    fd.append('uploadingFile', fileUpload.prop('files')[0]);
    fd.append(csrfName, token);

    $.ajax({
        type: "POST",
        url: "/upload/image",
        data: fd,
        processData: false,
        contentType: false,
        success: function(result){
            console.info(result);
            imageIdField.val(result);
            imageSRC.attr("src","/image/"+result);
        }
    });
}

function searhResult(query, search) {
    location.href=query+"&query="+$('#'+search).val()
}

function showMsgBox(msgBox) {
    msgBox.show();
    setTimeout(function() { msgBox.hide(); }, 3000);
}