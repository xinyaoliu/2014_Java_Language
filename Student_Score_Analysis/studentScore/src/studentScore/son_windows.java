package studentScore;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import studentScore.main_windows.main_running_Jpanel;

public class son_windows extends JFrame{
	private int bujige_number = 0;private double bujige_number_1 = 0;
	private int jige_number = 0;private double jige_number_1 = 0;
	private int zhongdeng_number = 0;private double zhongdeng_number_1 = 0;
	private int lianghao_number = 0;private double lianghao_number_1 = 0;
	private int youxiu_number = 0;private double youxiu_number_1 = 0; 
	private int[] a = new int[100];
	private DecimalFormat df=new DecimalFormat(".##");
	private main_windows tc;
	private int arc1;
	private int arc2;
           public son_windows(main_windows t1)
           {
        	   this.tc = t1;
        	   for(int i=1;i<=tc.getarraylist_score().size();i++)
           	{
           		a[i-1] = Integer.valueOf((String) tc.getarraylist_score().get(i-1)).intValue();
           	}
        	   for(int i = 0;i<tc.getarraylist_score().size();i++)
           	{if(a[i]<60)bujige_number++;
           	else if(a[i]<70)jige_number++;
           	else if(a[i]<80)zhongdeng_number++;
           	else if(a[i]<90)lianghao_number++;
           	else youxiu_number++;
           	}
           	 bujige_number_1 = bujige_number*100/tc.getarraylist_score().size();
           	 jige_number_1 = jige_number*100/tc.getarraylist_score().size();
           	 zhongdeng_number_1 = zhongdeng_number*100/tc.getarraylist_score().size();
           	 lianghao_number_1 = lianghao_number*100/tc.getarraylist_score().size();
           	 youxiu_number_1 = youxiu_number*100/tc.getarraylist_score().size();
          
           	 draw_Jpanel p1 = new draw_Jpanel();
            setSize(600,600);
            setLocationRelativeTo(null);        
            setVisible(true);
            add(p1);
           }
           
           class draw_Jpanel extends JPanel {
        	   public draw_Jpanel()
        	   {       		   
        	   }
        	   protected void paintComponent(Graphics g)
        	   {     		   
        		   //柱
        		  g.drawString("人数",30,350+5);
        		  //g.drawString("25",30,380+5);
        		  g.drawString("10",30,410+5);
        		  //g.drawString("15",30,440+5);
        		  g.drawString("5",30,470+5);
        		  //g.drawString("5",30,500+5);
        		  g.drawString("0",30,530+5);
        		  g.drawRect(50,380,500, 30);
        		  g.drawRect(50,410,500, 30);
        		  g.drawRect(50,440,500, 30);
        		  g.drawRect(50,470,500, 30);
        		  g.drawRect(50,500,500, 30);
        		  g.setColor(Color.BLUE);
        		  
        		  if(bujige_number!=0)
        		  {
        			  g.fillRect(108,530-18*bujige_number,30,18*bujige_number);
        		  }
        		  if(jige_number!=0)
        		  {
        			  g.fillRect(108+88,530-18*jige_number,30,18*jige_number);
        		  }
        		  if(zhongdeng_number!=0)
        		  {
        			  g.fillRect(108+88*2,530-18*zhongdeng_number,30,18*zhongdeng_number);
        		  }
        		  if(lianghao_number!=0)
        		  {
        			  g.fillRect(108+88*3,530-18*lianghao_number,30,18*lianghao_number);
        		  }
        		  if(youxiu_number!=0)
        		  {
        			  g.fillRect(108+88*4,530-18*youxiu_number,30,18*youxiu_number);
        		  }
        		  
        		  g.drawString("<60",108,550);
        		  g.drawString("60-69",108+88,550);
        		  g.drawString("70-79",108+88*2,550);
        		  g.drawString("80-89",108+88*3,550);
        		  g.drawString("90-100",108+88*4,550);
        		  g.setColor(Color.black);
        		 
        		  
        		  //餅
        		  g.setFont(new Font("SansSerif",Font.BOLD,36));
        		  g.drawString("成绩百分比",200,55);
        		
        		  g.setColor(Color.red);
        		  g.fillArc(80,130,150,150,0,bujige_number*360/tc.getarraylist_score().size());
        		  arc1 = bujige_number*360/tc.getarraylist_score().size();
        		  arc2 = arc1+jige_number*360/tc.getarraylist_score().size();
        		  g.setColor(Color.blue);
        		  g.fillArc(80,130,150,150,arc1,jige_number*360/tc.getarraylist_score().size());
        		  System.out.println(arc1);
        		  arc1 = arc2;
        		  arc2+=zhongdeng_number*360/tc.getarraylist_score().size();
        		  g.setColor(Color.gray);
        		  g.fillArc(80,130,150,150,arc1,zhongdeng_number*360/tc.getarraylist_score().size());
        		  arc1 = arc2;
        		  arc2+=lianghao_number*360/tc.getarraylist_score().size();
        		  g.setColor(Color.yellow);
        		  g.fillArc(80,130,150,150,arc1,lianghao_number*360/tc.getarraylist_score().size());
        		  arc1 = arc2;
        		  g.setColor(Color.green);
        		  g.fillArc(80,130,150,150,arc1,360-arc1);
        		  g.setColor(Color.black);
        		  g.drawRect(430,150-15,120,150);
        		  g.setColor(Color.red);
        		  g.fillRect(440,150+8-15,20,20);
        		  g.setColor(Color.blue);
        		  g.fillRect(440,150+28*2-20-15,20,20);
        		  g.setColor(Color.gray);
        		  g.fillRect(440,150+28*3-20-15,20,20);
        		  g.setColor(Color.yellow);
        		  g.fillRect(440,150+28*4-20-15,20,20);
        		  g.setColor(Color.green);
        		  g.fillRect(440,150+28*5-20-15,20,20);
        		  g.setColor(Color.black);
        		  g.setFont(new Font("SansSerif",Font.BOLD,12));
        		  g.drawString("<60"+"  "+df.format(bujige_number_1)+"%",470,150+8+15-15);
        		  g.drawString("60-69"+"  "+df.format(jige_number_1)+"%",470,150+28*2-20+10+5-15);
        		  g.drawString("70-79"+"  "+df.format(zhongdeng_number_1)+"%",470,150+28*3-20+10+5-15);
        		  g.drawString("80-89"+"  "+df.format(lianghao_number_1)+"%",470,150+28*4-20+10+5-15);
        		  g.drawString(">=90"+"  "+df.format(youxiu_number_1)+"%",470,150+28*5-20+10+5-15);       		  
        	   }
        	   
           }
           
           
}
