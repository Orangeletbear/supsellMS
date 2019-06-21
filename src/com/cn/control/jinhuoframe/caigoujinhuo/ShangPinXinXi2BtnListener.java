package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

public class ShangPinXinXi2BtnListener implements ActionListener{

	AddShangPingDialog addShang;//������
	ShangPinXinXi2 shang;//��ǰ����
	
	public ShangPinXinXi2BtnListener(ShangPinXinXi2 dialog){
		this.shang = dialog;
		this.addShang = dialog.getDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shang.getQueren()){
			int i = addShang.getSplbtable1().getSelectedRow();//��һ������
			
			if(i != -1){
				String xiugaijinjia = shang.getCankaojinjia().getText();//�޸ĺ�Ľ���
				String xiugaishuliang = shang.getShuliang().getText();//�޸ĺ������
			
				if(!(xiugaijinjia.matches("\\d*[.]?\\d*"))){
					JOptionPane.showMessageDialog(shang,"����Ϊ�Ƿ����֣�");
				}else{
					if(!(xiugaijinjia.matches("\\d*[.]?\\d*"))){
						JOptionPane.showMessageDialog(shang,"����Ϊ�Ƿ����֣�");
					}else{
						float zongjine = Float.parseFloat(xiugaijinjia)*
						Float.parseFloat(xiugaishuliang);
					
						addShang.getData().get(i).set(3,xiugaijinjia);//�滻������
						addShang.getData().get(i).set(4,xiugaishuliang);//�滻������
						addShang.getData().get(i).set(5,zongjine);//�滻���ܽ��
						/*
						 * ����ֻ�ĵ���ǰ������ݣ����øĵ��������洫��ȥ��Vector������
						 */
						Vector argVector = (Vector)addShang.getYiPi_data().get(i);
						argVector.set(5, xiugaijinjia);
						argVector.set(6, xiugaishuliang);
						argVector.set(7, zongjine);
					
						
						//ˢ�±�
						addShang.getATM1().setDataVector(
							addShang.getData(),ColumnNames.splbtable1_colunm);
						//�رյ�ǰ����
						shang.dispose();
					}
				}
				
			}
		}
		
	}

}
