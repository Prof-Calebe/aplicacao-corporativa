/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.facade;

import exemplo.jpa.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/ContatoFacade")
public class ContatoFacade extends AbstractFacade<Contato> implements ContatoFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContatoFacade() {
        super(Contato.class);
    }
}
