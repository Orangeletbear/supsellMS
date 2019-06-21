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
		    data.add(frame.getT1().getText().toString());}//1客户名称
		    else{data.add("");}
		    
		    if(frame.getT2()!=null){
	        data.add(frame.getT2().getText().toString());}//2联系人
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
		    
		    if(frame.getJf()!=null){
	        data.add(frame.getJf().getText().toString());}//4初期应收
		    else{data.add("");}
		    
		    
	    if(frame.c1.isSelected()){//6默认客户
	    	data.add("是");
	    }else{
	    	data.add("");
	    }
	    if(frame.c2.isSelected()){//7禁用
	    	data.add("是");
	    }else{
	    	data.add("否");
	    }
	    
	    if(CustomerDB.changeCustomer(data)){
	    	
	    	Vector data2 = CustomerDB.getData();
	    	CustomerSet.getCustomerModel().setDataVector(data2,
	    			AllTableModel.getVectorFromObj(CustomerCulomns.customerNames));
	    	     JOptionPane.showMessageDialog(null,"修改成功!");
	    	     frame.dispose();
	    	     
	    	   
	    	    
	    	     CustomerSet frame1 =  (CustomerSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	            
	         	 Log.traceLog("操作员：",user," 修改了仓库："+
	         	      frame.getT1().getText()+" 的信息");
	            
				 
	        	 
	    }else{
	    	JOptionPane.showMessageDialog(null,"数据修改失败，请查看输入是否正确!");
	    	 
	    }
	    
	}

 
}
