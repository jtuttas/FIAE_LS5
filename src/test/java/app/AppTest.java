package app;

import org.junit.Assert;
import org.junit.Test;

/**
 * AppTest
 */
public class AppTest {


    @Test
    public void maxTest() {
       Assert.assertEquals("Max von 5 und 6 sollte 6 sein!", 6, App.max(5, 6));
    }
}