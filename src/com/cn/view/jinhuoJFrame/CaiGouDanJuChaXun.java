package com.cn.view.jinhuoJFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.cn.dao.jinhuo.caigoudanju.JDBCCaiGouDanJu;
import com.cn.dao.jinhuo.wanglaizhangwu.JDBCWangLaiZhangWu;
import com.cn.model.AllTableModel;
import com.cn.util.JDatePicker;
import com.cn.view.jinhuoJFrame.columnName.CaiGouDanJuColumnNames;
import com.cn.view.jinhuoJFrame.columnName.ColumnNames;
import com.cn.view.jinhuoJFrame.jdialog.caigoudanjuchaxun.XiangXiChaZhao;



public class CaiGouDanJuChaXun extends JDialog{
	/*
	 * ������
	 */
	private JFrame frame;
//	north ���
	
	private JButton chaKanDanJu = new JButton(new ImageIcon("res/AcionIcon/chakuangdanju.jpg"));
	private JButton zhengDanTuiHuo = new JButton(new ImageIcon("res/AcionIcon/zhengDantuihuo.jpg"));
	private JButton daoChu = new JButton(new ImageIcon("res/AcionIcon/export.jpg"));
	private JButton daYin = new JButton(new ImageIcon("res/AcionIcon/print.jpg"));
//	center ���
	//	ʱ��1
	private JDatePicker chaXunShiJian =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	//	ʱ��2
	private JDatePicker zhi =   new JDatePicker(JDatePicker.STYLE_CN_DATE);
	private JTextField gongHuoShangORdanJuHao = new JTextField(12);
	//��
	private AllTableModel ATM;
	private JTable table1;
	private Vector table1_data = new Vector();//table ����
//	south
	private AllTableModel ATM2;
	private JTable table2;
	private Vector table2_data = new Vector();//table ����
	
	public CaiGouDanJuChaXun(JFrame frame,String title,boolean model){
		super(frame,title,model);
		this.frame = frame;
		init();
	}
	private void init(){
		this.setSize(1000, 630);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);////////////////////////////////////////////////
	
		this.setLayout(new BorderLayout());
		this.add(north(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.add(south(),BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
//	north
	private JPanel north(){
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
		//����button�ڱ߾�
		//�˳�Button
		JButton tuiChu = new JButton(new ImageIcon("res/AcionIcon/exit.jpg"));
		tuiChu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CaiGouDanJuChaXun.this.dispose();
			}
		});
//		//��ϸ����
//		JButton xiangXiChaZhao = new JButton(new ImageIcon("res/AcionIcon/xiangXiChaZhao.jpg"));
//		xiangXiChaZhao.setMargin(new Insets(0,0,0,0));
//		final CaiGouDanJuChaXun argDialog = this;
//		xiangXiChaZhao.addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				new XiangXiChaZhao(argDialog,"��ϸ����",true);
//			}
//			
//		});
		//�����˻�
		zhengDanTuiHuo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i = table1.getSelectedRow();
				if(i == -1){
					JOptionPane.showMessageDialog(null,"��ѡ��ɹ�����!");
					return;
				}
				String danhao = ((Vector)table1_data.get(i)).get(0).toString();
				if(!danhao.matches("CJ.*")){
					JOptionPane.showMessageDialog(CaiGouDanJuChaXun.this,"��ѡ��ɹ��������ݣ���CJ��ͷ!");
					return;
				}
				Vector argdata = JDBCWangLaiZhangWu.getDanJuXiangXi(danhao);
				//˳�򱻴����ˣ�������
				Vector newdata = new Vector();
				for(Object tmp : argdata){
					Vector inner = new Vector();
					inner.add(((Vector)tmp).get(0));
					inner.add(((Vector)tmp).get(1));
					inner.add(((Vector)tmp).get(2));
					inner.add(((Vector)tmp).get(6));
					inner.add(((Vector)tmp).get(7));
					inner.add(((Vector)tmp).get(3));
					inner.add(((Vector)tmp).get(4));
					inner.add(((Vector)tmp).get(5));
					
					newdata.add(inner);
				}
//				������
				String gonghuoshang = ((Vector)table1_data.get(i)).get(2).toString();
				
				//new һ���ɹ��˻�����
			 new CaiGouTuiHuo(frame,"�ɹ��˻�",true,newdata,gonghuoshang);
				
			}
		
			
		});
		chaKanDanJu.setMargin(new Insets(0,0,0,0));
		zhengDanTuiHuo.setMargin(new Insets(0,0,0,0));
		daoChu.setMargin(new Insets(0,0,0,0));
		daYin.setMargin(new Insets(0,0,0,0));
		tuiChu.setMargin(new Insets(0,0,0,0));
		
//		north.add(xiangXiChaZhao);
		north.add(chaKanDanJu);
		north.add(zhengDanTuiHuo);
		north.add(daoChu);
		north.add(daYin);
		north.add(tuiChu);
		north.setBorder(new LineBorder(Color.GRAY,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		
		return north;
	}
// center�ٷֳ�������pane1��pane2
	private JPanel center(){
		JPanel center = new JPanel();
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
	  //pane1
		pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane1.add(new JLabel("��ѯʱ��:"));
		pane1.add(chaXunShiJian);
		pane1.add(new JLabel("��"));
		pane1.add(zhi);
		pane1.add(new JLabel("��������/���ݺŲ�ѯ��"));
		pane1.add(gongHuoShangORdanJuHao);
		//��ѯ��ť
		JButton chaXun = new JButton("��ѯ");
		chaXun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String time1 = chaXunShiJian.getSelectedItem().toString();
				String time2 = zhi.getSelectedItem().toString();
				String gonghuoshang = gongHuoShangORdanJuHao.getText().toString();
				
				table1_data= JDBCCaiGouDanJu.getCaiGou(time1,time2,gonghuoshang);
				
				ATM.setDataVector(table1_data,CaiGouDanJuColumnNames.table1_columnNames);
			}
		});
		pane1.add(chaXun);
		//pane1.setBorder(new LineBorder(Color.GRAY));//��������ָ����ɫ�ͺ�ȵ��߱߿�
	  //pane2
		//��
		ATM = new AllTableModel(table1_data,CaiGouDanJuColumnNames.table1_columnNames);
		table1 = new JTable(ATM);
		table1.addMouseListener(new MouseAdapter(){//���ϲ����ļ�����
			 public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1){
						int i = table1.getSelectedRow();
						String danhao = (String)((Vector)table1_data.get(i)).get(0);
						//table2�ĸ���ˢ��
						table2_data = JDBCCaiGouDanJu.getDanJuXiangXi(danhao);
						ATM2.setDataVector(table2_data,CaiGouDanJuColumnNames.table2_columnNames);
					}
			 }
		});
		
		//���̶���С
		table1.setPreferredScrollableViewportSize(new Dimension(990,280));
		
		pane2.add(new JScrollPane(table1));
	  //center
		center.setLayout(new BorderLayout());
		center.add(pane1,BorderLayout.NORTH);
		center.add(pane2,BorderLayout.CENTER);
		//center.setBorder(new LineBorder(Color.BLACK,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		
		return center;
	}
	
//	south
	private JPanel south(){
		JPanel south = new JPanel();
		
		ATM2 = new AllTableModel(table2_data,CaiGouDanJuColumnNames.table2_columnNames);
		table2= new JTable(ATM2);
		table2.setPreferredScrollableViewportSize(new Dimension(990,130));//���̶���С
		
		south.setLayout(new FlowLayout(FlowLayout.LEFT));
		south.add(new JLabel("���ݵ���ϸ��Ϣ:"));
		south.add(new JScrollPane(table2),BorderLayout.CENTER);//��һ��������
		//south.setBorder(new LineBorder(Color.BLACK,1));//��������ָ����ɫ�ͺ�ȵ��߱߿�
		
		
		return south;
	}
	
	public static void main(String[] args){
		new CaiGouDanJuChaXun((JFrame)null,"�ɹ����ݲ�ѯ",true);
	}
}
