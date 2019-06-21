package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;
/**
 * 弹出的dialog：商品信息（采购进货）中   确认button  所触发的事件
 * @author Administrator
 *
 */
public class ShangPingXinXiBtnListener implements ActionListener{

	//父窗口
	private AddShangPingDialog dialog;
	//当前窗口
	private ShangPinXinXi shangDialog;
	
	
	public ShangPingXinXiBtnListener(ShangPinXinXi shangDialog,AddShangPingDialog dialog){
		this.dialog = dialog;
		this.shangDialog = shangDialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shangDialog.getQueren()){//点击确定button
			
			Vector<Object> tmp = new Vector<Object>();//用于向表中传数据
			//添加  商品编号
			tmp.add(shangDialog.getShangpinbianhao().getText());
			//添加  商品名称
			tmp.add(shangDialog.getShangpinmingcheng().getText());
			//添加  单位
			tmp.add(shangDialog.getJibendanwei().getText());
			
			//添加  进价
			String jinjiaString =shangDialog.getCankaojinjia().getText();
			float jinjia = 0;//用来存进价
			if(jinjiaString.matches("\\d+[.]?\\d*")){//判断 进价是否是数字
				jinjia = Float.parseFloat(jinjiaString);
				tmp.add(jinjia);
			}else{//不是数字，进价设为0
				tmp.add(0.00);
			}
			//添加   数量
			String shuliangString = shangDialog.getShuliang().getText();
			float shuliang = 0;
			if(shuliangString.matches("\\d+")){//判断  数量 是否是合法数字
				shuliang = Float.parseFloat(shangDialog.getShuliang().getText());
				if(shuliang == 0){
					JOptionPane.showMessageDialog(shangDialog,"数量不能为0！");
				}else{
					tmp.add(shuliang);
				}
			}else{
				JOptionPane.showMessageDialog(shangDialog,"数量不能为空或非正整数！");
			}
			//添加  总金额
			float zongJinE = jinjia * shuliang;
			tmp.add(zongJinE);
		    //数据入表
			if(shuliangString.matches("\\d*[1-9]\\d*")){//之所以重复写，不放上去，是个人觉得这样可读性强些
				dialog.getData().add(tmp);
				dialog.getATM1().setDataVector(dialog.getData(), ColumnNames.splbtable1_colunm);
				shangDialog.dispose();//添加完数据后，应该dispose当前dialog
			}
			
			
			/*
			 * 采购进货界面表中数据都能从这里读取，为省事直接写这
			 */
			Vector<Object> argVector = new Vector<Object>();
			argVector.add(shangDialog.getShangpinbianhao().getText());
			argVector.add(shangDialog.getShangpinmingcheng().getText());
			argVector.add(shangDialog.getJibendanwei().getText());
			argVector.add(shangDialog.getGuigexinghao().getText());
			argVector.add(shangDialog.getYanse().getText());
			argVector.add(shangDialog.getCankaojinjia().getText());
			argVector.add(shangDialog.getShuliang().getText());
			argVector.add(zongJinE);
			
			if(shuliangString.matches("\\d*[1-9]\\d*")){//之所以不要判断设定的单价，是因为单价格式不对则单价设为0
				dialog.getYiPi_data().add(argVector);//
			}
		}
		
	}
	

}
