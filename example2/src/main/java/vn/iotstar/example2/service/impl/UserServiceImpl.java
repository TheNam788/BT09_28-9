package vn.iotstar.example2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import vn.iotstar.example2.dto.UserDTO;
import vn.iotstar.example2.mapper.UserMapper;
import vn.iotstar.example2.repository.UserRepository;
import vn.iotstar.example2.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;

    public UserDTO findById(Long id) {
        return mapper.toDTO(repo.findById(id).orElseThrow());
    }
}
