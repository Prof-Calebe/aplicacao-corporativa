package exemplo;

import javax.ejb.Stateless;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/EJBStatelessExemplo")
public class EJBStatelessExemplo implements EJBStatelessExemploInterface {

    @Override
    public String metodo(double d, int a, String s) {

        return s + ":" + d + ":" + a;
    }
}
