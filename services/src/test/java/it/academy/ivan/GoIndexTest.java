package it.academy.ivan;

import it.academy.ivan.command.GoIndex;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ivan on 22.05.2016.
 */
public class GoIndexTest {
@Test
    public void checkCorrectPageReturn(){
    GoIndex a = new GoIndex();
    HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);

    assertNotNull(a.execute(mockedRequest));
    assertEquals("/pages/login.jsp", a.execute(mockedRequest));
}
}