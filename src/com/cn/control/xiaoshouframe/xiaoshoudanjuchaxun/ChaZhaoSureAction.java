package com.cn.control.xiaoshouframe.xiaoshoudanjuchaxun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JLabel;

import com.cn.dao.xiaoshou.xiaoshoudanjuchaxun.JDBCDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.xiaoshoudanjuchaxun.DanJuColumnames;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.ChaZhaoDialog;
import com.cn.view.xiaoshouJFrame.xiaoshoudanjuchaxun.DanJuChaXunDialog;
/**
 * 销售单据查询对话框
 * 上的详细查找上的确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class ChaZhaoSureAction implements ActionListener {

	private ChaZhaoDialog dialog ;
	private DanJuChaXunDialog mainDialog = XiangXiChaZhaoAction.getDialog();
	
	public ChaZhaoSureAction(ChaZhaoDialog dialog ){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {

		String keHuName = dialog.getKeHuName().getText();
		String strDate1 = null;
		String strDate2 = null; 
		String czyName = (String) dialog.getCzybox().getSelectedItem();
		String ckName = (String) dialog.getCkbox().getSelectedItem();
		
		JDatePicker datePicker1 = dialog.getDataPicker1();
		JDatePicker datePicker2 = dialog.getDataPicker2();
	    
     	Vector data = null;
     	Vector data2 = null;
    	JLabel label = mainDialog.getShangPinMingXiLabel();
		try {
			strDate1 = DateConventer.dateToStr(datePicker1.getSelectedDate(),"yyyy-MM-dd");
			strDate2 = DateConventer.dateToStr(datePicker2.getSelectedDate(),"yyyy-MM-dd");

		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	
		data = JDBCDanJuFind.getData(keHuName,ckName,czyName,strDate1,strDate2);
	
		if(data.size() > 0 ){
			mainDialog.getTabelModel().setDataVector(data,
					AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
			//设置表格第一行数据被选中
			mainDialog.getHuiZongTable().requestFocus();
			mainDialog.getHuiZongTable().setRowSelectionInterval(0,0);
			
			//初始状态下明细表显示汇总表的第一条单据的商品信息
			String danHao = (String) mainDialog.getTabelModel().getValueAt(0,0);
		
			label.setText(danHao+"         "+(String) mainDialog.getTabelModel().getValueAt(0,2));
			label.setForeground(Color.RED);
			data2 = JDBCDanJuFind.getDate(danHao);	

			mainDialog.getTabelModel2().setDataVector(data2,
			AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
			}else{
				label.setText("");
				mainDialog.getTabelModel2().setDataVector(null,
						AllTableModel.getVectorFromObj(DanJuColumnames.mingXiBiaoColumnames));
				mainDialog.getTabelModel().setDataVector(data,
						AllTableModel.getVectorFromObj(DanJuColumnames.zongBiaoColumnames));
				
			}
			 
		mainDialog.getPanel_center_keHuText().setText(keHuName);
		try {
			mainDialog.getPanel_center_chaXunShiJian().setSelectedDate(datePicker1.getSelectedDate());
			mainDialog.getPanel_center_zhi().setSelectedDate(datePicker2.getSelectedDate());
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		dialog.dispose();
	}
	
}
