package com.example.advert_search.dto.mapperGenericki;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {
    public DtoEntity convertToDto(Object object,DtoEntity mapper){
        return new ModelMapper().map(object,mapper.getClass());
    }
    public Object convertToEntity(Object object, DtoEntity mapper){
        return new ModelMapper().map(mapper, object.getClass());
    }
}
