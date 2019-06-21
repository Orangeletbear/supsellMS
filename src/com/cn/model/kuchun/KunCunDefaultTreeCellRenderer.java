package com.cn.model.kuchun;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;

public class KunCunDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	public KunCunDefaultTreeCellRenderer() {
	}
	//�ر�ʱ���ͼ��
	public Icon getClosedIcon() {
        return new ImageIcon("res/smallIcon/fileclose.png");
      }
      //�ڵ��ʱ���ͼ��
      public Icon getOpenIcon() {
        return new ImageIcon("res/smallIcon/fileopen.png");
      }
      //Ҷ�ӽ���ͼ��
      public Icon getLeafIcon() {
        return new ImageIcon("res/smallIcon/fileopen3.png");
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
