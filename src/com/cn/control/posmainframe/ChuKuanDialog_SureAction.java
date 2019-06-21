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
 * POS收银员出款对话框上
 * 的确定按钮所对应的监听器
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
		//收银员
		String shouYinYuan = dialog.getUserName().getText();
		Object syyId = JDBC_POS_GetInfo.getId(shouYinYuan);
		
		//入款单号
		String danHao = dialog.getchuKuanDanHao().getText();
		//入款金额
		String money = dialog.getchuKuanJinE().getText();
		//入款日期
	    String date = DateConventer.dateToStr(new Date());
	    //操作员
	    String czy = syyId.toString();
	    
	    data.add(danHao);
	    data.add(date);
	    data.add(money);
	    data.add(syyId);
	    data.add(czy);
	    
	    
	    if("".equals(money)){
	    //写入数据库
	    	JOptionPane.showMessageDialog(dialog, "金额不能为零！");
	    }else{
	    	   POScrk_JDBC.insertChuKuanData(data);
	    	   dialog.dispose();
	    }
		//写日志信息
		 Log.traceLog( "  操作员  ",shouYinYuan," 开了一张收银员入款单据："+danHao);
	}
}


