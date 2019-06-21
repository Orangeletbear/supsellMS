package com.cn.control.xiaoshouframe.poscontrol;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import com.cn.dao.xiaoshou.XPOSJDBCControl;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.postongji.POSXiaoShouCulomnModel;
import com.cn.view.xiaoshouJFrame.POS.VIPConsumeDialog;

/**
 * POS会员销售详细查询
 * @author finey
 *
 */
public class HuiYuanXiaoFeiXiangXiMouseActon extends MouseAdapter {
	private VIPConsumeDialog frame;
	public HuiYuanXiaoFeiXiangXiMouseActon(VIPConsumeDialog frame) {
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 1){
			
			int row = frame.getConsumeTable().getSelectedRow();
        	String xsId = frame.getConsumeModel().getValueAt(row, 0).toString();
        	
        	String hyName = frame.getConsumeModel().getValueAt(row, 3).toString();
			
        	frame.getDetailedInfoLabel().setText(xsId+"  "+hyName);
        	Vector data = XPOSJDBCControl.getHuiYuanXiaoFeiMingXi(xsId);
        	frame.setMingXiData(data);
        	frame.getDetailedModel().setDataVector(data,
        			AllTableModel.getVectorFromObj(POSXiaoShouCulomnModel.detailedInfoColumNames));
        	
        	
        	
		}

	}

	

}
