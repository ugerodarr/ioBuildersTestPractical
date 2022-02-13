package com.ugerodarr.iobuilders.application.services.user;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.infrastructure.dtos.user.UserDTO;

public interface CreateUserService {

    User createUser(UserDTO userDTO)throws Exception;

}
