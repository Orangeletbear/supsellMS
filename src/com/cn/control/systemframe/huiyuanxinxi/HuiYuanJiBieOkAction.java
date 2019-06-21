package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
import com.cn.view.systemJFrame.huiyuanguanli.AddHuiYuanJiBie;
import com.cn.view.systemJFrame.huiyuanguanli.HuiYuanJiBieSet;

/**
 * ��Ա���������޸ļ�����
 * @author Administrator
 *
 */
public class HuiYuanJiBieOkAction implements ActionListener {
   
	private AddHuiYuanJiBie frame;
	public HuiYuanJiBieOkAction(AddHuiYuanJiBie frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {

		Vector<String> data = new Vector<String>();
		//0-4
		data.add(frame.getJbID().getText());
		data.add(frame.getJbName().getText());
		data.add(frame.getJbZheKou().getText());
		float zheKou = new Float(data.get(2).toString()).floatValue();
		if(zheKou >1 || zheKou < 0 ){
			JOptionPane.showMessageDialog(frame,"�ۿ����ݲ���ȷ������");
			return;
		}
		data.add(frame.getJiFenUp().getText());
		data.add(frame.getJiFenDown().getText());
		
		//ȡ�������û���д����־�ļ�
		HuiYuanJiBieSet jbSet =  (HuiYuanJiBieSet)(frame.getOwner());
        HuiYanGuangLiFrame hyframe = (HuiYanGuangLiFrame)jbSet.getOwner();
      	MainFrame mframe = (MainFrame)hyframe.getOwner();
      	String user = mframe.getUser();
      	//���޸Ļ�������
		if(!frame.isAddOrAlter()){
			
			boolean isAdd = HuiYuanXinGLJDBC.addAJiBieXinXi(data);
			
			if(isAdd == true){
		       	 JOptionPane.showMessageDialog(frame,"�ɹ����Ӽ���");
		       	 ((HuiYuanJiBieSet)(frame.getOwner())).initData();
		       	 //д��־
		     	 Log.traceLog("  ����Ա  ",user," �����˻�Ա���� :  "+data.get(1).toString());
		       	 frame.dispose();
		       	 
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"ע:���Ӽ���ʧ��,��鿴�����Ƿ���ȷ");
		        }  
		}else{
			boolean isChange = HuiYuanXinGLJDBC.atlerAJiBieXinXi(data);
			
			if(isChange == true){
		       	 JOptionPane.showMessageDialog(frame,"�޸ĳɹ�");
		       	 ((HuiYuanJiBieSet)(frame.getOwner())).initData();
		       	 //д��־
		          Log.traceLog("  ����Ա  ",user," �޸��˻�Ա���� :  "+data.get(1).toString()+"  ����Ϣ");
		       	 
		          
		          frame.dispose();
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"ע: �޸�ʧ��,�����Ƿ���ȷ");
		       	 //frame.dispose();
		        }  
		}
		
	}

}
