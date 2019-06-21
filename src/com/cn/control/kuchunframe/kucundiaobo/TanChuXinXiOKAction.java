package com.cn.control.kuchunframe.kucundiaobo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.view.kuchunJFrame.kucunDiaobo.AddShangPinXinXiDialog;

/**
 * 将商品信息显示栏上的信息确定后添加到已选表格中
 * 应该要区分是新增还是修改？！！！
 * @author Administrator
 *
 */
public class TanChuXinXiOKAction implements ActionListener {
	private AddShangPinXinXiDialog dialog;
	private Vector<String>vo = new Vector<String>();
	public TanChuXinXiOKAction(AddShangPinXinXiDialog dialog){
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * 为1时则为修改商品信息
		 */
		if(dialog.getFlag()==1){
			int row = dialog.getDialog().getSxsptable().getSelectedRow();
			if(row >= 0){
					dialog.getDialog().getTableModel3().setValueAt(dialog.getTextDBSL().getText(),row, 5);
					String dbNum = dialog.getTextDBSL().getText().toString();
					int db = Integer.valueOf(dbNum);
					String djNum = dialog.getLabelCBDJ().getText().toString();
					float dj = Float.valueOf(djNum);
					dialog.getDialog().getTableModel3().setValueAt(db * dj,row, 6);
			}
		}else{
			actions();
			dialog.getDialog().getTableModel3().setDataVector(dialog.getDialog().getVo3(),dialog.getDialog().getVe3());
//			dialog.getDialog().getSxsptable().setRowSelectionInterval(0, 0);
		}
		dialog.dispose();
	}
	
	private void actions(){
		String kcNum = dialog.getLabelDQKC().getText().toString();
		int kc = Integer.valueOf(kcNum);
		String dbNum = dialog.getTextDBSL().getText().toString();
		int db = Integer.valueOf(dbNum);
		String djNum = dialog.getLabelCBDJ().getText().toString();
		float dj = Float.valueOf(djNum);
		
		if(kc > 0 && db > 0){
			if(kc >= db){
				vo.add(dialog.getLabelSPMC().getText());
				vo.add(dialog.getLabelDW().getText().toString());
				vo.add(dialog.getLabelGGXH().getText());
				vo.add(dialog.getLabelYS().getText());
				vo.add(dialog.getLabelCBDJ().getText());
				vo.add(dialog.getTextDBSL().getText());
				vo.add("" + db * dj);
				
				dialog.getDialog().getVo3().add(vo);
			}else {
				JOptionPane.showMessageDialog(null, "你输入的数量太大,请重新输入！");
			}
		} else if(kc <= 0){
			JOptionPane.showMessageDialog(null, "库存不够！请尽快进行采购！");
		}else if(db <= 0){
			JOptionPane.showMessageDialog(null, "选择商品数量不能为负!");
		}
		
	}
}
