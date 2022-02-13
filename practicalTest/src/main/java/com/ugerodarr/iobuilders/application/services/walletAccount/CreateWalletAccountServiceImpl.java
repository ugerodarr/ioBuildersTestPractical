package com.ugerodarr.iobuilders.application.services.walletAccount;

import com.ugerodarr.iobuilders.application.command.walletAccount.CreateWalletAccountCommand;
import com.ugerodarr.iobuilders.application.commandbus.CommandBus;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletAccount.WalletAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateWalletAccountServiceImpl implements CreateWalletAccountService{

    @Autowired
    CommandBus commandBus;

    public CreateWalletAccountServiceImpl(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public WalletAccount createWalletAccount(WalletAccountDTO walletAccountDTO) throws Exception {
        //Creamos el comando
        CreateWalletAccountCommand command = new CreateWalletAccountCommand(walletAccountDTO.getWalletAccountName(), walletAccountDTO.getIdUser());
        //Realizamos la llamada el bus
        return commandBus.handle(command);
    }
}
