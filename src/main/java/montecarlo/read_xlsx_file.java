package montecarlo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_xlsx_file {
    private static final String NAME = "./data/fabrika.xlsx";

    public static List getCellData() throws IOException {
        // Bu fonsiyon .xlsx dosyasının içeriğini okumamızı saylar
        List<Integer> dataList = new ArrayList<Integer>();

        XSSFWorkbook workbook = new XSSFWorkbook(NAME);
        XSSFSheet sheet = workbook.getSheet("Ketçap Fabrikası");

        for (int j = 0; j < getRowCount(); j++) {

            DataFormatter dataFormatter = new DataFormatter();
            Cell value = sheet.getRow(j).getCell(0);
            String cellValue = dataFormatter.formatCellValue(value);
            dataList.add(Integer.parseInt(cellValue));
        }

        // System.out.println("Dosyadan okunan değerler = " + dataList.toString());
        return dataList;

    }

    public static int getRowCount() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(NAME);
            XSSFSheet sheet = workbook.getSheet("Ketçap Fabrikası");
            int rowCount = sheet.getPhysicalNumberOfRows();
            return rowCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
