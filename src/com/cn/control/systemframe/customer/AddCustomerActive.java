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
			 obj[0] = frame.getT1().getText();//客户名称
			 obj[1] = frame.getT2().getText();//联系人
			 obj[2] = frame.getT3().getText();//联系电话
			 obj[3] = frame.getT4().getText();//联系地址
			 obj[4] = frame.getT5().getText();//备注
			 obj[5] = frame.getFe().getText();//初期应收
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getC1().isSelected()){//默认客户
				 obj[6]="是";
			 }
			    else{obj[6]="";}
			 
			 if(frame.getC2().isSelected()){//禁用
				 obj[7]="是";
			 }
			    else{obj[7]="";}
			 
			 
			 // System.out.println(obj[6]);
			if(CustomerDB.addCustomer(obj)){
				
				Vector data = CustomerDB.getData();
				
				 ((CustomerSet) frame.getOwner()).getCustomerModel().setDataVector(data,
						AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
				
				 JOptionPane.showMessageDialog(null,"客户增加成功");
	        	 frame.dispose();
	        	 
	        	 
	        	 CustomerSet frame1= (CustomerSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	              
	         	 Log.traceLog("操作员：",user," 增加了客户："+
	         	      frame.getT1().getText()+" 的信息");
	           
				 
	        	 
				
			  }
			else{
				JOptionPane.showMessageDialog(null, "数据添加失败，请查看输入是否正确！");
				 }
		}else{JOptionPane.showMessageDialog(null,"请填写客户名称！！");}

	}}


