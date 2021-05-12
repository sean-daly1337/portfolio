package service.impl;

import dto.ImageDto;
import entities.Image;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.ImageRepository;
import service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ImageDto getPictureByImageId(String imageId) {
        Image image = imageRepository.findByImageId(imageId);

        if (image == null)
            throw new CustomServiceException(ErrorMessages.IMAGE_NOT_AVAILABLE.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        ImageDto retValued = new ImageDto();
        BeanUtils.copyProperties(image, retValued);

        return retValued;
    }


}
