package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import com.cn.dao.jinhuo.jinhuoguanli.JDBCShangPinXinXi;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi2;

public class AddWindowListenerRIGHT implements WindowListener{
	
	AddShangPingDialog addShang;
	ShangPinXinXi2 shang;
	
	public AddWindowListenerRIGHT(ShangPinXinXi2 shang){
		this.shang = shang;
		this.addShang = shang.getDialog();
	}

	public void windowActivated(WindowEvent e) {
		
	}

	public void windowClosed(WindowEvent e) {
		
	}

	public void windowClosing(WindowEvent e) {
		
	}

	public void windowDeactivated(WindowEvent e) {
		
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		int tmp = addShang.getSplbtable1().getSelectedRow();//ѡ������һ��
		if(tmp != -1){
			Object spid = addShang.getData().get(tmp).get(0);//�������ݵĵ�һ������  ��Ʒ���
		
			//��ʼ������
			Vector v = JDBCShangPinXinXi.getData((String)spid);
		
			//����toString����null���ð죬������ɽկ��
			shang.getShangpinbianhao().setText(""+v.remove(0));
		
			shang.getShangpinmingcheng().setText(""+v.remove(0));
			shang.getShangpinmingcheng().setForeground(Color.RED);//��Ʒ������Ϊ��ɫ����
		
			shang.getGuigexinghao().setText(""+v.remove(0));
			//argDanwei������һ������ͬʱ����  ������λ  ��  ѡ��λ
			String argDanwei = ""+v.remove(0);
			shang.getJibendanwei().setText(argDanwei);
			////////////����comboBox�Ĺ����൥λ��ʱûд����������������
			shang.getXuanzedanwei().addItem(argDanwei);
			shang.getShengchanchangshang().setText(""+v.remove(0));
			shang.getYanse().setText(""+v.remove(0));
		
			shang.getDangqiankucun().setText(""+v.remove(0));
			shang.getDangqiankucun().setForeground(Color.RED);//��ǰ�����Ϊ��ɫ����
		
			shang.getBeizhu().setText(""+v.remove(0));
			shang.getCankaojinjia().setText(""+addShang.getData().get(tmp).get(3));//tmp�е������ǽ���
			shang.getShuliang().setText(""+addShang.getData().get(tmp).get(4));//tmp�е������ǽ���
		}
	}

}
