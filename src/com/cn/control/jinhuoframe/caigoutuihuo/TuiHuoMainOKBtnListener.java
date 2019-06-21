package com.cn.control.jinhuoframe.caigoutuihuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.jinhuo.GongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_ckinfoJDBC;
import com.cn.dao.jinhuo.Tb_gongHuoShangJDBC;
import com.cn.dao.jinhuo.Tb_spinfoJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.Insert_tb_th_detailJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.Insert_tb_th_mainJDBC;
import com.cn.dao.jinhuo.caigoutuihuo.TuiHuoInsert_tb_spJDBC;
import com.cn.util.DateConventer;
import com.cn.view.jinhuoJFrame.CaiGouTuiHuo;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.mainJFrame.MainFrame;

public class TuiHuoMainOKBtnListener implements ActionListener{

	CaiGouTuiHuo dialog;
	public TuiHuoMainOKBtnListener(CaiGouTuiHuo dialog){
		this.dialog = dialog;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dialog.getQueDing()){
			if(dialog.getCaiGouTuiHuo_data().isEmpty()){
				JOptionPane.showMessageDialog(dialog,"单据中无业务发生，不能保存");
				return;
			}
			String gong = dialog.getGongHuoShang().getText();
			if(gong.equals("")){
				JOptionPane.showMessageDialog(dialog,"供货商不能为空");
				return;
			}
			if(GongHuoShangJDBC.getName(gong).isEmpty()){
				JOptionPane.showMessageDialog(dialog,"无该供货商记录，请先添加该新供货商");
				return;
			}
			
		
			if(dialog.getYingShouJinE().getText().equals("")){//先排除为null。。置为0
				dialog.getYingShouJinE().setText("0");
			}
			if(dialog.getShiShouJinE().getText().equals("")){//先排除为null。。置为0
				dialog.getShiShouJinE().setText("0");
			}
			
			float yingfujine = Float.parseFloat(dialog.getYingShouJinE().getText());
			float shifujine = Float.parseFloat(dialog.getShiShouJinE().getText());
				
			
			//一切满足后。开始向数据库中写数据了
			
			//采购退货主表
			/*单号，开单日期（String），供货商（id），入库仓库（id），
			 *应付金额，实付金额，优惠金额
			 *经办人，操作员，备注
			*/
			Vector<String> cg_main_data = new Vector<String>();
			//单号
			cg_main_data.add(dialog.getDanhao().getText());
			//开单日期（String）
			try {
				cg_main_data.add(DateConventer.dateToStr(dialog.getTuiHuoRiQi().getSelectedDate(),"yyyy-MM-dd"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//供货商（id）
			cg_main_data.add(Tb_gongHuoShangJDBC.change(dialog.getGongHuoShang().getText()));
			//入库仓库（id）
			if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("主仓库")){
				cg_main_data.add("001");
			}else if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("酒库")){
				cg_main_data.add("002");
			}else if(dialog.getChuHuoCangKu().getSelectedItem().toString().equals("饮料仓库")){
				cg_main_data.add("003");
			}else{//食品库
				cg_main_data.add("004");
			}
			//应付金额
			cg_main_data.add(dialog.getYingShouJinE().getText());
			//实付金额
			cg_main_data.add(dialog.getShiShouJinE().getText());
			//经办人
			cg_main_data.add(dialog.getJingbanren().getSelectedItem().toString());
			//操作员
			cg_main_data.add(((MainFrame)dialog.getFrame()).getUser());
			//备注
			cg_main_data.add(dialog.getBeiZhu().getText());
			
			Insert_tb_th_mainJDBC.insert(cg_main_data);
			
			/*
			 * 采购退货祥表，一条一条的加
			 */
			for(Object tmp : dialog.getCaiGouTuiHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				//商品编号，单号，数量，总金额
				Insert_tb_th_detailJDBC.insert(hangShuJu.get(0).toString(),
						dialog.getDanhao().getText(),
						hangShuJu.get(6).toString(),
						hangShuJu.get(7).toString());
			}
			
			
			
			
			//写进商品信息表
			for(Object tmp : dialog.getCaiGouTuiHuo_data()){
				Vector hangShuJu = (Vector)tmp;
				
				if(!Tb_spinfoJDBC.find(hangShuJu.get(0).toString()).isEmpty()){
					//商品编号，商品数量，仓库
					String bianhao = hangShuJu.get(0).toString();
					String shuliang = hangShuJu.get(6).toString();
					String cangku = Tb_ckinfoJDBC.find(dialog.getChuHuoCangKu().getSelectedItem().toString());
					
					//还是用到进货的JDBC，因为是退货，所以数量是减，所以添个负号。
					TuiHuoInsert_tb_spJDBC.insert(bianhao, shuliang, cangku);
				}
			}
			//刷新界面，霍霍
			 JOptionPane.showMessageDialog(dialog,"数据存入成功!");
			dialog.getCaiGouTuiHuo_data().clear();
			dialog.getYingShouJinE().setText("0");
			dialog.getShiShouJinE().setText("0");
			dialog.getGongHuoShang().setText("0");
			//刷新表
			dialog.getATM().setDataVector(dialog.getCaiGouTuiHuo_data(),
					ColumnNames.caiGouJinHuo_columns);
			
		}
			
			
			
	}
		
}
	
	