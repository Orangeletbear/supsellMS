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

public class JMenuTwoListener extends MouseAdapter implements  ActionListener {
	KeHuXiaoShouMainFrame frame;
	public JMenuTwoListener(KeHuXiaoShouMainFrame frame){
		this.frame=frame;
	}
	public void actionPerformed(ActionEvent e)  {
			Connection conn = JDBCTool.getConnection();
		    Statement st = null;
			ResultSet  rs = null;
			try{
				String	sql="select  kh_name,kh_th_date,kh_th_id,'商品退货付款',kh_th_ytje,kh_th_stje,"+
    			" (kh_th_stje-kh_th_ytje),kh_th_jbr,kh_th_czy,kh_th_bz from tb_khth_main,"+
    			" tb_khinfo where  "+
                "   kh_id=kh_th_name and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo().getSelectedDate())+"','YYYY-MM-DD')-"+
				    "kh_th_date<0 and to_date('"+DateConventer.dateToStr(frame.getDatePickerTo1().getSelectedDate())+"','YYYY-MM-DD') - " +
				    "kh_th_date>0  ";;
				Vector data=new Vector();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//获取表中的列数
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
		JOptionPane.showMessageDialog(null,"数据库发生错误，操作失败!");
		
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally{
		JDBCTool.freeResorse(rs, st, conn);
	}
	   
			
	}
	
}
