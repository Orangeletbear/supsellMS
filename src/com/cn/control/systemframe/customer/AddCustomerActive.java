package com.cn.control.systemframe.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
 
import com.cn.dao.system.CustomerDB;
import com.cn.dao.system.StorageDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.CustomerCulomns;
import com.cn.model.system.StorageCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.CangKuSheZhi;
import com.cn.view.systemJFrame.CustomerSet;
import com.cn.view.systemJFrame.CangKuXheZhi.AddStorage;
import com.cn.view.systemJFrame.Customer.AddCustomer;

public class AddCustomerActive implements ActionListener{
	   
	    
		private AddCustomer frame;  
	    
	    
	    public String[]obj = new String[9];
	    
	    
		public AddCustomerActive(AddCustomer frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if(frame.getT1().getText()!=null && !frame.getT1().getText().trim().equals("")){
			 obj[0] = frame.getT1().getText();//�ͻ�����
			 obj[1] = frame.getT2().getText();//��ϵ��
			 obj[2] = frame.getT3().getText();//��ϵ�绰
			 obj[3] = frame.getT4().getText();//��ϵ��ַ
			 obj[4] = frame.getT5().getText();//��ע
			 obj[5] = frame.getFe().getText();//����Ӧ��
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getC1().isSelected()){//Ĭ�Ͽͻ�
				 obj[6]="��";
			 }
			    else{obj[6]="";}
			 
			 if(frame.getC2().isSelected()){//����
				 obj[7]="��";
			 }
			    else{obj[7]="";}
			 
			 
			 // System.out.println(obj[6]);
			if(CustomerDB.addCustomer(obj)){
				
				Vector data = CustomerDB.getData();
				
				 ((CustomerSet) frame.getOwner()).getCustomerModel().setDataVector(data,
						AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
				
				 JOptionPane.showMessageDialog(null,"�ͻ����ӳɹ�");
	        	 frame.dispose();
	        	 
	        	 
	        	 CustomerSet frame1= (CustomerSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	              
	         	 Log.traceLog("����Ա��",user," �����˿ͻ���"+
	         	      frame.getT1().getText()+" ����Ϣ");
	           
				 
	        	 
				
			  }
			else{
				JOptionPane.showMessageDialog(null, "�������ʧ�ܣ���鿴�����Ƿ���ȷ��");
				 }
		}else{JOptionPane.showMessageDialog(null,"����д�ͻ����ƣ���");}

	}}


