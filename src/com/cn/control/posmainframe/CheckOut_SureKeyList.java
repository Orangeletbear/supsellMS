package com.cn.control.posmainframe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.cn.dao.pos.JDBCInsertData;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.xiaoshou.JDBCGetInfo;
import com.cn.dao.xiaoshou.shangpinxiaoshuo.JDBCAddXiaoShouInfo;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.posmainJFrame.CheckOut;
import com.cn.view.posmainJFrame.POSFrame;
/**
 * ���˶Ի����ȷ����ݼ�
 * @author Administrator
 *
 */
public class CheckOut_SureKeyList implements KeyListener {

	 private CheckOut dialog;
	 private POSFrame frame;
	    
	 public CheckOut_SureKeyList(CheckOut dialog){
		 this.dialog = dialog;
		 this.frame = dialog.getFrame();
	 }
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_F5){
			//���Ҫ�������ݿ������ܱ��е�����
			 Object[] zongBiaoData = new Object[11];
			
	       //����
			zongBiaoData[0] = frame.getIdField().getText();
			
		    //��ȡ��������
			zongBiaoData[1] = DateConventer.dateToStr(Calendar.getInstance().getTime());
			
			//��ȡ����Ա����
			String dgName = frame.getDgBox().getSelectedItem().toString();
			zongBiaoData[2] = JDBC_POS_GetInfo.getdgId(dgName);
			
			//��ȡ�ֿ�����
			String cangKu = frame.getChangKuBox().getSelectedItem().toString();
			//��ȡ�ֿ�Id
			zongBiaoData[3] =JDBCGetInfo.getcangKuId(cangKu);
			
			  //��ȡ��Ա����
		     String hyName = "��ͨ�û�";
			//��ȡ��ԱId
		     if(" ".equals(frame.getHyName().getText())){
		    	 zongBiaoData[4] = JDBC_POS_GetInfo.getczyId(hyName);
		     }else{
		    	 zongBiaoData[4] = frame.getHyName().getText();
		     }
			
			
			//��ȡӦ�����
			zongBiaoData[5] = dialog.getShouldPay().getText();
			
			//��ȡʵ�����
			zongBiaoData[6] =Float.parseFloat(dialog.getGivePay().getText())- 
			                      Float.parseFloat(dialog.getReturnPay().getText());
			 System.out.println(zongBiaoData[6]);
			//��ȡ��������
			String fkfs = dialog.getZfWay().getText();
			zongBiaoData[7] = JDBC_POS_GetInfo.getfsId(fkfs);
			 
			//����Ա
			String user =frame.getUser();
			zongBiaoData[8] = JDBC_POS_GetInfo.getId(user);

			zongBiaoData[9] = zongBiaoData[8];
	    	//��ȡ��ע
			zongBiaoData[10] = dialog.getHyID().getText();
		
			//�������ܱ��в�������
			JDBCInsertData.insertXiaoShouData(zongBiaoData);
			
			
			  /**
			   * ��ȡ���������۵�����е�����
			   * 
			   */
				//��������ݿ��е����۵����������Ϣ
				int row = frame.getMode().getRowCount();
				int column = frame.getMode().getColumnCount();
				
				for(int i = 0;i< row; i++){
					Object[] data = new Object[column];
					//��Ʒ��
					data[0] =frame.getMode().getValueAt(i, 1);
					//����
					data[1] =  zongBiaoData[0];
					//����
					data[2] = frame.getMode().getValueAt(i, 7).toString();
					//�ܽ��
					data[3] = frame.getMode().getValueAt(i, 8).toString();
					
					//�����ݿ��в�������
					JDBCInsertData.insertXiangBiaoData(data);
				}
				
				//�������ݿ��е���Ʒ�����Ϣ					
				for(int i = 0 ; i < row;i++){
					String spId = frame.getMode().getValueAt(i, 1).toString();
					int shuLiang = Integer.parseInt(frame.getMode().getValueAt(i, 7).toString());
					//�Ȼ�ȡ����Ʒԭ�ȵĿ��
					int old = Integer.parseInt(JDBCGetInfo.getKuCun(spId).toString());
					//�������ݿ��е���Ʒ�����Ϣ
					JDBCAddXiaoShouInfo.updateKuCun(spId, old -shuLiang);
				}
				
				//�����ձ��е�����
		
				frame.getData().removeAllElements();
				frame.getAll().setText("");
				frame.getHyName().setText("h007");
				frame.repaint();
				//�ı䵥��
				String str = null;
				int xd = Integer.parseInt(frame.getIdField().getText().substring(11, 14))+1;
				if(xd < 10){
					str = "000"+xd;
				}else if(xd <100){
					str = "00"+xd;
				}else if(xd<1000){
					str = "0"+xd;
				}else{
					str = ""+xd;
				}
			
				frame.getIdField().setText(frame.getIdField().getText().substring(0,10)+str);
				frame.getAll().setText("0.0");
				frame.setNum(1);
				//��ʾ��Ϣ
				 JOptionPane.showMessageDialog(dialog, "��  ��   ��   ��");
				//ʹɾ����ť���޸���Ʒ��ť��ʾ�ɼ�
			
				//д��־��Ϣ
				 Log.traceLog( "  ����Ա  ",user," �� "+hyName+" ����һ��pos���۵��ݣ�"+zongBiaoData[0]);
				 dialog.dispose();
				
		}else if(e.getKeyCode() == KeyEvent.VK_F4){
			dialog.dispose();
		}
	
		}

	
	public void keyReleased(KeyEvent e) {
		

	}

	public void keyTyped(KeyEvent e) {
		

	}

}
