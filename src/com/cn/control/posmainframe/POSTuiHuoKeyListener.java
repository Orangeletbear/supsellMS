package com.cn.control.posmainframe;
/**
 * POS�˻��Ի����϶�Ӧ�ļ��̼�����
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.pos.JDBCInsertData;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.model.AllTableModel;
import com.cn.model.pos.POSTableModel;
import com.cn.util.DateConventer;
import com.cn.view.posmainJFrame.ChangeNumber;
import com.cn.view.posmainJFrame.POSTuiHuoDialog;

public class POSTuiHuoKeyListener implements KeyListener {

	private POSTuiHuoDialog dialog;
	
	public POSTuiHuoKeyListener(POSTuiHuoDialog dialog){
		this.dialog = dialog;
	}
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource().equals(dialog.getXsIS()) &&e.getKeyCode() == 10){
			String danHao = dialog.getXsIS().getText();
			
			ArrayList<String > dh = JDBC_POS_GetInfo.get_pos_xs_id();
			int i = 0;
			for( ;i<dh.size();i++){
				if(danHao.equals(dh.get(i))){
					Vector data = JDBC_POS_GetInfo.getxs_Info(danHao);
					dialog.getXsDate().setText(data.get(0).toString());
					dialog.getHyID().setText(data.get(1).toString());
					dialog.getSptm().requestFocus();
					break;
				}
			}
			if(i == dh.size()){
				JOptionPane.showMessageDialog(dialog, "�����۵������ڣ���˲����¼",
						"ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE,null);
			}
		}else if(e.getSource().equals(dialog.getSptm()) &&e.getKeyCode() == 10){
			String danHao = dialog.getXsIS().getText();
			System.out.println(danHao);
			
			String spId = dialog.getSptm().getText();
			//System.out.println(spId);
			ArrayList<String > spIds = JDBC_POS_GetInfo.get_pos_sp_id(danHao);
			int i = 0;
			//System.out.println(spIds.size());
			
			for( ;i<spIds.size();i++){
				if(spId.equals(spIds.get(i))){
					
					Vector data = dialog.getData();
					data.add(JDBC_POS_GetInfo.get_pos_sp_info(dialog.getCount(), spId));
					//System.out.println(data);
					dialog.getDefaultModel().setDataVector(data,
							AllTableModel.getVectorFromObj(POSTableModel.SPCulomns));
					dialog.setCount(dialog.getCount()+1);
					
					dialog.getSpTable().setRowSelectionInterval(
							dialog.getData().size()-1, dialog.getData().size()-1);
					break;
				}
			}
			if(i == spIds.size()){
				JOptionPane.showMessageDialog(dialog, "��ǰ���۵���û�и���Ʒ�����ۼ�¼�������˻�!",
						"ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE,null);
			}
			int row = dialog.getSpTable().getRowCount();
			int column = dialog.getDefaultModel().getColumnCount();
			
			float money = 0f;
			float number = 0f;
			for(int t = 0;t< row;t++){
				//System.out.println(dialog.getDefaultModel().getValueAt(t, 8).toString());
				money = money+ new Float(dialog.getDefaultModel().getValueAt(t, 8).toString());
				//System.out.println(dialog.getDefaultModel().getValueAt(t, 7).toString());
				
				number = number +new Float(dialog.getDefaultModel().getValueAt(t, 7).toString());
			}
		
			dialog.getSum().setText(String.valueOf(money));
			dialog.getNumber().setText(String.valueOf(number));
			
		}else if(e.getKeyCode() == KeyEvent.VK_F3){
			
			int row = dialog.getSpTable().getSelectedRow();
			if(row ==-1){
				return;
			}
			float m = new Float(dialog.getDefaultModel().getValueAt(row, 8).toString());
			float s = new Float(dialog.getDefaultModel().getValueAt(row, 7).toString());
			dialog.getDefaultModel().removeRow(row);
			dialog.getSum().setText(String.valueOf(new Float(dialog.getSum().getText()) - m));
			dialog.getNumber().setText(String.valueOf(new Float(dialog.getNumber().getText())-s));
			dialog.setCount(dialog.getCount() -1);
			
			dialog.getSpTable().setRowSelectionInterval(
					dialog.getData().size()-1, dialog.getData().size()-1);
		}else if(e.getKeyCode() == KeyEvent.VK_F4){
			new ChangeNumber(dialog,"�޸�����");
		}else if(e.getKeyCode() == KeyEvent.VK_F5){
			
			//��Ų������ݿ�POS�˻������е�����
			Vector  zbData = new Vector();
			//��ȡ�˻�����
			zbData.add(dialog.getTuiHuoID().getText());
			//��ȡ���۵���
			zbData.add(dialog.getXsIS().getText()); 
			//��ȡ�˻�����
			zbData.add( DateConventer.dateToStr(Calendar.getInstance().getTime()));
		
			ArrayList data = JDBC_POS_GetInfo.get_pos_xs_info(dialog.getXsIS().getText());
			//��ȡ����Ա
			zbData.add(data.get(0));
			//��ȡ�ֿ�
			zbData.add(data.get(1));
			
			//��ȡӦ�˽��
			zbData.add(dialog.getSum().getText());
			//��ȡʵ�˽��
			zbData.add(dialog.getSum().getText());
			//��ȡ����Ա
			String user =dialog.getFrame().getUser();
			zbData.add(JDBC_POS_GetInfo.getId(user)) ;
			//��ȡ������
			zbData.add(data.get(2));
			//��ȡ��ע
			zbData.add(data.get(3));
			
			
			//�����ݿ�pos�˻��ܱ��в�������
			JDBCInsertData.insert_th_main_Data(zbData);
			
			//������˻�����в��������
			
			//��������ݿ��е����۵����������Ϣ
			int row = dialog.getDefaultModel().getRowCount();
			int column = dialog.getDefaultModel().getColumnCount();
			
			for(int i = 0;i< row; i++){
				Object[] th_data = new Object[column];
				//��Ʒ��
				th_data[0] =dialog.getDefaultModel().getValueAt(i, 1);
				//����
				th_data[1] =  zbData.get(0);
				//����
				th_data[2] = dialog.getDefaultModel().getValueAt(i, 7).toString();
				//�ܽ��
				th_data[3] = dialog.getDefaultModel().getValueAt(i, 8).toString();
				
				//�����ݿ��в�������
				JDBCInsertData.insert_th_detail_Data(th_data);
				
			}
			
			//��ʾ��Ϣ
			JOptionPane.showMessageDialog(dialog, "û�����ô�ӡ��,���ܴ�ӡСƱ",
					"ϵͳ��ʾ", JOptionPane.DEFAULT_OPTION, null);
		    dialog.getData().removeAllElements();
		   /* dialog.getDefaultModel().setDataVector(dialog.getData(),
		    		AllTableModel.getVectorFromObj(POSTableModel.SPCulomns));*/
		    dialog.repaint();
			dialog.getSptm().setText("");
			dialog.getSum().setText("0.0");
			dialog.getNumber().setText("0");
			dialog.getXsIS().setText("");
			dialog.getXsDate().setText("");
			dialog.getHyID().setText("");
			
			//�ı䵥��
			String str = null;
			int xd = Integer.parseInt(dialog.getTuiHuoID().getText().substring(11, 14))+1;
			if(xd < 10){
				str = "000"+xd;
			}else if(xd <100){
				str = "00"+xd;
			}else if(xd<1000){
				str = "0"+xd;
			}else{
				str = ""+xd;
			}
		
			dialog.getTuiHuoID().setText(dialog.getTuiHuoID().getText().substring(0,10)+str);
			
			dialog.getXsIS().requestFocus();
			
		}else if(e.getKeyCode() == KeyEvent.VK_F7){
			if(dialog.getSpTable().getRowCount() == 0){
				dialog.dispose();
			}else{
				int n = JOptionPane.showOptionDialog(dialog, "�б������˻���Ʒ,�Ƿ��˳�������", "ϵͳ��ʾ", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.DEFAULT_OPTION, null, null, null);
				if(n == JOptionPane.YES_OPTION){
					dialog.dispose();
				}else{
					
				}
			}
			
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			int selectRow = dialog.getSpTable().getSelectedRow();
			if(selectRow == dialog.getData().size()){
				return;
			}
			if(selectRow ==-1){
				return;
			}
			dialog.getSpTable().setRowSelectionInterval(
					selectRow+1, selectRow+1);
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			int selectRow = dialog.getSpTable().getSelectedRow();
			if(selectRow == dialog.getData().size()){
				return;
			}
			if(selectRow ==-1){
				return;
			}
			dialog.getSpTable().setRowSelectionInterval(
					selectRow-1, selectRow-1);
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
