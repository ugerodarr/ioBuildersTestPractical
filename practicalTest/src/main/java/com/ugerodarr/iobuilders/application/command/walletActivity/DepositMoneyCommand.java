package com.ugerodarr.iobuilders.application.command.walletActivity;

import com.ugerodarr.iobuilders.application.commandbus.Command;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;

import java.math.BigInteger;

public class DepositMoneyCommand extends Command<WalletActivity> {

    private BigInteger idUser;
    private BigInteger idWalletAccount;
    private String description;
    private Float quantity;

    public DepositMoneyCommand(BigInteger idUser, BigInteger idWalletAccount, String description, Float quantity) {
        this.idUser = idUser;
        this.idWalletAccount = idWalletAccount;
        this.description = description;
        this.quantity = quantity;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public BigInteger getIdWalletAccount() {
        return idWalletAccount;
    }

    public String getDescription() {
        return description;
    }

    public Float getQuantity() {
        return quantity;
    }
}
