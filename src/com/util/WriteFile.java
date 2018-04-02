package com.util;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/3/30.
 */


public class WriteFile {
    public static void main(String args[]) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 写入Txt文件 */

            DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.set(2007,00,01,00,00);
            File writename = new File("D:\\test\\time.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            //2007年1月1日00:00到2020年01月01日00:00的按每分钟累加的循环节为6837120次
            for(int i=0;i<6837120;i++) {
                writename.createNewFile(); // 创建新文件
                calendar.add(Calendar.MINUTE, 1);
                String time = df.format(calendar.getTime());
                //时间按年，月，日，时，分格式拆分
                String year = time.substring(0,4);
                String month = time.substring(5,7);
                String day = time.substring(8,10);
                String hour = time.substring(11,13);
                String minute = time.substring(14,16);

                out.append(time+","+year+","+month+","+day+","+hour+","+minute);
                out.append("\r\n"); // \r\n即为换行
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}