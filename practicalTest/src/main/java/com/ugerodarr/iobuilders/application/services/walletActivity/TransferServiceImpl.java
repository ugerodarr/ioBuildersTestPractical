package com.ugerodarr.iobuilders.application.services.walletActivity;

import com.ugerodarr.iobuilders.application.command.walletActivity.TransferCommand;
import com.ugerodarr.iobuilders.application.commandbus.CommandBus;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    CommandBus commandBus;

    public TransferServiceImpl(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public List<WalletActivity> transfer(TransferDTO transferDTO) throws Exception {
        //Creamos el comando
        TransferCommand command = new TransferCommand(transferDTO.getIdUserSender(), transferDTO.getIdWalletAccountSender(), transferDTO.getIdUserReceiver(), transferDTO.getIdWalletAccountReceiver(), transferDTO.description, transferDTO.quantity);
        //Realizamos la llamada el bus
        return commandBus.handle(command);
    }
}
