package com.ugerodarr.iobuilders.application.services.walletAccount;

import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletAccount.WalletAccountDTO;


public interface CreateWalletAccountService {

    WalletAccount createWalletAccount(WalletAccountDTO walletAccountDTO) throws Exception;

}
