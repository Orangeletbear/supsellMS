package com.cn.control.tongjiframe.KeHuXiaoShouTongJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.tongji.tongJiModel;
import com.cn.util.DateConventer;
import com.cn.util.JDBCTool;
import com.cn.view.tongjiJFrame.KeHuXiaoShouMainFrame;

public class JMenuListener extends MouseAdapter implements  ActionListener {
	KeHuXiaoShouMainFrame frame;
	public JMenuListener(KeHuXiaoShouMainFrame frame){
		this.frame=frame;
	}
	public void actionPerformed(ActionEvent e)  {
		if(e.getSource()==frame.getXiaoShou()){
		Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try{
			String	sql=" select  kh_name,xs_xsdate,xs_id,'��Ʒ���۸���',xs_ysje,xs_ssje," +
 			"(xs_ssje-xs_ysje),xs_jbr,xs_czy,xs_bz from tb_sell_main," +
 			"  tb_khinfo where  "+
             " kh_id=xs_khid and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate())+"','YYYY-MM-DD')-"+
		    "tb_sell_main.xs_xsdate<0 and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate())+"','YYYY-MM-DD') - " +
		    "tb_sell_main.xs_xsdate>0 ";
			Vector data=new Vector();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		//��ȡ���е�����
		int columnCount = rs.getMetaData().getColumnCount();
		while(rs.next()){
			Vector tmp = new Vector();
			for(int column = 1;column<=columnCount;column++){
				tmp.add(rs.getObject(column));
			}
	    data.add(tmp);
	    frame.getZhangWuDtm().setDataVector(data, AllTableModel.getVectorFromObj(tongJiModel.zhangWuNames));
	}
	
} catch (SQLException e1) {
	e1.printStackTrace();
	JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬲���ʧ��!");
	
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} finally{
	JDBCTool.freeResorse(rs, st, conn);
}
   
		}
		
	}
	
}
