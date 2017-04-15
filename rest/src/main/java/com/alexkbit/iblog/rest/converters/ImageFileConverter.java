package com.alexkbit.iblog.rest.converters;

import com.alexkbit.iblog.model.Image;
import com.alexkbit.iblog.model.ImageType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Util convertor to image from multipart file
 */
public class ImageFileConverter {

    /**
     * Convert {@link MultipartFile} to {@link Image}
     * @param uploadingFile uploading file
     * @return {@link Image}
     * @throws IOException
     */
    public static Image convertTo(MultipartFile uploadingFile) throws IOException {
        Image image = new Image();
        image.setData(uploadingFile.getBytes());
        image.setName(uploadingFile.getOriginalFilename());
        image.setType(ImageType.valueOf(uploadingFile.getContentType().split("/")[1].toUpperCase()));
        return image;
    }
}
