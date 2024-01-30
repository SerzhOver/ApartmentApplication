package com.example.springcrud.mapper;

import com.example.springcrud.entity.UserEntity;
import com.example.springcrud.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

    User toDto(UserEntity userEntity);
}
