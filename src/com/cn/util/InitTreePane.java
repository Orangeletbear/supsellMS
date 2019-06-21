package com.cn.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.cn.dao.system.OperatorDB;
import com.cn.dao.toolbar.JDBCCuCunFind;
import com.cn.model.kuchun.KunCunDefaultTreeCellRenderer;
import com.cn.view.systemJFrame.OperatorSet;
/**
 * ���ֿ�������
 * @author Administrator
 *
 */
public class InitTreePane extends JPanel {
	
	private JPanel pane;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private JPopupMenu popMenu = new JPopupMenu();
	
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}
	public JPanel getPane(){
		return pane;
	}
	/**
	 * @param tree
	 */
	public InitTreePane(JTree tree){
		
		pane = new JPanel();
		//pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.setLayout(new BorderLayout());
		
		String [] getLbName = JDBCCuCunFind.getSpLbData();
	    DefaultMutableTreeNode root = new DefaultMutableTreeNode("�������");
		
		DefaultMutableTreeNode lbName[] = new DefaultMutableTreeNode[getLbName.length];
		for(int i = 0;i<getLbName.length;i++){
			lbName[i] = new  DefaultMutableTreeNode(getLbName[i]);
			root.add(lbName[i]);
		}
	
	    treeModel = new DefaultTreeModel(root);
	    
	    tree = new JTree(treeModel);
	    
	    KunCunDefaultTreeCellRenderer render = new KunCunDefaultTreeCellRenderer();
	    
	    tree.setCellRenderer(render);
	    
	    tree.setCellEditor(new DefaultTreeCellEditor(tree, render) {
	        
	    });
	    tree.setSize(200, 800);
	    pane.add(tree);
	    
	    this.tree = tree;
	    tree.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				JTree tree = getTree();
			    int x = e.getX();
			    int y = e.getY();
			    TreePath path = tree.getPathForLocation(x, y);
			    if(path == null) return;
			    tree.setSelectionPath(path);
			    if(e.getButton() == MouseEvent.BUTTON3) {
			    	popMenu.show(tree, x, y);
			    }
			}
	    });
	    //���ж�ѡ��״̬
	    tree.setSelectionRow(0);
	    pane.setBorder(new LineBorder(Color.gray));
	    pane.setBackground(Color.white);
	    initPopupMenu();
	}
	
	private void initPopupMenu(){
		OperatorLBAction l = new OperatorLBAction(this);
		
		JMenuItem addLB = new JMenuItem("�������");
		JMenuItem deleLB = new JMenuItem("ɾ�����");
		JMenuItem atlerLB = new JMenuItem("�޸����");
		
		popMenu.add(addLB);
		popMenu.add(deleLB);
		popMenu.add(atlerLB);
		
		addLB.addActionListener(l);
		deleLB.addActionListener(l);
		atlerLB.addActionListener(l);
		
		
		
		
		
	}
	public JTree getTree() {
		return tree;
	}
	
	/**
	 * ���ɾ�����޸ģ����ӵļ�����
	 * @author finey
	 *
	 */
	class OperatorLBAction implements ActionListener{
		
		private InitTreePane pane;
		
		OperatorLBAction(InitTreePane pane){
			this.pane = pane;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getActionCommand().equals("�������")){
				new AddDialog("�������",false);
			}
			if(arg0.getActionCommand().equals("ɾ�����")){
				
				int choice =  JOptionPane.showConfirmDialog(
						null, "�Ƿ�ɾ��������Ʒ��","ɾ������",
		        		 JOptionPane.YES_NO_OPTION, 1);
		          //��ȷ��ɾ������
			     if(choice == JOptionPane.YES_OPTION){

			    	 JTree tree = getTree();

					    DefaultTreeModel mode = (DefaultTreeModel)tree.getModel();
					    
					    DefaultMutableTreeNode parent = (DefaultMutableTreeNode )(mode.getRoot());
					    
					    DefaultMutableTreeNode deleNoder = 
					    	(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					    
					    mode.removeNodeFromParent(deleNoder);
					    //�������ݿ�
			            SPLBOperator.deleSPLB(deleNoder.getUserObject().toString());
			     }
			}
			if(arg0.getActionCommand().equals("�޸����")){
				new AddDialog("�޸����",true);
				
			}
		}
		
	}
	/**
	 * �����޸����Ի���
	 * @author finey
	 *
	 */
	class AddDialog extends JDialog{
		
		private JTextField lbName = new JTextField(15);
		private JButton btnConfirm = new JButton("ȷ��");
		private boolean isChange;
		
		public JTextField getLbName() {
			return lbName;
		}

		public boolean isChange() {
			return isChange;
		}

		AddDialog(String title,boolean isChange){
			super((JDialog)null,title,true);
			this.isChange = isChange;
			init();
		
		
		}
		
		private void init() {
		    this.setSize(200, 100);
		    this.setLocationRelativeTo(null);
		    JPanel pane = new JPanel();
		    pane.add(lbName);
		    pane.add(btnConfirm);
		    btnConfirm.addActionListener(
		    	new AddTreeNodeActionListener(this));
		    this.getContentPane().add(pane);
		    this.setVisible(true);
		  }

		  public JTextField getLBName() {
		    return lbName;
		  }
	}
	/**
	 * ���ӽ�������
	 * @author Administrator
	 *
	 */
	class AddTreeNodeActionListener implements ActionListener {
		
		  private AddDialog frame;
		  public AddTreeNodeActionListener(AddDialog frame) {
	
		      this.frame = frame;
			 
		  }
		  public void actionPerformed(ActionEvent e) {
			  if(!frame.isChange){
				    JTree tree = getTree();
				    String lbName = frame.getLBName().getText();
				    DefaultTreeModel mode = (DefaultTreeModel)tree.getModel();
				    
				    DefaultMutableTreeNode parent = (DefaultMutableTreeNode )(mode.getRoot());
				    
				    DefaultMutableTreeNode node = new DefaultMutableTreeNode(lbName);
				    
				    //��ָ��λ�ò���һ���Ĭ�����
				    mode.insertNodeInto(node, parent, parent.getChildCount());
				    //д�����ݿ�
				    SPLBOperator.addSPLB(lbName);
				    frame.dispose();
			  }else{
				    TreePath   treePath   =   tree.getSelectionPath(); 
		            DefaultMutableTreeNode   node1   =   (DefaultMutableTreeNode)   treePath.getLastPathComponent(); 
		            //ԭ��������
		            String sName = node1.getUserObject().toString();
		            String mbName = frame.getLbName().getText();
		            
		            //���� 
		            node1.setUserObject(mbName); 
		            DefaultTreeModel   treeModel   =   (DefaultTreeModel)   tree.getModel(); 
		            //ˢ�� 
		            treeModel.reload(); 
		            //����ѡ��֧ 
		            tree.setSelectionPath(treePath); 
		            //�������ݿ�
		            SPLBOperator.atlerSPLB(sName, mbName);
		            frame.dispose();
		            
			  }
		  
		  }

		}
}
/**
 * ��Ʒ���Ĳ���
 * @author finey
 *
 */

class SPLBOperator {
	/*
	 * ������Ʒ���
	 */
	public static void addSPLB(String lbName){
		
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		ResultSet  rs = null;
		try {
			st = conn.createStatement();
			rs= st.executeQuery("select * from tb_sblb");
			String lbID = null;
			while(rs.next()){
				lbID = rs.getString(1);
			}
			
			int lb = new Integer(lbID).intValue();
			
			String tmpLb = new String((lb+1)+"");
			String sql = "insert into tb_sblb values('"+tmpLb+"','"+lbName+"' )";
			
			rs= st.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			
		} finally{
			JDBCTool.freeResorse(rs, st, conn);
		}

	}
	/*
	 * �޸���Ʒ�����
	 */
	public static void atlerSPLB(String from,String to){
		
		String sql = "update tb_sblb lb set lb.sblb_name = '"+to+"'" +
				"where lb.sblb_name ='"+from+"'";
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		try {
			st = conn.createStatement();
	       st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			
		} finally{
			JDBCTool.freeResouse(st, conn);
		}
	}
	/*
	 * ɾ����Ʒ���
	 */
	public static void deleSPLB(String lbName){
		String sql = "delete tb_sblb lb where lb.sblb_name ='"+lbName+"'";
    	
    	Connection conn = JDBCTool.getConnection();
	    Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿⷢ�����󣬳�ʼ��ʧ��!");
			
		} finally{
			JDBCTool.freeResouse(st, conn);
		}
	}
	
	
}


