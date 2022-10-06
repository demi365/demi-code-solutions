package com.code.preparations.demi;

public class Testing {

    public static void main(String[] args) {
        long val = 598133298706668255L;
        long base = 1634;
        System.out.println(baseValue(base, 7));
        System.out.println(val);
        while(val>0) {
            System.out.println(val%base);
            val = val/base;
        }

    }

    public static long baseValue(long n, int bit) {
        long val = 1;
        long res = 1;
        for(int i=1; i<bit; i++) {
            long temp = res;
            val *= n;
            res += val;
            System.out.println(res);
            if(res < temp) {
                return Long.MAX_VALUE;
            }
        }
        return res;
    }

}
