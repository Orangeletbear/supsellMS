package com.cn.view.systemJFrame.Operator.privateTree;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;
/**
 * Ȩ������ѡ��ͼƬ��ʾ
 * @author finey
 *
 */
public class PrivateTreeDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	public PrivateTreeDefaultTreeCellRenderer() {
	}
	//�ر�ʱ���ͼ��
	public Icon getClosedIcon() {
        return new ImageIcon("res/smallIcon/private1.png");
      }
      //�ڵ��ʱ���ͼ��
      public Icon getOpenIcon() {
        return new ImageIcon("res/smallIcon/private1.png");
      }
      //Ҷ�ӽ���ͼ��
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
