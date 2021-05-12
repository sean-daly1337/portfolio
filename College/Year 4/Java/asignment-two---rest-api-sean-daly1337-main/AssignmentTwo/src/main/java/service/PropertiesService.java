package service;

import dto.PropertiesDto;

import java.util.List;

public interface PropertiesService {


    PropertiesDto getPropertiesById(Long pId);

    List<PropertiesDto> getAllProperties(int page, int limit);

    PropertiesDto createProperties(PropertiesDto propertiesDto);

    void deleteProperties(Long pId);

    PropertiesDto updateProperties(PropertiesDto propertiesDto);
}
