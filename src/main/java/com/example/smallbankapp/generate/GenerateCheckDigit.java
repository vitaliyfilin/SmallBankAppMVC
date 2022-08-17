package com.example.smallbankapp.generate;

import java.util.Random;

public class GenerateCheckDigit {
    public static Long generateCheckDigit() {
        long range = 123456789012345L;
        Random r = new Random();
        long l = (long) (r.nextDouble() * range);
        int cd = generateDigit(l);
        Long shmong = Long.parseLong(l + "" + cd);
        if (checkLength(shmong)) {
            return shmong;
        } else {
            return Long.parseLong(shmong + "1");
        }
    }
    private static int generateDigit(long l) {
        String str = Long.toString(l);
        int[] ints = new int[str.length()];
        for(int i = 0;i< str.length(); i++){
            ints[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i = ints.length-2; i>=0; i=i-2){
            int j = ints[i];
            j = j*2;
            if(j>9){
                j = j%10 + 1;
            }
            ints[i]=j;
        }
        int sum=0;
        for(int i = 0;i< ints.length; i++){
            sum+=ints[i];
        }
        if(sum%10==0){
            return 0;
        }else return 10-(sum%10);
    }
    static boolean checkLength (Long l) {
        if (l.toString().length() < 16) {
            return false;
        }
        return true;
    }
}
