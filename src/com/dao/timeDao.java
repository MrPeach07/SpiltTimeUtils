package com.dao;

import com.model.time;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/29.
 */
public class timeDao {
    public static void insert(Connection conn){
        try
        {
            PreparedStatement psql = conn.prepareStatement("insert into time (id) values(?)");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.set(2007,0,01,01,00);
            //System.out.println(time);
            //2007年1月1日01:00到2017年3月30日01:00循环节为5387040次
            for(int i = 0;i<5387040;i++) {
                calendar.add(Calendar.MINUTE,1);
                String time = df.format(calendar.getTime());
                psql.setString(1, time);
                psql.executeUpdate();  //参数准备后执行语句
            }
            psql.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据插入成功！"+"\n");
        }
    }

    public static void main(String[] args){
        Connection conn;    //与特定数据库的连接（会话）的变量
        String driver = "com.mysql.jdbc.Driver";  //驱动程序名
        String url = "jdbc:mysql://119.6.248.58:6001/scca_mdd";  //指向要访问的数据库！注意后面跟的是数据库名称
        String user = "root";   //navicat for sql配置的用户名
        String password = "scca123";  //navicat for sql配置的密码
        timeDao timedao = new timeDao();
        try{
            Class.forName(driver);  //用class加载动态链接库——驱动程序
            conn = DriverManager.getConnection(url,user,password);  //利用信息链接数据库
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            timeDao.insert(conn);
            conn.close();
        }catch(ClassNotFoundException e){  //catch不同的错误信息，并报错
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            System.out.println("数据库各项操作顺利进行！");
        }
    }



}

