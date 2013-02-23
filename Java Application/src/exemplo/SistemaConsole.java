/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

import exemplo.exceptions.ObjetoNotNullException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class SistemaConsole {

    public static void main(String[] args) {

        boolean ok = false;
        String s = null;
        double d = 0;
        int i = 0;

        System.out.println("Digite os seguintes valores");
        while (!ok) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Int:");
                i = in.nextInt();
                System.out.println("Double:");
                d = in.nextDouble();
                System.out.println("String:");
                s = in.next();
                ok = true;
            } catch (InputMismatchException e) {
                System.err.println("Algum número informado é inválido!");
                System.out.println("Digite novamente:");
            }
        }

        try {
            Properties props = new Properties();
            props.load(new java.io.FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);

            EJBStatelessExemploInterface beanStateless = (EJBStatelessExemploInterface) ctx.lookup("ejb/EJBStatelessExemplo");
            System.out.println("\nResultado EJBStatelessExemploInterface:");
            System.out.println(beanStateless.metodo(d, i, s));

            EJBStatefulExemploInterface beanStateful = (EJBStatefulExemploInterface) ctx.lookup("ejb/EJBStatefulExemplo");
            beanStateful.set(new ObjetoExemplo(s, i, d));
            System.out.println("\nResultado EJBStatefulExemploInterface:");
            System.out.println(beanStateful.get());

        } catch (ObjetoNotNullException e) {
            System.err.println("Objeto no EJBStatefulExemploInterface já está instanciado.");
            e.printStackTrace(System.err);
        } catch (Exception e) {
            System.err.println("Erro ao tentar achar EBJs:");
            e.printStackTrace(System.err);
        }
    }
}
