package com.ugerodarr.iobuilders.application.commandbus;

public interface CommandBus {

    <T> T handle(Command<T> command) throws Exception;

}
