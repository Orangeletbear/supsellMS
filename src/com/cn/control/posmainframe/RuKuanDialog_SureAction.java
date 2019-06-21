package com.cn.control.posmainframe;
/**
 * ����Ա���Ի���
 * ȷ����ť����Ӧ�ļ�����
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.pos.POScrk_JDBC;
import com.cn.dao.pos.JDBC_POS_GetInfo;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.posmainJFrame.POSLuKuangDialog;

public class RuKuanDialog_SureAction implements ActionListener {

	private POSLuKuangDialog dialog;
	
    public RuKuanDialog_SureAction(POSLuKuangDialog dialog){
	   this.dialog = dialog;
   }
    
	public void actionPerformed(ActionEvent e) {
		Vector data = new Vector();
		//����Ա
		String shouYinYuan = dialog.getUserName().getText();
		Object syyId = JDBC_POS_GetInfo.getId(shouYinYuan);
		
		//����
		String danHao = dialog.getruKuanDanHao().getText();
		//�����
		String money = dialog.getruKuanJinE().getText();
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
	    	JOptionPane.showMessageDialog(dialog, "����Ϊ�㣡");
	    }else{
	    	   POScrk_JDBC.insertRuKuanData(data);
	    	   dialog.dispose();
	    }
		//д��־��Ϣ
		 Log.traceLog( "  ����Ա  ",shouYinYuan," ����һ������Ա���ݣ�"+danHao);
	}

}
