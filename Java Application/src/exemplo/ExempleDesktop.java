package exemplo;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ExempleDesktop implements ObjetoExemploInterface {

    protected String s;
    protected int i;
    protected double d;

    public ExempleDesktop(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String getString() {
        return s;
    }

    @Override
    public int getInt() {
        return i;
    }

    @Override
    public double getDouble() {
        return d;
    }

    @Override
    public String toString() {
        return "ExampleDesktop{" + "s=" + s + ", i=" + i + ", d=" + d + '}';
    }
}
