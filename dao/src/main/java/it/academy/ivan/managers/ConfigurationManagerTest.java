package it.academy.ivan.managers;

import org.junit.Test;

import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ivan on 22.05.2016.
 */
public class ConfigurationManagerTest {
@Test
    public void checkCorrectBundle(){
    ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    ConfigurationManager a = new ConfigurationManager();
    String aa = ConfigurationManager.getProperty("path.page.admin.clients");
    assertNotNull(aa);
    assertEquals("/pages/clients.jsp", aa);
}
}