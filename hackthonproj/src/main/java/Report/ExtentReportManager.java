package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {
	
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		if(report ==null) {
			String fileName=timestamputils.getDateStamp()+".html"; 
			ExtentHtmlReporter htmlrepo=new ExtentHtmlReporter("./test-output/"+fileName);
			report=new ExtentReports();
			report.attachReporter(htmlrepo);
			
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Browser", "chrome");
			
			
			htmlrepo.config().setDocumentTitle("Automation report");
			htmlrepo.config().setReportName("Display bookshelf automation report");
			htmlrepo.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlrepo.config().setTimeStampFormat("MM dd yyyy HH:MM:SS");
		}
		return report;
	}

}
