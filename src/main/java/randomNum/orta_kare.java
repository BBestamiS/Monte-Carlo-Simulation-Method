package randomNum;

import java.util.ArrayList;
import java.util.List;

public class orta_kare {
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
                             // ilk konumunu tutacak olan değişken; [3, 0, *2, 1, 7, 0, 0, 8] *2'nin dizide
                             // ki konumunu tutuyor
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
                    // System.out.println(secondNumList.toString());
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
                    // System.out.println(secondNumList.toString());

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
}
