/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.exceptions;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@ApplicationException
public class ObjetoNotNullException extends EJBException {

    public ObjetoNotNullException(String message) {
        super(message);
    }
}
