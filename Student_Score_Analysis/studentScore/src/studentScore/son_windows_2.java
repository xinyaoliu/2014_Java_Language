package studentScore;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import studentScore.main_windows.main_running_Jpanel;
import studentScore.son_windows.draw_Jpanel;

public class son_windows_2 extends JFrame{
	DecimalFormat df=new DecimalFormat(".##");
	private int sum = 0;
	private int[] a = new int[100];
	private int highest = 0;
	private int lowest = 0;
	private int square = 0;
	private int temp = 0;
	private int min = 0 ;
	private int index=0;
	private int bujige_number = 0;private double bujige_number_1 = 0;
	private int jige_number = 0;private double jige_number_1 = 0;
	private int zhongdeng_number = 0;private double zhongdeng_number_1 = 0;
	private int lianghao_number = 0;private double lianghao_number_1 = 0;
	private int youxiu_number = 0;private double youxiu_number_1 = 0; 
	private main_windows tc;
	private JLabel[] zhanshi = new JLabel[6];
	private Font font2 = new Font("SansSerif",Font.BOLD,20);
	
           public son_windows_2(main_windows t2)
           {
        	   this.tc = t2;
        	   for(int i=1;i<=tc.list_score.size();i++)
           	{
           		a[i-1] = Integer.valueOf(tc.list_score.get(i-1)).intValue();
           	}
           	for(int i = 0;i<tc.list_score.size()-1;i++)
           	{
           		index = i;
           		min = a[i];
           		for(int j = i+1;j<tc.list_score.size();j++)
           		{
           			if(min>a[j])
           			{
           				min = a[j];index = j;
           			}
           		}
           		temp = a[i];
           		a[i] = a[index];
           		a[index] = temp;
           	}
           	for(int i = 0;i<tc.list_score.size();i++)
           		System.out.println(a[i]);
           	for(int i = 0;i<tc.list_score.size();i++)
           	{sum+=a[i];if(a[i]<60)bujige_number++;
           	else if(a[i]<70)jige_number++;
           	else if(a[i]<80)zhongdeng_number++;
           	else if(a[i]<90)lianghao_number++;
           	else youxiu_number++;
           	}
           	 bujige_number_1 = bujige_number*100/tc.list_score.size();
           	 jige_number_1 = jige_number*100/tc.list_score.size();
           	 zhongdeng_number_1 = zhongdeng_number*100/tc.list_score.size();
           	 lianghao_number_1 = lianghao_number*100/tc.list_score.size();
           	 youxiu_number_1 = youxiu_number*100/tc.list_score.size();
           	lowest = a[0];highest = a[tc.list_score.size()-1];square = sum/tc.list_score.size();
          
           	draw_Jpanel p1 = new draw_Jpanel();
           setSize(600,600);
           setLocationRelativeTo(null);        
           setVisible(true);
           add(p1);
           
            zhanshi[0] = new JLabel("最高分："+highest+"分，最低分："+lowest+"分，平均分："+square+"分");
           	zhanshi[5] = new JLabel("不及格（分数《60）："+bujige_number+"人，占："+df.format(bujige_number_1)+"%");
           	zhanshi[1] = new JLabel("及格（60<=分数<70）："+jige_number+"人，占："+df.format(jige_number_1)+"%");
           	zhanshi[2] = new JLabel("中等（70《=分数《80）："+zhongdeng_number+"人，占："+df.format(zhongdeng_number_1)+"%");
           	zhanshi[3] = new JLabel("良好（80《=分数《90）："+lianghao_number+"人，占："+df.format(lianghao_number_1)+"%");
           	zhanshi[4] = new JLabel("                 优秀（90<=分数《=100）："+youxiu_number+"人，占："+df.format(youxiu_number_1)+"%");
           	
           	
           	zhanshi[0].setBounds(100,35,1000,100);
           	zhanshi[5].setBounds(100,75,1000,100);
           	zhanshi[1].setBounds(100,115,1000,100);
           	zhanshi[2].setBounds(100,155,1000,100);
           	zhanshi[3].setBounds(100,195,1000,100);
           	zhanshi[4].setBounds(100,260,1000,100);
           	for(int i=0;i<=5;i++)
           		zhanshi[i].setFont(font2);
           	
           	add(zhanshi[0]);
        	add(zhanshi[5]);
           	add(zhanshi[1]);
           	add(zhanshi[2]);
           	add(zhanshi[3]);
           	add(zhanshi[4]);
           
           	repaint();
           
           
           }
           
           class draw_Jpanel extends JPanel {
        	   public draw_Jpanel()
        	   {    
        		 
        	   }
        	   
           }
           
           
}
