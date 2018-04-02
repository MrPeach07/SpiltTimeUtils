package test.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/3/30.
 */
public class test {
    public static void main(String[] args){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2007,0,01,01,00);
        //2007年1月1日01:00到2017年3月30日01:00循环节为5387040次

        for(int i=0;i<10;i++) {
            calendar.add(Calendar.MINUTE, 1);
            String time = df.format(calendar.getTime());
            String year = time.substring(0,4);
            String month = time.substring(5,7);
            String day = time.substring(8,10);
            String hour = time.substring(11,13);
            String minute = time.substring(14,16);

            System.out.println(time);
            System.out.println(year);
            System.out.println(month);
            System.out.println(day);
            System.out.println(hour);
            System.out.println(minute);

        }

    }

}
