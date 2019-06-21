package com.cn.control.jinhuoframe.caigoujinhuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.AddShangPingDialog;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ShangPinXinXi;
/**
 * ������dialog����Ʒ��Ϣ���ɹ���������   ȷ��button  ���������¼�
 * @author Administrator
 *
 */
public class ShangPingXinXiBtnListener implements ActionListener{

	//������
	private AddShangPingDialog dialog;
	//��ǰ����
	private ShangPinXinXi shangDialog;
	
	
	public ShangPingXinXiBtnListener(ShangPinXinXi shangDialog,AddShangPingDialog dialog){
		this.dialog = dialog;
		this.shangDialog = shangDialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == shangDialog.getQueren()){//���ȷ��button
			
			Vector<Object> tmp = new Vector<Object>();//��������д�����
			//���  ��Ʒ���
			tmp.add(shangDialog.getShangpinbianhao().getText());
			//���  ��Ʒ����
			tmp.add(shangDialog.getShangpinmingcheng().getText());
			//���  ��λ
			tmp.add(shangDialog.getJibendanwei().getText());
			
			//���  ����
			String jinjiaString =shangDialog.getCankaojinjia().getText();
			float jinjia = 0;//���������
			if(jinjiaString.matches("\\d+[.]?\\d*")){//�ж� �����Ƿ�������
				jinjia = Float.parseFloat(jinjiaString);
				tmp.add(jinjia);
			}else{//�������֣�������Ϊ0
				tmp.add(0.00);
			}
			//���   ����
			String shuliangString = shangDialog.getShuliang().getText();
			float shuliang = 0;
			if(shuliangString.matches("\\d+")){//�ж�  ���� �Ƿ��ǺϷ�����
				shuliang = Float.parseFloat(shangDialog.getShuliang().getText());
				if(shuliang == 0){
					JOptionPane.showMessageDialog(shangDialog,"��������Ϊ0��");
				}else{
					tmp.add(shuliang);
				}
			}else{
				JOptionPane.showMessageDialog(shangDialog,"��������Ϊ�ջ����������");
			}
			//���  �ܽ��
			float zongJinE = jinjia * shuliang;
			tmp.add(zongJinE);
		    //�������
			if(shuliangString.matches("\\d*[1-9]\\d*")){//֮�����ظ�д��������ȥ���Ǹ��˾��������ɶ���ǿЩ
				dialog.getData().add(tmp);
				dialog.getATM1().setDataVector(dialog.getData(), ColumnNames.splbtable1_colunm);
				shangDialog.dispose();//��������ݺ�Ӧ��dispose��ǰdialog
			}
			
			
			/*
			 * �ɹ���������������ݶ��ܴ������ȡ��Ϊʡ��ֱ��д��
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
			
			if(shuliangString.matches("\\d*[1-9]\\d*")){//֮���Բ�Ҫ�ж��趨�ĵ��ۣ�����Ϊ���۸�ʽ�����򵥼���Ϊ0
				dialog.getYiPi_data().add(argVector);//
			}
		}
		
	}
	

}
