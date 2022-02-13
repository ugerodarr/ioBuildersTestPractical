package com.ugerodarr.iobuilders.application.usecases.user;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.repository.UserRepository;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateUserUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDomainService userDomainService;

    public CreateUserUseCase(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    public User handle(String name, String lastName, String password, String email) throws Exception {
        //Comprobamos que el email no esta registrado
        userDomainService.checkEmailNotExist(email);
        //Creamos un nuevo usuario
        User user = new User(name, lastName, password, email, new Date());
        //Guardamos el usuario
        return userRepository.saveAndFlush(user);
    }
}
