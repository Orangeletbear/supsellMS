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
			JOptionPane.showMessageDialog(frame,"密码确认有误请重新输入(最长为六位数)");
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
       	
		//是修改还是增加
		if(!frame.isAddOrAtler()){
			boolean isAdd = HuiYuanXinGLJDBC.addAHuiYuanData(data);
			if(isAdd == true){
		       	 JOptionPane.showMessageDialog(frame,"会员成功加入");
		       	 ((HuiYanGuangLiFrame)(frame.getOwner())).initData();
		       	 
		       	
		       	 Log.traceLog("  操作员  ",user,"加入一条ID为 "+data.get(2).toString()+" 会员信息");
		       	 frame.dispose();
		       	 
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"注: 会员增加失败,数据是否正确");
		       	 //frame.dispose();
		        }  
		}else{
			boolean isChange = HuiYuanXinGLJDBC.atlerHuiYuanMassege(data);
			
			if(isChange == true){
		       	 JOptionPane.showMessageDialog(frame,"会员修改成功");
		       	 ((HuiYanGuangLiFrame)(frame.getOwner())).initData();
		       	 
		       	 Log.traceLog("  操作员  ",user,"修改了会员ID为 :"+data.get(0).toString()+" 的信息");
		       	 frame.dispose();
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"注: 会员修改失败,数据是否正确");
		       	 //frame.dispose();
		        }  
		}
		
   }
}
