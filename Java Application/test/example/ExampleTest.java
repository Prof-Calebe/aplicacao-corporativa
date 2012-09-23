/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ExampleTest {

    @Test
    public void ConstructorTest() {
        Example e = new Example(1);
        assertEquals(new Integer(1), e.getNumber());
    }
}
