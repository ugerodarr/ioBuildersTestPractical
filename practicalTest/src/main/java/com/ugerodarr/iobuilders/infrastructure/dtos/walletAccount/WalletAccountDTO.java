package com.ugerodarr.iobuilders.infrastructure.dtos.walletAccount;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class WalletAccountDTO {

    @NotNull(message = "IdUser can not be null")
    public BigInteger idUser;

    @NotBlank(message = "walletAccountName can not be null")
    public String walletAccountName;

    public WalletAccountDTO() {
    }

    public WalletAccountDTO(BigInteger idUser, String walletAccountName) {
        this.idUser = idUser;
        this.walletAccountName = walletAccountName;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public String getWalletAccountName() {
        return walletAccountName;
    }

    public void setWalletAccountName(String walletAccountName) {
        this.walletAccountName = walletAccountName;
    }
}
