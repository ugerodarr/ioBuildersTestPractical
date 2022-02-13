package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.TransferDTO;

import java.util.List;

public interface TransferService {

    List<WalletActivity> transfer (TransferDTO transferDTO) throws Exception;

}
