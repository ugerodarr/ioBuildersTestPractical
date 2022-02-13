package com.ugerodarr.iobuilders.domain.model.user.repository;

import com.ugerodarr.iobuilders.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {

    //Consulta que obtiene el usuario por el campo email
    User findByEmail(String email);

}
