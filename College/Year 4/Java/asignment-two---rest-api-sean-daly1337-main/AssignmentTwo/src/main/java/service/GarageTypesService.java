package service;

import dto.GarageTypesDto;

import java.util.List;

public interface GarageTypesService {

    GarageTypesDto getGarageById(Long garageId);


    List<GarageTypesDto> getGarageTypesList(int page, int limit);

    GarageTypesDto createGarageTypes(GarageTypesDto agentsDto);

    void deleteGarageTypes(Long agentId);

    GarageTypesDto updateGarageTypes(GarageTypesDto agentsDto);
}
