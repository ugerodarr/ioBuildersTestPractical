package com.ugerodarr.iobuilders.application.usecases.walletAccount;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.repository.WalletAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Date;

@Component
public class CreateWalletAccountUseCase {

    @Autowired
    WalletAccountRepository walletAccountRepository;

    @Autowired
    UserDomainService userDomainService;

    public CreateWalletAccountUseCase(WalletAccountRepository walletAccountRepository, UserDomainService userDomainService) {
        this.walletAccountRepository = walletAccountRepository;
        this.userDomainService = userDomainService;
    }

    public WalletAccount handle(String walletAccountName, BigInteger idUser) throws Exception {
        //Comprobamos que el usuario existe
        User user = userDomainService.checkUserExist(idUser);
        //Creamos un nuevo WalletAccount
        WalletAccount walletAccount = new WalletAccount(walletAccountName, user, new Date());
        //Guardamos el WalletAccount
        return walletAccountRepository.saveAndFlush(walletAccount);
    }

}
