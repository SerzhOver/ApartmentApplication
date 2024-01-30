package com.example.springcrud.mapper;

import com.example.springcrud.entity.ApartmentEntity;
import com.example.springcrud.model.Apartment;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ApartmentMapper {

    Apartment toDto(ApartmentEntity entity);

    List<Apartment> toDtoList(List<ApartmentEntity> entityList);

    @Mapping(target = "id", ignore = true)
    ApartmentEntity toEntity(Apartment apartment);
}