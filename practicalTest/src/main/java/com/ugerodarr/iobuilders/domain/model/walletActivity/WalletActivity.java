package com.ugerodarr.iobuilders.domain.model.walletActivity;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "WALLETACTIVITY")
public class WalletActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDWALLETACTIVITY")
    private BigInteger idWalletActivity;

    @ManyToOne
    @JoinColumn(name="IDWALLETACCOUNT", nullable = false)
    private WalletAccount walletAccount;

    @ManyToOne
    @JoinColumn(name="IDACTIVITYTYPE", nullable = false)
    private ActivityType activityType;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="QUANTITY", nullable = false)
    private Float quantity;

    @Column(name="CREATION_DATE")
    private Date creationDate;

    public WalletActivity() {
    }

    public WalletActivity(WalletAccount walletAccount, ActivityType activityType, String description, Float quantity, Date creationDate) {
        this.walletAccount = walletAccount;
        this.activityType = activityType;
        this.description = description;
        this.quantity = quantity;
        this.creationDate = creationDate;
    }

    public BigInteger getIdWalletActivity() {
        return idWalletActivity;
    }

    public void setIdWalletActivity(BigInteger idWalletActivity) {
        this.idWalletActivity = idWalletActivity;
    }

    public WalletAccount getWalletAccount() {
        return walletAccount;
    }

    public void setWalletAccount(WalletAccount walletAccount) {
        this.walletAccount = walletAccount;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
