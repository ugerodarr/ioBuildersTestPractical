package com.ugerodarr.iobuilders.application.command.walletActivity;

import com.ugerodarr.iobuilders.application.commandbus.Command;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;

import java.math.BigInteger;
import java.util.List;

public class TransferCommand extends Command<List<WalletActivity>> {

    private BigInteger idUserSender;
    private BigInteger idWalletAccountSender;
    private BigInteger idUserReceiver;
    private BigInteger idWalletAccountReceiver;
    private String description;
    private Float quantity;

    public TransferCommand(BigInteger idUserSender, BigInteger idWalletAccountSender, BigInteger idUserReceiver, BigInteger idWalletAccountReceiver, String description, Float quantity) {
        this.idUserSender = idUserSender;
        this.idWalletAccountSender = idWalletAccountSender;
        this.idUserReceiver = idUserReceiver;
        this.idWalletAccountReceiver = idWalletAccountReceiver;
        this.description = description;
        this.quantity = quantity;
    }

    public BigInteger getIdUserSender() {
        return idUserSender;
    }

    public BigInteger getIdWalletAccountSender() {
        return idWalletAccountSender;
    }

    public BigInteger getIdUserReceiver() {
        return idUserReceiver;
    }

    public BigInteger getIdWalletAccountReceiver() {
        return idWalletAccountReceiver;
    }

    public String getDescription() {
        return description;
    }

    public Float getQuantity() {
        return quantity;
    }
}
