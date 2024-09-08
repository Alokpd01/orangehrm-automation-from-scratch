package org.automation.dataprovider;

import org.automation.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class PIMPageDataProvider {

    private ExcelUtil excelUtil = new ExcelUtil();

    @DataProvider(name = "addEmployee")
    public Object[][] getAddEmployeeData() throws IOException {
        excelUtil.setFilePathAndName("testdata/pim/AddEmployee.xlsx", "Sheet1");
        List<Object[]> dataList = excelUtil.getData();
        excelUtil.close();

        // Convert List<Object[]> to Object[][]
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    @DataProvider(name = "editEmployee")
    public Object[][] getEditEmployeeData() throws IOException {
        excelUtil.setFilePathAndName("testdata/pim/EditEmployee.xlsx", "Sheet1");
        List<Object[]> dataList = excelUtil.getData();
        excelUtil.close();

        // Convert List<Object[]> to Object[][]
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    @DataProvider(name = "deleteEmployee")
    public Object[][] getDeleteEmployeeData() throws IOException {
        excelUtil.setFilePathAndName("testdata/pim/DeleteEmployee.xlsx", "Sheet1");
        List<Object[]> dataList = excelUtil.getData();
        excelUtil.close();

        // Convert List<Object[]> to Object[][]
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

}
