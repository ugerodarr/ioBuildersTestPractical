package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.application.command.walletActivity.DepositMoneyCommand;
import com.ugerodarr.iobuilders.application.commandbus.CommandBus;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.DepositMoneyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositMoneyServiceImpl implements DepositMoneyService{

    @Autowired
    CommandBus commandBus;

    public DepositMoneyServiceImpl(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public WalletActivity depositMoney(DepositMoneyDTO depositMoneyDTO) throws Exception {
        //Creamos el comando
        DepositMoneyCommand command = new DepositMoneyCommand(depositMoneyDTO.idUser, depositMoneyDTO.idWalletAccount, depositMoneyDTO.description, depositMoneyDTO.quantity);
        //Realizamos la llamada el bus
        return commandBus.handle(command);
    }
}
