package com.Li.Tank.tank;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class HspTanKGame01 extends JFrame {//框架
    MyPanle mp = null;//不继承调用Mypanle  画图区域
     static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {


        HspTanKGame01 hspTanKGame01 = new HspTanKGame01();//需要在主方法里面启动

    }

    public HspTanKGame01() {
        System.out.println("请入  1 新游戏 2 继续游戏");
        String key =scanner.next();
       mp= new MyPanle(key);
        Thread thread = new Thread(mp);
        thread.start();//把mp的线程放进去 定启动
        this.add(mp);//把绘图区域写进去
        this.setSize(1500,750);//绘图大小  窗口填充
        this.addKeyListener(mp);//监听事件加入面板
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//可以关闭真正关闭
        this.setVisible(true);//可以关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();//关闭的时候写入文件
                System.exit(0);//正常退出
            }
        });
    }
}
