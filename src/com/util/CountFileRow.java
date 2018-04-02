package com.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/31.
 */
public class CountFileRow {
        public static void main(String args[]) {
            try {
                FileReader read = new FileReader("D://test/time.txt");
                BufferedReader br = new BufferedReader(read);
                String row;
                int rownum = 0;
                while ((row = br.readLine()) != null) {
                    rownum ++;
                }
                System.out.println("rownum="+rownum);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
