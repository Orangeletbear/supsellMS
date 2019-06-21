package com.cn.control.systemframe.huiyuanxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cn.dao.system.HuiYuanXinGLJDBC;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.model.AllTableModel;
import com.cn.model.system.HYSZTableCulomns;
import com.cn.model.system.SPTJTableCulomns;
import com.cn.view.systemJFrame.HuiYanGuangLiFrame;
/**
 * 查询会员基本信息监听器
 * @author Administrator
 *
 */
public class FindHYBaseMAction implements ActionListener {

	HuiYanGuangLiFrame frame;
	public FindHYBaseMAction(HuiYanGuangLiFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
         String hyID = frame.getDjfield1().getText();
         
         Vector data = HuiYuanXinGLJDBC.getHuiYuanBaseM(hyID);
         //更新界面数据
         frame.getHyXinXiTM().setDataVector(data,
     		   AllTableModel.getVectorFromObj(HYSZTableCulomns.ColumnName11));
         
	}

}
