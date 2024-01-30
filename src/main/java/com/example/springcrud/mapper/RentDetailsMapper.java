package com.example.springcrud.mapper;

import com.example.springcrud.entity.RentDetailsEntity;
import com.example.springcrud.model.RentDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface RentDetailsMapper {

    @Mapping(target = "id", ignore = true)
    RentDetailsEntity toEntity(RentDetails rentDetails);
}