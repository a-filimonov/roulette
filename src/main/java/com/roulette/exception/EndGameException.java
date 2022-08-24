package com.roulette.exception;

import com.roulette.core.user.User;
import lombok.Getter;

@Getter
public class EndGameException extends RuntimeException {

    private final User user;

    public EndGameException(User user) {
        super(String.format("Game ended for user %s", user.getName()));
        this.user = user;
    }
}
