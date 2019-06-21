package com.cn.control.systemframe.suplly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.StorageDB;
import com.cn.dao.system.SupllyDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.SuplyCulomns;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.GongHuoShang;
import com.cn.view.systemJFrame.GongHuo.AddSuply;

public class AddSupllyAction implements ActionListener{
	   
	    
		private AddSuply frame;  
	    
	    
	    public String[]obj = new String[9];
	    
	    
		public AddSupllyAction(AddSuply frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			
			if(frame.getText1()!=null && !frame.getText1().getText().equals("")){
			 obj[0] = frame.getText1().getText();//供货商名称
			 obj[1] = frame.getText2().getText();//联系人
			 obj[2] = frame.getText3().getText();//联系电话
			 obj[3] = frame.getText4().getText();//联系地址
			 obj[4] = frame.getText5().getText();//备注
			 obj[5] = frame.getJfe().getText();//初期应收
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getCb1().isSelected()){//默认客户
				 obj[6]="是";
			 }
			    else{obj[6]="否";}
			 
			 if(frame.getCb2().isSelected()){//禁用
				 obj[7]="是";
			 }
			    else{obj[7]="否";}
			 
			 
			 // System.out.println(obj[6]);
			if(SupllyDB.addSuplly(obj)){
				Vector data = SupllyDB.getData();
				 GongHuoShang.getSupplyModel().setDataVector(data,
						AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
				 JOptionPane.showMessageDialog(null,"供货商增加成功");
	        	 frame.dispose();
	        	 
	        	 GongHuoShang frame1=(GongHuoShang)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	              
	         	 Log.traceLog("操作员：",user," 增加了供货商："+
	         	      frame.getText1().getText()+" 的信息");
	          
	        	 
			  }
			else{
				JOptionPane.showMessageDialog(null, "数据增加失败，请查看输入是否正确！");}
			
			
			}else{JOptionPane.showMessageDialog(null,"请填写供货商名");}
		}

	}


