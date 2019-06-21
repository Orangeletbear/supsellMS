package com.cn.control.systemframe.storage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.dao.system.StorageDB;
import com.cn.view.systemJFrame.CangKuSheZhi;

public class DeleteStorageAction implements ActionListener {


		CangKuSheZhi frame;
		public DeleteStorageAction(CangKuSheZhi frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if(frame.getTable().getSelectedColumn()<=0){
	        	JOptionPane.showMessageDialog(null,"请先选择一条数据");
				return;
	        }
			int ok = JOptionPane.showConfirmDialog(frame, "删除后不可恢复！",
					"系统警告", JOptionPane.YES_NO_OPTION);
		
	        if(ok==JOptionPane.YES_OPTION){
	        	 int row = frame.getTable().getSelectedRow();
		    	 Object obj = frame.getTable().getValueAt(row, 0);
		    	 if(StorageDB.DeleteStorageData(obj.toString().trim())){
		    		 JOptionPane.showMessageDialog(null,"数据成功删除");
		    		 //StorageDB.DeleteStorageData("","");
		    	 } else JOptionPane.showConfirmDialog(null, "删除失败");		 
		}
	}
	}