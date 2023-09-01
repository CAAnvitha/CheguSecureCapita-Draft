package com.anvitha.securecapita.service;

import com.anvitha.securecapita.domain.User;
import com.anvitha.securecapita.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
