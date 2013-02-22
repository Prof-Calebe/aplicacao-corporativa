/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.controller;

import exemplo.jpa.Contato;
import exemplo.jpa.facade.ContatoFacade;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ContatoController {

    private ContatoFacade contatoFacade;

    public ContatoController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        contatoFacade = (ContatoFacade) ctx.lookup("ejb/ContatoFacade");
    }

    public void create(Contato entity) {
        contatoFacade.create(entity);
    }

    public List<Contato> findAll() {
        return (contatoFacade.findAll());
    }
}
