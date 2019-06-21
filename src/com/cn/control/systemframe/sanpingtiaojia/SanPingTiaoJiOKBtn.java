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
 * ���۹����ȷ���¼�
 * ���ı�ļ۸�д�����ݿ�
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
        	 JOptionPane.showMessageDialog(frame,"���۳ɹ�");
        	 
        	 ShangPingGuangLiFrame spGL = (ShangPingGuangLiFrame)frame.getOwner();
        	 
        	 MainFrame mframe = (MainFrame) spGL.getOwner();
	       	 
	       	 String user = mframe.getUser();
	       	 Log.traceLog(" ����Ա  ",user,"  ����Ʒ "+changeData.get(1).toString() +"  �����˵���");
        	 frame.dispose();
        	 
         }else{
        	 JOptionPane.showMessageDialog(frame,"����ʧ��");
        	 frame.dispose();
         }
         
	}

}
