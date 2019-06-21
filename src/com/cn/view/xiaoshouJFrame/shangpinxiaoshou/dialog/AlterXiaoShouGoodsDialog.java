package com.cn.view.xiaoshouJFrame.shangpinxiaoshou.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AlterGoods_DocumentsListener;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AlterXiaoShouGoodsAction;
import com.cn.control.xiaoshouframe.shangpinxiaoshuo.AlterXiaoShouGoods_SureAction;
import com.cn.util.JNumberField;
import com.cn.view.xiaoshouJFrame.shangpinxiaoshou.ShangPinXiaoShouDialog;
/**
 * ������Ʒ���۶Ի����е��޸���Ʒ��ť
 * ��˫�����ϵı��ʱ���ֵĶԻ���
 * @author Administrator
 *
 */
public class AlterXiaoShouGoodsDialog extends JDialog {
	
	//������
	  private ShangPinXiaoShouDialog dialog; 
	  //��Ʒ���
	  private JLabel goodId= new JLabel();
	  //��Ʒ����
	  private JLabel goodName= new JLabel();
	  //����ͺ�
	  private JLabel xingHao= new JLabel();
	  //��������
	  private JLabel changShang= new JLabel();
	  //��ɫ
	  private JLabel color= new JLabel();
	  //��ǰ���
	  private JLabel kuCun= new JLabel();
	  //��ע
	  private JLabel beiZhu= new JLabel();
	  //��λ
	  private JLabel danWei = new JLabel();
	  //�ο��ۼ�
	  private JTextField canKaoShouJia = new JTextField();
	  //����
	  private JNumberField shuLiang = new JNumberField();
  //������
	  private JTextField daZhe = new JTextField();
	  //�ۺ󵥼�
	  private JLabel danJia = new JLabel(); 
	  //�ܼƽ��
	  private JLabel zje = new JLabel();
	  
	  private JButton sure = new JButton("ȷ��");
	  private JButton exit = new JButton("�˳�");
	  
	 
	  public AlterXiaoShouGoodsDialog(ShangPinXiaoShouDialog dialog,String title){
		  super(dialog,title,true);
		  this.dialog = dialog;
		 this.addWindowListener(new AlterXiaoShouGoodsAction(this));
		  init();
	  }
	  public void init(){
		  JPanel mainPanel = new JPanel();
		  mainPanel.setLayout(new BorderLayout());
		  mainPanel.add(createCenterPanel(),BorderLayout.CENTER);

		  mainPanel.add(initSouthPanel(),BorderLayout.SOUTH);
		  this.add(mainPanel);
		 this.setLocationRelativeTo(null);
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setSize(400,300);
		 this.setVisible(true);
		  
	  }
		/**
		 * �м��������Ĳ���
		 * @return
		 */
		public JPanel createCenterPanel(){
			JPanel centerPanel = new JPanel();
			centerPanel.setBorder(new TitledBorder("��Ʒ��Ϣ"));
			centerPanel.setLayout(new BorderLayout());
			
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(4,1,1,10));
			center.setLayout(new GridLayout(5,0,1,10));
			center.add(new JLabel("��Ʒ���:"));
			center.add(goodId);
			center.add(new JLabel("��Ʒ����:"));
			center.add(goodName);
			center.add(new JLabel("����ͺ�:"));
			center.add(xingHao);
			center.add(new JLabel("��     λ:"));
			center.add(danWei);
			center.add(new JLabel("��������:"));
			center.add(changShang);
			center.add(new JLabel("��      ɫ:"));
			center.add(color);
			center.add(new JLabel("��ǰ���:"));
			center.add(kuCun);
			center.add(new JLabel("��      ע:"));
			center.add(beiZhu);
			
			JPanel south = new JPanel();
			south.setLayout(new GridLayout(2,1));
			Box box1 = Box.createHorizontalBox();
			box1.add(new JLabel("�ο��ۼ�:"));
			box1.add(canKaoShouJia);

           canKaoShouJia.getDocument().addDocumentListener(
        		  new AlterGoods_DocumentsListener(this) );
			box1.add(new JLabel("Ԫ"));
			box1.add(Box.createHorizontalStrut(8));
			box1.add(new JLabel("������:"));
			box1.add(daZhe);
			daZhe.getDocument().addDocumentListener(
	        		  new AlterGoods_DocumentsListener(this) );
			box1.add(Box.createHorizontalStrut(8));
			box1.add(new JLabel("����:"));
			box1.add(shuLiang);
			shuLiang.getDocument().addDocumentListener(
	        		  new AlterGoods_DocumentsListener(this) );
			Box box2 = Box.createHorizontalBox();
			box2.add(new JLabel("�ۺ󵥼�:"));
			box2.add(danJia);
			box2.add(new JLabel("Ԫ"));
			box2.add(Box.createHorizontalStrut(100));
			JLabel label = new JLabel("1Ϊ������,0.8Ϊ�����!");
			label.setForeground(Color.RED);
			box2.add(label);
			box2.add(new JLabel("�ܼ�:"));
			box2.add(zje);
		    box2.add(new JLabel("Ԫ"));
		    
			south.add(box1);
			south.add(box2);
			
			centerPanel.add(center,BorderLayout.CENTER);
			centerPanel.add(south,BorderLayout.SOUTH);
			
			
			return centerPanel;
		}
		
		public JPanel initSouthPanel() {
			JPanel southPanel = new JPanel();
			southPanel.add(sure);
			sure.addActionListener(new AlterXiaoShouGoods_SureAction(this));
			southPanel.add(new JLabel("                    "));
			southPanel.add(exit);
			exit.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
				dispose();
				}
				
			});
			return southPanel;
		}
		
		public JLabel getBeiZhu() {
			return beiZhu;
		}
		public JTextField getCanKaoShouJia() {
			return canKaoShouJia;
		}
		public JLabel getChangShang() {
			return changShang;
		}
		public JLabel getColor() {
			return color;
		}
		public JLabel getDanJia() {
			return danJia;
		}
		public JLabel getDanWei() {
			return danWei;
		}
		public JTextField getDaZhe() {
			return daZhe;
		}
		public ShangPinXiaoShouDialog getDialog() {
			return dialog;
		}
		public JLabel getGoodId() {
			return goodId;
		}
		public JLabel getGoodName() {
			return goodName;
		}
		public JLabel getKuCun() {
			return kuCun;
		}
		public JTextField getShuLiang() {
			return shuLiang;
		}
		public JLabel getXingHao() {
			return xingHao;
		}
		public JLabel getZje() {
			return zje;
		}
		public static void main(String[] args){
			new AlterXiaoShouGoodsDialog(null,"");
		}
}
