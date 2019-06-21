package com.cn.control.systemframe.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.StorageDB;
import com.cn.dao.system.WorkerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.model.system.WorkerCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.WorkSet;
import com.cn.view.systemJFrame.Worker.ChangeWorker;

public class ChangeWorkerAction implements ActionListener {

	public ChangeWorker frame;
	
	public ChangeWorkerAction (ChangeWorker frame){
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		 Vector data = new Vector();
		    
		    if(frame.getT1()!=null){
		    data.add(frame.getT1().getText().toString());}//姓名
		    else{data.add("");}
		    
		    if(frame.getT2()!=null){
	        data.add(frame.getT2().getText().toString());}//职务
		    else{data.add("");}
		    
		    
		    if(frame.getT3()!=null){
	        data.add(frame.getT3().getText().toString());}//3联系电话
	        else{data.add("");}
		    
		    
		    if(frame.getT4()!=null){
	        data.add(frame.getT4().getText().toString());}//5联系地址
		    else{data.add("");}
		    
		    if(frame.getT5()!=null){
	        data.add(frame.getT5().getText().toString());}//备注8
		    else{data.add("");}
		    
		    if(frame.getC1().isSelected()){
		    	data.add("是");
		    }else{data.add("否");}
		    
		    if(frame.getC2().isSelected()){
		    	data.add("是");
		    }else{data.add("否");}
		    
		    if(frame.getC3().isSelected()){
		    	data.add("是");
		    }else{data.add("否");}
		    
	  if(WorkerDB.changeWorker(data)){
	    	
	    	Vector data2 = WorkerDB.getData();
	    	WorkSet.getWorkerModel().setDataVector(data2,
	    			AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
	    	     JOptionPane.showMessageDialog(null,"员工修改成功!");
	    	     frame.dispose();
	    	     
	    	    
	    	     WorkSet frame1 = (WorkSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	           
	         	 Log.traceLog("操作员：",user," 修改了仓库："+
	         	      frame.getT1().getText()+" 的信息");
	            
				 
	        	 
	    }else{
	    	JOptionPane.showMessageDialog(null,"数据修改失败，请查看输入是否正确!");
	    	 
	    }
	    
	}
		
}


