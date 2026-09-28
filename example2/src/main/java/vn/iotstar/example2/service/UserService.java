package vn.iotstar.example2.service;

import vn.iotstar.example2.dto.UserDTO;

public interface UserService {

    UserDTO findById(Long id);
}
