package montecarlo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        // boolean tmp = true;
        // while (tmp) {
        // System.out.println("Yapmak istediğiniz işlemi seçiniz");
        // System.out.println("1-2022 değerlerini tahmin et");
        // System.out.println("2-Orta Kare yöntemi kullanarak rastgele sayı üret");
        // System.out.println("2-Doğrusal Eşlik yöntemi kullanarak rastgele sayı üret");

        // }
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
        int b;
        System.out.println("Başlangıç değerini giriniz.");
        a = sayiAl();
        System.out.println("Kaç tane sayı üretilsin?");
        b = sayiAl();
        rndOrtaKare(b, a);
        // rndDogrusalEslenik(a, 7, 5, 3, 16);
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

    public static void rndOrtaKare(int i, float x0) {

        float x = x0;
        int firstNumDigit = numOfDigits(x0);
        for (int w = 0; w < i; w++) {
            float squareOfFirtsNum = x * x;
            int resultNum = 0;

            int secondNumDigit = numOfDigits(squareOfFirtsNum);
            int secondNumTmpDigit = secondNumDigit;
            List<Integer> secondNumList = new ArrayList<Integer>();
            if (secondNumDigit > firstNumDigit) {
                for (int j = secondNumTmpDigit; j >= 1; j--) {
                    int s = (int) Math.pow(10, (secondNumTmpDigit - 1));
                    int asd = (int) squareOfFirtsNum / s;
                    secondNumList.add(asd);
                    squareOfFirtsNum = squareOfFirtsNum % s;
                    secondNumTmpDigit--;
                }
                double middleOfFirstNum = ((double) firstNumDigit / 2);
                double middleOfSecondNum = ((double) secondNumDigit / 2);
                int digitTmp = (int) Math.pow(10, (firstNumDigit - 1));

                int tmp = 0; // Ortanca sayıyı alabilmek için gerekli; X1 sayısının, ilk rakamının, dizide ki
                             // ilk konumunu tutacak olan değişken;
                if (middleOfFirstNum % 1 == 0) {

                    if (middleOfSecondNum % 1 == 0) {
                        tmp = firstNumDigit - (((firstNumDigit - 1) / 2) + 1);
                    } else {
                        tmp = firstNumDigit - (((firstNumDigit - 1) / 2) + 2);
                    }

                    for (int j = 0; j < firstNumDigit; j++) {
                        resultNum = resultNum + (secondNumList.get(tmp) * digitTmp);
                        digitTmp = digitTmp / 10;
                        tmp++;
                    }
                    int digitOfResult = numOfDigits(resultNum);
                    if (digitOfResult < firstNumDigit) {
                        resultNum = resultNum * (int) Math.pow(10, (firstNumDigit - digitOfResult));
                    }

                    System.out.println((double) resultNum / (((int) Math.pow(10, (firstNumDigit - 1))) * 10)); // Üretilen
                    // Random
                    // sayı
                    x = resultNum;

                } else {
                    tmp = firstNumDigit - (((firstNumDigit - 1) / 2) + 1);

                    for (int j = 0; j < firstNumDigit; j++) {
                        resultNum = resultNum + (secondNumList.get(tmp) * digitTmp);
                        digitTmp = digitTmp / 10;
                        tmp++;
                    }
                    int digitOfResult = numOfDigits(resultNum);
                    if (digitOfResult < firstNumDigit) {
                        resultNum = resultNum * (int) Math.pow(10, (firstNumDigit - digitOfResult));
                        System.out.println("girdi");
                    }

                    System.out.println((double) resultNum / (((int) Math.pow(10, (firstNumDigit - 1))) * 10)); // Üretilen
                    // Random
                    // sayı
                    x = resultNum;
                }
            } else {
                System.out.println("Bu sayı kullanılarak üretilebilecek en fazla sayı üretildi!");
                break;
            }
        }
    }

    public static int numOfDigits(float num) {
        boolean tmp = true;
        int numOfDigit = 1;
        int a = 10;
        while (tmp) {
            if (num / a < 1) {
                tmp = false;
                return numOfDigit;
            } else {
                numOfDigit++;
                a = a * 10;
            }
        }
        return 0;
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