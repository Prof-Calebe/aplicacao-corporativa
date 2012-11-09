package exemplo;

import javax.ejb.Stateless;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless
public class EJBExemplo implements EJBExemploInterface {

    @Override
    public String metodo(double d, int a, String s) {

        return s + ":" + d + ":" + a;
    }
}
