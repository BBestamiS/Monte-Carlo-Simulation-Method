package montecarlo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetValue {
    private static final String NAME = "./data/Book1.xlsx";

    public static List getCellData() throws IOException {
        List<List> years = new ArrayList<List>();

        XSSFWorkbook workbook = new XSSFWorkbook(NAME);
        XSSFSheet sheet = workbook.getSheet("Ketçap Fabrikası");
        for (int i = 0; i < 10; i = i + 3) {
            List<Month> year = new ArrayList<Month>();
            for (int j = 4; j < getRowCount(); j++) {
                Month month = new Month();
                Cell value = sheet.getRow(j).getCell(0 + i);
                DataFormatter dataFormatter = new DataFormatter();
                String cellValue = dataFormatter.formatCellValue(value);
                month.setMonth(cellValue);
                value = sheet.getRow(j).getCell(1 + i);
                cellValue = dataFormatter.formatCellValue(value);
                month.setQuantity(Integer.parseInt(cellValue));
                System.out.println(month.toString());
                year.add(month);
            }
            years.add(year);
        }

        return years;

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
