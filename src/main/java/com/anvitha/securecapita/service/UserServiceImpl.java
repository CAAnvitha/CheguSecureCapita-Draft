package com.anvitha.securecapita.service;

import com.anvitha.securecapita.domain.User;
import com.anvitha.securecapita.dto.UserDTO;
import com.anvitha.securecapita.dtomapper.UserDTOMapper;
import com.anvitha.securecapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return  UserDTOMapper.fromUser(userRepository.create(user));
    }
}
