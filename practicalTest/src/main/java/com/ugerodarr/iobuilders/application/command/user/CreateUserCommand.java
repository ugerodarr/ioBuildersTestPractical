package com.ugerodarr.iobuilders.application.command.user;

import com.ugerodarr.iobuilders.application.commandbus.Command;
import com.ugerodarr.iobuilders.domain.model.user.User;

public class CreateUserCommand extends Command<User> {

    private String name;
    private String lastName;
    private String password;
    private String email;

    public CreateUserCommand(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
