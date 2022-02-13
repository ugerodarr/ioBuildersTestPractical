package com.ugerodarr.iobuilders.application.querybus;

public interface QueryHandler<T, U extends Query<T>> {

    T handle(U query) throws Exception;
}