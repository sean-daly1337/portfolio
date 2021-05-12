package controllers;

import dto.PropertiesDto;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import models.requests.AgentsDeleteRequestModel;
import models.responses.PropertiesResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.PropertiesService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/properties") // http://localhost:8080/agents
public class PropertiesController {


    @Autowired
    Utils utils;

    @Autowired
    private PropertiesService propertiesService;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PropertiesResponseModel getProperties(@PathVariable Long id) {
        PropertiesResponseModel returnedValue = new PropertiesResponseModel();

        PropertiesDto propertiesDto = propertiesService.getPropertiesById(id);

        BeanUtils.copyProperties(propertiesDto, returnedValue);

        return returnedValue;
    }


    @GetMapping()
    public List<PropertiesDto> getAgents(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<PropertiesDto> returnedValue = new ArrayList<>();

        List<PropertiesDto> allProperties = propertiesService.getAllProperties(page, limit);

        for (PropertiesDto g : allProperties) {
            PropertiesDto propertiesDto = new PropertiesDto();
            BeanUtils.copyProperties(g, propertiesDto);
            returnedValue.add(propertiesDto);
        }

        return returnedValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PropertiesResponseModel createAgent(@ModelAttribute PropertiesResponseModel propertiesResponseModel) {

        if (propertiesResponseModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        PropertiesResponseModel returnedValue = new PropertiesResponseModel();
        PropertiesDto propertiesDto = new PropertiesDto();

        BeanUtils.copyProperties(propertiesResponseModel, propertiesDto);

        PropertiesDto createdProperty = propertiesService.createProperties(propertiesDto);
        BeanUtils.copyProperties(createdProperty, returnedValue);

        return returnedValue;
    }


    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String deleteProperty(@ModelAttribute AgentsDeleteRequestModel agentsDeleteRequestModel) {

        propertiesService.deleteProperties(agentsDeleteRequestModel.getAgentId());
        return "Property Deleted from database";
    }


    @PutMapping(path = "/{pId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PropertiesResponseModel updateAgent(@PathVariable Long pId, @ModelAttribute PropertiesResponseModel agentsRequestModel) {

        if (agentsRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        PropertiesDto fetchedUser = propertiesService.getPropertiesById(pId);
        if (fetchedUser == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.BAD_REQUEST);

        PropertiesResponseModel returnedValue = new PropertiesResponseModel();
        PropertiesDto propertiesDto = new PropertiesDto();

        BeanUtils.copyProperties(agentsRequestModel, propertiesDto);

        PropertiesDto createdProperty = propertiesService.updateProperties(propertiesDto);
        BeanUtils.copyProperties(createdProperty, returnedValue);

        return returnedValue;
    }
}
