package randomNum;

import java.util.ArrayList;
import java.util.List;

public class orta_kare {
    // Bu sınıf orta kare yöntemi kullanarak, rastgele sayı üretimi için
    // yazılmıştır.
    public static void rndOrtaKare(int i, float x0) {

        // Bu algoritma bir sayı alır. Aldığı sayıyının
        // karesini alır. Bu sayıdan, gelen sayının basamak sayısı kadar, ortasından
        // sayı alınabilmesi için izlenen yöntem şudur; Diyelim gelen sayı 5489
        // olduğunu varsayalım. Bu
        // sayının karesi 30129121'dir ve bu sayının ortasından 4 basamaklı sayının
        // alınması gerekmektedir. Bunu şu şekilde yapar. 30129121 sayısının rakamlarını
        // bir listeye atar.Bu liste [3,0,1,2,9,1,2,1] şeklinde olmaktadır. Basamak
        // sayısı yarıya bölünür.
        // Yani 8 / 2 den 4 değeri elde edilir. Dizinin 4. indexinde 9
        // değeri bulunmaktadır. İlk gelen sayının basamak sayısı 4'tür ve ortadan 4
        // basamaklı sayı alınması gerekmektedir. 4 basamaktan biri 9 olduğuna göre.
        // 4'den 1 çıkartılır. 3 sayısı bulunur. İlk gelen değer çift basamaklı olduğu
        // için ortancası yoktur. Bu yüzden bulunan 9 değerinin sağında, alınması
        // gereken 1 eleman; solunda
        // 2 eleman vardır ve ilk sayı çift ise her zaman sol taraf sağ taraftan 1
        // basamak daha fazladır. Bunun hesabı için 3 sayısı 2 ye bölünür ve '1' integer
        // değeri elde edilir.Elde edilen 1 değerine, sol sağdan 1 eleman daha
        // fazla olduğu için 1
        // değeri eklenir ve 2 bulunur. İkinci sayının ortası yani 8 / 2 = 4 'den, 2
        // çıkarılırsa ortadan alınacak 4 elemanlı sayının, ilk rakamının, dizide ki
        // indexini bulmuş oluruz ki bu sayı 2'dir. Diziye gidilip 2. indexine bakılırsa
        // 1 değeri görülür. Bu durum ortadan 4 elemanlı sayı alınacağı için bir döngü
        // yardımıyla 2 sayısına bir bir eklenerek ortadaki sayı alınabilir bir hale
        // getirilir. Yani döngü 2 den başlayacak ve dizinin ikinci indexini alacak. Bu
        // değer 1'dir. Daha sonra 2 yi bir arttırıp 3 gelecek ve dizinin 3. indexini
        // alacak ki bu değer 2'dir ta ki 4 eleman alınana kadar devam edecek ve sonunda
        // 1291 değerini ortadan almış olacak. Eğer gelen sayının basamak sayısı tek
        // ise, durum biraz farklıdır. Çünkü sayının ortancası vardır ve sağ, sol tarafa
        // eşit oranda rakam dağılması vardır. Örnek olarak 321 sayısını alalım. 321
        // sayısının basamak sayısı 3'tür yani tek sayıdır. 321^2 'i 103041 etmektedir
        // ve bu sayının rakamları da bir listeye atılır. [1,0,3,0,4,1] listesi elde
        // edilir. Bu sayının ortadan alınması gereken sayı 3 basamaklı 030'dur yani 30
        // sayısıdır. Bu sayıyı alabilmek için, listenin eleman sayısının yarısı
        // alınarak, sayının ortancası bulunur.
        // 6 / 2'den 3 sonucu elde edilir. Listeye gidip 3.
        // indexe baktığımızda '0' elemanını görürüz. İkinci sayının basamak sayısı tek
        // olsaydı yani [1,1,0,3,0,4,1] bunun gibi 7 elemanlı olsaydı; 7 / 2'den 3
        // sonucuna ulaşılıp, listenin 3. indexi, ortadan alınacak 3 elemanlı sayının
        // ortancası olacaktı.
        // Fakat örnekte verilen sayının, karesinin basamak sayısı çift sayı
        // olduğu için bir simetri söz konusu değildir. Liste de 3. eleman '0'
        // sayısıdır. Eğer bu indexi ortanca kabul edersek sağ tarafa, 3 basamaklı
        // ortanca sayıyı almış olacaktık (304). Fakat ben sol tarafa yakın olan 3
        // basamaklı ortanca sayıyı (030) almak istediğim için, gelen sayının basamak
        // sayısı ki bu sayı 3, 3'ten 1 çıkartıp, 2'ye böldüğümde 1 sonucunu elde
        // ediyorum. İkinci sayının basamak sayısının yarısı yani 6 / 2 = 3'ten bu
        // sayıyı çıkartıyorum. Sonucu 2 buluyorum. Bulduğum bu sonuç bir index ve
        // ortadan alınacak sayının, ilk rakamının, dizide bulunduğu konumu bana
        // veriyor. Diziye gidip 2. indexe bakarsak '3' rakamını görürüz ve eğer gelen
        // sayının basamak sayısı kadar ilerletirsek 304 sayını alırız. Bu sonuç sağa
        // yaslı olan sonuç ve ben bunu istemiyorum. O yüzden bulduğum 2 indexinden 1
        // çıkartırsam 1 sonucunu elde ederim. Dizi de bu indexe karşılık gelen
        // sayıya bakarsam '0'dır. Gelen sayının basamak sayısı kadar ilerletirsem 030
        // yani 30 sayısını elde etmiş olurum.

        float x = x0;
        int firstNumDigit = numOfDigits(x0);
        for (int w = 0; w < i; w++) {
            float squareOfFirtsNum = x * x;
            int resultNum = 0;

            int secondNumDigit = numOfDigits(squareOfFirtsNum);
            int secondNumTmpDigit = secondNumDigit;
            List<Integer> secondNumList = new ArrayList<Integer>();
            if (secondNumDigit > firstNumDigit) {
                // Üretilebilecek sayı kalmaması durumunu kontrol eden koşul
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

                    tmp = (int) middleOfSecondNum - (((firstNumDigit - 1) / 2) + 1);

                    for (int j = 0; j < firstNumDigit; j++) {
                        resultNum = resultNum + (secondNumList.get(tmp) * digitTmp);
                        digitTmp = digitTmp / 10;
                        tmp++;
                    }
                    // Sayıların karelerini tutan listeleri görebilmek için alttaki yorum satırını
                    // açınız
                    // System.out.println(secondNumList.toString());
                    System.out.println(w + 1 + ". üretilen sayı ="
                            + (double) resultNum / ((int) Math.pow(10, (firstNumDigit))));
                    // Üretilen Random sayı
                    x = resultNum;

                } else {
                    if (middleOfSecondNum % 1 == 0) {
                        tmp = (int) middleOfSecondNum - (((firstNumDigit - 1) / 2) + 1);

                    } else {
                        tmp = (int) middleOfSecondNum - ((firstNumDigit - 1) / 2);
                    }
                    for (int j = 0; j < firstNumDigit; j++) {
                        resultNum = resultNum + (secondNumList.get(tmp) * digitTmp);
                        digitTmp = digitTmp / 10;
                        tmp++;
                    }
                    // Sayıların karelerini tutan listeleri görebilmek için alttaki yorum satırını
                    // açınız
                    // System.out.println(secondNumList.toString());

                    System.out.println(w + 1 + ". üretilen sayı ="
                            + (double) resultNum / ((int) Math.pow(10, (firstNumDigit))));
                    // Üretilen Random sayı
                    x = resultNum;
                }
            } else {
                System.out.println("Bu sayı kullanılarak üretilebilecek en fazla sayı üretildi!");
                break;
            }
        }
    }

    public static int numOfDigits(float num) {
        // Bu Fonksiyon içerisine aldığı sayının basamak sayısını döndürüyor.
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
