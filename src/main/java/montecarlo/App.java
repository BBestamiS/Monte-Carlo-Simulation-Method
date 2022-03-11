package montecarlo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        // GetValue getValue = new GetValue();
        // List<List> years = new ArrayList<List>();
        // years = getValue.getCellData();
        // Iterator<List> itr = null;
        // Iterator<List> monthitr = null;
        // itr = years.iterator();
        // while (itr.hasNext()) {
        // monthitr = itr.next().iterator();
        // while (monthitr.hasNext()) {
        // Month month = (Month) monthitr.next();
        // System.out.println(month.getMonth() + " " + month.getQuantity());
        // }

        // }
        Scanner scan = new Scanner(System.in);
        int a;
        a = sayiAl();
        rndDogrusalEslenik(a, 7, 5, 3, 16);
    }

    public static int sayiAl() {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        try {
            a = scan.nextInt();
            System.out.println("Girilen değer = " + a);
            return a;

        } catch (Exception e) {
            System.out.println("Yalnızca rakam giriniz");
            sayiAl();
        }
        return a;
    }

    public static void rndOrtaKare() {

    }

    public static void rndDogrusalEslenik(int i, float z0, float a, float c, float m) {
        System.out.println(rndDogrusalEslenikFormul(a, c, m, z0, i).toString());
    }

    public static List rndDogrusalEslenikFormul(float a, float c, float m, float z0, int i) {
        List<Float> randomNumList = new ArrayList<Float>();
        float z = z0;
        float u;
        float tmp;
        u = (z / m);
        randomNumList.add(u);
        for (int j = 0; j < i - 1; j++) {
            z = (((a * z) + c) % m);
            tmp = z / m;
            randomNumList.add(tmp);
        }

        return randomNumList;
    }

}