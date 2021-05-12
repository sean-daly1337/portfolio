package service.impl;

import dto.StylesDto;
import entities.Styles;
import exceptions.CustomServiceException;
import exceptions.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.StylesRepository;
import service.StylesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StylesServiceImpl implements StylesService {

    @Autowired
    private StylesRepository stylesRepository;


    @Override
    public StylesDto getStylesById(Long stylesId) {
        Styles styles = stylesRepository.getStylesById(stylesId);

        if (styles == null)
            throw new CustomServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        StylesDto retValued = new StylesDto();
        BeanUtils.copyProperties(styles, retValued);

        return retValued;
    }

    @Override
    public List<StylesDto> getStylesList(int page, int limit) {
        List<StylesDto> returnedValue = new ArrayList<>();

        if (page > 0) page--;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Styles> stylesRepositoryAll = stylesRepository.findAll(pageableRequest);
        List<Styles> stylesRepositoryAllContent = stylesRepositoryAll.getContent();

        for (Styles e : stylesRepositoryAllContent) {
            StylesDto stylesDto = new StylesDto();
            BeanUtils.copyProperties(e, stylesDto);

            returnedValue.add(stylesDto);
        }
        return returnedValue;
    }

    @Override
    public StylesDto createStylesTypes(StylesDto stylesDto) {
        Styles styles = new Styles();
        BeanUtils.copyProperties(stylesDto, styles);

        Styles storedDetails = stylesRepository.save(styles);
        StylesDto returnedValue = new StylesDto();
        BeanUtils.copyProperties(storedDetails, returnedValue);

        return returnedValue;
    }

    @Override
    public void deleteStylesTypes(Long stylesId) {

    }

    @Override
    public StylesDto updateStyles(StylesDto stylesDto) {
        return null;
    }
}
