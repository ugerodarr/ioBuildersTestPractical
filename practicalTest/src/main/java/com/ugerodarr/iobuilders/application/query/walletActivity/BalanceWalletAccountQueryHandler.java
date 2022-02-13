package com.ugerodarr.iobuilders.application.query.walletActivity;

import com.ugerodarr.iobuilders.application.querybus.QueryHandler;
import com.ugerodarr.iobuilders.application.usecases.walletActivity.BalanceWalletAccountUseCase;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceWalletAccountQueryHandler implements QueryHandler<BalanceWalletAccountViewModel, BalanceWalletAccountQuery> {

    @Autowired
    BalanceWalletAccountUseCase useCase;

    public BalanceWalletAccountQueryHandler(BalanceWalletAccountUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public BalanceWalletAccountViewModel handle(BalanceWalletAccountQuery query) throws Exception {
        return useCase.handle(query.getIdUser(), query.getIdWalletAccount());
    }
}
