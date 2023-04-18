package com.Li.Tank.tank;

public class Bomb {
    int x,y;
   int life  =12;//生命周期
   boolean isLive =true;//是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public  void lifeDown(){
        if (life>0){
            life--;
        }else {
            isLive =false;
        }
    }
}
