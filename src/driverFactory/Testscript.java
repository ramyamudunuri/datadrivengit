package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class Testscript extends AppUtilPom{
	String inputpath="D:\\11oClock\\DDT_FrameWork\\FileInput\\EMPLOGIN.xlsx";
	String outputpath="D:\\11oClock\\DDT_FrameWork\\FileOutput\\empresults.xlsx";
	@Test
	public void start_test()throws Throwable {
		
		AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int row=xl.rowCount("EMPDATA");
		Reporter.log("no of rows are"+row,true);

		for(int i=1;i<=row;i++) {
			String Fristname=xl.getCellData("EMPDATA", i, 0);
			String middlename=xl.getCellData("EMPDATA", i, 1);
			String lastname=xl.getCellData("EMPDATA", i, 2);
			
			
		
		boolean res=emp.verify_Emp(Fristname, middlename, lastname);
	if (res) {
		xl.setCelldata("EMPDATA", row, 3, "LOGINSUCCES", "pass");
		
	}
	else {
		xl.setCelldata("EMPDATA", row, 3, "Loginfail", "fail");
	}
		}
	}

}
