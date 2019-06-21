package com.cn.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * EXCEL读取类
 *
 *实现“导出”
 *
 */
public class ReaderXls {
	
/**
 *
 *将JTable中的数据写入表Excel中
 *
 * @param filename   文件名
 * @param table      表名
 * @param mane       表名上的各个属性值
 * 	
 */
	public static void reader(String filename, JTable table, String[] mane) {
		filename = filename+".xls";
		File fileWrite = new File(filename);// 声明一个文件类
		try {
			
			fileWrite.createNewFile();			
			OutputStream os = new FileOutputStream(fileWrite);
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			// 创建子表并写入数据
			WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
			// 取得TABLE的行数
			int a = table.getRowCount();
			// 取得TABLE的列数
			int b = table.getColumnCount();
			for (int k = 0; k < b; k++) {
				jxl.write.Label labelN = new jxl.write.Label(k, 0, mane[k]);
				try {
					ws.addCell(labelN);
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < b; i++) {
				for (int j = 1; j <= a; j++) {
					String str = null;				
				  //将表中的数据全部转为字符串
					str = String.valueOf(table.getValueAt(j - 1, i));									
					
					jxl.write.Label labelN = new jxl.write.Label(i, j, str);
					try {
						ws.addCell(labelN);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}
			// 写入工作表
			wwb.write();

			try {
				wwb.close();
				JOptionPane.showMessageDialog(null, "在" + filename + "成功导出数据");
			} catch (WriteException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "导入数据前请关闭工作表");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "没有进行筛选");
			e.printStackTrace();

		}
	}
}
