package com.cn.control.systemframe.storage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

//import mypackage.gui.homeworkMVC.dao.JDBCGetDate;
//import mypackage.gui.homeworkMVC.model.TableCulomn;

import com.cn.dao.system.OperatorDB;
import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.StorageCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.CangKuSheZhi;
import com.cn.view.systemJFrame.OperatorSet;
import com.cn.view.systemJFrame.CangKuXheZhi.AddStorage;

public class AddStorageAction implements ActionListener {
    
	private AddStorage frame;  
    
    
    public String[]obj = new String[7];
    
    
	public AddStorageAction(AddStorage frame){
		 
		
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(frame.getT1().getText()!=null && !frame.getT1().getText().equals("")){
		
		 obj[0] = frame.getT1().getText();
		 obj[1] = frame.getT2().getText();
		 obj[2] = frame.getT3().getText();
		 obj[3] = frame.getT4().getText();
		 obj[4] = frame.getT5().getText();
		// obj[5] = frame.get.getText();
		// obj[6] = frame.getT1().getText();
		 
		 if(frame.getC1().isSelected()){
			 obj[5]="是";
		 }
		    else{obj[5]="否";}
		 
		 if(frame.getC2().isSelected()){
			 obj[6]="是";
		 }
		    else{obj[6]="否";}
		 
		 
		 // System.out.println(obj[6]);
		if(StorageDB.addStorageData(obj)){
			Vector data = StorageDB.getData();
			 ((CangKuSheZhi) frame.getOwner()).getTablemodel().setDataVector(data,
					AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));
			 JOptionPane.showMessageDialog(null,"仓库增加成功！");
			 frame.dispose();
			 
			 
			 CangKuSheZhi frame1 = (CangKuSheZhi)frame.getOwner();
			 
             MainFrame mUser = (MainFrame)(frame1.getOwner());
             String user=mUser.getUser();
             
             
         	 Log.traceLog("操作员：",user," 增加了仓库："+
         	      frame.getT1().getText()+" 的信息");
           
			 
        	 
			
		  }
		    else{JOptionPane.showMessageDialog(null,"仓库增加失败！请查看数据输入是否正确！");
			 }
		
		
		
	}else{JOptionPane.showMessageDialog(null,"请填写仓库名！");}
	}
}
