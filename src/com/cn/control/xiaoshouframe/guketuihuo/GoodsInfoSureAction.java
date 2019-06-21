package com.cn.control.xiaoshouframe.guketuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.model.AllTableModel;
import com.cn.model.xiaoshou.guketuihuo.DialogCulomnModel;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.AddTuiHuoGoodsDialog;
import com.cn.view.xiaoshouJFrame.guketuihuo.dialog.GoodsInfoDialog;
/**
 * 商品信息(销售退货)
 * 对话框上的确定按钮所对应的监听器
 * @author Administrator
 *
 */
public class GoodsInfoSureAction implements ActionListener {

	//父窗口
	private  AddTuiHuoGoodsDialog mainDialog;
	//当前窗口
	private GoodsInfoDialog dialog;
	
	public GoodsInfoSureAction(AddTuiHuoGoodsDialog mainDialog,GoodsInfoDialog dialog){
		this.mainDialog =mainDialog;
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		
		//存放要放入父窗口右边表格中的数据
		Vector data1 = new Vector();
		
		Vector<String> data = new Vector<String>();
		//加入商品名称
		data.add(dialog.getGoodName().getText());
		//加入单位
		data.add(dialog.getDanWei().getText());
		
		//添加 退货单价
		String tuiJiaString = dialog.getTuiHuoDanJia().getText();
		float tuiJia = 0;
		if(tuiJiaString.matches("\\d+[.]?\\d*")){//判断 退货单价是否是数字型字符串
			data.add(tuiJiaString);
			tuiJia = Float.parseFloat(tuiJiaString);
		}else{//不是数字，退货单价设为0
			data.add("0.00");
		}
		
		//添加数量
		String shuLiangString = dialog.getShuLiang().getText();
		float shuLiang = 0;
		if(shuLiangString.matches("\\d+")){//判断  数量 是否是合法数字
			shuLiang = Float.parseFloat(dialog.getShuLiang().getText());
			if(shuLiang == 0){
				JOptionPane.showMessageDialog(dialog,"数量不能为0！");
			}else{
				data.add(shuLiangString);
			}
		}else{
			JOptionPane.showMessageDialog(dialog,"数量不能为空或非正整数！");
		}
		//添加总金额
		float zje = shuLiang*tuiJia;
		data.add(""+zje);
		
		data1 =mainDialog.getData();
		data1.add(data);
		//System.out.println(data.size() > 0);
		if(data1.size() > 0){
		mainDialog.getSxsp_tableModel().setDataVector(data1,
					AllTableModel.getVectorFromObj(DialogCulomnModel.rightColumnName2));
			mainDialog.getSxsptable().requestFocus();
			mainDialog.getSxsptable().setRowSelectionInterval(0, 0);
				
		}
	
		//按下确认后好释放该窗口
		dialog.dispose();
		
		
      //添加要向顾客退货选项卡表中返回的数据
		
		Vector<Object> vector = new Vector<Object>();
		//添加商品编号
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				 mainDialog.getSpqdtable().getSelectedRow(), 0));
		//添加商品名称
		vector.add(dialog.getGoodName().getText());
		//添加单位
		vector.add(dialog.getDanWei().getText());
		//添加单价
		vector.add(tuiJia);
		//添加数量
		vector.add(shuLiang);
		//添加总金额
		vector.add(zje);
		
		//添加规格型号
		vector.add(mainDialog.getSpqd_tableModel().getValueAt(
				mainDialog.getSpqdtable().getSelectedRow(), 3));
		//添加颜色
		vector.add(dialog.getColor().getText());
		
		mainDialog.getMainData().add(vector);

		
	 }

}
