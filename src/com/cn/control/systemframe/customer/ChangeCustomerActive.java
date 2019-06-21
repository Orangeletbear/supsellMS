package com.cn.control.systemframe.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.cn.dao.system.CustomerDB;
import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.Customer.ChangeCustomer;

public class ChangeCustomerActive implements ActionListener {
	
	ChangeCustomer frame;
	
	public ChangeCustomerActive(ChangeCustomer frame){
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		    Vector data = new Vector();
		    
		    if(frame.getT1()!=null){
		    data.add(frame.getT1().getText().toString());}//1�ͻ�����
		    else{data.add("");}
		    
		    if(frame.getT2()!=null){
	        data.add(frame.getT2().getText().toString());}//2��ϵ��
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
		    
		    if(frame.getJf()!=null){
	        data.add(frame.getJf().getText().toString());}//4����Ӧ��
		    else{data.add("");}
		    
		    
	    if(frame.c1.isSelected()){//6Ĭ�Ͽͻ�
	    	data.add("��");
	    }else{
	    	data.add("");
	    }
	    if(frame.c2.isSelected()){//7����
	    	data.add("��");
	    }else{
	    	data.add("��");
	    }
	    
	    if(CustomerDB.changeCustomer(data)){
	    	
	    	Vector data2 = CustomerDB.getData();
	    	CustomerSet.getCustomerModel().setDataVector(data2,
	    			AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
	    	     JOptionPane.showMessageDialog(null,"�޸ĳɹ�!");
	    	     frame.dispose();
	    	     
	    	   
	    	    
	    	     CustomerSet frame1 =  (CustomerSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	            
	         	 Log.traceLog("����Ա��",user," �޸��˲ֿ⣺"+
	         	      frame.getT1().getText()+" ����Ϣ");
	            
				 
	        	 
	    }else{
	    	JOptionPane.showMessageDialog(null,"�����޸�ʧ�ܣ���鿴�����Ƿ���ȷ!");
	    	 
	    }
	    
	}

 
}
