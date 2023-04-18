package com.Li.Tank.tank;

public class Shot implements Runnable {
    int x;
    int y;
    int direct = 0;//子弹方向
    int spead = 2;//子弹速度
    boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;

    }

    @Override
    public void run() {
        while (true) {//死循环
            try {
                Thread.sleep(50);//休眠50毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {//根据子弹方向改变子弹坐标
                //WDSA
                case 0:
                    y -= spead;
                    break;
                case 1:
                    x += spead;
                    break;
                case 2:
                    y += spead;
                    break;
                case 3:
                    x -= spead;
                    break;
            }
            System.out.println("" + x + y);
            if (!(x > 00 && x <= 1000 && y >= 0 && y <= 750&&isLive)) {//子弹不在界面范围内//则死亡
                isLive = false;
                break;

            }
        }

    }//多线程
}
