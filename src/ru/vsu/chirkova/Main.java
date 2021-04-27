package ru.vsu.chirkova;

import java.math.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number A:");
        BigInteger A = new BigInteger(br.readLine().trim());
        System.out.println("Number B:");
        BigInteger B = new BigInteger(br.readLine().trim());
        System.out.print("Result: ");
        System.out.print((kara(A, B)).toString());
    }

    public static BigInteger kara(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());

        if (N <= 2000) return x.multiply(y);
        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = kara(a, c);
        BigInteger bd = kara(b, d);

        BigInteger abcd = kara(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }
}