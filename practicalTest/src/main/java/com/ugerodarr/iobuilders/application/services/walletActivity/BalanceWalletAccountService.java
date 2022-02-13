package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;

import java.math.BigInteger;

public interface BalanceWalletAccountService {

    BalanceWalletAccountViewModel balanceWalletAccount(BigInteger idUser, BigInteger idWalletAccount) throws Exception;

}
