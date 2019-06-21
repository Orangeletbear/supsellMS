package com.cn.control.systemframe.sanpingxinxi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cn.dao.system.SanPingGuanLiJDBC;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.util.DateConventer;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.AddShangPingDialog;

/**
 * 增加一条商品
 * @author Administrator
 *
 */
public class AddSPOKAcion implements ActionListener {

	private AddShangPingDialog frame;
	
	public AddSPOKAcion(AddShangPingDialog frame) {
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
		
		
        boolean isAdd= SanPingGuanLiJDBC.addADataToDataDB(Data);
        
        if(isAdd == true){
       	 JOptionPane.showMessageDialog(frame,"商品增加成功");
       	 Vector data = new Vector();
       	 data.add(Data.get(1));
       	 data.add(Data.get(2));
       	 frame.getModel().addRow(data);
       	 ((ShangPingGuangLiFrame)(frame.getOwner())).initDataFromDB();
        }else{
       	 JOptionPane.showMessageDialog(frame,"注: 商品增加失败,请注意数据是否正确");
       	 frame.dispose();
        }   
	}

}
