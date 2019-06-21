package com.cn.view.xiaoshouJFrame.table;

import java.util.Vector;

public class TableDataVO {
  private Vector data;
  
  //private TableDataVO tableDataVO;
  
  private TableDataVO() {}
  
  public static TableDataVO getInstance() {
	  
    return new TableDataVO();
  }
  
  /**
   * @return Returns the data.
   */
  public Vector getData() {
    return data;
  }

  /**
   * @param data The data to set.
   */
  public void setData(Vector data) {
    this.data = data;
  }
  
}
