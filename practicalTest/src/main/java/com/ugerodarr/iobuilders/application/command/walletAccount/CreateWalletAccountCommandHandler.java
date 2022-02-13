package com.ugerodarr.iobuilders.application.command.walletAccount;

import com.ugerodarr.iobuilders.application.commandbus.CommandHandler;
import com.ugerodarr.iobuilders.application.usecases.walletAccount.CreateWalletAccountUseCase;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateWalletAccountCommandHandler implements CommandHandler<WalletAccount, CreateWalletAccountCommand> {

    @Autowired
    CreateWalletAccountUseCase useCase;

    public CreateWalletAccountCommandHandler(CreateWalletAccountUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public WalletAccount handle(CreateWalletAccountCommand command) throws Exception {
        //Realizamos la llamada al caso de uso
        return useCase.handle(command.getWalletAccountName(), command.getIdUser());
    }
}
