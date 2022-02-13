package com.ugerodarr.iobuilders.application.command.walletAccount;

import com.ugerodarr.iobuilders.application.commandbus.Command;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;

import java.math.BigInteger;

public class CreateWalletAccountCommand extends Command<WalletAccount> {

    private String walletAccountName;
    private BigInteger idUser;

    public CreateWalletAccountCommand(String walletAccountName, BigInteger idUser) {
        this.walletAccountName = walletAccountName;
        this.idUser = idUser;
    }

    public String getWalletAccountName() {
        return walletAccountName;
    }

    public BigInteger getIdUser() {
        return idUser;
    }
}
