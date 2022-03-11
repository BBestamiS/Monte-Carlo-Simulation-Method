package montecarlo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        GetValue getValue = new GetValue();
        List<List> years = new ArrayList<List>();
        years = getValue.getCellData();
        Iterator<List> itr = null;
        Iterator<List> monthitr = null;
        itr = years.iterator();
        while (itr.hasNext()) {
            monthitr = itr.next().iterator();
            while (monthitr.hasNext()) {
                Month month = (Month) monthitr.next();
                System.out.println(month.getMonth() + "   " + month.getQuantity());
            }

        }
    }

}