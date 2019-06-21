package com.cn.control.xiaoshouframe.shangpinxiaoshuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCAddXiaoShouInfo;
import com.cn.model.xiaoshou.shangpinxiaoshou.XiaoShouCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
import com.cn.view.mainJFrame.MainFrame;
/**
 * ��Ʒ���۶Ի����ϵ�ȷ����ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class ShangPinXiaoShou_SureAction implements ActionListener {

	private ShangPinXiaoShouDialog dialog;
	
	public ShangPinXiaoShou_SureAction(ShangPinXiaoShouDialog dialog){
		this.dialog = dialog;
	}
	
	/**
	 * ��ȡ�����ϵ����ݣ��������������ݿ�
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(dialog.getTableModel().getRowCount() == 0){
			JOptionPane.showMessageDialog(dialog,"������û��ҵ�������ܱ���");
		}else{
			String message = "���ݱ���������޸�,�Ƿ�ȷ�ϱ��棡";
			int n = JOptionPane.showOptionDialog(dialog, message, "ϵͳ��Ϣ", 
					  JOptionPane.YES_NO_OPTION,  JOptionPane.INFORMATION_MESSAGE, null, null, null);
			  if(n == JOptionPane.YES_OPTION){
				//���Ҫ�������ݿ������ܱ��е�����
					 Object[] zongBiaoData = new Object[9];
					
			        //����
					zongBiaoData[0] = dialog.getDanHaoLabel().getText();
					 
				    //��ȡ�ͻ�����
					String khName = dialog.getKeHuText().getText();
					//��ȡ�ͻ�Id
					 zongBiaoData[1] = JDBCGetInfo.getKeHuId(khName);
					//��ȡ�ֿ�����
					String cangKu = dialog.getCangKuBox().getSelectedItem().toString();
					//��ȡ�ֿ�Id
					zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
					//��ȡ��������
					try {
						zongBiaoData[2] = DateConventer.dateToStr(dialog.getDataPicker().getSelectedDate());
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					//��ȡʵ�ս��
					zongBiaoData[5] = dialog.getShiShouText().getText();
					//��ȡӦ�ս��
					zongBiaoData[4] = dialog.getYingShouText().getText();
					//��ȡ������
					zongBiaoData[6] = dialog.getJingBanBox().getSelectedItem();
					
					String user =((MainFrame)dialog.getOwner()).getUser();
					
					//����Ա
					zongBiaoData[7] = user;
					//��ȡ��ע
					zongBiaoData[8] = dialog.getBeiZhuText().getText();
					
					 //	�����ݿ��в�������
					JDBCAddXiaoShouInfo.set_xs_zb_Data(zongBiaoData);
						
				  /**
				   * ��ȡ���������۵�����е�����
				   * 
				   */
					//��������ݿ��е����۵����������Ϣ
					int row = dialog.getTableModel().getRowCount();
					int column = dialog.getTableModel().getColumnCount();
					
					for(int i = 0;i< row; i++){
						Object[] data = new Object[column];
						//��Ʒ��
						data[0] =dialog.getTableModel().getValueAt(i, 0);
						//����
						data[1] =  zongBiaoData[0];
						//����
						data[2] = dialog.getTableModel().getValueAt(i, 8).toString();
						//�ܽ��
						data[3] = dialog.getTableModel().getValueAt(i, 9).toString();
						
						//�����ݿ��в�������
						JDBCAddXiaoShouInfo.set_xs_xb_Data(data);
					}
					
					//�������ݿ��е���Ʒ�����Ϣ					
					for(int i = 0 ; i < row;i++){
						String spId = dialog.getTableModel().getValueAt(i, 0).toString();
						int shuLiang = Integer.parseInt(dialog.getTableModel().getValueAt(i, 8).toString());
						//�Ȼ�ȡ����Ʒԭ�ȵĿ��
						int old = Integer.parseInt(JDBCGetInfo.getKuCun(spId).toString());
						//�������ݿ��е���Ʒ�����Ϣ
						JDBCAddXiaoShouInfo.updateKuCun(spId, old -shuLiang);
					}
					
					//�����ձ��е�����
					dialog.getTableModel().setDataVector(XiaoShouCulomnModel.obj,
							XiaoShouCulomnModel.columnNames);
					dialog.getShiShouText().setText("0.0");
					dialog.getYingShouText().setText("0.0");
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
					
					//��ʾ��Ϣ
					 JOptionPane.showMessageDialog(dialog, "���ݱ���ɹ�");
					//ʹɾ����ť���޸���Ʒ��ť��ʾ�ɼ�
					dialog.getDeleteButton().setVisible(false);
					dialog.getAlterButton().setVisible(false);
					//д��־��Ϣ
					 Log.traceLog( "  ����Ա  ",user," �� "+khName+" ����һ�����۵��ݣ�"+zongBiaoData[0]);
			    	
					 dialog.getData().clear();
				}

			}
			
		}
			  
}


