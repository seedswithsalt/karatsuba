package ru.vsu.chirkova;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number A: ");
        long i = in.nextLong();
        System.out.println("Number B: ");
        long j = in.nextLong();
        System.out.print("Result: " + kara(i, j));
    }

    public static long kara(long i, long j) {
        if (i < 10 || j < 10)
            return i * j;
        double n = getLength(Math.max(i, j));
        if (n % 2 == 1)
            n++;
        long a = (long) (i / Math.pow(10, (n / 2)));
        long b = (long) (i % Math.pow(10, (n / 2)));
        long c = (long) (j / Math.pow(10, (n / 2)));
        long d = (long) (j % Math.pow(10, (n / 2)));

        long first = kara(a, c);
        long second = kara(b, d);
        long third = kara(a + b, c + d);

        return ((long) ((first * Math.pow(10, n)) + ((third - first - second) * Math.pow(10, (n / 2))) + second));
    }

    public static int getLength(long a) {
        String b = Long.toString(a);
        return b.length();
    }
}