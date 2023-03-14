public class Ponto {
    public int x;
    public int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String t = "[" + x + ", " + y + "]";
        return t;
    }
}