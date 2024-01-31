package com.example.springcrud.persistence.mapper;

import com.example.springcrud.model.User;
import com.example.springcrud.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    User toDto(UserEntity userEntity);
}
