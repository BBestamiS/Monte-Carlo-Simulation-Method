package randomNum;

import java.util.ArrayList;
import java.util.List;

public class dogrusal_eslik {
    public static void rndDogrusalEslik(float a, float c, float m, float x0, int i) {
        List<Float> randomNumList = new ArrayList<Float>();
        List<Integer> xiList = new ArrayList<Integer>();
        float z = x0;
        xiList.add((int) z);
        float u;
        float tmp;
        u = (z / m);
        randomNumList.add(u);
        for (int j = 0; j < i - 1; j++) {
            z = (((a * z) + c) % m);
            xiList.add((int) z);
            tmp = z / m;
            randomNumList.add(tmp);
        }
        for (int j = 0; j < randomNumList.size(); j++) {
            System.out.println("i = " + j + ", Xi = " + xiList.get(j) + ", Ui = " + randomNumList.get(j));
        }
    }
}
