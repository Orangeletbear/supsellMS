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
 * EXCEL��ȡ��
 *
 *ʵ�֡�������
 *
 */
public class ReaderXls {
	
/**
 *
 *��JTable�е�����д���Excel��
 *
 * @param filename   �ļ���
 * @param table      ����
 * @param mane       �����ϵĸ�������ֵ
 * 	
 */
	public static void reader(String filename, JTable table, String[] mane) {
		filename = filename+".xls";
		File fileWrite = new File(filename);// ����һ���ļ���
		try {
			
			fileWrite.createNewFile();			
			OutputStream os = new FileOutputStream(fileWrite);
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			// �����ӱ�д������
			WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
			// ȡ��TABLE������
			int a = table.getRowCount();
			// ȡ��TABLE������
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
				  //�����е�����ȫ��תΪ�ַ���
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
			// д�빤����
			wwb.write();

			try {
				wwb.close();
				JOptionPane.showMessageDialog(null, "��" + filename + "�ɹ���������");
			} catch (WriteException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "��������ǰ��رչ�����");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "û�н���ɸѡ");
			e.printStackTrace();

		}
	}
}
