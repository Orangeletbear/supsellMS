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
			 obj[0] = frame.getText1().getText();//����������
			 obj[1] = frame.getText2().getText();//��ϵ��
			 obj[2] = frame.getText3().getText();//��ϵ�绰
			 obj[3] = frame.getText4().getText();//��ϵ��ַ
			 obj[4] = frame.getText5().getText();//��ע
			 obj[5] = frame.getJfe().getText();//����Ӧ��
			// obj[6] = frame.getT1().getText();
			 
			 if(frame.getCb1().isSelected()){//Ĭ�Ͽͻ�
				 obj[6]="��";
			 }
			    else{obj[6]="��";}
			 
			 if(frame.getCb2().isSelected()){//����
				 obj[7]="��";
			 }
			    else{obj[7]="��";}
			 
			 
			 // System.out.println(obj[6]);
			if(SupllyDB.addSuplly(obj)){
				Vector data = SupllyDB.getData();
				 GongHuoShang.getSupplyModel().setDataVector(data,
						AllTableModel.getVectorFromObj(SuplyCulomns.suplyNames));
				 JOptionPane.showMessageDialog(null,"���������ӳɹ�");
	        	 frame.dispose();
	        	 
	        	 GongHuoShang frame1=(GongHuoShang)frame.getOwner();
	             MainFrame mUser = (MainFrame)(frame1.getOwner());
	             String user=mUser.getUser();
	             
	              
	         	 Log.traceLog("����Ա��",user," �����˹����̣�"+
	         	      frame.getText1().getText()+" ����Ϣ");
	          
	        	 
			  }
			else{
				JOptionPane.showMessageDialog(null, "��������ʧ�ܣ���鿴�����Ƿ���ȷ��");}
			
			
			}else{JOptionPane.showMessageDialog(null,"����д��������");}
		}

	}


