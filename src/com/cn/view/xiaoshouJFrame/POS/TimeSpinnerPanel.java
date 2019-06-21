package com.cn.view.xiaoshouJFrame.POS;

import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.cn.util.JDatePicker;

/**
 * 查询时间面板。  
 * @author Administrator
 *
 */
public class TimeSpinnerPanel extends JPanel {

	private  JDatePicker dataPicker1 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JDatePicker dataPicker2 =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
    
	
	public JDatePicker getDataPicker1() {
		return dataPicker1;
	}
	public JDatePicker getDataPicker2() {
		return dataPicker2;
	}
	public TimeSpinnerPanel(){
		init();
	}
	public void init(){
		this.add(createPanel());
	  
	}
	public JPanel createPanel(){
		JPanel panel  = new JPanel();
	 
		panel.add(dataPicker1);
		//panel.add(timeSpinnerPanel());
		panel.add(new JLabel(" 至 "));
		panel.add(dataPicker2);
		//panel.add(timeSpinnerPanel());
		
		return panel;
	}

	public JPanel timeSpinnerPanel(){
		
		JPanel timeSpinnerPane = new JPanel();
		SpinnerDateModel   model   =   new   SpinnerDateModel();   
	    model.setCalendarField(Calendar.WEEK_OF_MONTH);   
	    JSpinner   spinner   =   new   JSpinner(model);   
	    JSpinner.DateEditor   editor   =   new   JSpinner.DateEditor(spinner,   "HH:mm:ss");   
	    editor.getTextField().setEditable(false);//加上这句.   
	    spinner.setPreferredSize(new Dimension(100,23));
	    spinner.setEditor(editor);   
	  
	    timeSpinnerPane.add(spinner);
	    
	        return timeSpinnerPane;
	}
	//测试类
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,90); 
		frame.add(new TimeSpinnerPanel());
		frame.setVisible(true);
	}
}
