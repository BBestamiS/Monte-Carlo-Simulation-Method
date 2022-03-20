package montecarlo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        List<Integer> dataList = new ArrayList<Integer>();
        dataList = read_xlsx_file.getCellData();
        Collections.sort(dataList);
        // System.out.println(dataList.toString());
        List frequencyList = tmpGetFrequency(dataList);
        List probabilityList = getProbability(frequencyList);
        List cumulativeList = cumulativeProbability(probabilityList);
        System.out.println(cumulativeList);
        List estimatedList = createEstimated(cumulativeList);
        Collections.sort(estimatedList);
        frequencyList = tmpGetFrequency(estimatedList);
        System.out.println(estimatedList.toString());
        for (int i = 0; i < frequencyList.size(); i = i + 2) {
            System.out.println(i + 1 + ".= " + frequencyList.get(i) + " " + frequencyList.get(i + 1));
        }
        // System.out.println(probabilityList.toString());
        // int a;
        // int b;
        // System.out.println("Başlangıç değerini giriniz.");
        // a = readNum();
        // System.out.println("Kaç tane sayı üretilsin?");
        // b = readNum();
        // orta_kare.rndOrtaKare(b, a);
        // rndDogrusalEslenik(a, 7, 2, 3, 16);
    }

    public static List createEstimated(List dataList) {
        List tmpList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            double tmp = random.nextDouble();
            System.out.println(tmp);
            for (int j = dataList.size() - 1; j > 2; j = j - 4) {
                if (tmp >= (Double) dataList.get(j)) {
                    tmpList.add(dataList.get(j - 3));
                    break;
                }
            }
        }
        return tmpList;
    }

    public static List cumulativeProbability(List dataList) {
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

    public static List tmpGetFrequency(List dataList) {
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
        List tmpList = new ArrayList();
        int rowCount = read_xlsx_file.getRowCount();

        for (int i = 1; i < dataList.size(); i = i + 2) {

            tmpList.add(dataList.get(i - 1));
            tmpList.add(dataList.get(i));
            tmpList.add((Double.parseDouble(dataList.get(i).toString()) / rowCount));
        }
        return tmpList;
    }

    public static void getFrequency(List dataList) {
        List<Integer> frequencyList = new ArrayList<Integer>();

        for (int i = 0; i < dataList.size(); i++) {
            int tmp = 0;
            for (int j = 0; j < frequencyList.size(); j = j + 2) {
                if (dataList.get(i).toString().equals(frequencyList.get(j).toString())) {
                    frequencyList.set(j + 1, (frequencyList.get(j + 1) + 1));
                    tmp = 1;
                    break;
                }
            }
            if (tmp == 0) {
                frequencyList.add((Integer) dataList.get(i));
                frequencyList.add(1);
            }
        }

        System.out.println(frequencyList.toString());
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