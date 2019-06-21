package com.cn.view.systemJFrame.Operator.privateTree;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;
/**
 * 权限树的选择图片显示
 * @author finey
 *
 */
public class PrivateTreeDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	public PrivateTreeDefaultTreeCellRenderer() {
	}
	//关闭时候的图标
	public Icon getClosedIcon() {
        return new ImageIcon("res/smallIcon/private1.png");
      }
      //节点打开时候的图标
      public Icon getOpenIcon() {
        return new ImageIcon("res/smallIcon/private1.png");
      }
      //叶子结点的图标
      public Icon getLeafIcon() {
        return new ImageIcon("res/smallIcon/user.png");
      }
      
      public Font getFont() {
        return new Font(Font.SANS_SERIF, Font.BOLD, 15);
      }
      
      public Color getBorderSelectionColor() {
        return Color.gray;
      }
      
      public Color getBackgroundSelectionColor() {
        return Color.gray;
      }
}
