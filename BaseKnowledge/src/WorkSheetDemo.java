

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class WorkSheetDemo {
	public static void main(String[] args) throws Exception {
		String compStr = null;

		String preStr = "  0% 4103/com.gm.gmaudio: 0% user + 0% kernel / faults: 2452 minor".trim();
		String postStr = "  1.1% 4103/com.gm.gmaudio: 3.0% user + 36.2% kernel / faults: 2452 minor".trim();

		String[] preList = preStr.split(" ");
		String[] postList = postStr.split(" ");
		String flo = "[0-9]{1,5}[.]?[0-9]{0,1}";
		String CPU_REGEX = flo + "% [0-9]{1,5}/.*: " + flo + "% user \\+ " + flo
				+ "% kernel / faults: [0-9]{1,5} minor";
		List<String> stdOutput = new ArrayList<String>();
		stdOutput.add(preStr);
		stdOutput.add(postStr);
		stdOutput.add(compStr);
		//TextCommandResult result = new TextCommandResult(0, stdOutput, null);

		writeToWorkSheet(preList,postList);
	}

	private static void writeToWorkSheet(String[] preList, String[] postList) throws FileNotFoundException, IOException {

		DecimalFormat df = new DecimalFormat("######0.0");
		

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFCellStyle cellStyle = wb.createCellStyle();   
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFSheet sheet = wb.createSheet("result");
		for (int i = 0; i < 4; i++)
			sheet.setColumnWidth(i, 15 * 256);
		HSSFRow row = sheet.createRow(0);
		row.createCell(1).setCellValue("Total Usage");
		row.createCell(2).setCellValue("User Usage");
		row.createCell(3).setCellValue("Kernel Usage");

		row = sheet.createRow(1);
		row.createCell(0).setCellValue("CpuUsage1");
		row.createCell(1).setCellValue(preList[0].replace("%", ""));
		row.createCell(2).setCellValue(preList[2].replace("%", ""));
		row.createCell(3).setCellValue(preList[5].replace("%", ""));

		row = sheet.createRow(2);
		row.createCell(0).setCellValue("CpuUsage2");

		row.createCell(1).setCellValue(postList[0].replace("%", ""));
		row.createCell(2).setCellValue(postList[2].replace("%", ""));
		row.createCell(3).setCellValue(postList[5].replace("%", ""));

		row = sheet.createRow(3);
		row.createCell(0).setCellValue("deltaUsage");
		row.createCell(1).setCellValue(df.format(Double.parseDouble(postList[0].replace("%", ""))
				- Double.parseDouble(preList[0].replace("%", ""))));
		row.createCell(2).setCellValue(df.format(Double.parseDouble(postList[2].replace("%", ""))
				- Double.parseDouble(preList[2].replace("%", ""))));
		row.createCell(3).setCellValue(df.format(Double.parseDouble(postList[5].replace("%", ""))
				- Double.parseDouble(preList[5].replace("%", ""))));

		FileOutputStream fileOut = new FileOutputStream("/home/makun/workbook.xls");
		wb.write(fileOut);
		fileOut.close();
		System.out.println("done");
	}
}
