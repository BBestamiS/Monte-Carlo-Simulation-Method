package montecarlo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import randomNum.orta_kare;

public class App {

    public static void main(String[] args) throws Exception {
        boolean condition = true;
        int a;
        int b;
        int x0;
        int c;
        int m;
        List<Integer> dataList = new ArrayList<Integer>();
        while (condition) {
            System.out.println("Hangi işlemi yapmak istiyorsunuz?");
            System.out.println("1 - Monte Carlo benzetimi kullanarak; Ketçap Fabrikasının 2022 yılı tahmini");
            System.out.println("2 - Orta Kare yöntemi kullanarak rastgele sayı üretimi");
            System.out.println("3 - Doğrusal Eşlik yöntemi kullanarak rastgele sayı üretimi");
            System.out.println("4 - Çıkış");
            int selection = readNum();
            switch (selection) {
                case 1:
                    // Monte Carlo yöntemi için yazılan algoritma şu şekilde işlemektedir; dataList
                    // adında excel dosyasının içeriğini tutan liste oluşturulmuştur. Bu liste
                    // calculateAllParameters() fonksiyonuna, ihtiyaç duyulan tüm parametreleri
                    // hesaplaması için gönderilmiştir.
                    // Liste küçükten büyüğe doğru, Collections.sort() metodu kullanılarak
                    // sıralanması sağlandı. Sıralı listenin
                    // içerisinde ki elemanların frekans değerlerinin hesaplanması için
                    // getFrequency() metoduna, dataList'i yolluyorum ve bunun sonucunda bana
                    // bir liste döndürüyor. Bu liste;
                    // [gönderilen miktar1, frekans değeri1, gönderilen miktar2, frekans değeri2,
                    // ....]
                    // tarzında kaç farklı değer varsa, listenin çift sayılı indexlerinde gönderilen
                    // miktar, tek sayılı indexlerinde frekans değerlerini tutacak şekilde kodlaması
                    // gerçekleştirildi. getFrequency() metodu bittiğinde frequencyList listesine bu
                    // yeni oluşturulan listeyi yollar hale getirildi. Daha sonra frekans listesi
                    // getProbability() fonsiyonuna gönderilerek, her bir frekansın; toplam
                    // frekanslara olasığı hesaplanılarak yeni bir listeye yazdırıldı. Bu liste şu
                    // şekilde modellendi; [gönderilen miktar1, frekans değeri1, olasılık değeri1,
                    // ......] şeklinde tüm gönderilen miktarların hem frekansı hem olasılıkları tek
                    // bir listede tutulur duruma getirildi. Daha sonra bu liste probabilityList
                    // listesine yazılarak, cumulativeProbability() metoduna gönderildi. Bu metot da
                    // diğer metotlar gibi kümülatif olasılığı hesaplayıp listenin sonuna ekler
                    // şekilde devam ettirildi ve bu metot bittiğinde elimizde [gönderilen miktar1,
                    // frekans değeri1, olasılık değeri1, kümülatif olasılık1, ......] tarzında bir
                    // liste oluşturuldu ve ihityaç duyulan tüm elemanlar bir listeye sığdırılmış
                    // hale getirildi. Program çalıştırıldığında bu liste ekrana yazdırılmaktadır.
                    // Daha sonra bilgisayara rastgele sayılar ürettirmek ve tahmin oluşturmak için
                    // createEstimated() metoduna listenin son hali yollanmaktadır. Bu metot,
                    // kullanıcının dilediği tekrar sayısı kadar 12 aylık süreci tekrar edecek ve
                    // oluşturulan rastgele sayıların kümülatif olasılığı göz önüne alınarak hangi
                    // değer de olduğunu bulacaktır. Bulunan değerler her ay'a tek tek eklenip
                    // tekrar sayısına bölünüp hangi ayda ne kadar değer gelebilir kısmı ekrana
                    // yazdırılacaktır ve üretilen bu sayıların hepsinin frekans değerleri de ekrana
                    // yazdırılıp işlem sonlandırılacaktir.

                    dataList = read_xlsx_file.getCellData(); // montecarlo/read_xlsx_file.java altında bulunan xlsx
                                                             // dosyasından veri okumayı sağlayan metodun çağrılması
                                                             // System.out.println(dataList.toString());

                    List cumulativeList = calculateAllParameters(dataList);// frekans, olasılık ve kümülatif olasılık
                                                                           // metotlarının çağrıldığı ve oluşturulan
                                                                           // listenin ekrana basıldığı fonksiyon.

                    System.out.println("12 ay için kaç tekrar oluşturulsun?");
                    cumulativeList = createEstimated(cumulativeList, readNum());// Rastgele sayılar oluşturarak tahmin
                                                                                // işlemini
                    // sağlayacak fonksiyon
                    calculateAllParametersForResult(cumulativeList);
                    break;
                case 2:
                    System.out.println("Başlangıç değerini giriniz.");
                    a = readNum();
                    System.out.println("Kaç tane sayı üretilsin?");
                    b = readNum();
                    orta_kare.rndOrtaKare(b, a); // randomNum/orta_kare.java sınıfının içerisinde bulunan rndOrtaKare()
                                                 // metodunun çağrılması.
                    break;
                case 3:
                    System.out.println("Kaç tane sayı üretilsin?");
                    int i = readNum();
                    System.out.println("Sabit çarpanı (a) değerini giriniz.");
                    a = readNum();
                    System.out.println("Artış (c) değerini giriniz.");
                    c = readNum();
                    System.out.println("Başlangıç değerini (x0) giriniz.");
                    x0 = readNum();
                    System.out.println("Mod (m) değerini giriniz.");
                    m = readNum();
                    boolean misbigger = true;
                    while (misbigger) { // mod (m) sayısının değir seçilen sayılardan büyük olup olmadığının kontrol
                                        // edildiği döngü.
                        if (m > a && m > c && m > x0) {
                            misbigger = false;
                        } else {
                            System.out.println("m değeri diğerlerinden büyük bir sayı olamalı; Lütfen tekrar giriniz.");
                            m = readNum();
                        }
                    }
                    randomNum.dogrusal_eslik.rndDogrusalEslik(a, c, m, x0, i);
                    break;
                case 4:
                    condition = false; // Programdan çıkmayı sağlayan atama işlemi
                    break;

                default:
                    System.out.println("Sadece 1, 2 veya 3 seçeneklerini seçebilirsiniz!");
                    break;
            }
        }
    }

    public static List calculateAllParameters(List dataList) {
        Collections.sort(dataList); // dataList'in sıralanması

        List frequencyList = getFrequency(dataList); // frekans tablosunu oluşturacak olan metot
        List probabilityList = getProbability(frequencyList); // her bir frekansın toplam frekanslara
                                                              // oranını tabloya ekleyen metot
        List cumulativeList = cumulativeProbability(probabilityList); // kümülatif olasılığı tabloya ekleyen
                                                                      // metot
        System.out.println("-------------------------------------------------------------------");
        System.out.println(
                "Excel dosyasında okunan değerlerin miktar, frekans, olasılık ve kümülatif olasılık tablosu");
        int tmp = 1;
        // Oluşan listenin ekranda kullanıcıya gösterilmesini sağlayan döngü
        for (int i = 0; i < cumulativeList.size(); i = i + 4) {
            System.out.println(
                    tmp + ". =  " + cumulativeList.get(i) + "      " + cumulativeList.get(i + 1) + "      "
                            + cumulativeList.get(i + 2) + "      " + cumulativeList.get(i + 3));
            tmp++;
        }
        System.out.println("-------------------------------------------------------------------");
        return cumulativeList;
    }

    public static void calculateAllParametersForResult(List dataList) {
        Collections.sort(dataList); // dataList'in sıralanması

        List frequencyList = getFrequency(dataList); // frekans tablosunu oluşturacak olan metot
        List probabilityList = getProbability(frequencyList); // her bir frekansın toplam frekanslara
                                                              // oranını tabloya ekleyen metot
        System.out.println("-------------------------------------------------------------------");
        System.out.println(
                "Oluşturulan değerlerin miktar, frekans ve olasılık  tablosu");
        int tmp = 1;
        // Oluşan listenin ekranda kullanıcıya gösterilmesini sağlayan döngü
        for (int i = 0; i < probabilityList.size(); i = i + 3) {
            System.out.println(
                    tmp + ". =  " + probabilityList.get(i) + "      " + probabilityList.get(i + 1) + "      "
                            + probabilityList.get(i + 2));
            tmp++;
        }
        System.out.println("-------------------------------------------------------------------");

    }

    public static List createEstimated(List dataList, int r) {
        List randomNumList = new ArrayList();
        // Oluşturulacak tüm ratgele sayıların, kümülatif olasılık karşısında ki
        // değerlerinin tutulacağı liste
        List monthList = new ArrayList();
        // Her ay için oluşturulan toplam değerleri tutuacak olan liste
        Random random = new Random();
        int month = 0; // month, döngü içerisinde kaçıncı ayda olduğumuzu tutacak değişken
        int tmp = 0; // 1 yılın yani 12 ayın dolup dolmadığını tutan değişken
        for (int i = 0; i < 12 * r; i++) {
            // Döngü 12 ay için sırayla tek tek sayı üretir ve hangi kümülatif olasılığa
            // denk geldiğini, denk gelen sayıyı alıp bir liste de tutmayı sağlar

            double randomNum = random.nextDouble(); // Rastgele sayının oluşturulması
            // System.out.println(tmp); //Oluşturulan Rastgele sayıları görmek için yorum
            // satırını kaldırınız.

            for (int j = dataList.size() - 1; j > 2; j = j - 4) {
                // Bu döngü şu şekilde çalışmaktadır; İlk çalıştırılması sırasında, tüm gerekli
                // elemanların bulunduğu listenin, son elemanının kümülatif olasılığını alır,
                // oluşturulan rastgele sayı eğer bu son, yani en büyük kümülatif olasılıktan
                // büyük ise rastgele oluşturulan sayı en büyük gönderilen miktara eşittir der
                // ve en büyük miktarı tutar. Eğer eşit değilse, en büyük kümülatif olasılıktan
                // daha küçük bir sayı oluşturulmuşsa döngü bir önceki kümülatif olasılığı alır
                // ve ondan büyük mü, onun kontrolünü sağar. Bu şekilde devam eder ve eğer en
                // küçük kümülatif olasılıktan daha küçük bir sayı üretildiyse en küçük sayıyı
                // alır ve listeye atar.
                if (randomNum >= (Double) dataList.get(j)) {
                    if (month >= 12) {
                        // 1 yılın tamamlanıp tamamlanmadığını kontol eden koşul
                        month = 0;
                        tmp = 1;
                    }
                    if (tmp == 1) {
                        monthList.set(month, ((Integer) monthList.get(month) + (Integer) dataList.get(j - 3)));
                        // 12 ay dolup, tekrar ocak ayına yani ilk aya, o ayın önceki değerleriyle
                        // toplanıp tekrardan o aya yazılmasının yapıldığı yer.
                    } else {
                        monthList.add(dataList.get(j - 3));
                        // dataList'in j-3'ncü elemanının listeye eklenmesinin sebebi; dizinin
                        // [gönderilen miktar, frekans değeri, olasılık değeri, kümülatif olasılık]
                        // şeklinde olmasıdır. Kümülatif olasılığın bulunduğu indexten 3 adım geri
                        // gidilirse, gönderilen miktara erişim sağlanır.
                    }
                    randomNumList.add(dataList.get(j - 3)); // Frekans hesaplamasının yapılabilmesi için, tüm
                                                            // oluşturulmuş
                    // elemanların listeye eklenmesi
                    month++;
                    break;
                }
            }
        }
        for (int i = 0; i < monthList.size(); i++) {
            // Bu döngü 2022 yılı için her aya düşen ortalama sayıyı bulup ekrana
            // yazdırılmasını sağlar. Kaç iterasyon döndüyse her ay o iter sayısına bölünür
            // ve 12 aylık bir değer elde edilir.
            monthList.set(i, ((Integer) monthList.get(i) / r));
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("2022 yılı, ay ay ortalama ne kadar domates kullanılacağı tablosu");
        for (int i = 0; i < monthList.size(); i++) {
            // 12 aylık tahmini değer listesi ekrana ay ay yazdırılır.
            System.out.println(i + 1 + ". ay = " + monthList.get(i));
        }

        return randomNumList;
    }

    public static List cumulativeProbability(List dataList) {
        // Bu fonksiyon kümülatif olasılık hesabında kullanılır. Bu işi bir önceki
        // değerin kümülatif olasılıyla, o anki değerin frekansının olasılını
        // toplar ve listenin sonuna ekler.
        List tmpList = new ArrayList();
        double tmp = 0;
        for (int i = 2; i < dataList.size(); i = i + 3) {
            tmpList.add(dataList.get(i - 2));
            tmpList.add(dataList.get(i - 1));
            tmpList.add(dataList.get(i));
            tmpList.add(tmp);
            tmp = tmp + (Double) dataList.get(i);
        }
        return tmpList;
    }

    public static List getFrequency(List dataList) {
        // dataList içerisinde ki elemanların tekrar sayılarını hesaplayıp bunları
        // [gönderilen miktar1, frekans değeri1, gönderilen miktar2, frekans değeri2,
        // ....] formatta liste haline döndüren fonksiyon. Fonksiyona gelen liste sıralı
        // olduğu için, eğer bakılan eleman önceki elemandan farklı ise; önceki eleman
        // dizinin başka bir yerinde bulunmadığı anlaşılır ve frekansı hesaplanır

        List<Integer> frequencyList = new ArrayList<Integer>();
        int tmp = (Integer) dataList.get(0);
        int frequencyListIndex = -1;
        for (int i = 0; i < dataList.size(); i++) {
            if (tmp != (Integer) dataList.get(i)) {
                frequencyListIndex = frequencyListIndex + 2;
                tmp = (Integer) dataList.get(i);
                frequencyList.add((Integer) dataList.get(i));
                frequencyList.add(1);
            } else {
                if (frequencyListIndex == -1) {
                    // liste boşsa set yapmak yerine eklme işlemi yapacak olan koşul
                    frequencyList.add((Integer) dataList.get(i));
                    frequencyList.add(1);
                    frequencyListIndex = 0;
                } else {
                    frequencyList.set(frequencyListIndex + 1, (frequencyList.get(frequencyListIndex + 1) + 1));
                }
            }

        }
        return frequencyList;

    }

    public static List getProbability(List dataList) {
        // Bu fonksiyon, frekansı hesaplanan listenin olasılığını hesaplamayı sağlar.
        // Bunu her değerin frekans değeriyle, toplam değer sayısının bölümüyle bulur ve
        // gelen listenin sonuna olasılık değerini atar.
        List tmpList = new ArrayList();
        int rowCount = read_xlsx_file.getRowCount();

        for (int i = 1; i < dataList.size(); i = i + 2) {

            tmpList.add(dataList.get(i - 1));
            tmpList.add(dataList.get(i));
            tmpList.add((Double.parseDouble(dataList.get(i).toString()) / rowCount));
        }
        return tmpList;
    }

    public static int readNum() {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        try {
            a = scan.nextInt();
            System.out.println("Girilen değer = " + a);
            return a;

        } catch (Exception e) {
            System.out.println("Yalnızca rakam giriniz");
            readNum();
        }
        return a;
    }

}