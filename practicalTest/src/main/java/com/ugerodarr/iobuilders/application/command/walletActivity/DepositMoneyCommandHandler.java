package com.ugerodarr.iobuilders.application.command.walletActivity;


import com.ugerodarr.iobuilders.application.commandbus.CommandHandler;
import com.ugerodarr.iobuilders.application.usecases.walletActivity.DepositMoneyUseCase;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepositMoneyCommandHandler implements CommandHandler<WalletActivity, DepositMoneyCommand> {

    @Autowired
    DepositMoneyUseCase useCase;

    public DepositMoneyCommandHandler(DepositMoneyUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public WalletActivity handle(DepositMoneyCommand command) throws Exception {
        //Realizamos la llamada al caso de uso
        return useCase.handle(command.getIdUser(), command.getIdWalletAccount(), command.getDescription(), command.getQuantity());
    }
}
