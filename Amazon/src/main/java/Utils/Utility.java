package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

		public static String getTD(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException {

			FileInputStream file = new FileInputStream("C:\\Users\\ramko\\eclipse-workspace\\SRC\\Amazon\\TestData\\TestData.xlsx");

			org.apache.poi.ss.usermodel.Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
			String value = sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
			return value;
		}
/////
}
