package com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class DepositMoneyDTO {

    @NotNull(message = "IdUser can not be null")
    public BigInteger idUser;

    @NotNull(message = "IdWalletAccount can not be null")
    public BigInteger idWalletAccount;

    public String description;

    @NotNull(message = "Quantity can not be null")
    public Float quantity;

    public DepositMoneyDTO() {
    }

    public DepositMoneyDTO(BigInteger idUser, BigInteger idWalletAccount, String description, Float quantity) {
        this.idUser = idUser;
        this.idWalletAccount = idWalletAccount;
        this.description = description;
        this.quantity = quantity;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public BigInteger getIdWalletAccount() {
        return idWalletAccount;
    }

    public void setIdWalletAccount(BigInteger idWalletAccount) {
        this.idWalletAccount = idWalletAccount;
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
