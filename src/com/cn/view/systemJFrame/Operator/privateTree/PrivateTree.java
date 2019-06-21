package com.cn.view.systemJFrame.Operator.privateTree;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.cn.view.systemJFrame.Operator.privateTree.jtreecheck.CheckTreeManager;

public class PrivateTree {
	// 加载权限树的滚动面板
	private JScrollPane treeScrollPane;

	private CheckTreeManager checkTreeManager;
	private JTree rightTree;
	
    private JPanel treePane = new JPanel();

    
    //选择树的初始化
	public PrivateTree() {
		treePane.setLayout(new BorderLayout());
		treePane.add(createTreeScrollPane());
		
	}
	
	public JTree getRightTree() {
	  return rightTree;
	}
	
	public JScrollPane getTreeScrollPane() {
		return treeScrollPane;
	}

	public  JPanel getTreePane() {	
		
		return treePane;
	}

	/**
	 * 创建中部滚动面板，用于加载树
	 * 
	 * @return
	 */
	private JScrollPane createTreeScrollPane() {
		if (treeScrollPane == null) {
			treeScrollPane = new JScrollPane();
			//rightTree = new RightTree().createTree();
			checkTreeManager = new CheckTreeManager(rightTree = new RightTree()
					.createTree());
			treeScrollPane.setViewportView(rightTree);
		}
		return treeScrollPane;
	}

	public CheckTreeManager getCheckTreeManager() {
		return checkTreeManager;
	}

}
