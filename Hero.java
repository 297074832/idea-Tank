package com.Li.Tank.tank;

import java.util.Vector;

public class Hero extends  TanK {
    Shot shot = null;//子弹刚刚开始没有  调用其他类方法
    Vector<Shot> shots =new Vector<>();//我的子弹数组
    public Hero(int x, int y) {
        super(x, y);
    }
    public  void shotEnemyTank(){
        if (shots.size() == 5){//子弹数组
            return;
        }
        switch (getDirect()){//根据坦克方法确定子弹坐标
            // WDSA  0 1 2 3
            case 0://子弹坐标 加方向
                 shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY()+20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY()+60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY()+20, 3);
                break;


        }
        shots.add(shot);
        new Thread(shot).start();//把得到的shot坐标  都去调用shot里面写的线程  子弹移动
    }
}
