package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;

public class TimeAction implements ActionListener {

	DanJuChaXunDialog dialog = TimeFindDanJuAction.getDialog();
	JDatePicker datePicker1 = dialog.getPanel_center_chaXunShiJian();
	JDatePicker datePicker2 = dialog.getPanel_center_zhi();
	String strDate1 = null;
	String strDate2 = null;
	String systemDate = null;
	Vector data = null;
	Vector data2 = null;
 	JLabel label = dialog.getShangPinMingXiLabel();
	
	public void actionPerformed(ActionEvent e) {
		try {
			
			strDate1 = DateConventer.dateToStr(datePicker1.getSelectedDate(),"yyyy-MM-dd");
			strDate2 = DateConventer.dateToStr(datePicker2.getSelectedDate(),"yyyy-MM-dd");
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		
    	 Calendar   cal   =   Calendar.getInstance(); 
    	 String today = new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
         cal.add(Calendar.DATE,   -1); 
         String   yesterday   =   new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
         cal.add(Calendar.DATE,   -1); 
         String   qianTian   =   new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
    	 cal.add(Calendar.DATE, -5);
    	 String   week   =   new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime()); 
    	
    	 
		if("今天".equals(e.getActionCommand().trim())){
		
			data = JDBCDanJuFind.getData("",today, today);
		/*	try {
				dialog.getPanel_center_chaXunShiJian().
				                   setSelectedDate(new Date());
				dialog.getPanel_center_zhi().setSelectedDate(DateConventer.strToDate(today));
			} catch (ParseException e1) {
			
				e1.printStackTrace();
			}*/
			
		}else if("昨天".equals(e.getActionCommand().trim())){
			
			data = JDBCDanJuFind.getData("",yesterday,yesterday );
			/*try {
				dialog.getPanel_center_chaXunShiJian().
				                    setSelectedDate(DateConventer.strToDate(yesterday));
				dialog.getPanel_center_zhi().setSelectedDate(DateConventer.strToDate(yesterday));
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}*/
			
			
		}else if("前天".equals(e.getActionCommand().trim())){
			
			data = JDBCDanJuFind.getData( "",qianTian,qianTian );
			/*try {
				dialog.getPanel_center_chaXunShiJian().
				                    setSelectedDate(DateConventer.strToDate(qianTian));
				dialog.getPanel_center_zhi().setSelectedDate(DateConventer.strToDate(qianTian));
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}*/
			
		}else if("最近七天".equals(e.getActionCommand().trim())){
			
			data = JDBCDanJuFind.getData("", week,today );
		/*	try {
				dialog.getPanel_center_chaXunShiJian().
				                    setSelectedDate(DateConventer.strToDate(week));
				dialog.getPanel_center_zhi().setSelectedDate(DateConventer.strToDate(today));
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}*/
			
		}
		
		if(data.size() > 0 ){
			dialog.getTabelModel().setDataVector(data,
					AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
			//设置表格第一行数据被选中
			dialog.getHuiZongTable().requestFocus();
			dialog.getHuiZongTable().setRowSelectionInterval(0,0);
			
			//初始状态下明细表显示汇总表的第一条单据的商品信息
			String danHao = (String) dialog.getTabelModel().getValueAt(0,0);
			
			label.setText(danHao+"         "+(String) dialog.getTabelModel().getValueAt(0,2));
			label.setForeground(Color.RED);
			data2 = JDBCDanJuFind.getDate(danHao);	

			dialog.getTabelModel2().setDataVector(data2,
			AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
			}else{
				label.setText("");
				dialog.getTabelModel().setDataVector(data,
						AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
				dialog.getTabelModel2().setDataVector(null,
						AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
				String message = "没有符合条件的记录，查询时间为："+strDate1+"至"+strDate2
				+"单据号/客户名称为";
				JOptionPane.showMessageDialog(dialog, message);
			}
			 
		}


	}


