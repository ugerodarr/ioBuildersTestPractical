package com.ugerodarr.iobuilders.domain.model.walletAccount.services;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;

import java.math.BigInteger;

public interface WalletAccountDomainService {

    WalletAccount checkUserInWallet(BigInteger idWalletAccount, User user) throws Exception;

}
