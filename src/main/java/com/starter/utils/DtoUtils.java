package com.starter.utils;

import org.modelmapper.ModelMapper;

public class DtoUtils {
    public DtoEntity converToDto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object converToEntity(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }
}
