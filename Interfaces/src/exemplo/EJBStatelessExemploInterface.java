package exemplo;

import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EJBStatelessExemploInterface {

    String metodo(double d, int a, String s);
}
