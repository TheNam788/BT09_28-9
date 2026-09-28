package vn.iotstar.example2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vn.iotstar.example2.dto.UserDTO;
import vn.iotstar.example2.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User user);
}
