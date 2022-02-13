package com.ugerodarr.iobuilders.application.services.user;

import com.ugerodarr.iobuilders.application.command.user.CreateUserCommand;
import com.ugerodarr.iobuilders.application.commandbus.CommandBus;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.infrastructure.dtos.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    @Autowired
    CommandBus commandBus;

    public CreateUserServiceImpl(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        //Creamos el comando
        CreateUserCommand command = new CreateUserCommand(userDTO.getName(), userDTO.getLastName(), userDTO.getPassword(), userDTO.getEmail());
        //Realizamos la llamada el bus
        return commandBus.handle(command);
    }
}
