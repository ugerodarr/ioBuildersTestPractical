package com.ugerodarr.iobuilders.domain.model.walletActivity.services;

import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class WalletActivityDomainServiceImpl implements WalletActivityDomainService{

    @Autowired
    WalletActivityRepository walletActivityRepository;

    @Override
    public Float totalWalletAccount(BigInteger idWalletAccount) {
        return walletActivityRepository.sumByWalletAccount(idWalletAccount);
    }

}
