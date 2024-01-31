package com.example.springcrud.persistence.mapper;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.persistence.entity.ApartmentEntity;
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