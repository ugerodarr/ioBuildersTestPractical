package com.ugerodarr.iobuilders.domain.model.walletActivity.repository;

import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface WalletActivityRepository extends JpaRepository<WalletActivity, BigInteger> {

    //Consulta que obtiene toda la actividad de un walletAccount
    List<WalletActivity> findByWalletAccount(WalletAccount walletAccount);

    //Consulta que obtiene la suma de toda la actividad de un walletAccount
    @Query(value = "SELECT SUM(quantity) FROM WALLETACTIVITY w WHERE IDWALLETACCOUNT = ?1", nativeQuery = true)
    Float sumByWalletAccount(BigInteger idwalletAccount);

}
