package exemplo;

import exemplo.exceptions.ObjetoNotNullException;
import javax.ejb.Stateful;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateful(mappedName = "ejb/EJBStatefulExemplo")
public class EJBStatefulExemplo implements EJBStatefulExemploInterface {

    protected ObjetoExemplo objeto;

    public EJBStatefulExemplo() {
        objeto = null;
    }

    @Override
    public void set(ObjetoExemplo objeto) throws ObjetoNotNullException {
        if (this.objeto == null) {
            this.objeto = objeto;
        } else {
            throw new ObjetoNotNullException("O objeto já foi instanciando!");
        }
    }

    @Override
    public ObjetoExemplo get() {
        return objeto;
    }
}
