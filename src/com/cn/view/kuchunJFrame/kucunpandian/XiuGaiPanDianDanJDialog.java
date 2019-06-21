package com.cn.view.kuchunJFrame.kucunpandian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cn.dao.kuchun.kucundiaobo.kucundiaobodan.addshangpin.AddShangPinDataToView;
import com.cn.model.AllTableModel;
import com.cn.model.kuchun.KCDBModel;
import com.cn.model.kuchun.KCPDModel;
import com.cn.model.kuchun.GongYong.AddSanPingCulomns;
import com.cn.util.JDatePicker;

/**
 * 
 * �޸��̵㵥����
 * @author Administrator
 *
 */
public class XiuGaiPanDianDanJDialog extends JDialog {
		
		private JLabel labelPDDH;//�̵㵥��
		private JComboBox comboPDCK;//�̵�ֿ�
		private JDatePicker datePDRQ;//�̵�����
		private JLabel labelCZY;//����Ա
		private JLabel labelBZ;//��ע
		
		private JTextField textSPBH;//��Ʒ���
		private JButton btnYes;//ȷ����ť
		private JTable tableSPQD;//��Ʒ�嵥
		private AllTableModel tableModelSPQD;//��Ʒ�嵥
		private Vector voKCSP;//�̵�����Ʒ��������
		private Vector veKCSP;//�̵�����Ʒ����
		
		private JButton btnXG;//�޸�
		private JButton btnSC;//ɾ��
		private JButton btnOK;//ȷ��
		private JButton btnExit;//�˳�
		private JTable tableYPSP;//��Ʒ�嵥
		private AllTableModel tableModelYPSP;//��Ʒ�嵥
		private Vector voYPSP;//�̵�����Ʒ��������
		private Vector veYPSP;//�̵�����Ʒ����
		
		
		public XiuGaiPanDianDanJDialog(JDialog dialog,String title,boolean b){
			super(dialog,title,b);
			init();
//			addGetDatas(this.comboPDCK.getSelectedItem().toString());
		}
////////////////////
		public JComboBox getComboPDCK() {
			return comboPDCK;
		}

		//��ʼ�������Ʒͬʱ��ѡ��ֿ�����Ʒ��Ϣ��ѯ����
		
		
		////////////��ָ���쳣
		///////////����������Vector�ı�����г�����һ�������
		private void addGetDatas(String name){
     		Vector datas = null ;//= AddShangPinDataToView.dataToView(name);
			Vector columns = AllTableModel.getVectorFromObj(AddSanPingCulomns.ColumnName1);
			
//			for(int i = 1; i < datas.size(); i ++){
//				System.out.println(datas.get(i));
//			}
//			for(int i = 00; i < columns.size(); i ++){
//				System.out.println(columns.get(i));
//			}
			tableModelSPQD.setDataVector(datas, columns);
//			tableSPQD.setRowSelectionInterval(0, 0);
		}
		private void init(){
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.add(addCom());
//			this.setVisible(true);
		}
		
		private JPanel addCom(){
			JPanel jpanel = new JPanel();
			jpanel.setLayout(new BorderLayout());
			{
				jpanel.add(addNor(),BorderLayout.NORTH);
				jpanel.add(addCen(),BorderLayout.CENTER);
			}
			return jpanel;
		}

		/*
		 * �в�
		 */
		private JPanel addNor(){
			JPanel norJpanel = new JPanel();
			norJpanel.setLayout(new GridLayout(3,1));
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			JPanel jpanel3 = new JPanel();

			JLabel label1 = new JLabel("�̵㵥�� ��");
			JLabel label2 = new JLabel("�̵�ֿ� ��");
			JLabel label3 = new JLabel("�̵����� ��");
			JLabel label4 = new JLabel("�� �� Ա��");
			JLabel label5 = new JLabel("��    ע��");
			JLabel label6 = new JLabel("��ʾ���̵��в��ܸ����ֿ�����ڡ�" +
					"��û���������֮ǰ�����ǲɹ����������۵��ܸı��������Ĳ�������Ȼ����ɿ�������Ĳ�׼��");
			
			{
				labelPDDH = new JLabel("PD101028100001");
				labelPDDH.setForeground(Color.RED);
				comboPDCK = new JComboBox(KCDBModel.itemsCK);
				comboPDCK.setEnabled(false);
				datePDRQ = new JDatePicker();
				datePDRQ.setEnabled(false);
				labelCZY = new JLabel("admin");
				labelBZ = new JLabel("_____________________________________");
			}
			{
				jpanel1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
				jpanel1.add(label1);
				jpanel1.add(labelPDDH);
				jpanel1.add(label2);
				jpanel1.add(comboPDCK);
				jpanel1.add(label3);
				jpanel1.add(datePDRQ);
				jpanel1.add(label4);
				jpanel1.add(labelCZY);
			}
			
			{
				jpanel2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
				jpanel2.add(label5);
				jpanel2.add(labelBZ);
			}
			
			{
				label6.setForeground(Color.RED);
				jpanel3.add(label6);
			}
			
			{
				norJpanel.add(jpanel1);
				norJpanel.add(jpanel2);
				norJpanel.add(jpanel3);
			}
			
			norJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�̵���Ϣ"));
			return norJpanel;
		}
		
		/*
		 * �в�
		 * �м䲿�ַ�Ϊ������������
		 */
		private JPanel addCen(){
			JPanel cenJpanel = new JPanel();
			cenJpanel.setLayout(new GridLayout(1,2));
			{
				cenJpanel.add(addLeft());
				cenJpanel.add(addRight());
			}
			return cenJpanel;
		}
		
		/*
		 * ���
		 */
		private JPanel addLeft(){
			JPanel leftJpanel = new JPanel();
			leftJpanel.setLayout(new BorderLayout());
				
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			
			tableModelSPQD = new AllTableModel();
			tableSPQD = new JTable(tableModelSPQD);
			
			JLabel label = new JLabel("��Ʒ���");
			textSPBH = new JTextField(10);
			btnYes =new JButton("ȷ   ��");
			
			{
				jpanel1.add(label);
				jpanel1.add(textSPBH);
				jpanel1.add(btnYes);
			}
			
			{
				voKCSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataKCSP);
				veKCSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsKCSP);
				createTable(jpanel2,tableSPQD,tableModelSPQD,voKCSP,veKCSP);
			}
			
			{
				leftJpanel.add(jpanel1,BorderLayout.NORTH);
				leftJpanel.add(jpanel2,BorderLayout.CENTER);
			}
			leftJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"�����Ʒ"));
			return leftJpanel;
		}
		
		/*
		 * �ұ�
		 */
		private JPanel addRight(){
			JPanel rightJpanel = new JPanel();
			rightJpanel.setLayout(new BorderLayout());
			
			JPanel jpanel1 = new JPanel();
			JPanel jpanel2 = new JPanel();
			
			jpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
			btnXG = new JButton("�޸�");
			btnSC = new JButton("ɾ��");
			btnOK = new JButton("ȷ��");
			btnExit = new JButton("�˳�");
			{
				btnExit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						XiuGaiPanDianDanJDialog.this.dispose();
					}
				});
			}
			{
				jpanel1.add(btnXG);
				jpanel1.add(btnSC);
				jpanel1.add(btnOK);
				jpanel1.add(btnExit);
			}
			
			{
				voYPSP = AllTableModel.getVectorDataFromObj(KCPDModel.dataYPSP);
				veYPSP = AllTableModel.getVectorFromObj(KCPDModel.colunmsYPSP);
				createTable(jpanel2,tableYPSP,tableModelYPSP,voYPSP,veYPSP);
			}
			
			{
				rightJpanel.add(jpanel1,BorderLayout.NORTH);
				rightJpanel.add(jpanel2,BorderLayout.CENTER);
			}
			rightJpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1),"������Ʒ"));
			return rightJpanel;
		}
		
		/*
		 * �˷����Ǵ���table���
		 * 
		 */
		private void createTable(JPanel jpanel,JTable table,
			AllTableModel tableModel,Vector data,Vector colunms){
			
			tableModel = new AllTableModel(data,colunms);
			table = new JTable(tableModel);
			table.setAutoCreateRowSorter(true); //������ñ���Զ�����
			table.setPreferredScrollableViewportSize(new Dimension(380,400));
			JScrollPane scroPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroPane.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
			jpanel.add(scroPane);
		}
		
		/**
		 * @param args
		 */
/*		public static void main(String[] args) {
			new XinZengPanDianDanJDialog(null,"¼���̵���Ʒ",true);
		}*/
}
