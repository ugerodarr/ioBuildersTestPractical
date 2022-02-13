package com.ugerodarr.iobuilders.domain.model.user.services;

import com.ugerodarr.iobuilders.domain.model.user.User;

import java.math.BigInteger;

public interface UserDomainService {

    void checkEmailNotExist(String email) throws Exception;

    User checkUserExist(BigInteger idUser) throws Exception;

}
