package service.impl;

import dto.GarageTypesDto;
import entities.Garagetypes;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.GarageTypesRepository;
import service.GarageTypesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageTypesServiceImpl implements GarageTypesService {

    @Autowired
    private GarageTypesRepository garageTypesRepository;


    @Override
    public GarageTypesDto getGarageById(Long garageId) {
        Garagetypes garageType = garageTypesRepository.getGarageType(garageId);

        if (garageType == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        GarageTypesDto retValued = new GarageTypesDto();
        BeanUtils.copyProperties(garageType, retValued);

        return retValued;
    }

    @Override
    public List<GarageTypesDto> getGarageTypesList(int page, int limit) {
        List<GarageTypesDto> returnedValue = new ArrayList<>();

        if (page > 0) page--;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Garagetypes> garageTypesRepositoryAll = garageTypesRepository.findAll(pageableRequest);
        List<Garagetypes> garagetypesList = garageTypesRepositoryAll.getContent();

        for (Garagetypes e : garagetypesList) {
            GarageTypesDto garageTypesDto = new GarageTypesDto();
            BeanUtils.copyProperties(e, garageTypesDto);

            returnedValue.add(garageTypesDto);
        }
        return returnedValue;
    }

    @Override
    public GarageTypesDto createGarageTypes(GarageTypesDto agentsDto) {
        Garagetypes garagetypes = new Garagetypes();
        BeanUtils.copyProperties(agentsDto, garagetypes);

        Garagetypes storedDetails = garageTypesRepository.save(garagetypes);
        GarageTypesDto returnedValue = new GarageTypesDto();
        BeanUtils.copyProperties(storedDetails, returnedValue);

        return returnedValue;
    }

    @Override
    public void deleteGarageTypes(Long agentId) {

        garageTypesRepository.deleteById(agentId);
    }

    @Override
    public GarageTypesDto updateGarageTypes(GarageTypesDto agentsDto) {

        Garagetypes garagetypes = new Garagetypes();
        BeanUtils.copyProperties(agentsDto, garagetypes);

        Garagetypes storedDetails = garageTypesRepository.save(garagetypes);
        GarageTypesDto returnedValue = new GarageTypesDto();
        BeanUtils.copyProperties(storedDetails, returnedValue);

        return returnedValue;
    }
}
