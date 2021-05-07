package version1.gameUtil.mazegenerator;

public class Vertex {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int wall1;
    private int wall2;

    public Vertex setX1(int x1) {
        this.x1 = x1;
        return this;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public Vertex setX2(int x2) {
        this.x2 = x2;
        return this;
    }

    public int getX2() {
        return x2;
    }

    public Vertex setY1(int y1) {
        this.y1 = y1;
        return this;
    }

    public Vertex setY2(int y2) {
        this.y2 = y2;
        return this;
    }

    public int getWall1() {
        return wall1;
    }

    public Vertex setWall1(int wall1) {
        this.wall1 = wall1;
        return this;
    }

    public int getWall2() {
        return wall2;
    }

    public Vertex setWall2(int wall2) {
        this.wall2 = wall2;
        return this;
    }
}
