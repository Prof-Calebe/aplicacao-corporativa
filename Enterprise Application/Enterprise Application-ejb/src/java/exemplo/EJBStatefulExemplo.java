package exemplo;

import exemplo.exceptions.ObjetoNotNullException;
import javax.ejb.Stateful;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateful(mappedName = "ejb/EJBStatefulExemplo")
public class EJBStatefulExemplo implements EJBStatefulExemploInterface {

    protected ObjetoExemploInterface objeto;

    public EJBStatefulExemplo() {
        objeto = null;
    }

    @Override
    public void set(ObjetoExemploInterface objeto) throws ObjetoNotNullException {
        if (objeto == null) {
            this.objeto = objeto;
        } else {
            throw new ObjetoNotNullException();
        }
    }

    @Override
    public ObjetoExemploInterface get() {
        return objeto;
    }
}
