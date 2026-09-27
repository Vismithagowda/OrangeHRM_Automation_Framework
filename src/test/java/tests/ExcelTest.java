package tests;

import org.testng.annotations.Test;
import utils.ExcelUtils;

public class ExcelTest {

    @Test
    public void readExcelData() {

        ExcelUtils.setExcelFile(
                "src/test/resources/LoginData.xlsx",
                "Sheet1"
        );

        String username = ExcelUtils.getCellData(1, 0);
        String password = ExcelUtils.getCellData(1, 1);

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}