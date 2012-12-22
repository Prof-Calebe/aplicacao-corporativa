/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import exemplo.ExempleDesktop;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ExampleTest {

    @Test
    public void ConstructorTest() {
        ExempleDesktop e = new ExempleDesktop("teste", 2, 2);
        assertEquals("teste", e.getString());
        assertEquals(new Integer(2), new Integer(e.getInt()));
        assertEquals(new Double(2), new Double(e.getDouble()));
    }
}
