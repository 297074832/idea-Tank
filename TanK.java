package com.Li.Tank.tank;

public class TanK {
    private  int x;
    private  int y;
    private  int  direct;
    private  int   speed = 2;
    boolean isLive = true;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public  void moveUp(){//上右边下左
        y -=speed;
    }
    public  void moveRight(){
        x+=speed;
    }
    public  void moveDown(){
        y +=speed;
    }
    public  void moveLeft(){
        x-=speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public TanK(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
