package com.Li.Tank.tank;

import java.io.*;
import java.util.Vector;

/**
 * 记录成绩
 *
 */

public class Recorder {
    private  static  int allEnemyTankNum = 0;
    //IO写文件
//    private  static FileWriter fw = null;
    private  static BufferedWriter bw= null;//写
    private  static BufferedReader br = null;
    private  static  String recordFile = "src\\mRecord.txt";
    private static Vector<EnemyTank> enemyTanks=null;//调用Py的数组
     private  static Vector<Node> nodes =new Vector<>();//拿到坦克信息

    public static String getRecordFile() {//得到文件
        return recordFile;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;//改变本来数组
    }
    public static  Vector<Node>  getNodesAndEnemyTankRec(){
        try {
            br = new BufferedReader(new FileReader(recordFile));//读取路径
            allEnemyTankNum=Integer.parseInt(br.readLine());//读
            String line = "";//接受到的Noe
            while ((line=br.readLine())!=null){
                String[] xyd = line.split(" ");//按“ ‘分割
                Node node = new Node(Integer.parseInt(xyd[0]),//  拿到 分件 100  200 3;
                        Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);//放入nodes


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return nodes;//返回no数组
    }

    public  static  void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum+"\r\n");//将文件写入
            //遍历敌人坦克
            for (int i = 0; i< enemyTanks.size();i++){
                EnemyTank enemyTank = enemyTanks.get(i);//遍历定取出坦克
                if (enemyTank.isLive){//是否存活
                    //得到 坦克 XYD
                    String record = enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                    bw.write(record+"\r\n");


                }
            }
//            bw.newLine();//换行
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw!= null){
                try {
                    bw.close();//     关流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }
    public  static  void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;

    }
}
