package it.academy.ivan;

import it.academy.ivan.command.ActionCommand;
import it.academy.ivan.command.CommandEnum;
import it.academy.ivan.command.EmptyCommand;
import it.academy.ivan.command.LoginCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * Created by Ivan on 22.05.2016.
 */
public class ActionFactoryTest {
    @Test
    public void checkThatCommandIsLegal() {
        ActionCommand current = new EmptyCommand();
        String action = "login";
        CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
        current = currentEnum.getCurrentCommand();
        assertNotNull(current);
        assertNotSame(new LoginCommand(), current);
    }
}