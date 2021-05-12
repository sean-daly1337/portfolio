package service;

import dto.PropertyTypeDto;

import java.util.List;

public interface PropertyTypesService {

    PropertyTypeDto getPropertyTypeById(Long garageId);

    List<PropertyTypeDto> getPropertyTypesList(int page, int limit);

    PropertyTypeDto createPropertyTypes(PropertyTypeDto propertyTypeDto);

    void deletePropertyTypes(Long propertyId);

    PropertyTypeDto updatePropertyTypes(PropertyTypeDto propertyTypeDto);
}
