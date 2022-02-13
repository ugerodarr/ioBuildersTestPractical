package com.ugerodarr.iobuilders.domain.model.walletAccount;

import com.ugerodarr.iobuilders.domain.model.user.User;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "WALLETACCOUNTS")
public class WalletAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDWALLETACCOUNT")
    private BigInteger idWalletAccount;

    @ManyToOne
    @JoinColumn(name="IDUSER" , nullable = false)
    private User user;

    @Column(name="NAME" , nullable = false)
    private String name;

    @Column(name="CREATION_DATE")
    private Date creationDate;

    public WalletAccount() {
    }

    public WalletAccount(String name, User user, Date creationDate) {
        this.name = name;
        this.user = user;
        this.creationDate = creationDate;
    }

    public BigInteger getIdWalletAccount() {
        return idWalletAccount;
    }

    public void setIdWalletAccount(BigInteger idWalletAccount) {
        this.idWalletAccount = idWalletAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
