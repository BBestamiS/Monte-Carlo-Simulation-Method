package randomNum;

import java.util.ArrayList;
import java.util.List;

public class dogrusal_eslik {
    public static void rndDogrusalEslik(float a, float c, float m, float z0, int i) {
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

        System.out.println(randomNumList.toString());
    }
}
