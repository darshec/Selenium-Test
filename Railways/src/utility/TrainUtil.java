package utility;


import java.util.ArrayList;

import excel.utility.Xls_Reader;

public class TrainUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList <Object[]> getDataFromExcel1() {
		
		ArrayList<Object[]> mytrain = new ArrayList<Object[]>();
	
		try {
			
			reader = new Xls_Reader("D:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse\\Projects\\Railways\\src\\TestDataDrive\\rails.xlsx");
		}catch (Exception e) 
		
		{
		System.out.println(e.getMessage());
		//e.printStackTrace()
			}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("raildetails");rowNum++)
		{
			
			String Date = reader.getCellData("raildetails", "Date", rowNum);
			String storagetank = reader.getCellData("raildetails", "storagetank", rowNum);
			
			//Integer istoragetank = Integer.parseInt(storagetank);
			//System.out.println(istoragetank);
			String flowmeter = reader.getCellData("raildetails", "flowmeter", rowNum);
			String shift = reader.getCellData("raildetails", "shift", rowNum);
			String fromtime = reader.getCellData("raildetails", "fromtime", rowNum);
			String tilltime = reader.getCellData("raildetails", "tilltime", rowNum);
			String shiftmanager = reader.getCellData("raildetails", "shiftmanager", rowNum);
			String operator = reader.getCellData("raildetails", "operator", rowNum);
			String atg = reader.getCellData("raildetails", "atg", rowNum);
			String locono = reader.getCellData("raildetails", "locono", rowNum);
			String locoshed = reader.getCellData("raildetails", "locoshed", rowNum);
			String fuelpoint = reader.getCellData("raildetails", "fuelpoint", rowNum);
			String trainno = reader.getCellData("raildetails", "trainno", rowNum);
			String traintype = reader.getCellData("raildetails", "traintype", rowNum);
			String locopilotid = reader.getCellData("raildetails", "locopilotid", rowNum);
			String locopilotname = reader.getCellData("raildetails", "locopilotname", rowNum);
			String Inward = reader.getCellData("raildetails", "Inward", rowNum);
			String Preset = reader.getCellData("raildetails", "Preset", rowNum);
			String Fuelstarttime = reader.getCellData("raildetails", "Fuelstarttime", rowNum);
			String Fuelendtime = reader.getCellData("raildetails", "Fuelendtime", rowNum);
			String Qtyissued = reader.getCellData("raildetails", "Qtyissued", rowNum);
			String OpenReading = reader.getCellData("raildetails", "OpenReading", rowNum);
			String CloseReading = reader.getCellData("raildetails", "CloseReading", rowNum);
			String TransactionDate = reader.getCellData("raildetails", "TransactionDate", rowNum);
			String VegaT = reader.getCellData("raildetails", "VegaT", rowNum);
		
			Object ob[] = {Date, storagetank, flowmeter, shift, fromtime, tilltime, shiftmanager, operator, atg, locono, locoshed, fuelpoint, trainno, traintype, locopilotid, locopilotname, Inward, Preset, Fuelstarttime, Fuelendtime, Qtyissued, OpenReading, CloseReading, TransactionDate, VegaT};
			mytrain.add(ob);	
		}
		return mytrain;
	}
}
