package exemplo;

import exemplo.exceptions.ObjetoNotNullException;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EJBStatefulExemploInterface {

    void set(ObjetoExemplo objeto) throws ObjetoNotNullException;
    
    ObjetoExemplo get();
}
