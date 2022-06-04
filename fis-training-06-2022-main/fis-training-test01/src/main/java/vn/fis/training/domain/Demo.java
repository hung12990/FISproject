package vn.fis.training.domain;

import java.io.IOException;

public class Demo {
    public static void main(String[] args)  {
        try {
            if(true)  {
                System.out.println("hunjgssss");
                throw new IOException("name NOT BLANK");
            }
            System.out.println("hunjg");
        }catch (Exception e){
            System.out.println("hu");

        }
        System.out.println("a");


    }
}
