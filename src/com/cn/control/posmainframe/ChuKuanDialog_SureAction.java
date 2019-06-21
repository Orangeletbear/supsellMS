package com.cn.control.posmainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.dao.pos.POScrk_JDBC;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.posmainJFrame.POSChuKuangDialog;
/**
 * POS����Ա����Ի�����
 * ��ȷ����ť����Ӧ�ļ�����
 * @author Administrator
 *
 */
public class ChuKuanDialog_SureAction implements ActionListener {

	private POSChuKuangDialog dialog;
	
	public ChuKuanDialog_SureAction(POSChuKuangDialog dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
	
		Vector data = new Vector();
		//����Ա
		String shouYinYuan = dialog.getUserName().getText();
		Object syyId = JDBC_POS_GetInfo.getId(shouYinYuan);
		
		//����
		String danHao = dialog.getchuKuanDanHao().getText();
		//�����
		String money = dialog.getchuKuanJinE().getText();
		//�������
	    String date = DateConventer.dateToStr(new Date());
	    //����Ա
	    String czy = syyId.toString();
	    
	    data.add(danHao);
	    data.add(date);
	    data.add(money);
	    data.add(syyId);
	    data.add(czy);
	    
	    
	    if("".equals(money)){
	    //д�����ݿ�
	    	JOptionPane.showMessageDialog(dialog, "����Ϊ�㣡");
	    }else{
	    	   POScrk_JDBC.insertChuKuanData(data);
	    	   dialog.dispose();
	    }
		//д��־��Ϣ
		 Log.traceLog( "  ����Ա  ",shouYinYuan," ����һ������Ա���ݣ�"+danHao);
	}
}


