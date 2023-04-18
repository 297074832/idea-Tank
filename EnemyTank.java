package com.Li.Tank.tank;

import java.util.Vector;

public class EnemyTank extends TanK implements Runnable {
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();//敌人坦克方数组
    boolean isLive = true;

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;//其他类 调用
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public boolean isTouchEnemyTank() {
        switch (this.getDirect()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);//取出坦克
                    if (enemyTank != this) {//不和自己比较/上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60) {
                                return true;//发生了碰撞}
                            }

                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40) {
                                return true;//发生了碰撞}
                            }


                        }

                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);//取出坦克
                    if (enemyTank != this) {//不和自己比较/上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60) {
                                return true;//发生了碰撞}
                            }

                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40) {
                                return true;//发生了碰撞}
                            }


                        }

                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);//取出坦克
                    if (enemyTank != this) {//不和自己比较/上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60) {
                                return true;//发生了碰撞}
                            }

                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40) {
                                return true;//发生了碰撞}
                            }


                        }

                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);//取出坦克
                    if (enemyTank != this) {//不和自己比较/上下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60) {
                                return true;//发生了碰撞}
                            }

                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return  true;//发生了碰撞
                            }
                            if (this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40) {
                                return true;//发生了碰撞}
                            }


                        }

                    }
                }
                break;
        }
        return false;///没有碰撞


    }


    @Override
    public void run() {

        while (true) {
            if (isLive&&shots.size() <10){//子弹为零
                Shot s =null;
                switch (getDirect()){
                    case 0:
                        s = new Shot(getX()+20,getY(),0);

                        break;
                    case 1:
                        s = new Shot(getX()+60,getY()+20,1);
                        break;
                    case 2:
                        s = new Shot(getX()+20,getY()+60,2);
                        break;
                    case 3:
                        s = new Shot(getX(),getY()+20,3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();

            }
            switch (getDirect()) {//移动方向
                case 0:
                    for (int i = 0; i < 30; i++) {//移动三十步
                        if (getY()>0&&!isTouchEnemyTank()){
                            moveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX()+60<1000&&!isTouchEnemyTank()){
                            moveRight();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY()+60<750&&!isTouchEnemyTank()){
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX()>0&&!isTouchEnemyTank()){
                            moveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
            }
//            try {
//                Thread.sleep(50);//休眠
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            setDirect((int)(Math.random()*4));
            if (!isLive) {//死亡着退出
                break;
            }

            }

    }
}
