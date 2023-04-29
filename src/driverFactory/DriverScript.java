package driverFactory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.Functionalibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
	String inputpath="D:\\11oClock\\DDT_FrameWork\\FileInput\\Login.xlsx";
	String outputpath="D:\\11oClock\\DDT_FrameWork\\FileOutput\\DataDrivenResults.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void startTest() throws Throwable{
		// create object for excel util file
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int rc=xl.rowCount("login");
		report=new ExtentReports("./ExtenReports/login.html");
		for(int i=1;i<=rc;i++) {
			test=report.startTest("validate login");

			//read username and password cell
			String username=xl.getCellData("login", i, 0);
			String password=xl.getCellData("login", i, 1);
			//calling login method
			boolean res=Functionalibrary.login_verify(username, password);
			if (res) {
				report=new 
				// if res is true write login as pass
				xl.setCelldata("login", i, 2, "login success", outputpath);
				xl.setCelldata("login", i, 3, "pass", outputpath);
			}
			else {
				File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteration/"+i+"loginpage.png"));

				xl.setCelldata("login", i, 3, "fail", outputpath);
				test.log(LogStatus.FAIL,"login fail");









			}
			report.endTest(test);
			report.flush();
		}


	}



}
