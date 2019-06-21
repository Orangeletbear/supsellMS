package com.cn.view.systemJFrame.XiTongWeiHu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * 年结算图表对话框
 * @author finey
 *
 */
public class YearCountChart extends JDialog {    
         
	private NianZhongJieSuanDialog frame;
	private float [] chartData;
	private int[] numData;
	
	public YearCountChart(NianZhongJieSuanDialog dialog,
			String title,int[] numdata,float [] data){
	    
		super(dialog,title,true);
		this.chartData = data;
		this.numData= numdata;
		this.frame = dialog;
		init();
	}
	
	public void init(){
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(cretePane());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private JPanel cretePane(){
		
	 JPanel allPane = new JPanel();	
     
      allPane.setLayout(new GridLayout(2,1));
      allPane.add(createChartNum());
      allPane.add(createChartMoney());

	  return allPane;
		
	}
	/**
	 * 数字图表
	 * @return
	 */
    private JPanel createChartNum(){
    	
        JPanel pane = new JPanel();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        String spName = "各       商      品      销      售       数      量     情      况";
        
        dataset.addValue(numData[0], "采购数", spName);
        dataset.addValue(numData[1], "采购退货数", spName);
        dataset.addValue(numData[2], "采购合计", spName);    
        
        dataset.addValue(numData[3], "销售单数", spName);
        dataset.addValue(numData[4], "销售退货数", spName);
        dataset.addValue(numData[5], "销售合计", spName);    
        
        
        dataset.addValue(numData[6], "调拔单数", spName);  
        dataset.addValue(numData[7], "调拔数量", spName);  
        
        dataset.addValue(numData[8], "报损单数", spName);  
        dataset.addValue(numData[9], "报损数量", spName);  
        
        dataset.addValue(numData[10], "报溢单数", spName);  
        dataset.addValue(numData[11], "报溢数量", spName);  
        /*   
        	把PlotOrientation.VERTICAL改成PlotOrientation.HORIZONTAL，柱状图变成了水平。   
           
        	使用createBarChart3D就会生成三维柱状图。   
           
        */   
        JFreeChart chart = ChartFactory.createBarChart3D(    
                "年终--各数量结算--图表",                    // 标题    
                "商品总汇",                      // 横轴名称    
                "商品数量",                     // 纵轴名称    
                dataset,                    // 数据    
                PlotOrientation.VERTICAL,   // 使用垂直柱状图    
                true,                       // 是否使用legend    
                false,                      // 是否使用tooltip    
                false                       // 是否使用url链接    

                );    
        
        chart.getTitle().setFont(new Font("黑体", Font.BOLD,16));
        //chart.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
        /*------这句代码解决了底部汉字乱码的问题-----------*/ 
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 14)); 
        
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        
        domainAxis.setTickLabelFont(new Font("黑体", Font.BOLD,14));
        //X标题
        domainAxis.setLabelFont(new Font("黑体", Font.BOLD,14));
        
        
        ValueAxis numberaxis = chart.getCategoryPlot().getRangeAxis(); 
        numberaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 14));  
        numberaxis.setLabelFont(new Font("黑体", Font.BOLD, 14));  
        
        CategoryPlot plot = chart.getCategoryPlot();//获得图表区域对象
        
        
        //设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis
        //domainAxis.setLowerMargin(0.1);//设置距离图片左端距离此时为10%
        //domainAxis.setUpperMargin(0.1);//设置距离图片右端距离此时为百分之10
        domainAxis.setCategoryLabelPositionOffset(10);//图表横轴与标签的距离(10像素)
        domainAxis.setCategoryMargin(0.2);//横轴标签之间的距离20%
        //domainAxis.setMaximumCategoryLabelLines(1);
        //domainAxis.setMaximumCategoryLabelWidthRatio(0);

        //设定柱子的属性
        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.1);//设置最高的一个柱与图片顶端的距离(最高柱的10%)
        
        
      //设置图表的颜色
        org.jfree.chart.renderer.category.BarRenderer3D renderer;
        renderer = new org.jfree.chart.renderer.category.BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.red);
        renderer.setSeriesPaint(0, new Color(0, 255, 255));//计划柱子的颜色为青色
        renderer.setSeriesOutlinePaint(0,Color.BLACK);//边框为黑色
        renderer.setSeriesPaint(1, new Color(0, 255, 0));//实报柱子的颜色为绿色
        renderer.setSeriesOutlinePaint(1,Color.red);//边框为红色
        renderer.setItemMargin(0.25);//组内柱子间隔为组宽的10%
        //显示每个柱的数值，并修改该数值的字体属性
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelFont(new Font("黑体",Font.BOLD,12));//12号黑体加粗
        renderer.setItemLabelPaint(Color.black);//字体为黑色
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);//使用我们设计的效果
   	  pane.setLayout(new BorderLayout());	 
   	  pane.add(new ChartPanel(chart));
   	  pane.setBorder(new TitledBorder("商品各数量统计"));
   	  return pane;
    }
    /**
	 * 金钱图表
	 * @return
	 */
    private JPanel createChartMoney(){
    	
        JPanel pane = new JPanel();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        String spName = "各       商      品      收      入      支       出       情      况";
        
        dataset.addValue(numData[2], "采购合计", spName);
        dataset.addValue(chartData[0], "采购总金额", spName);   
        
        dataset.addValue(numData[5], "销售合计", spName);
        dataset.addValue(chartData[1], "销售总金额", spName);
     
         
        
        dataset.addValue(numData[9], "报损数量", spName);  
        dataset.addValue(chartData[2], "报损总金额", spName);  
        
        dataset.addValue(numData[11], "报溢数量", spName);  
        dataset.addValue(chartData[3], "报溢总金额", spName);  
        /*   
        	把PlotOrientation.VERTICAL改成PlotOrientation.HORIZONTAL，柱状图变成了水平。   
           
        	使用createBarChart3D就会生成三维柱状图。   
           
        */   
        JFreeChart chart = ChartFactory.createBarChart3D(    
                "年终--收入结算--图表",                    // 标题    
                "商品总汇",                      // 横轴名称    
                "商品数量金额",                     // 纵轴名称    
                dataset,                    // 数据    
                PlotOrientation.VERTICAL,   // 使用垂直柱状图    
                true,                       // 是否使用legend    
                false,                      // 是否使用tooltip    
                false                       // 是否使用url链接    

                );    
        
        chart.getTitle().setFont(new Font("黑体", Font.BOLD,16));
        //chart.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
        /*------这句代码解决了底部汉字乱码的问题-----------*/ 
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 14)); 
        
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        
        domainAxis.setTickLabelFont(new Font("黑体", Font.BOLD,14));
        //X标题
        domainAxis.setLabelFont(new Font("黑体", Font.BOLD,14));
        
        
        ValueAxis numberaxis = chart.getCategoryPlot().getRangeAxis(); 
        numberaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 14));  
        numberaxis.setLabelFont(new Font("黑体", Font.BOLD, 14));  
        
        CategoryPlot plot = chart.getCategoryPlot();//获得图表区域对象
        
        
        //设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis
        //domainAxis.setLowerMargin(0.1);//设置距离图片左端距离此时为10%
        //domainAxis.setUpperMargin(0.1);//设置距离图片右端距离此时为百分之10
        //domainAxis.setCategoryLabelPositionOffset(10);//图表横轴与标签的距离(10像素)
        //domainAxis.setCategoryMargin(0.2);//横轴标签之间的距离20%
        //domainAxis.setMaximumCategoryLabelLines(1);
        //domainAxis.setMaximumCategoryLabelWidthRatio(0);

        //设定柱子的属性
        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.1);//设置最高的一个柱与图片顶端的距离(最高柱的10%)
        
        
      //设置图表的颜色
        org.jfree.chart.renderer.category.BarRenderer3D renderer;
        renderer = new org.jfree.chart.renderer.category.BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.red);
        renderer.setSeriesPaint(0, new Color(0, 255, 255));//计划柱子的颜色为青色
        renderer.setSeriesOutlinePaint(0,Color.BLACK);//边框为黑色
        renderer.setSeriesPaint(1, new Color(0, 255, 0));//实报柱子的颜色为绿色
        renderer.setSeriesOutlinePaint(1,Color.red);//边框为红色
        renderer.setItemMargin(0.3);//组内柱子间隔为组宽的10%
        //显示每个柱的数值，并修改该数值的字体属性
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelFont(new Font("黑体",Font.BOLD,12));//12号黑体加粗
        renderer.setItemLabelPaint(Color.black);//字体为黑色
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);//使用我们设计的效果
        
   	  pane.setLayout(new BorderLayout());	 
   	  pane.add(new ChartPanel(chart));
   	  pane.setBorder(new TitledBorder("商品金额统计"));
   	  return pane;
    }
    
    public static void main(String [] args){
    	new YearCountChart(null,"",new int[]{},new float[]{});
    }
   
}   

