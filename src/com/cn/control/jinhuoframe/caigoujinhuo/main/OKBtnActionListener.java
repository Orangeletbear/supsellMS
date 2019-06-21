package com.cn.control.jinhuoframe.caigoujinhuo.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.GongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_ckinfoJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.dao.jinhuo.jinhuoguanli.Insert_tb_cg_detail;
import com.cn.dao.jinhuo.jinhuoguanli.Insert_tb_cg_mainJDBC;
import com.cn.dao.jinhuo.jinhuoguanli.Insert_tb_spinfoJDBC;
import com.cn.util.DateConventer;
import com.cn.view.jinhuoJFrame.CaiGouJinHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoujinhuo.ChaEChuLi;
import com.cn.view.mainJFrame.MainFrame;

/**
 * �ɹ�����������ȷ��Button������
 * �жϽ������ݵĺϷ��ԣ�ʵ�����������Żݽ�
 * @author Administrator
 *
 */
public class OKBtnActionListener implements ActionListener{

	CaiGouJinHuo dialog;
	public OKBtnActionListener(CaiGouJinHuo dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dialog.getQueDing()){
			if(dialog.getCaiGouJinHuo_data().isEmpty()){
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
		
			if(dialog.getYingFuJinE().getText().equals("")){//���ų�Ϊnull������Ϊ0
				dialog.getYingFuJinE().setText("0");
			}
			if(dialog.getShiFuJinE().getText().equals("")){//���ų�Ϊnull������Ϊ0
				dialog.getShiFuJinE().setText("0");
			}
			
			float yingfujine = Float.parseFloat(dialog.getYingFuJinE().getText());
			float shifujine = Float.parseFloat(dialog.getShiFuJinE().getText());
				
			//���Ӧ��������ʵ����newһ��������
			if(yingfujine >shifujine + dialog.getYouHuiJine()+dialog.getQianKuanJine()){
					new ChaEChuLi(dialog,"����",true);
					return;
			}
			//һ������󡣿�ʼ�����ݿ���д������
			
			//�ɹ���������
			/*���ţ��������ڣ�String���������̣�id�������ֿ⣨id����
			 *Ӧ����ʵ�����Żݽ��
			 *�����ˣ�����Ա����ע
			*/
			Vector<String> cg_main_data = new Vector<String>();
			//����
			cg_main_data.add(dialog.getDanhao().getText());
			//�������ڣ�String��
			try {
				cg_main_data.add(DateConventer.dateToStr(dialog.getJinHuoRiQi().getSelectedDate(),"yyyy-MM-dd"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//�����̣�id��
			cg_main_data.add(Tb_gongHuoShangJDBC.change(dialog.getGongHuoShang().getText()));
			//���ֿ⣨id��
			if(dialog.getShouHuoCangKu().getSelectedItem().toString().equals("���ֿ�")){
				cg_main_data.add("001");
			}else if(dialog.getShouHuoCangKu().getSelectedItem().toString().equals("�ƿ�")){
				cg_main_data.add("002");
			}else if(dialog.getShouHuoCangKu().getSelectedItem().toString().equals("���ϲֿ�")){
				cg_main_data.add("003");
			}else{//ʳƷ��
				cg_main_data.add("004");
			}
			//Ӧ�����
			cg_main_data.add(dialog.getYingFuJinE().getText());
			//ʵ�����
			cg_main_data.add(dialog.getShiFuJinE().getText());
			//�Żݽ��
			cg_main_data.add(""+dialog.getYouHuiJine());
			//������
			cg_main_data.add(dialog.getJingbanren().getSelectedItem().toString());
			//����Ա
			cg_main_data.add(((MainFrame)dialog.getFrame()).getUser());
			//��ע
			cg_main_data.add(dialog.getBeiZhu().getText());
			
			Insert_tb_cg_mainJDBC.insert(cg_main_data);
			//�ɹ����һ��һ���ļ�
			for(Object tmp : dialog.getCaiGouJinHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				//��Ʒ��ţ����ţ��������ܽ��
				Insert_tb_cg_detail.insert(hangShuJu.get(0).toString(),
						dialog.getDanhao().getText(),
						hangShuJu.get(6).toString(),
						hangShuJu.get(7).toString());
			}
			
			
			
			
			//д����Ʒ��Ϣ��
			for(Object tmp : dialog.getCaiGouJinHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				//������ݿ��в����������ţ���Ϊ����Ʒ
				if(!Tb_spinfoJDBC.find(hangShuJu.get(0).toString()).isEmpty()){//����Ʒ
					//��Ʒ��ţ���Ʒ���۵��ۣ���Ʒ�������ֿ�
					String bianhao = hangShuJu.get(0).toString();
					String danjia = hangShuJu.get(5).toString();
					String shuliang = hangShuJu.get(6).toString();
					String cangku = Tb_ckinfoJDBC.find(dialog.getShouHuoCangKu().getSelectedItem().toString());
					
					Insert_tb_spinfoJDBC.insert(bianhao, danjia, shuliang, cangku);
				}else{//����Ʒ
					
				}
				
				
				
				
			}
		
			//ˢ�½��棬����
			 JOptionPane.showMessageDialog(dialog,"���ݴ���ɹ�!");
			dialog.getCaiGouJinHuo_data().clear();
			dialog.getGongHuoShang().setText("");
			dialog.getYingFuJinE().setText("0");
			dialog.getShiFuJinE().setText("0");
//			ˢ�±�
			dialog.getATM().setDataVector(dialog.getCaiGouJinHuo_data(),
					ColumnNames.caiGouJinHuo_columns);
		}
			
			
			
	}
		
}