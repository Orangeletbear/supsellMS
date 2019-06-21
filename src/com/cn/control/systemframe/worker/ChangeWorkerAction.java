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
		    data.add(frame.getT1().getText().toString());}//����
		    else{data.add("");}
		    
		    if(frame.getT2()!=null){
	        data.add(frame.getT2().getText().toString());}//ְ��
		    else{data.add("");}
		    
		    
		    if(frame.getT3()!=null){
	        data.add(frame.getT3().getText().toString());}//3��ϵ�绰
	        else{data.add("");}
		    
		    
		    if(frame.getT4()!=null){
	        data.add(frame.getT4().getText().toString());}//5��ϵ��ַ
		    else{data.add("");}
		    
		    if(frame.getT5()!=null){
	        data.add(frame.getT5().getText().toString());}//��ע8
		    else{data.add("");}
		    
		    if(frame.getC1().isSelected()){
		    	data.add("��");
		    }else{data.add("��");}
		    
		    if(frame.getC2().isSelected()){
		    	data.add("��");
		    }else{data.add("��");}
		    
		    if(frame.getC3().isSelected()){
		    	data.add("��");
		    }else{data.add("��");}
		    
	  if(WorkerDB.changeWorker(data)){
	    	
	    	Vector data2 = WorkerDB.getData();
	    	WorkSet.getWorkerModel().setDataVector(data2,
	    			AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
	    	     JOptionPane.showMessageDialog(null,"Ա���޸ĳɹ�!");
	    	     frame.dispose();
	    	     
	    	    
	    	     WorkSet frame1 = (WorkSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	           
	         	 Log.traceLog("����Ա��",user," �޸��˲ֿ⣺"+
	         	      frame.getT1().getText()+" ����Ϣ");
	            
				 
	        	 
	    }else{
	    	JOptionPane.showMessageDialog(null,"�����޸�ʧ�ܣ���鿴�����Ƿ���ȷ!");
	    	 
	    }
	    
	}
		
}


