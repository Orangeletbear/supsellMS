package com.cn.control.systemframe.sanpingtiaojia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import com.cn.dao.system.SanPingTiaoJiJDBC;
import com.cn.util.DateConventer;
import com.cn.util.Log;
import com.cn.view.mainJFrame.MainFrame;
import com.cn.view.systemJFrame.ShangPingGuangLiFrame;
import com.cn.view.systemJFrame.shangpingxinxidialog.SPTiaoJiManage;
/**
 * 调价管理的确定事件
 * 将改变的价格写入数据库
 * @author finey
 *
 */
public class SanPingTiaoJiOKBtn implements ActionListener {
	private SPTiaoJiManage frame;
	public SanPingTiaoJiOKBtn(SPTiaoJiManage frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent arg0) {
		
         Vector<String> changeData = new Vector<String>();
         
         changeData.add(frame.getSpId().getText().toString());
         changeData.add(frame.getSpName().getText().toString());
         changeData.add(frame.getSpJingPrice().getText().toString());
         changeData.add(frame.getSpShouPrice().getText().toString());
         changeData.add(frame.getSpZheKou().getText().toString());
         if(frame.getSpIsTeJia().isSelected()){
        	 changeData.add("1");
         }else{
        	 changeData.add("0");
         }
         changeData.add(frame.getSpTePrice().getText().toString());
         changeData.add(frame.getHuiYuanTePrice().getText().toString());
         
         if(frame.getSpUse().isSelected()){
        	 changeData.add("1");
         }else{
        	 changeData.add("0");
         }
         if(frame.getHaveTeJia().isSelected()){
        	 changeData.add("1");
         }else{
        	 changeData.add("0");
         }
         Date to = null;
         Date from = null;
         try {
        	 from = frame.getDateFrom().getSelectedDate();
        	 to = frame.getDateTo().getSelectedDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		changeData.add(DateConventer.dateToStr(from, "yyyy-MM-dd"));
	    changeData.add(DateConventer.dateToStr(to, "yyyy-MM-dd"));
		   
	    
         boolean isChange = SanPingTiaoJiJDBC.changeSPPrice(changeData);
         
         if(isChange == true){
        	 JOptionPane.showMessageDialog(frame,"调价成功");
        	 
        	 ShangPingGuangLiFrame spGL = (ShangPingGuangLiFrame)frame.getOwner();
        	 
        	 MainFrame mframe = (MainFrame) spGL.getOwner();
	       	 
	       	 String user = mframe.getUser();
	       	 Log.traceLog(" 操作员  ",user,"  对商品 "+changeData.get(1).toString() +"  进行了调价");
        	 frame.dispose();
        	 
         }else{
        	 JOptionPane.showMessageDialog(frame,"调价失败");
        	 frame.dispose();
         }
         
	}

}
