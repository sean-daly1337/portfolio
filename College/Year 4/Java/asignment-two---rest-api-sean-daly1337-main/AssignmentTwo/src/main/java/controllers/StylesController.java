package controllers;

import dto.StylesDto;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import models.requests.StylesDeleteRequestModel;
import models.requests.StylesRequestModel;
import models.responses.StylesResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.StylesService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/styles") // http://localhost:8080/agents
public class StylesController {

    @Autowired
    Utils utils;

    @Autowired
    private StylesService stylesService;

    @GetMapping(path = "/{style_Id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public StylesResponseModel getPropertyTypes(@PathVariable Long style_Id) {
        StylesResponseModel returnedValue = new StylesResponseModel();

        StylesDto stylesDto = stylesService.getStylesById(style_Id);

        BeanUtils.copyProperties(stylesDto, returnedValue);

        return returnedValue;
    }


    @GetMapping()
    public List<StylesDto> getAllStyles(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<StylesDto> returnedValue = new ArrayList<>();

        List<StylesDto> propertyTypesList = stylesService.getStylesList(page, limit);

        for (StylesDto g : propertyTypesList) {
            StylesDto propertyTypeDto = new StylesDto();
            BeanUtils.copyProperties(g, propertyTypeDto);
            returnedValue.add(propertyTypeDto);
        }

        return returnedValue;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StylesResponseModel createPropertyTypes(@ModelAttribute StylesRequestModel stylesRequestModel) {

        if (stylesRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (stylesRequestModel.getP_Style() == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);

        if (!utils.validateData(stylesRequestModel.getP_Style())) {
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        StylesResponseModel returnedValue = new StylesResponseModel();
        StylesDto stylesDto = new StylesDto();

        BeanUtils.copyProperties(stylesRequestModel, stylesDto);

        StylesDto createdStylesDto = stylesService.createStylesTypes(stylesDto);
        BeanUtils.copyProperties(createdStylesDto, returnedValue);

        return returnedValue;
    }

    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public String deleteStyles(@ModelAttribute StylesDeleteRequestModel stylesDeleteRequestModel) {

        if (stylesDeleteRequestModel == null)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        if (stylesDeleteRequestModel.getStyle_Id() == 0)
            throw new CustomServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        stylesService.deleteStylesTypes(stylesDeleteRequestModel.getStyle_Id());
        return "Style Deleted from database";
    }


}
