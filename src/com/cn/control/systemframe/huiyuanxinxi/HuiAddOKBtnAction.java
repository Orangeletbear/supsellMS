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
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.huiyuanguanli.AddHuiYuan;

public class HuiAddOKBtnAction implements ActionListener {

	private AddHuiYuan frame;
	public HuiAddOKBtnAction(AddHuiYuan frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {

		Vector<String> data = new Vector<String>();
		//0-4
		data.add(frame.getHyID().getText());
		data.add(frame.getHyJiBie().getSelectedItem().toString());
		data.add(frame.getHyName().getText());
		data.add(new String(frame.getHySecret().getPassword()));
		try {
			data.add(DateConventer.dateToStr(
					frame.getHyBirthday().getSelectedDate(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//5-9
		
		data.add(new String(frame.getHyCirSecret().getPassword()));
		if( data.get(3).length()>6 || !data.get(3).equals(data.get(5))){
			JOptionPane.showMessageDialog(frame,"����ȷ����������������(�Ϊ��λ��)");
			frame.getHySecret().setText("");
			frame.getHyCirSecret().setText("");
			return ;
			
		}
		
		data.add(frame.getHyJiFen().getText());
		data.add(frame.getHyTell().getText());
		try {
			data.add(DateConventer.dateToStr(
					frame.getHyJiaLuDate().getSelectedDate(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			data.add(DateConventer.dateToStr(
					frame.getHyJieDate().getSelectedDate(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//10-13
		if(frame.getHyYouJiZhiDate().isSelected()){
			data.add("1");
		}else{
			data.add("0");
		}
		
	    data.add(frame.getHyStart().getSelectedItem().toString());

		data.add(frame.getHyShenJi().getSelectedItem().toString());
		data.add(frame.getHyBeiZhu().getText());
		
		HuiYanGuangLiFrame hydialog = (HuiYanGuangLiFrame)frame.getOwner();
		
       	MainFrame mframe = (MainFrame)hydialog.getOwner();
       	
       	String user = mframe.getUser();
       	
		//���޸Ļ�������
		if(!frame.isAddOrAtler()){
			boolean isAdd = HuiYuanXinGLJDBC.addAHuiYuanData(data);
			if(isAdd == true){
		       	 JOptionPane.showMessageDialog(frame,"��Ա�ɹ�����");
		       	 ((HuiYanGuangLiFrame)(frame.getOwner())).initData();
		       	 
		       	
		       	 Log.traceLog("  ����Ա  ",user,"����һ��IDΪ "+data.get(2).toString()+" ��Ա��Ϣ");
		       	 frame.dispose();
		       	 
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"ע: ��Ա����ʧ��,�����Ƿ���ȷ");
		       	 //frame.dispose();
		        }  
		}else{
			boolean isChange = HuiYuanXinGLJDBC.atlerHuiYuanMassege(data);
			
			if(isChange == true){
		       	 JOptionPane.showMessageDialog(frame,"��Ա�޸ĳɹ�");
		       	 ((HuiYanGuangLiFrame)(frame.getOwner())).initData();
		       	 
		       	 Log.traceLog("  ����Ա  ",user,"�޸��˻�ԱIDΪ :"+data.get(0).toString()+" ����Ϣ");
		       	 frame.dispose();
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"ע: ��Ա�޸�ʧ��,�����Ƿ���ȷ");
		       	 //frame.dispose();
		        }  
		}
		
   }
}
