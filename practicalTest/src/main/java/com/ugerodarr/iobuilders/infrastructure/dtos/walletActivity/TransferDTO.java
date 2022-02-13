package com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class TransferDTO {

    @NotNull(message = "idUserSender can not be null")
    public BigInteger idUserSender;

    @NotNull(message = "idWalletAccountSender can not be null")
    public BigInteger idWalletAccountSender;

    @NotNull(message = "idUserReceiver can not be null")
    public BigInteger idUserReceiver;

    @NotNull(message = "idWalletAccountReceiver can not be null")
    public BigInteger idWalletAccountReceiver;

    public String description;

    @NotNull(message = "Quantity can not be null")
    public Float quantity;

    public TransferDTO() {
    }

    public TransferDTO(BigInteger idUserSender, BigInteger idWalletAccountSender, BigInteger idUserReceiver, BigInteger idWalletAccountReceiver, String description, Float quantity) {
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

    public void setIdUserSender(BigInteger idUserSender) {
        this.idUserSender = idUserSender;
    }

    public BigInteger getIdWalletAccountSender() {
        return idWalletAccountSender;
    }

    public void setIdWalletAccountSender(BigInteger idWalletAccountSender) {
        this.idWalletAccountSender = idWalletAccountSender;
    }

    public BigInteger getIdUserReceiver() {
        return idUserReceiver;
    }

    public void setIdUserReceiver(BigInteger idUserReceiver) {
        this.idUserReceiver = idUserReceiver;
    }

    public BigInteger getIdWalletAccountReceiver() {
        return idWalletAccountReceiver;
    }

    public void setIdWalletAccountReceiver(BigInteger idWalletAccountReceiver) {
        this.idWalletAccountReceiver = idWalletAccountReceiver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
