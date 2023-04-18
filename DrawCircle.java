package com.Li.Tank;

import javax.swing.*;
import java.awt.*;

/**
 *  1.  画图
 */

public class DrawCircle  extends  JFrame{//框架  显示的
    private MyPanel mp = null;//定义一个面板 画的图都在这里
    public static void main(String[] args) {
        new DrawCircle();//需要去调用

    }
    public DrawCircle(){//构造器  //需要在主方法调用
        mp = new MyPanel();//给原来的空面板传入值
        this.add(mp);//把面板放进去
        this.setSize(400,300);//设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//真正退出//不设置还在运行
        this.setVisible(true);//窗口可以显示
    }
}
//画图工具需要继承
class MyPanel extends JPanel{
    //MyPanel画板
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类方法画图//画笔
        System.out.println("diaoyong");//当窗口被调用他就会被调用  paint
        g.drawOval(10,10,100,100);
    }
}
