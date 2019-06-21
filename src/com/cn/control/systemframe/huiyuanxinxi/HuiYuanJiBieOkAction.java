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
 * 会员级别增加修改监听器
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
			JOptionPane.showMessageDialog(frame,"折扣数据不正确请重输");
			return;
		}
		data.add(frame.getJiFenUp().getText());
		data.add(frame.getJiFenDown().getText());
		
		//取出界面用户，写入日志文件
		HuiYuanJiBieSet jbSet =  (HuiYuanJiBieSet)(frame.getOwner());
        HuiYanGuangLiFrame hyframe = (HuiYanGuangLiFrame)jbSet.getOwner();
      	MainFrame mframe = (MainFrame)hyframe.getOwner();
      	String user = mframe.getUser();
      	//是修改还是增加
		if(!frame.isAddOrAlter()){
			
			boolean isAdd = HuiYuanXinGLJDBC.addAJiBieXinXi(data);
			
			if(isAdd == true){
		       	 JOptionPane.showMessageDialog(frame,"成功增加级别");
		       	 ((HuiYuanJiBieSet)(frame.getOwner())).initData();
		       	 //写日志
		     	 Log.traceLog("  操作员  ",user," 增加了会员级别 :  "+data.get(1).toString());
		       	 frame.dispose();
		       	 
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"注:增加级别失败,请查看数据是否正确");
		        }  
		}else{
			boolean isChange = HuiYuanXinGLJDBC.atlerAJiBieXinXi(data);
			
			if(isChange == true){
		       	 JOptionPane.showMessageDialog(frame,"修改成功");
		       	 ((HuiYuanJiBieSet)(frame.getOwner())).initData();
		       	 //写日志
		          Log.traceLog("  操作员  ",user," 修改了会员级别 :  "+data.get(1).toString()+"  的信息");
		       	 
		          
		          frame.dispose();
		        }else{
		       	 JOptionPane.showMessageDialog(frame,"注: 修改失败,数据是否正确");
		       	 //frame.dispose();
		        }  
		}
		
	}

}
