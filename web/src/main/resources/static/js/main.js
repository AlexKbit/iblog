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