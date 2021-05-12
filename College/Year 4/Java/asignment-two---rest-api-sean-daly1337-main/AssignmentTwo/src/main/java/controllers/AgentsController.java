package controllers;

import dto.AgentsDto;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import models.requests.AgentsDeleteRequestModel;
import models.requests.AgentsRequestModel;
import models.responses.AgentsResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.AgentsService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agents") // http://localhost:8080/agents
public class AgentsController {

    @Autowired
    Utils utils;

    @Autowired
    private AgentsService agentsService;

    @GetMapping(path = "/{agent_Id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public AgentsResponseModel getAgent(@PathVariable Long agent_Id) {
        AgentsResponseModel returnedValue = new AgentsResponseModel();

        AgentsDto agentsDto = agentsService.getAgentById(agent_Id);

        BeanUtils.copyProperties(agentsDto, returnedValue);

        return returnedValue;
    }

    @GetMapping()
    public List<AgentsDto> getAgents(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<AgentsDto> returnedValue = new ArrayList<>();

        List<AgentsDto> groups = agentsService.getAgentsList(page, limit);

        for (AgentsDto g : groups) {
            AgentsDto groupDto = new AgentsDto();
            BeanUtils.copyProperties(g, groupDto);
            returnedValue.add(groupDto);
        }

        return returnedValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AgentsResponseModel createAgent(@ModelAttribute AgentsRequestModel agentsRequestModel) {

        if (agentsRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (agentsRequestModel.getName() == null || agentsRequestModel.getPhone() == null || agentsRequestModel.getFax() == null
                || agentsRequestModel.getEmail() == null || agentsRequestModel.getUsername() == null || agentsRequestModel.getPassword() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(agentsRequestModel.getName(), agentsRequestModel.getPhone(), agentsRequestModel.getFax(),
                agentsRequestModel.getEmail(), agentsRequestModel.getUsername(), agentsRequestModel.getPassword()))
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        AgentsResponseModel returnedValue = new AgentsResponseModel();
        AgentsDto agentsDto = new AgentsDto();

        BeanUtils.copyProperties(agentsRequestModel, agentsDto);

        AgentsDto createdUser = agentsService.createAgent(agentsDto);
        BeanUtils.copyProperties(createdUser, returnedValue);

        return returnedValue;
    }

    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String deleteAgent(@ModelAttribute AgentsDeleteRequestModel agentsDeleteRequestModel) {

        agentsService.deleteAgent(agentsDeleteRequestModel.getAgentId());
        return "Agent Deleted from database";
    }

    @PutMapping(path = "/{agent_Id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AgentsResponseModel updateAgent(@PathVariable Long agent_Id, @ModelAttribute AgentsRequestModel agentsRequestModel) {

        if (agentsRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (agentsRequestModel.getName() == null || agentsRequestModel.getPhone() == null || agentsRequestModel.getFax() == null
                || agentsRequestModel.getEmail() == null || agentsRequestModel.getUsername() == null || agentsRequestModel.getPassword() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(agentsRequestModel.getName(), agentsRequestModel.getPhone(), agentsRequestModel.getFax(),
                agentsRequestModel.getEmail(), agentsRequestModel.getUsername(), agentsRequestModel.getPassword()))
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        AgentsDto fetchedUser = agentsService.getAgentById(agent_Id);
        if (fetchedUser == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.BAD_REQUEST);

        AgentsResponseModel returnedValue = new AgentsResponseModel();
        AgentsDto agentsDto = new AgentsDto();

        BeanUtils.copyProperties(agentsRequestModel, agentsDto);

        AgentsDto createdUser = agentsService.updateAgent(agentsDto);
        BeanUtils.copyProperties(createdUser, returnedValue);

        return returnedValue;
    }

}
