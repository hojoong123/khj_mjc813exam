package com.mjc.studyjava;

import java.math.BigDecimal;
import java.util.Random;

public class MyMathMathic {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public long mul(int a, int b) {
        return (long) a * b;
    }

    public int divM(int a, int b) {
        return a / b;
    }

    public int divN(int a, int b) {
        return a % b;
    }

    public boolean same(int a, int b) {
        return a == b;
    }

    public boolean same(String a, String b) {
        return a != null && a.equals(b);
    }

    public boolean notsame(int a, int b) {
        return a != b;
    }

    public boolean big(int a, int b) {
        return a > b;
    }

    public boolean small(int a, int b) {
        return a < b;
    }

    public int shiftLeft(int a, byte b) {
        return a << b;
    }

    public int shiftRight(int a, byte b) {
        return a >> b;
    }

    public int shiftRight0(int a, byte b) {
        return a >>> b;
    }

    public long square(int a, byte b) {
        long r = 1;
        for (int i = 0; i < b; i++) {
            r *= a;
        }
        return r;
    }

    public int absolute(int a) {
        return a < 0 ? -a : a;
    }

    public String toHex(int a) {
        return Integer.toHexString(a);
    }

    public String toBin(int a) {
        return Integer.toBinaryString(a);
    }

    public String toOct(int a) {
        return Integer.toOctalString(a);
    }

    public int toDec(String a) {
        return Integer.parseInt(a);
    }

    public static int array(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int sumMultiples(int[] array, int n) {
        int sum = 0;
        for (int num : array) {
            if (num % n == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public int java_4_3() {
        int a = 0;
        for(int i = 1;i<=100;i++) {
            if(i % 3 == 0) {
                a += i;
            }
        }
        return a;
    }

    public BigDecimal getBigDecimal(int n, int s) {
        String decimalString = n + "." + s;
        return new BigDecimal(decimalString);
    }

    public Integer[] getIntegerArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public int[] makeRandomIntArray(int n) {
        int[] result = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt();
        }
        return result;
    }

    public String makeEncryptString(String text, int n) {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        int length = n * text.length();
        char[] result = new char[length];

        for (int i = 0; i < length+1; i++) {

        }
        return charset;
    }

}