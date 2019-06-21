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
 * 单击商品销售对话框中的修改商品按钮
 * 或双击其上的表格时出现的对话框
 * @author Administrator
 *
 */
public class AlterXiaoShouGoodsDialog extends JDialog {
	
	//父窗口
	  private ShangPinXiaoShouDialog dialog; 
	  //商品编号
	  private JLabel goodId= new JLabel();
	  //商品名称
	  private JLabel goodName= new JLabel();
	  //规格型号
	  private JLabel xingHao= new JLabel();
	  //生产厂商
	  private JLabel changShang= new JLabel();
	  //颜色
	  private JLabel color= new JLabel();
	  //当前库存
	  private JLabel kuCun= new JLabel();
	  //备注
	  private JLabel beiZhu= new JLabel();
	  //单位
	  private JLabel danWei = new JLabel();
	  //参考售价
	  private JTextField canKaoShouJia = new JTextField();
	  //数量
	  private JNumberField shuLiang = new JNumberField();
  //打折率
	  private JTextField daZhe = new JTextField();
	  //折后单价
	  private JLabel danJia = new JLabel(); 
	  //总计金额
	  private JLabel zje = new JLabel();
	  
	  private JButton sure = new JButton("确认");
	  private JButton exit = new JButton("退出");
	  
	 
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
		 * 中间面板组件的布局
		 * @return
		 */
		public JPanel createCenterPanel(){
			JPanel centerPanel = new JPanel();
			centerPanel.setBorder(new TitledBorder("商品信息"));
			centerPanel.setLayout(new BorderLayout());
			
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(4,1,1,10));
			center.setLayout(new GridLayout(5,0,1,10));
			center.add(new JLabel("商品编号:"));
			center.add(goodId);
			center.add(new JLabel("商品名称:"));
			center.add(goodName);
			center.add(new JLabel("规格型号:"));
			center.add(xingHao);
			center.add(new JLabel("单     位:"));
			center.add(danWei);
			center.add(new JLabel("生产厂商:"));
			center.add(changShang);
			center.add(new JLabel("颜      色:"));
			center.add(color);
			center.add(new JLabel("当前库存:"));
			center.add(kuCun);
			center.add(new JLabel("备      注:"));
			center.add(beiZhu);
			
			JPanel south = new JPanel();
			south.setLayout(new GridLayout(2,1));
			Box box1 = Box.createHorizontalBox();
			box1.add(new JLabel("参考售价:"));
			box1.add(canKaoShouJia);

           canKaoShouJia.getDocument().addDocumentListener(
        		  new AlterGoods_DocumentsListener(this) );
			box1.add(new JLabel("元"));
			box1.add(Box.createHorizontalStrut(8));
			box1.add(new JLabel("打折率:"));
			box1.add(daZhe);
			daZhe.getDocument().addDocumentListener(
	        		  new AlterGoods_DocumentsListener(this) );
			box1.add(Box.createHorizontalStrut(8));
			box1.add(new JLabel("数量:"));
			box1.add(shuLiang);
			shuLiang.getDocument().addDocumentListener(
	        		  new AlterGoods_DocumentsListener(this) );
			Box box2 = Box.createHorizontalBox();
			box2.add(new JLabel("折后单价:"));
			box2.add(danJia);
			box2.add(new JLabel("元"));
			box2.add(Box.createHorizontalStrut(100));
			JLabel label = new JLabel("1为不打折,0.8为打八折!");
			label.setForeground(Color.RED);
			box2.add(label);
			box2.add(new JLabel("总计:"));
			box2.add(zje);
		    box2.add(new JLabel("元"));
		    
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
