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
			 obj[0] = frame.getT1().getText().toString();//Ա������
			 obj[1] = frame.getT2().getText().toString();//����ְ��
			 obj[2] = frame.getT3().getText().toString();//��ϵ�绰
			 obj[3] = frame.getT4().getText().toString();//��ϵ��ַ
			 obj[4] = frame.getT5().getText().toString();//��ע
			//obj[5] = frame.getFe().getText();//����Ӧ��
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getC1().isSelected()){// 
				 obj[5]="��";
			 }
			    else{obj[5]="��";}
			 
			 if(frame.getC2().isSelected()){// 
				 obj[6]="��";
			 }
			    else{obj[6]="��";}
			 if(frame.getC3().isSelected()){// 
				 obj[7]="��";
			 }
			    else{obj[7]="��";}
			 
			 // System.out.println(obj[6]);
	if(WorkerDB.addWorker(obj)){
				
		Vector data = WorkerDB.getData();
		 WorkSet.getWorkerModel().setDataVector(data,
				AllTableModel.getVectorFromObj(WorkerCulomns.workerNames));
			JOptionPane.showMessageDialog(null,"Ա�����ӳɹ�");
	        	 frame.dispose();
	        	
	        	 
	        	 WorkSet frame1 = (WorkSet)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	             
	         	 Log.traceLog("����Ա��",user," ������Ա����"+
	         	      frame.getT1().getText()+" ����Ϣ");
	          
				 
	        	 
			  }
			else{
				JOptionPane.showMessageDialog(null,"Ա������ʧ�ܣ���鿴�����Ƿ���ȷ��");
				 }
			
			
			}else{JOptionPane.showMessageDialog(null,"����дԱ����������");}	
		}

	}


