package utilities;

public class Constant {
		
	//URLs
	public static String baseURL = "http://automationpractice.com/index.php";
	public static String baseURL_Staging = ""; 
	public static String baseURL_QA = ""; 
	
	
	//Path Names
		
	public static String ChromeExePath =  "C:\\SandboxLibraries\\chromedriver_win32\\chromedriver.exe";
	public static String IEExePath =  "C:\\SandboxLibraries\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe";
	
	//File Names
	public static String File_TestData = "TestDataSet1.xlsx";
	
    //Test Data Sheet Columns
    
	public static final int Col_TestCaseName = 0;		 
	public static final int Col_UserName =1 ;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_Env = 4;
	public static final int Col_Results = 5;
	public static final int Col_Timestamp = 6;
	public static final int Col_Desc = 7;

}
