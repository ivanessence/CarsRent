package it.academy.ivan;

import it.academy.ivan.command.GoToRegistrationPageCommand;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ivan on 22.05.2016.
 */
public class GoToRegistrationPageCommandTest {
@Test

    public void checkCorrectPageReturn(){
        GoToRegistrationPageCommand b = new GoToRegistrationPageCommand();
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);

        assertNotNull(b.execute(mockedRequest));
        assertEquals("/pages/registration.jsp", b.execute(mockedRequest));
    }
}
