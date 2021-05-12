package service.impl;

import dto.PropertyTypeDto;
import entities.Propertytypes;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.PropertyTypesRepository;
import service.PropertyTypesService;
import shared.Utils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyTypeServiceImpl implements PropertyTypesService {

    @Autowired
    Utils utils;

    @Autowired
    private PropertyTypesRepository propertyTypesRepository;


    @Override
    public PropertyTypeDto getPropertyTypeById(Long propertyId) {
        Propertytypes propertyType = propertyTypesRepository.getPropertyType(propertyId);

        if (propertyType == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        PropertyTypeDto retValued = new PropertyTypeDto();
        BeanUtils.copyProperties(propertyType, retValued);

        return retValued;
    }

    @Override
    public List<PropertyTypeDto> getPropertyTypesList(int page, int limit) {
        List<PropertyTypeDto> returnedValue = new ArrayList<>();

        if (page > 0) page--;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Propertytypes> propertyTypesRepositoryAll = propertyTypesRepository.findAll(pageableRequest);
        List<Propertytypes> propertyTypesRepositoryAllContent = propertyTypesRepositoryAll.getContent();

        for (Propertytypes e : propertyTypesRepositoryAllContent) {
            PropertyTypeDto propertyTypeDto = new PropertyTypeDto();
            BeanUtils.copyProperties(e, propertyTypeDto);

            returnedValue.add(propertyTypeDto);
        }
        return returnedValue;
    }

    @Override
    public PropertyTypeDto createPropertyTypes(PropertyTypeDto propertyTypeDto) {
        Propertytypes propertytypes = new Propertytypes();
        BeanUtils.copyProperties(propertyTypeDto, propertytypes);

        Propertytypes storedDetails = propertyTypesRepository.save(propertytypes);
        PropertyTypeDto returnedValue = new PropertyTypeDto();
        BeanUtils.copyProperties(storedDetails, returnedValue);

        return returnedValue;
    }

    @Override
    public void deletePropertyTypes(Long propertyId) {
        propertyTypesRepository.deleteById(propertyId);

    }

    @Override
    public PropertyTypeDto updatePropertyTypes(PropertyTypeDto agentsDto) {
        return null;
    }
}
