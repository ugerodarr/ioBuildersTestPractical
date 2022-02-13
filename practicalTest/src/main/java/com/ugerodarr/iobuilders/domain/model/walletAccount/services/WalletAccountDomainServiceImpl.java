package com.ugerodarr.iobuilders.domain.model.walletAccount.services;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.repository.WalletAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class WalletAccountDomainServiceImpl implements WalletAccountDomainService {

    @Autowired
    WalletAccountRepository walletAccountRepository;

    public WalletAccountDomainServiceImpl(WalletAccountRepository walletAccountRepository) {
        this.walletAccountRepository = walletAccountRepository;
    }

    //Servicio que comprueba si el walletAccount es valido para el usuario y si no lanza una excepcion
    @Override
    public WalletAccount checkUserInWallet(BigInteger idWalletAccount, User user) throws Exception {
        WalletAccount walletAccount = walletAccountRepository.findByIdWalletAccountAndUser(idWalletAccount, user);
        if(walletAccount == null)
        {
            throw new Exception("WalletAccount is not valid for this User");
        }
        return walletAccount;
    }

}
