package com.util;

import java.io.*;

/**
 * Created by Administrator on 2018/3/31.
 */
public class SpiltFile {
        public static void main(String args[]) {
            try {
                FileReader read = new FileReader("D://test/time.txt");
                BufferedReader br = new BufferedReader(read);
                String row;
                int rownum = 0;

                int fileNo = 1;
                FileWriter fw = new FileWriter("D://test/time.txt"+fileNo +".txt");
                while ((row = br.readLine()) != null) {
                    rownum ++;
                    fw.append(row + "\r\n");
                    if((rownum /1709280 ) > (fileNo - 1)){
                        fw.close();
                        fileNo ++ ;
                        fw = new FileWriter("D://test/time.txt"+fileNo +".txt");
                    }
                }
                fw.close();
                System.out.println("rownum="+rownum+";fileNo="+fileNo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
