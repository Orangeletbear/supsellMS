package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

public class ShangPinXinXi2BtnListener implements ActionListener{

	AddShangPingDialog addShang;//父窗口
	ShangPinXinXi2 shang;//当前窗口
	
	public ShangPinXinXi2BtnListener(ShangPinXinXi2 dialog){
		this.shang = dialog;
		this.addShang = dialog.getDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shang.getQueren()){
			int i = addShang.getSplbtable1().getSelectedRow();//哪一行数据
			
			if(i != -1){
				String xiugaijinjia = shang.getCankaojinjia().getText();//修改后的进价
				String xiugaishuliang = shang.getShuliang().getText();//修改后的数量
			
				if(!(xiugaijinjia.matches("\\d*[.]?\\d*"))){
					JOptionPane.showMessageDialog(shang,"进价为非法数字！");
				}else{
					if(!(xiugaijinjia.matches("\\d*[.]?\\d*"))){
						JOptionPane.showMessageDialog(shang,"数量为非法数字！");
					}else{
						float zongjine = Float.parseFloat(xiugaijinjia)*
						Float.parseFloat(xiugaishuliang);
					
						addShang.getData().get(i).set(3,xiugaijinjia);//替换掉进价
						addShang.getData().get(i).set(4,xiugaishuliang);//替换掉数量
						addShang.getData().get(i).set(5,zongjine);//替换掉总金额
						/*
						 * 上面只改掉当前表格数据，还得改掉向主界面传过去的Vector中数据
						 */
						Vector argVector = (Vector)addShang.getYiPi_data().get(i);
						argVector.set(5, xiugaijinjia);
						argVector.set(6, xiugaishuliang);
						argVector.set(7, zongjine);
					
						
						//刷新表
						addShang.getATM1().setDataVector(
							addShang.getData(),ColumnNames.splbtable1_colunm);
						//关闭当前窗体
						shang.dispose();
					}
				}
				
			}
		}
		
	}

}
