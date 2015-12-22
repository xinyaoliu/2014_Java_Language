package studentScore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class main_windows extends JFrame{
	  private main_running_Jpanel p1;
	  private ArrayList<String> list_course = new ArrayList<String>();
	  private ArrayList<String> list_name = new ArrayList<String>();
	  private ArrayList<String> list_number = new ArrayList<String>();
	  ArrayList<String> list_score = new ArrayList<String>();
      public main_windows() throws FileNotFoundException
      { 	
    	p1 = new main_running_Jpanel();
        setSize(600,400);
        setLocationRelativeTo(null);        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        add(p1);
        file_input();
      }
      class main_running_Jpanel extends JPanel {   
    	  private JRadioButton[] jradiobutton = new JRadioButton[10];
    	  private JLabel jlabel_luru = new JLabel("请选择需要录入的课程成绩");
    	  private JLabel jlabel_2 = new JLabel("请输入成绩，成绩输入完后按确定保存");
    	  private JButton select = new JButton("确定");
    	  private JButton select1 = new JButton("确定");
    	  private JButton select2 = new JButton("确定");
    	  private JButton select3 = new JButton("图形分析");
    	  private JTextField[] chengjishuru1 = new JTextField[50];
    	  private JLabel[] chengjishuru2 = new JLabel[50];
    	  private JButton p1 = new JButton("录入成绩");
	      private JButton p2 = new JButton("打开成绩");
	      private JButton p3 = new JButton("退出");

	   // private ImageIcon image1 = new ImageIcon(getClass().getResource("image/body.jpg"));
    	  private JLabel p5 = new JLabel("欢迎使用学生成绩录入系统");
    	  private Font font1 = new Font("SansSerif",Font.BOLD,24);
    	  private Font font2 = new Font("SansSerif",Font.BOLD,14);
    	  private Font font3 = new Font("SansSerif",Font.BOLD,14);
    	/*  public void paint(Graphics g) {
    		  g.setFont(font3);
    		  g.setColor(Color.blue); 
    	  }*/
    	  private String classes;
    	  private String select_course;
    	  private JButton xiugai = new JButton("修改");
    	  private JButton fenxi = new JButton("分析");
    	  private JLabel[] zhanshi = new JLabel[6];
    	  private int sign = 1;
    	  public main_running_Jpanel()
    	  {
        	  select.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {               		 
            		  try {
                  		for(int i = 1;i<=list_course.size();i++)
                		{
                			if(jradiobutton[i-1].isSelected())
                			{
                				select_course = list_course.get(i-1);
                			}
                		}                 	   
					 file_input2();
					 if(sign == 1)
					 {
					 inset_Jpanel_2();
					 remove(select);
              	   remove(jlabel_luru);
              	  for(int i=1;i<=list_course.size();i++)
          		  {
              		  remove(jradiobutton[i-1]);
          		  }}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}                   		
            	  }            	  
              });
        	  select1.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {               		 
            		  try {
						file_output();
						remove1();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}               
            	  }
              });
          	  select2.addActionListener(new ActionListener(){
          		  
              	  public void actionPerformed(ActionEvent e)
              	  {               		 
              		  try {
              	      	  for(int i=1;i<=list_name.size();i++)
              	  		  {
              	      		  remove(chengjishuru2[i-1]);
              	      		  remove(chengjishuru1[i-1]);
              	  		  }
              	      	  remove(select2);
              	      	  remove(jlabel_2);
    					  file_output();
    					  show_Jpanel();
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}               
              	  }
                });
          	select3.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {               		 
            		  son_windows k = new son_windows(getmain_windows());             
            	  }
              });
          	xiugai.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {          
                  	 remove(fenxi);
                  	 remove(xiugai);
                  	 remove(select3);
                  	 for(int i=1;i<=list_name.size();i++)
              		  {
                  		  remove(chengjishuru2[i-1]);
              		  }
            		xiugai_Jpanel_2();         		  
            	  }
              });
          	fenxi.addActionListener(new ActionListener(){
          	  public void actionPerformed(ActionEvent e)
          	  {          
                	
          		son_windows_2 j = new son_windows_2(getmain_windows()); 
                	 //fenxi();  
          	  }
            });
          	
    		  p5.setFont(font1);
    		  setSize(1000,700);
    		  setLayout(null);
    		  p1.setFont(font2);
    		  p2.setFont(font2);
    		  p3.setFont(font2);
    		  p5.setBounds(getWidth()/2-380,0,500,100);
              p1.setBounds(getWidth()/2-80,100,140,30);
              p2.setBounds(getWidth()/2-80,150,140,30);
              p3.setBounds(getWidth()/2-80,300,140,30);
              p1.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {      removeAll();
	    		     add(p5);
	    		     add(p1);
	    		     add(p2);
	    		     add(p3);     		 
            		  inset_Jpanel();           		  
            	  }
              });
              p2.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {
            		  try {
						open_file();
						removeAll();
			    		  add(p5);
			    		  add(p1);
			    		  add(p2);
			    		  add(p3);
						show_Jpanel();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
            	  }
              });
              p3.addActionListener(new ActionListener(){
            	  public void actionPerformed(ActionEvent e)
            	  {
            		 System.exit(0);
            	  }
              });
    		  add(p5);
    		  add(p1);
    		  add(p2);
    		  add(p3);
    	  }
    	 // protected void paintComponent(Graphics g)
    	 // {
    	//	  g.drawImage(image1.getImage(),0,0,getWidth(),getHeight(),this);
    	 // }	  
          public void inset_Jpanel()//选择课程面板
          {    
        	  jlabel_luru.setBounds(20,80,300,50);
        	  jlabel_luru.setOpaque(false);
        	  jlabel_luru.setFont(font3);
        	  select.setBounds(200,250,100,30); //button
        	  add(select);
        	  add(jlabel_luru);
        	  for(int i=1;i<=list_course.size();i++)
    		  {
        		  jradiobutton[i-1] = new JRadioButton(list_course.get(i-1));
        		  jradiobutton[i-1].setBounds(30,100+i*30,200, 30);
        		  jradiobutton[i-1].setOpaque(false);
        		  jradiobutton[i-1].setFont(font2);
        		  add(jradiobutton[i-1]);
    		  }       	  
        	  repaint();
          }
          public void remove1()
          {
				remove(select1);
				remove(jlabel_2);
				for(int i=1;i<=list_name.size();i++)
	    		  {
	        		  remove(chengjishuru2[i-1]);
	        		  remove(chengjishuru1[i-1]);
	    		  }
				JOptionPane.showMessageDialog(null,"录入成功");
				repaint();
          }
          public void inset_Jpanel_2()//选择录入成绩后显示输入成绩面板
          {    

        	  for(int i=1;i<=list_name.size();i++)
    		  {
        		  chengjishuru2[i-1] = new JLabel(list_name.get(i-1));
        		  chengjishuru1[i-1] = new JTextField(0);
        		  chengjishuru2[i-1].setBounds(30,80+i*30,100, 30); //100,100+i*50,200, 30
        		  chengjishuru1[i-1].setBounds(100,80+i*30,65, 30);  //150,100+i*50,80, 30
        		  chengjishuru2[i-1].setFont(font2);
        		  add(chengjishuru2[i-1]);
        		  add(chengjishuru1[i-1]);
    		  }
        	  jlabel_2.setBounds(30,30,500,100);
        	  jlabel_2.setFont(font3);
        	  select1.setBounds(200,325,100,30);
        	  add(select1);
        	  add(jlabel_2);
        	  repaint();
          }
          public void file_input2() throws FileNotFoundException//打开录入班级文件面板
    	  {
        	  sign = 1;
              list_name.clear();
              list_number.clear();
        	  JFileChooser filechooser = new JFileChooser("src/studentScore/data/classes/");
        	  File file;
        	  Scanner input_file;
        	  String str;
    		  int i = 1;
    		  int j = 1;
        	  if(filechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
      		{
      			file = filechooser.getSelectedFile();      			 
      			classes = file.getName();
      			int o = classes.lastIndexOf('.');
      			classes = classes.substring(0,o);
      			if(new File("src/studentScore/data/score/"+classes+"-"+select_course+".dat").exists())
      			{
      				JOptionPane.showMessageDialog(null,"已经录入成绩，无需重新录入");
      				sign = 0;
      			}
      			else{     			
      			input_file = new Scanner(file);     			
      		    while(input_file.hasNext())
      		  {     		      
      			  str = input_file.next();
      			  if(i%2==1)
      			  list_number.add(str);
      			  else
      			  list_name.add(str);
      			  i++;
      		  }
      			}
      		}        	
    	  }
        public void file_output() throws IOException//保存文件
        {
        	FileOutputStream output1 = new FileOutputStream("src/studentScore/data/score/"+classes+"-"+select_course+".dat");
        	DataOutputStream output = new DataOutputStream(output1);
        	list_score.clear();
        	String str7;
        	for(int i = 1;i<=list_number.size();i++)
        	{       		
        		output.writeUTF(list_number.get(i-1));
        		output.writeUTF(list_name.get(i-1));
        		output.writeUTF(chengjishuru1[i-1].getText());
        		list_score.add(chengjishuru1[i-1].getText());
        	}
        	output.close();
        }
        public void open_file() throws IOException//打开班级成绩文件
        {
          list_name.clear();
          list_number.clear();
          list_score.clear();
          JFileChooser filechooser = new JFileChooser("src/studentScore/data/score/");
      	  File file;
  		  int i = 1;
      	  if(filechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
    		{
    			file = filechooser.getSelectedFile();
    			String str1 = file.getName();
    			int o = str1.lastIndexOf('-');
    			classes = str1.substring(0,o);
    			int q = str1.lastIndexOf('.');
    			select_course = str1.substring(o+1,q);
    			DataInputStream file_input = new DataInputStream(new FileInputStream(file));
    			try
    	         {
    	        	 while(true)
    	        	 {
    	        		 if(i%3==1)
    	        			 list_number.add(file_input.readUTF());
    	        			 if(i%3==2)
    	        				 list_name.add(file_input.readUTF());
    	        				 if(i%3==0)
    	        					 list_score.add(file_input.readUTF());
    	        	 i++;}
    	          }
    	         catch(EOFException ex)
    	         {
    	        	 
    	         }
    		}       
        }
        public void show_Jpanel()//展示成绩面板
        {
        	for(int i=1;i<=list_name.size();i++)
        	{
        		chengjishuru2[i-1] = new JLabel(list_number.get(i-1)+" "+list_name.get(i-1)+" "+list_score.get(i-1));
        		chengjishuru2[i-1].setBounds(30,60+i*30,200, 30);
        		chengjishuru2[i-1].setFont(font2);
        		add(chengjishuru2[i-1]);
        	}
        	xiugai.setBounds(300,260,100,30);        	
        	fenxi.setBounds(300,220,100,30);
        	select3.setBounds(300,180,100,30);
        	add(xiugai);
        	add(fenxi);
        	add(select3);
        	repaint();
        }
        
        
        public void xiugai_Jpanel_2()//选择录入成绩后显示输入成绩面板
        {    
        
      	  for(int i=1;i<=list_name.size();i++)
  		  {
      		  chengjishuru2[i-1] = new JLabel(list_name.get(i-1));
      		  chengjishuru1[i-1] = new JTextField(list_score.get(i-1));
    		  chengjishuru2[i-1].setBounds(30,80+i*30,100, 30); //100,100+i*50,200, 30
    		  chengjishuru1[i-1].setBounds(100,80+i*30,65, 30);  //150,100+i*50,80, 30
      		  chengjishuru2[i-1].setFont(font2);
      		  add(chengjishuru2[i-1]);
      		  add(chengjishuru1[i-1]);
  		  }

      	  
      	  jlabel_2.setBounds(30,30,500,100);
      	  jlabel_2.setFont(font3);
      	  select2.setBounds(200,325,100,30);
      	  add(select2);
      	  add(jlabel_2);
      	  repaint();
        }
        
        
        public void fenxi()
        {
        	DecimalFormat df=new DecimalFormat(".##");
        	int sum = 0;
        	int[] a = new int[100];
        	int highest = 0;
        	int lowest = 0;
        	int square = 0;
        	int bujige_number = 0;double bujige_number_1 = 0;
        	int jige_number = 0;double jige_number_1 = 0;
        	int zhongdeng_number = 0;double zhongdeng_number_1 = 0;
        	int lianghao_number = 0;double lianghao_number_1 = 0;
        	int youxiu_number = 0;double youxiu_number_1 = 0;       
        	int temp = 0;
        	int min = 0 ;
        	int index=0;
        	for(int i=1;i<=list_score.size();i++)
        	{
        		a[i-1] = Integer.valueOf(list_score.get(i-1)).intValue();
        	}
        	for(int i = 0;i<list_score.size()-1;i++)
        	{
        		index = i;
        		min = a[i];
        		for(int j = i+1;j<list_score.size();j++)
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
        	for(int i = 0;i<list_score.size();i++)
        		System.out.println(a[i]);
        	for(int i = 0;i<list_score.size();i++)
        	{sum+=a[i];if(a[i]<60)bujige_number++;
        	else if(a[i]<70)jige_number++;
        	else if(a[i]<80)zhongdeng_number++;
        	else if(a[i]<90)lianghao_number++;
        	else youxiu_number++;
        	}
        	 bujige_number_1 = bujige_number*100/list_score.size();
        	 jige_number_1 = jige_number*100/list_score.size();
        	 zhongdeng_number_1 = zhongdeng_number*100/list_score.size();
        	 lianghao_number_1 = lianghao_number*100/list_score.size();
        	 youxiu_number_1 = youxiu_number*100/list_score.size();
        	lowest = a[0];highest = a[list_score.size()-1];square = sum/list_score.size();
        	zhanshi[0] = new JLabel("最高分："+highest+"分，最低分："+lowest+"分，平均分："+square+"分");
        	zhanshi[5] = new JLabel("不及格（分数《60）："+bujige_number+"人，占："+df.format(bujige_number_1)+"%");
        	zhanshi[1] = new JLabel("及格（60<=分数<70）："+jige_number+"人，占："+df.format(jige_number_1)+"%");
        	zhanshi[2] = new JLabel("中等（70《=分数《80）："+zhongdeng_number+"人，占："+df.format(zhongdeng_number_1)+"%");
        	zhanshi[3] = new JLabel("良好（80《=分数《90）："+lianghao_number+"人，占："+df.format(lianghao_number_1)+"%");
        	zhanshi[4] = new JLabel("优秀（90<=分数《=100）："+youxiu_number+"人，占："+df.format(youxiu_number_1)+"%");
        	zhanshi[0].setBounds(650,100,1000,100);
        	zhanshi[5].setBounds(650,150,1000,100);
        	zhanshi[1].setBounds(650,200,1000,100);
        	zhanshi[2].setBounds(650,250,1000,100);
        	zhanshi[3].setBounds(650,300,1000,100);
        	zhanshi[4].setBounds(650,350,1000,100);
        	for(int i=0;i<=5;i++)
        		zhanshi[i].setFont(font2);
        	add(zhanshi[0]);
        	add(zhanshi[1]);
        	add(zhanshi[2]);
        	add(zhanshi[3]);
        	add(zhanshi[4]);
        	add(zhanshi[5]);
        	repaint();
        }
        
        
      }
      public void file_input() throws FileNotFoundException
	  {
    	  File file1 = new File("src/studentScore/data/course.txt");
    	  Scanner input_file = new Scanner(file1);
		  String str;
		  int i = 1;
		  while(input_file.hasNext())
		  {
			  str = input_file.next();
			  list_course.add(str);
		  }
		  input_file.close();
	  }
 
      
      public ArrayList getarraylist_score()
      {
    	  return list_score;
      }
      public main_windows getmain_windows()
      {
    	  return this;
      }
}
