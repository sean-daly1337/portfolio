package service.impl;

import dto.PropertiesDto;
import entities.Properties;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.PropertiesRepository;
import service.PropertiesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private PropertiesRepository propertiesRepository;


    @Override
    public PropertiesDto getPropertiesById(Long id) {
        Properties properties = propertiesRepository.getPropertiesById(id);

        if (properties == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        PropertiesDto retValued = new PropertiesDto();
        BeanUtils.copyProperties(properties, retValued);

        return retValued;
    }

    @Override
    public List<PropertiesDto> getAllProperties(int page, int limit) {
        List<PropertiesDto> returnedValue = new ArrayList<>();

        if (page > 0) page--;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Properties> groupsPage = propertiesRepository.findAll(pageableRequest);
        List<Properties> propertiesList = groupsPage.getContent();

        for (Properties e : propertiesList) {
            PropertiesDto propertiesDto = new PropertiesDto();
            BeanUtils.copyProperties(e, propertiesDto);

            returnedValue.add(propertiesDto);
        }
        return returnedValue;
    }

    @Override
    public PropertiesDto createProperties(PropertiesDto propertiesDto) {
        Properties properties = new Properties();
        BeanUtils.copyProperties(propertiesDto, properties);

        Properties storedUserDetails = propertiesRepository.save(properties);
        PropertiesDto returnedValue = new PropertiesDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }

    @Override
    public void deleteProperties(Long pId) {
        propertiesRepository.deleteById(pId);
    }

    @Override
    public PropertiesDto updateProperties(PropertiesDto propertiesDto) {

        Properties properties = new Properties();
        BeanUtils.copyProperties(propertiesDto, properties);

        Properties storedUserDetails = propertiesRepository.save(properties);
        PropertiesDto returnedValue = new PropertiesDto();
        BeanUtils.copyProperties(storedUserDetails, returnedValue);

        return returnedValue;
    }
}
