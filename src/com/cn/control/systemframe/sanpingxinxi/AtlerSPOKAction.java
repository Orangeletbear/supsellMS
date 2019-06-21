package com.cn.control.systemframe.sanpingxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.util.DateConventer;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AtlerShangPingDialog;
/**
 *修改商品确定后的监听器
 * @author finey
 *
 */
public class AtlerSPOKAction implements ActionListener {
	
	AtlerShangPingDialog frame;
	public AtlerSPOKAction(AtlerShangPingDialog frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {

		//取出界面数据
		Vector<String> Data = new Vector<String>();
		//0--4
		Data.add(frame.getSpLeiBie().getText().toString());
		Data.add(frame.getSpId().getText().toString());
		Data.add(frame.getSpName().getText().toString());
		Data.add(frame.getSpTiaoMa().getText().toString());
		Data.add(frame.getSpGuiGe().getText().toString());
		//5-10
		Data.add(frame.getSpDangWei().getSelectedItem().toString());
		Data.add(frame.getSpKuChun().getText().toString());
		Data.add(frame.getSpColor().getSelectedItem().toString());
		Data.add(frame.getSpJingPrice().getText().toString());
		Data.add(frame.getSpShouPrice().getText().toString());
		if(frame.getSpUseDate().isSelected()){
        	Data.add("1");
        }else{
        	Data.add("0");
        }
		//11--16
		Data.add(frame.getSpBaoZhiQi().getText().toString());
		Data.add(frame.getSpProductor().getText().toString());
		Data.add(frame.getSp_bz().getText().toString());
		Data.add(frame.getSpZheKou().getText().toString());
        if(frame.getSpIsTeJia().isSelected()){
        	Data.add("1");
        }else{
        	Data.add("0");
        }

        if(frame.getUseYes().isSelected()){
        	Data.add("1");
        }else{
        	Data.add("0");
        }
        //17 --21
        if(frame.getHaveTeJia().isSelected()){
        	Data.add("1");
        }else{
        	Data.add("0");
        }
        Data.add(frame.getSpTejia().getText().toString());
		Data.add(frame.getSpHuiYuanTejia().getText().toString());
		String dateFrom = null;
		String dateTo = null;
        try {
			dateFrom = DateConventer.dateToStr(
					frame.getDateFrom().getSelectedDate(), "yyyy-MM-dd");
			dateTo = DateConventer.dateToStr(
					frame.getDateTo().getSelectedDate(), "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Data.add(dateFrom);
		Data.add(dateTo);
		
		boolean isAtler = SanPingGuanLiJDBC.atlerSPDataDB(Data);
		
		if(isAtler == true){
	       	 JOptionPane.showMessageDialog(frame,"商品修改成功");
	       	 ((ShangPingGuangLiFrame)(frame.getOwner())).initDataFromDB();
	       	 frame.dispose();
	       	
	        }else{
	       	 JOptionPane.showMessageDialog(frame,"注: 商品修改失败,请注意数据是否正确");
	       	 frame.dispose();
	        }   

	}

}
