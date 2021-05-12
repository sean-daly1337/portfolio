package service;

import dto.StylesDto;

import java.util.List;

public interface StylesService {

    StylesDto getStylesById(Long stylesId);

    List<StylesDto> getStylesList(int page, int limit);

    StylesDto createStylesTypes(StylesDto stylesDto);

    void deleteStylesTypes(Long stylesId);

    StylesDto updateStyles(StylesDto stylesDto);
}
