package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.application.query.walletActivity.BalanceWalletAccountQuery;
import com.ugerodarr.iobuilders.application.querybus.QueryBus;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class BalanceWalletAccountServiceImpl implements BalanceWalletAccountService{

    @Autowired
    QueryBus queryBus;

    public BalanceWalletAccountServiceImpl(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @Override
    public BalanceWalletAccountViewModel balanceWalletAccount(BigInteger idUser, BigInteger idWalletAccount) throws Exception {
        //Creamos la query
        BalanceWalletAccountQuery query = new BalanceWalletAccountQuery(idUser, idWalletAccount);
        //Realizamos la llamada al bus
        return queryBus.handle(query);
    }
}
