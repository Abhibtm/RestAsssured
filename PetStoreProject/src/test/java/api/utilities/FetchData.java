package api.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FetchData {
	
	@DataProvider(name="A")
	public String[][] getData() throws Throwable
	{
		String path="D:\\Personal1\\PetStoreProject\\TestData\\RestDataDriven.xlsx";
		System.out.println(path);
		XLUtility xl = new XLUtility(path);
		int rowCount= xl.getRowCount("Sheet1");
		//System.out.println(rowCount);
		int cellCount=xl.getCellCount("Sheet1", rowCount);
		cellCount = cellCount+1;
		String[][] x=new String[rowCount][cellCount];
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				x[i][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return x;
		
		
	}
	@DataProvider(name ="username")
	public String[] Usergetname() throws Throwable
	{
		String path="D:\\Personal1\\PetStoreProject\\TestData\\RestDataDriven.xlsx";
		System.out.println(path);
		XLUtility xl = new XLUtility(path);
		int rowCount= xl.getRowCount("Sheet1");
		String[] data= new String[rowCount];
		
		for(int i=0;i<rowCount;i++)
		{
			data[i]= xl.getCellData("Sheet1", rowCount, 1);
		}
		
		return data;
	}

}
