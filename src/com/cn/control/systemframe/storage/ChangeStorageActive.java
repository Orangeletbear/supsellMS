package com.cn.control.systemframe.storage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.StorageCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.CangKuSheZhi;
import com.cn.view.systemJFrame.CangKuXheZhi.ChangeStorage;

public class ChangeStorageActive implements ActionListener {

	
	ChangeStorage frame;
	
	public ChangeStorageActive(ChangeStorage frame){
		this.frame=frame;
	}
	 
	public void actionPerformed(ActionEvent arg0) {
		 
		Vector data = new Vector();
		if(frame.getT1().getText()!=null){
              data.add(frame.getT1().getText());}
		else{data.add("");}
		
		if(frame.getT2().getText()!=null){
              data.add(frame.getT2().getText());}
		else{data.add("");}
		
		if(frame.getT3().getText()!=null){
              data.add(frame.getT3().getText());}
		else{data.add("");}
		
        if(frame.getT4().getText()!=null){
		data.add(frame.getT4().getText());}
        else{data.add("");}
        
        //if(frame.getC1().getText()!=null){
        if(frame.getC1().isSelected()){
        	data.add("是");}
        else{data.add("");}
      // }else{data.add("bb");}
        
        // if(frame.getC1().getText()!=null){
        if(frame.getC2().isSelected()){
        	data.add("是");}
            else{data.add("否");}
        //  }else{data.add("否b");}
        
         if(frame.getT5().getText()!=null){
            data.add(frame.getT5().getText());}
             else{data.add("");}
        
        if(StorageDB.ChangeStorageData(data)){
        	
        	Vector data1 = StorageDB.getData();
        	   CangKuSheZhi.getTablemodel().setDataVector(data1,
        			   AllTableModel.getVectorFromObj(StorageCulomns.cangKuNames));    
        	JOptionPane.showMessageDialog(null,"修改仓库数据库存成功~");
        	frame.dispose();
        	
        	
        	 
        	 CangKuSheZhi frame1 = (CangKuSheZhi)frame.getOwner();
             MainFrame mUser = (MainFrame)(frame1.getOwner());
             String user=mUser.getUser();
             
            
         	 Log.traceLog("操作员：",user," 修改了仓库："+
         	      frame.getT1().getText()+" 的信息");
           
        }
        else{JOptionPane.showMessageDialog(null,"数据修改失败，请查数据输入是否正确！");}
   }
	 
}


