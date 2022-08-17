package com.example.smallbankapp.generate;

import java.util.Random;

public class GenerateCCV {
    public static Long generateCCV() {
        Random rnd = new Random();
        int counter=0;
        StringBuffer stringBuffer = new StringBuffer();
        while(counter<=2){
            int generate = rnd.nextInt(9);
            stringBuffer.append(generate);
            counter++;
        }
        return Long.parseLong(stringBuffer.toString());
    }
}
