/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import exemplo.EJBExemploInterface;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class Run {

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
            } catch (NumberFormatException e) {
                System.err.println("Algum número informado é inválido!");
                System.out.println("Digite novamente:");
            }
        }

        try {
            Properties props = new Properties();
            props.load(new java.io.FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            EJBExemploInterface bean = (EJBExemploInterface) ctx.lookup("ejb/EJBStatelessExemplo");
            System.out.println("Resultado:");
            System.out.println(bean.metodo(d, i, s));
        } catch (IOException | NamingException e) {
            System.err.println("Erro ao tentar achar EJBExemploInterface:");
            e.printStackTrace(System.err);
        }
    }
}
