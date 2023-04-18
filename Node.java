package com.Li.Tank.tank;

/**
 * 坦克信息
 */
public class Node {
    private  int x;
    private  int Y;
    private  int direct;

    public Node(int x, int y, int direct) {
        this.x = x;
        Y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
