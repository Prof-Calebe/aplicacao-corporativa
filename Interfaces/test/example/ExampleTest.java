/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import exemplo.ObjetoExemplo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ExampleTest {

    @Test
    public void ConstructorTest() {
        ObjetoExemplo obj = new ObjetoExemplo("teste", 2, 2);
        assertEquals("teste", obj.getString());
        assertEquals(new Integer(2), new Integer(obj.getInt()));
        assertEquals(new Double(2), new Double(obj.getDouble()));
    }
}
