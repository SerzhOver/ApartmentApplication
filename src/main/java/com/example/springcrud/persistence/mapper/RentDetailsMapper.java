package com.example.springcrud.persistence.mapper;

import com.example.springcrud.model.RentDetails;
import com.example.springcrud.persistence.entity.RentDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface RentDetailsMapper {

    @Mapping(target = "id", ignore = true)
    RentDetailsEntity toEntity(RentDetails rentDetails);
}