package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JLabel;
import com.cn.dao.xiaoshou.guketuihuo.JDBCTuiHuoDanJuFind;
import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.TuiHuoTabelCulomnModel;
import com.cn.util.DateConventer;
import com.cn.util.JDatePicker;
import com.cn.view.xiaoshouJFrame.guketuihuo.GuKeTuiHuoDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GaoJiChaXun;


/**
 * 顾客退货对话框上的顾客退货查询选项卡
 * 中的高级查询按钮所弹出的查找对话框
 * 上的确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class GaoJiChaXunSureAction implements ActionListener {

	private GaoJiChaXun dialog ;
	private static GuKeTuiHuoDialog mainDialog = ChaZhaoKeHuButtonAction.getDialog();
	
	public GaoJiChaXunSureAction(GaoJiChaXun dialog ){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {

		String keHuName = dialog.getKeHuText().getText();
		String strDate1 = null;
		String strDate2 = null; 
		String czyName = (String) dialog.getCzyBox().getSelectedItem();
		String ckName = (String) dialog.getCkBox().getSelectedItem();
		
		JDatePicker datePicker1 = dialog.getDataPicker1();
		JDatePicker datePicker2 = dialog.getDataPicker2();
		JLabel label = mainDialog.getInformation();
		
     	Vector data = null;
     	Vector data2 = null;

		try {
			strDate1 = DateConventer.dateToStr(datePicker1.getSelectedDate(),"yyyy-MM-dd");
			strDate2 = DateConventer.dateToStr(datePicker2.getSelectedDate(),"yyyy-MM-dd");

		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	
		data = JDBCTuiHuoDanJuFind.getData(keHuName,ckName,czyName,strDate1,strDate2);
	
		if(data.size() > 0 ){
			mainDialog.getDanJuModel().setDataVector(data,
					AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.QueryColumnNames));
			//设置表格第一行数据被选中
			mainDialog.getDanJuTable().requestFocus();
			mainDialog.getDanJuTable().setRowSelectionInterval(0,0);
			
			//初始状态下明细表显示汇总表的第一条单据的商品信息
			String danHao = (String) mainDialog.getDanJuModel().getValueAt(0,0);
			
			label.setText(danHao+"         "+(String) mainDialog.getDanJuModel().getValueAt(0,2));
			label.setForeground(Color.RED);
			data2 = JDBCTuiHuoDanJuFind.getDate(danHao);	
			mainDialog.getXiangXiModel().setDataVector(data2,
			 AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.DanJuColumnNames));
			}else{
				label.setText("");
				mainDialog.getXiangXiModel().setDataVector(null,
						AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.DanJuColumnNames));
				mainDialog.getDanJuModel().setDataVector(data,
						AllTableModel.getVectorFromObj(TuiHuoTabelCulomnModel.QueryColumnNames));
				
			}
			 
		mainDialog.getKeHuText().setText(keHuName);
		try {
			mainDialog.getDataPicker1().setSelectedDate(datePicker1.getSelectedDate());
			mainDialog.getDataPicker2().setSelectedDate(datePicker2.getSelectedDate());
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		dialog.dispose();
	}
	
}

