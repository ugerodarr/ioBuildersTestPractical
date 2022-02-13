package com.ugerodarr.iobuilders.domain.model.user.services;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserDomainServiceImpl implements UserDomainService{

    @Autowired
    UserRepository userRepository;

    public UserDomainServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Servicio que comprueba si existe el email y si no lanza una excepcion
    @Override
    public void checkEmailNotExist(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user != null)
        {
            throw new Exception("Email already exists");
        }
    }

    //Servicio que comprueba si existe el usuario y si no lanza una excepcion
    @Override
    public User checkUserExist(BigInteger idUser) throws Exception {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty())
        {
            throw new Exception("User not found");
        }
        return user.get();
    }
}
