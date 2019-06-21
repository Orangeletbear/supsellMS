package com.cn.control.jinhuoframe.caigoutuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.GongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_ckinfoJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.Insert_tb_th_detailJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.Insert_tb_th_mainJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.TuiHuoInsert_tb_spJDBC;
import com.cn.util.DateConventer;
import com.cn.view.jinhuoJFrame.CaiGouTuiHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.mainJFrame.MainFrame;

public class TuiHuoMainOKBtnListener implements ActionListener{

	CaiGouTuiHuo dialog;
	public TuiHuoMainOKBtnListener(CaiGouTuiHuo dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dialog.getQueDing()){
			if(dialog.getCaiGouTuiHuo_data().isEmpty()){
				JOptionPane.showMessageDialog(dialog,"��������ҵ���������ܱ���");
				return;
			}
			String gong = dialog.getGongHuoShang().getText();
			if(gong.equals("")){
				JOptionPane.showMessageDialog(dialog,"�����̲���Ϊ��");
				return;
			}
			if(GongHuoShangJDBC.getName(gong).isEmpty()){
				JOptionPane.showMessageDialog(dialog,"�޸ù����̼�¼��������Ӹ��¹�����");
				return;
			}
			
		
			if(dialog.getYingShouJinE().getText().equals("")){//���ų�Ϊnull������Ϊ0
				dialog.getYingShouJinE().setText("0");
			}
			if(dialog.getShiShouJinE().getText().equals("")){//���ų�Ϊnull������Ϊ0
				dialog.getShiShouJinE().setText("0");
			}
			
			float yingfujine = Float.parseFloat(dialog.getYingShouJinE().getText());
			float shifujine = Float.parseFloat(dialog.getShiShouJinE().getText());
				
			
			//һ������󡣿�ʼ�����ݿ���д������
			
			//�ɹ��˻�����
			/*���ţ��������ڣ�String���������̣�id�������ֿ⣨id����
			 *Ӧ����ʵ�����Żݽ��
			 *�����ˣ�����Ա����ע
			*/
			Vector<String> cg_main_data = new Vector<String>();
			//����
			cg_main_data.add(dialog.getDanhao().getText());
			//�������ڣ�String��
			try {
				cg_main_data.add(DateConventer.dateToStr(dialog.getTuiHuoRiQi().getSelectedDate(),"yyyy-MM-dd"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//�����̣�id��
			cg_main_data.add(Tb_gongHuoShangJDBC.change(dialog.getGongHuoShang().getText()));
			//���ֿ⣨id��
			if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("���ֿ�")){
				cg_main_data.add("001");
			}else if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("�ƿ�")){
				cg_main_data.add("002");
			}else if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("���ϲֿ�")){
				cg_main_data.add("003");
			}else{//ʳƷ��
				cg_main_data.add("004");
			}
			//Ӧ�����
			cg_main_data.add(dialog.getYingShouJinE().getText());
			//ʵ�����
			cg_main_data.add(dialog.getShiShouJinE().getText());
			//������
			cg_main_data.add(dialog.getJingbanren().getSelectedItem().toString());
			//����Ա
			cg_main_data.add(((MainFrame)dialog.getFrame()).getUser());
			//��ע
			cg_main_data.add(dialog.getBeiZhu().getText());
			
			Insert_tb_th_mainJDBC.insert(cg_main_data);
			
			/*
			 * �ɹ��˻����һ��һ���ļ�
			 */
			for(Object tmp : dialog.getCaiGouTuiHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				//��Ʒ��ţ����ţ��������ܽ��
				Insert_tb_th_detailJDBC.insert(hangShuJu.get(0).toString(),
						dialog.getDanhao().getText(),
						hangShuJu.get(6).toString(),
						hangShuJu.get(7).toString());
			}
			
			
			
			
			//д����Ʒ��Ϣ��
			for(Object tmp : dialog.getCaiGouTuiHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				
				if(!Tb_spinfoJDBC.find(hangShuJu.get(0).toString()).isEmpty()){
					//��Ʒ��ţ���Ʒ�������ֿ�
					String bianhao = hangShuJu.get(0).toString();
					String shuliang = hangShuJu.get(6).toString();
					String cangku = Tb_ckinfoJDBC.find(dialog.getChuHuoCangKu().getSelectedItem().toString());
					
					//�����õ�������JDBC����Ϊ���˻������������Ǽ�������������š�
					TuiHuoInsert_tb_spJDBC.insert(bianhao, shuliang, cangku);
				}
			}
			//ˢ�½��棬����
			 JOptionPane.showMessageDialog(dialog,"���ݴ���ɹ�!");
			dialog.getCaiGouTuiHuo_data().clear();
			dialog.getYingShouJinE().setText("0");
			dialog.getShiShouJinE().setText("0");
			dialog.getGongHuoShang().setText("0");
			//ˢ�±�
			dialog.getATM().setDataVector(dialog.getCaiGouTuiHuo_data(),
					ColumnNames.caiGouJinHuo_columns);
			
		}
			
			
			
	}
		
}
	
	