package com.ugerodarr.iobuilders.application.query.walletActivity;

import com.ugerodarr.iobuilders.application.querybus.Query;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;

import java.math.BigInteger;

public class BalanceWalletAccountQuery extends Query<BalanceWalletAccountViewModel> {

    private BigInteger idUser;
    private BigInteger idWalletAccount;

    public BalanceWalletAccountQuery(BigInteger idUser, BigInteger idWalletAccount) {
        this.idUser = idUser;
        this.idWalletAccount = idWalletAccount;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public BigInteger getIdWalletAccount() {
        return idWalletAccount;
    }
}
