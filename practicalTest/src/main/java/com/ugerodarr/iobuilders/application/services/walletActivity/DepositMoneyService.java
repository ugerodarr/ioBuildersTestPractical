package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.DepositMoneyDTO;

public interface DepositMoneyService {

    WalletActivity depositMoney(DepositMoneyDTO depositMoneyDTO) throws Exception;

}
