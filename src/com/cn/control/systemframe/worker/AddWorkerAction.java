package com.cn.control.systemframe.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.CustomerDB;
import com.cn.dao.system.StorageDB;
import com.cn.dao.system.WorkerDB;
import com.cn.model.AllTableModel;
import com.cn.model.system.WorkerCulomns;
 

import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.WorkSet;
import com.cn.view.systemJFrame.Worker.AddWorker;

public class AddWorkerAction implements ActionListener{
	   
	    
		private AddWorker frame;  
	    
	    
	    public String[]obj = new String[9];
	    
	    
		public AddWorkerAction(AddWorker frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			if(frame.getT1().getText()!=null && !frame.getT1().getText().trim().equals("")){
			 obj[0] = frame.getT1().getText().toString();//员工姓名
			 obj[1] = frame.getT2().getText().toString();//所任职务
			 obj[2] = frame.getT3().getText().toString();//联系电话
			 obj[3] = frame.getT4().getText().toString();//联系地址
			 obj[4] = frame.getT5().getText().toString();//备注
			//obj[5] = frame.getFe().getText();//初期应收
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getC1().isSelected()){// 
				 obj[5]="是";
			 }
			    else{obj[5]="否";}
			 
			 if(frame.getC2().isSelected()){// 
				 obj[6]="是";
			 }
			    else{obj[6]="否";}
			 if(frame.getC3().isSelected()){// 
				 obj[7]="是";
			 }
			    else{obj[7]="否";}
			 
			 // System.out.println(obj[6]);
	if(WorkerDB.addWorker(obj)){
				
		Vector data = WorkerDB.getData();
		 WorkSet.getWorkerModel().setDataVector(data,
				AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
			JOptionPane.showMessageDialog(null,"员工增加成功");
	        	 frame.dispose();
	        	
	        	 
	        	 WorkSet frame1 = (WorkSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	             
	         	 Log.traceLog("操作员：",user," 增加了员工："+
	         	      frame.getT1().getText()+" 的信息");
	          
				 
	        	 
			  }
			else{
				JOptionPane.showMessageDialog(null,"员工增加失败，请查看输入是否正确！");
				 }
			
			
			}else{JOptionPane.showMessageDialog(null,"请填写员工姓名！！");}	
		}

	}


