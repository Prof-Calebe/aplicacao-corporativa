/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.facade;

import exemplo.jpa.Contato;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface ContatoFacadeRemote {

    void create(Contato contato);

    void edit(Contato contato);

    void remove(Contato contato);

    Contato find(Object id);

    List<Contato> findAll();

    List<Contato> findRange(int[] range);

    int count();
    
}
