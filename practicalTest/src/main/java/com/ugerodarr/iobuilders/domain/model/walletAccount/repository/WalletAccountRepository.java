package com.ugerodarr.iobuilders.domain.model.walletAccount.repository;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface WalletAccountRepository extends JpaRepository<WalletAccount, BigInteger> {

    //Consulta que comprueba si el usuario tiene disponible esa walletAccount
    WalletAccount findByIdWalletAccountAndUser(BigInteger idWalletAccount, User user);

}
