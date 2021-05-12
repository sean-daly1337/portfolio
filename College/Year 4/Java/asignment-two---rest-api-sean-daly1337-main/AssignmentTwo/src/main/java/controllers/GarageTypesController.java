package controllers;

import dto.GarageTypesDto;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import models.requests.GarageTypesDeleteRequestModel;
import models.requests.GarageTypesRequestModel;
import models.responses.GarageTypeResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.GarageTypesService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/garageTypes") // http://localhost:8080/agents
public class GarageTypesController {

    @Autowired
    Utils utils;

    @Autowired
    private GarageTypesService garageTypesService;


    @GetMapping(path = "/{garage_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GarageTypeResponseModel getGarageType(@PathVariable Long garage_id) {
        GarageTypeResponseModel returnedValue = new GarageTypeResponseModel();

        GarageTypesDto garageTypeDto = garageTypesService.getGarageById(garage_id);

        BeanUtils.copyProperties(garageTypeDto, returnedValue);

        return returnedValue;
    }

    @GetMapping()
    public List<GarageTypesDto> getAllGarageTypes(@RequestParam(name = "page", defaultValue = "0") int page,
                                                  @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<GarageTypesDto> returnedValue = new ArrayList<>();

        List<GarageTypesDto> garageTypesList = garageTypesService.getGarageTypesList(page, limit);

        for (GarageTypesDto g : garageTypesList) {
            GarageTypesDto groupDto = new GarageTypesDto();
            BeanUtils.copyProperties(g, groupDto);
            returnedValue.add(groupDto);
        }

        return returnedValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GarageTypeResponseModel createGarage(@ModelAttribute GarageTypesRequestModel garageTypesRequestModel) {

        if (garageTypesRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (garageTypesRequestModel.getG_Type() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(garageTypesRequestModel.getG_Type())) {
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        GarageTypeResponseModel returnedValue = new GarageTypeResponseModel();
        GarageTypesDto garageTypesDto = new GarageTypesDto();

        BeanUtils.copyProperties(garageTypesRequestModel, garageTypesDto);

        GarageTypesDto createdGarageType = garageTypesService.createGarageTypes(garageTypesDto);
        BeanUtils.copyProperties(createdGarageType, returnedValue);

        return returnedValue;
    }

    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String deleteGarage(@ModelAttribute GarageTypesDeleteRequestModel garageTypesDeleteRequestModel) {

        if (garageTypesDeleteRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (garageTypesDeleteRequestModel.getGarage_Id() == 0)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        garageTypesService.deleteGarageTypes(garageTypesDeleteRequestModel.getGarage_Id());
        return "Garage Type Deleted from database";
    }

    @PutMapping(path = "/{agent_Id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GarageTypeResponseModel updateGarage(@PathVariable Long agent_Id, @ModelAttribute GarageTypesRequestModel garageTypesRequestModel) {

        if (garageTypesRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (garageTypesRequestModel.getG_Type() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(garageTypesRequestModel.getG_Type())) {
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
        GarageTypesDto fetchedGarageType = garageTypesService.getGarageById(agent_Id);
        if (fetchedGarageType == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.BAD_REQUEST);

        GarageTypeResponseModel returnedValue = new GarageTypeResponseModel();
        GarageTypesDto garageTypesDto = new GarageTypesDto();

        BeanUtils.copyProperties(garageTypesRequestModel, garageTypesDto);

        GarageTypesDto createdGarageTypes = garageTypesService.updateGarageTypes(garageTypesDto);
        BeanUtils.copyProperties(createdGarageTypes, returnedValue);

        return returnedValue;
    }
}
