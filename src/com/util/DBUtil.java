package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    public static Connection getConnection(){//用这个方法获取mysql的连接
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");//加载驱动类
            conn=DriverManager.
                    getConnection("jdbc:mysql://119.6.248.58:6001/scca_mdd","root","scca123");//（url数据库的IP地址，user数据库用户名，password数据库密码）
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}