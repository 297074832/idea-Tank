package com.Li.Tank.tank;

import jdk.nashorn.internal.ir.CallNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

public class MyPanle extends JPanel implements KeyListener ,Runnable {//画图区域//监听键盘事件
    Hero hero = null;//需要画的先调用进来
//    Shot shot = null;//因为调用了 hero  所以不要声明子弹
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Node> nodes =new Vector<>();
    Vector<Bomb> bombs = new Vector<>();//存放炸弹
    int enemyTankSize = 8;//坦数量
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanle(String key){//构造器
//判断文件是否存在
        File file = new File(Recorder.getRecordFile());
        if (file.exists()){//文件存在
            nodes =Recorder.getNodesAndEnemyTankRec();//上把坦克数据//接受
        }else {
            System.out.println("文件不存在，只能开始新游戏");
            key = "1";
        }

        //我的坦克
        Recorder.setEnemyTanks(enemyTanks);//把坦克数组给Recorder
         hero = new Hero(500, 500);
         hero.setSpeed(3);//默认为2  坦克速度
        switch (key){
            case "1":
                for ( int i = 0 ; i< enemyTankSize;i++){
                    //敌人坦克坐标
                    EnemyTank enemyTank = new EnemyTank((100*(i+1)),0);//创建坦克坐标 敌人
                    enemyTank.setEnemyTanks(enemyTanks);//转换到敌人坦克
                    enemyTank.setDirect(2);
                    new Thread(enemyTank).start();

                    //创建子弹坐标
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    enemyTank.shots.add(shot);//把敌方坦克 数组 子弹放进来

                    new Thread(shot).start();//启动线程
                    enemyTanks.add(enemyTank);//创建一个坦克 顶加入 enemyTanks 数组



                }
                break;
            case "2":
                for ( int i = 0 ; i< nodes.size();i++){
                    Node node = nodes.get(i);//取出坦克
                    //敌人坦克坐标
                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY());//创建坦克坐标 敌人
                    enemyTank.setEnemyTanks(enemyTanks);//转换到敌人坦克
                    enemyTank.setDirect(node.getDirect());
                    new Thread(enemyTank).start();

                    //创建子弹坐标
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    enemyTank.shots.add(shot);//把敌方坦克 数组 子弹放进来

                    new Thread(shot).start();//启动线程
                    enemyTanks.add(enemyTank);//创建一个坦克 顶加入 enemyTanks 数组



                }
                break;
            default:
                System.out.println("输入有误");

        }

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
        new PlayAudio("src\\111.wav").start();//音乐
    }

    public  void showInfo(Graphics g){//玩家成绩
        g.setColor(Color.black);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);
        g.drawString("你累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,1);//画一个坦克
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum()+"",1100,100);

    }
    @Override
    public void paint(Graphics g) {//自己会调用
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充大小  为窗口
        showInfo(g);
        //                              我的坦克
        if (hero.isLive&&hero!=null) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }

            System.out.println("zdllllllllllllllllllllllllll");
            //                         画我的子弹
//            g.fill3DRect(hero.shot.x,hero.shot.y,5,5,false);
            //  遍历定取出
            for (int i = 0; i< hero.shots.size();i++){
                Shot shot = hero.shots.get(i);
                if (shot!=null&&shot.isLive == true) {//当子弹存在 存活时候
                    g.fill3DRect(shot.x, shot.y, 5, 5, false);
                }else {
                    hero.shots.remove(shot);//拿掉
                }
            }


        //画炸弹图片
        for (int i = 0;i <bombs.size();i++){
            //取出炸弹图标
            Bomb bomb = bombs.get(i);
           if (bomb.life>9){
               //根据生命周期来画
               g.drawImage(image1,bomb.x,bomb.y,60,60,this);
           }else if (bomb.life>6){
               g.drawImage(image2,bomb.x,bomb.y,60,60,this);
           }else  {
               g.drawImage(image3,bomb.x,bomb.y,60,60,this);
           }
           bomb.lifeDown();//调用炸弹减少方法
            if (bomb.life == 0){
                bombs.remove(bomb);
            }
        }
//        g.setColor(Color.gray);
        //                             敌人坦克

        for (int i = 0;i< enemyTanks.size();i++){//遍历坦克数组里面的坦克
            EnemyTank enemyTank = enemyTanks.get(i);//取出坦克数组里面的坦克
            //敌人坦克的方向
            //             绘制敌人坦克
            if (enemyTank.isLive){//坦克存活就画
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
            for (int j =0;j<enemyTank.shots.size();j++){//shots数组只有enemyTank里面有
                Shot shot = enemyTank.shots.get(j);//取出子弹
               if (shot.isLive){
                   //               绘制敌人子弹
                   g.draw3DRect(shot.x,shot.y,1,1,false);

               }else {
                   enemyTank.shots.remove(shot);//子弹死亡则移除
               }
            }
        }
        }

    }

    /**
     *
     * @param x//坐标
     * @param y
     * @param g //画笔
     * @param direct //方向  0-3
     * @param type//颜色  0-3
     */
    public  void drawTank(int x,int y,Graphics g ,int direct,int type){//话坦克 //封装方法
        switch (type){//颜色选择
            case 0:
                g.setColor(Color.yellow);//黄
                break;
            case 1:
                g.setColor(Color.pink);//粉
                break;
            case 2:
                g.setColor(Color.green);//绿
                break;
            case 3:
                g.setColor(Color.black);//on
                break;
        }
        switch (direct){//方向
            case 0://向上
                ////raised为填充类型
                g.fill3DRect(x, y, 10, 60, false);//塔克左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中间
                g.fillOval(x + 10, y + 20, 20, 20);//坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);

                break;
            case 1://向右边
                g.fill3DRect(x, y, 60, 10, false);//塔克左轮
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中间
                g.fillOval(x + 20, y + 10, 20, 20);//坦克圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://向下
                ////raised为填充类型
                g.fill3DRect(x, y, 10, 60, false);//塔克左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中间
                g.fillOval(x + 10, y + 20, 20, 20);//坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
//         g.fill3DRect(x, y, 10, 60, false);//塔克左轮
//                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
//                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克中间
//                g.fillOval(x + 10, y + 20, 20, 20);//坦克圆盖
//                g.drawLine(x + 20, y + 30, x + 20, y);

            case 3://向左边
                g.fill3DRect(x, y, 60, 10, false);//塔克左轮
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克中间
                g.fillOval(x + 20, y + 10, 20, 20);//坦克圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("其他情况不处理");

        }

    }
    public  void  hitHero(){//对面打我
        for (int i =0;i< enemyTanks.size();i++){//取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j< enemyTank.shots.size();j++){
                Shot shot = enemyTank.shots.get(j);//取出敌人子弹
                if (hero.isLive&&shot.isLive){
                    hitTank(shot,hero);//比较
                }

            }
        }
    }
    public  void hitEnemyTank(){//取出所有子弹判断//我打对面
        for (int j = 0 ;j< hero.shots.size();j++){
            Shot shot = hero.shots.get(j);
            if (shot!=null&&shot.isLive){

            for (int i  = 0;i< enemyTanks.size();i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(shot,enemyTank);

            }
            }
        }
    }
    public  void hitTank(Shot s ,TanK enemyTank){//子弹打中坦克
        switch (enemyTank.getDirect()){//根据坦克方向
            //上下方向
            case 0:
            case 2:
                if (s.x>enemyTank.getX()&&s.x<enemyTank.getX()+40
                &&s.y>enemyTank.getY()&&s.y<enemyTank.getY()+60){
                    s.isLive = false;//在坦克范围内 子弹消失
                    enemyTank.isLive = false;//坦克消失
                    enemyTanks.remove(enemyTank);
                    if (enemyTank instanceof EnemyTank){//如果被击毁的是敌方坦克  就++
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());//被击中坦克位置
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x>enemyTank.getX()&&s.x<enemyTank.getX()+60
                        &&s.y>enemyTank.getY()&&s.y<enemyTank.getY()+40){
                    s.isLive = false;//在坦克范围内 子弹消失
                    enemyTank.isLive = false;//坦克消失
                    enemyTanks.remove(enemyTank);
                    if (enemyTank instanceof EnemyTank){//如果被击毁的是敌方坦克  就++
                        Recorder.addAllEnemyTankNum();
                    }
                    //被击中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());//被击中坦克位置
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {//监听事件方法

    }

    @Override
    public void keyPressed(KeyEvent e) {//WDSA
       if (e.getKeyCode() == KeyEvent.VK_W){
           hero.setDirect(0);//如果按下w  坦克变成 上
           if (hero.getY()>0) {
               hero.moveUp();
           }
       }else if(e.getKeyCode() == KeyEvent.VK_D){
           hero.setDirect(1);//如果按下D  坦克变成 右边
           if (hero.getX()+60<1000){
               hero.moveRight();
           }

       }else if (e.getKeyCode() == KeyEvent.VK_S){
           hero.setDirect(2);//如果按下S  坦克变成 下
           if (hero.getY()+60<750){
               hero.moveDown();
           }

       }else if(e.getKeyCode() == KeyEvent.VK_A){
           hero.setDirect(3);//如果按下A  坦克变成左
           if (hero.getX()>0){
               hero.moveLeft();
           }

       }

       if (e.getKeyCode() == KeyEvent.VK_J){
           System.out.println("按下J");
//           if (hero.shot ==null||!hero.shot.isLive){//发射一颗子弹
               hero.shotEnemyTank();
//           }

       }
//       hitEnemyTank();//多发子弹判断
        this.repaint();//重绘


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            hitEnemyTank();//我打对面
        hitHero();//对面打我
        this.repaint();

    }
    }

//    @Override
//    public void run() {
//        try {
//            Thread.sleep(100);//每隔100毫秒画一次子弹
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.repaint();//C重绘
//
//    }
}
