package exemplo;

import java.io.Serializable;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ObjetoExemplo implements Serializable {

    protected String s;
    protected int i;
    protected double d;

    public ObjetoExemplo(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String getString() {
        return s;
    }

    public int getInt() {
        return i;
    }

    public double getDouble() {
        return d;
    }

    @Override
    public String toString() {
        return "ExampleDesktop{" + "s=" + s + ", i=" + i + ", d=" + d + '}';
    }
}
