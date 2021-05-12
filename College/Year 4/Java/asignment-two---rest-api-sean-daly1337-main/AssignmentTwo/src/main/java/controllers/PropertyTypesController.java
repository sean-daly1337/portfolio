package controllers;

import dto.PropertyTypeDto;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import models.requests.PropertyTypesDeleteRequestModel;
import models.requests.PropertyTypesRequestModel;
import models.responses.GarageTypeResponseModel;
import models.responses.PropertyTypeResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.PropertyTypesService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/propertyTypes") // http://localhost:8080/agents
public class PropertyTypesController {

    @Autowired
    Utils utils;

    @Autowired
    private PropertyTypesService propertyTypesService;


    @GetMapping(path = "/{p_Type}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PropertyTypeResponseModel getPropertyTypes(@PathVariable Long p_Type) {
        PropertyTypeResponseModel returnedValue = new PropertyTypeResponseModel();

        PropertyTypeDto propertyTypeDto = propertyTypesService.getPropertyTypeById(p_Type);

        BeanUtils.copyProperties(propertyTypeDto, returnedValue);

        return returnedValue;
    }

    @GetMapping()
    public List<PropertyTypeDto> getAllPropertyTypes(@RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<PropertyTypeDto> returnedValue = new ArrayList<>();

        List<PropertyTypeDto> propertyTypesList = propertyTypesService.getPropertyTypesList(page, limit);

        for (PropertyTypeDto g : propertyTypesList) {
            PropertyTypeDto propertyTypeDto = new PropertyTypeDto();
            BeanUtils.copyProperties(g, propertyTypeDto);
            returnedValue.add(propertyTypeDto);
        }

        return returnedValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PropertyTypeResponseModel createPropertyTypes(@ModelAttribute PropertyTypesRequestModel propertyTypesRequestModel) {

        if (propertyTypesRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (propertyTypesRequestModel.getP_Type() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(propertyTypesRequestModel.getP_Type())) {
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        PropertyTypeResponseModel returnedValue = new PropertyTypeResponseModel();
        PropertyTypeDto propertyTypeDto = new PropertyTypeDto();

        BeanUtils.copyProperties(propertyTypesRequestModel, propertyTypeDto);

        PropertyTypeDto createdPropertyType = propertyTypesService.createPropertyTypes(propertyTypeDto);
        BeanUtils.copyProperties(createdPropertyType, returnedValue);

        return returnedValue;
    }

    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String deletePropertyTypes(@ModelAttribute PropertyTypesDeleteRequestModel propertyTypesDeleteRequestModel) {

        if (propertyTypesDeleteRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (propertyTypesDeleteRequestModel.getPropertyId() == 0)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        propertyTypesService.deletePropertyTypes(propertyTypesDeleteRequestModel.getPropertyId());
        return "Property Type Deleted from database";
    }

    @PutMapping(path = "/{propertyId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GarageTypeResponseModel updatePropertyTypes(@PathVariable Long propertyId,
                                                       @ModelAttribute PropertyTypesRequestModel propertyTypesRequestModel) {

        if (propertyTypesRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (propertyTypesRequestModel.getP_Type() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(propertyTypesRequestModel.getP_Type())) {
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
        PropertyTypeDto fetchedGarageType = propertyTypesService.getPropertyTypeById(propertyId);
        if (fetchedGarageType == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.BAD_REQUEST);

        GarageTypeResponseModel returnedValue = new GarageTypeResponseModel();
        PropertyTypeDto garageTypesDto = new PropertyTypeDto();

        BeanUtils.copyProperties(propertyTypesRequestModel, garageTypesDto);

        PropertyTypeDto createdGarageTypes = propertyTypesService.updatePropertyTypes(garageTypesDto);
        BeanUtils.copyProperties(createdGarageTypes, returnedValue);

        return returnedValue;
    }
}
