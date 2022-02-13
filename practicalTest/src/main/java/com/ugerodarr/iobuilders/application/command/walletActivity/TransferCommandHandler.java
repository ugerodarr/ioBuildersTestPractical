package com.ugerodarr.iobuilders.application.command.walletActivity;

import com.ugerodarr.iobuilders.application.commandbus.CommandHandler;
import com.ugerodarr.iobuilders.application.usecases.walletActivity.TransferUseCase;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferCommandHandler implements CommandHandler<List<WalletActivity>, TransferCommand> {

    @Autowired
    TransferUseCase useCase;

    public TransferCommandHandler(TransferUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<WalletActivity> handle(TransferCommand command) throws Exception {
        //Realizamos la llamada al caso de uso
        return useCase.handle(command.getIdUserSender(), command.getIdWalletAccountSender(), command.getIdUserReceiver(), command.getIdWalletAccountReceiver(), command.getDescription(), command.getQuantity());
    }
}
