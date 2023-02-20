package Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class createExcel {
	 String outputFile = "./temp.xls";
	 static HSSFSheet sheet = null;
	 HSSFWorkbook excelbook=new HSSFWorkbook();
	
	 public void createExcel() {
		    try {
		        sheet = excelbook.createSheet("遊玩紀錄"); // 在索引0的位置建立行（最頂端的行）
		        HSSFRow row = sheet.createRow((short) 0);
		        HSSFCell monadism = row.createCell((short) 0); // 在索引0的位置建立單元格（左上端）
		        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
		        monadism.setCellValue("id");// 在單元格中輸入一些內容
		        row.createCell((short) 1).setCellValue("username"); // 在第一行第二列增加內容
		        row.createCell((short) 2).setCellValue("puzzle");
		        row.createCell((short) 3).setCellValue("time");
		        FileOutputStream out = new FileOutputStream(outputFile); // 新增輸出檔案流
		        excelbook.write(out);// 把對應的Excel工作簿存碟
		        out.flush();
		        out.close(); // 操作結束，關閉檔案
		        System.out.println("檔案建立成功！！！");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	 
	 public void insertvalue(String id, String username,String puzzle,String time) {
		    try {
		        excelbook = new HSSFWorkbook(new FileInputStream(outputFile));  //定義Excel表對像
		        HSSFSheet sheet = excelbook.getSheet("遊玩紀錄");        //獲得指定的工作表
		        int count = sheet.getPhysicalNumberOfRows();        //獲得工作表中總體行數
		        HSSFRow row = sheet.createRow((short) count);       //新增一行
		        row.createCell((short) 0).setCellValue(id);        // 在索引0的位置建立單元格（左上端）
		        row.createCell((short) 1).setCellValue(username);   
		        row.createCell((short) 2).setCellValue(puzzle); 
		        row.createCell((short) 3).setCellValue(time); 
		        FileOutputStream out;// 新增輸出檔案流        
		        out = new FileOutputStream(outputFile);
		        excelbook.write(out);// 把對應的Excel工作簿存碟
		        out.flush();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	 
	 
	 
}
