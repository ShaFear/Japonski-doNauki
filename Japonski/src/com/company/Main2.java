package com.company;

import java.io.*;
import java.math.*;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {
        File f = new File("znaczki2.txt");
        String s;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            s = br.readLine();
        }
        catch (Exception e){
            System.err.print(e.toString());
            return;
        }
        String t[] = s.split(" ");

        int[] poziom = {9, 17, 25, 33, 41, 49, 51, 62, 70, 78, 86, 94, 102, 104};

        int p = 13;
        try{
            p = Integer.parseInt(args[0]) - 1;
        }
        catch (Exception e){
        }

        int w = (int)Math.sqrt(poziom[p]);
        int l = 1;

        System.out.print("\t");

        for(int j=1; j<=w; j++){
            System.out.print(j + "\t");
        }
        System.out.println();
        char A = 'A';

        for(int j=0; j<(t.length*2); j++){
            Random r = new Random();
            int n = r.nextInt(poziom[p]);
            int m = r.nextInt(poziom[p]);
            String tmp = t[n];
            t[n] = t[m];
            t[m] = tmp;
        }

        for(int j=0; j<poziom[p]; j++){
            if((l-1)%w == 0) {
                System.out.print(A + "\t");
                A++;
            }
            System.out.print(t[j] + "\t");
            if(l%w == 0) {
                System.out.println();
            }
            l++;
        }

    }
}
