package it.academy.ivan;

import it.academy.ivan.command.LogoutCommand;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Ivan on 23.05.2016.
 */
public class LogoutCommandTest {
    @Test
    public void checkCorrectPageReturn(){
        LogoutCommand cm = new LogoutCommand();
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        HttpSession mockSession = (HttpSession) Mockito.mock(HttpSession.class);
        when(mockedRequest.getSession()).thenReturn(mockSession);

        assertNotNull(cm.execute(mockedRequest));
        assertNotEquals("/pages/login.jsp", cm.execute(mockedRequest));
        assertEquals("/index.jsp", cm.execute(mockedRequest));
    }
}