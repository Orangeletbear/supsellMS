package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCAddTuiHuoInfo;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
/**
 * �˿��˻��Ի�����
 * �Ĺ˿��˻�ѡ��ϵ�ȷ����ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class GuKeTuiHuoSureAction implements ActionListener {

	
	private GuKeTuiHuoDialog dialog ;
	
	public GuKeTuiHuoSureAction(GuKeTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(dialog.getTableModel().getRowCount() == 0){
			JOptionPane.showMessageDialog(dialog,"������û��ҵ�������ܱ���");
		}else{
			String message = "���ݱ���������޸�,�Ƿ�ȷ�ϱ��棡";
			int n = JOptionPane.showOptionDialog(dialog, message, "ϵͳ��Ϣ", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if(n == JOptionPane.YES_OPTION){
				/**
				 * ��ȡ������ͻ��˻����ܱ��е�����
				 */
				 Object[] zongBiaoData = new Object[9];
			      //���ݺ�
				 zongBiaoData[0] = dialog.getDanHaoLabel().getText();
				//��ȡ�ͻ�����
				String khName = dialog.getKeHuText1().getText();
				//��ȡ�ͻ�Id
				 zongBiaoData[1] = JDBCGetInfo.getKeHuId(khName);
				//��ȡ�ջ��ֿ�
				String cangKu = dialog.getCangKuBox().getSelectedItem().toString();
				//��ȡ�ֿ�Id
				zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
				//��ȡ��������
				try {
					zongBiaoData[2] = DateConventer.dateToStr(dialog.getDataPicker().getSelectedDate());
					//zongBiaoData[2] = dialog.getDataPicker().getSelectedDate();
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
		       //��ȡӦ�˽��
				zongBiaoData[4] = dialog.getYingTuiText().getText();
			  //��ȡʵ�˽��
				zongBiaoData[5] = dialog.getShiTuiText().getText();
			  //��ȡ������
				zongBiaoData[6] = dialog.getJingBanBox().getSelectedItem().toString();
				//����Ա
				String user = dialog.getMainFrame().getUser();
				zongBiaoData[7] = user;
			  //��ȡ��ע��Ϣ
				zongBiaoData[8] = dialog.getBeiZhuText().getText();
				
			 //	�����ݿ��в�������
				JDBCAddTuiHuoInfo.set_th_zb_Data(zongBiaoData);
				
			  /**
			   * ��ȡ������ͻ��˻�������е�����
			   * 
			   */	
				//��������ݿ��еĹ˿��˻����������Ϣ
				int row = dialog.getTableModel().getRowCount();
				int column = dialog.getTableModel().getColumnCount();
			
				for(int i = 0;i< row; i++){
					Object[] data = new Object[column];
					data[0] =dialog.getTableModel().getValueAt(i, 0);
					data[1] =  zongBiaoData[0];
					data[2] = dialog.getTableModel().getValueAt(i, 4).toString();
					data[3] = dialog.getTableModel().getValueAt(i, 5).toString();
					
					//�����ݿ��в�������
					JDBCAddTuiHuoInfo.set_th_xb_Data(data);
			
				}
				
				//��ձ��е�����
				dialog.getTableModel().setDataVector(TuiHuoTabelCulomnModel.obj,
			       TuiHuoTabelCulomnModel.BackColumNames);
				//
				dialog.getShiTuiText().setText("0.0");
				dialog.getYingTuiText().setText("0.0");

				//��ʾ��Ϣ
				 JOptionPane.showMessageDialog(dialog, "���ݱ���ɹ�");
				
				 //	д��־��Ϣ
				 Log.traceLog( "  ����Ա  ",user,"�� "+khName+" ����һ���˻����ݣ�"+zongBiaoData[0]);
	
				dialog.getDeleteButton().setVisible(false);
				dialog.getAlterButton().setVisible(false);
				//�ı䵥��
				String str = null;
				int xd = Integer.parseInt(dialog.getDanHaoLabel().getText().substring(11, 14))+1;
				if(xd < 10){
					str = "000"+xd;
				}else if(xd <100){
					str = "00"+xd;
				}else if(xd<1000){
					str = "0"+xd;
				}else{
					str = ""+xd;
				}
			
				dialog.getDanHaoLabel().setText(dialog.getDanHaoLabel().getText().substring(0,10)+str);
                dialog.getData().clear();
			}

		}
		
	}

}
