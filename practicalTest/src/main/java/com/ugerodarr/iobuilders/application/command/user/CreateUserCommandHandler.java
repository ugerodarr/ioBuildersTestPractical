package com.ugerodarr.iobuilders.application.command.user;

import com.ugerodarr.iobuilders.application.commandbus.CommandHandler;
import com.ugerodarr.iobuilders.application.usecases.user.CreateUserUseCase;
import com.ugerodarr.iobuilders.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<User, CreateUserCommand> {

    @Autowired
    CreateUserUseCase useCase;

    public CreateUserCommandHandler(CreateUserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public User handle(CreateUserCommand command) throws Exception {
        //Realizamos la llamada al caso de uso
        return useCase.handle(command.getName(), command.getLastName(), command.getPassword(), command.getEmail());
    }
}
