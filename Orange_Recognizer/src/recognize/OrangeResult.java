
package recognize;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;




import recognize.OrangeRecognizeUI;





public class OrangeResult extends JFrame{
	private OrangeRecognizeUI tc;
	private BufferedImage sourceImage;
	private int[][][] color_2;
	private int x,y,w,h;
	private int xx=0;
	private int yy=0;
	private int rr=0;

	private int num;
	String strings=new String("");
	
	public OrangeResult(BufferedImage srcImage) {
		this.sourceImage = srcImage;
	}
    

	public OrangeResult (OrangeRecognizeUI t1) {
		this.tc = t1;
		this.color_2=OrangeRecognizeUI.get_color_list();
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		draw_Jpanel p1 = new draw_Jpanel();
         setSize(800,600);
         setLocationRelativeTo(null);        
         setVisible(true);
         add(p1);
  
         
	}
	


	
	
	
	
	public void HoughCircle() {  
        
	    
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = new Mat(); 
        mat = Mat.eye(3, 3, CvType.CV_8UC1);  
        
        Mat grayMat = new Mat();          
        Mat circles=new Mat();
        
        Size size=new Size();
        size.height=9;
        size.height=9;

        Mat src = Highgui.imread("E:\\out.jpg");  
        Mat source = Highgui.imread("E:\\source.jpg");
       
        Imgproc.cvtColor(src, grayMat, Imgproc.COLOR_RGB2GRAY);  
        Imgproc.GaussianBlur( grayMat, grayMat, size, 2, 2);

        circles.create(src.rows(), src.cols(), CvType.CV_32FC3);
        Highgui.imwrite("E:\\out2.jpg", grayMat);  //gray 
        Imgproc.HoughCircles(grayMat, circles, Imgproc.CV_HOUGH_GRADIENT, 
        		2,50, 200, 72, 60, 200);
        //2,50, 200, 80, 60, 200  rgb 140
             //2,30, 200, 100, 50, 200
        //���ĸ�������double���͵�dp���ۼ���ͼ��ķֱ��ʺ�����ͼ��֮�ȵĵ������Ҵ˲���������һ��������ͼ��ֱ��ʵ͵��ۼ������������ֲ������Ļ����������Ӱɡ����磬���dp= 1ʱ���ۼ���������ͼ�������ͬ�ķֱ��ʡ����dp=2���ۼ�����������ͼ��һ����ô��Ŀ�Ⱥ͸߶ȡ�
     //   �����������double���͵�minDist��Ϊ����任��⵽��Բ��Բ��֮�����С���룬�������ǵ��㷨���������ֵ�������ͬԲ֮�����С���롣����������̫С�Ļ���������ڵ�Բ���ܱ�����ؼ�����һ���غϵ�Բ����֮�������������̫��Ļ���ĳЩԲ�Ͳ��ܱ��������ˡ�
   //     ������������double���͵�param1����Ĭ��ֵ100�����ǵ���������method���õļ�ⷽ���Ķ�Ӧ�Ĳ������Ե�ǰΨһ�ķ��������ݶȷ�CV_HOUGH_GRADIENT������ʾ���ݸ�canny��Ե������ӵĸ���ֵ��������ֵΪ����һ�롣
  //      ���߸�������double���͵�param2��Ҳ��Ĭ��ֵ100�����ǵ���������method���õļ�ⷽ���Ķ�Ӧ�Ĳ������Ե�ǰΨһ�ķ��������ݶȷ�CV_HOUGH_GRADIENT������ʾ�ڼ��׶�Բ�ĵ��ۼ�����ֵ����ԽС�Ļ����Ϳ��Լ�⵽����ġ���Բ��������Խ��Ļ�����ͨ������Բ�͸��ӽӽ�������Բ���ˡ�
     //   �ڰ˸�������int���͵�minRadius,��Ĭ��ֵ0����ʾԲ�뾶����Сֵ��
        //�ھŸ�������int���͵�maxRadius,Ҳ��Ĭ��ֵ0����ʾԲ�뾶�����ֵ��
        num=circles.cols();
        
    	for(int i=0; i<circles.cols(); i++) {
    		
    		xx=(int)circles.get(0,i)[0];
    		yy=(int)circles.get(0,i)[1];
    		rr=(int)circles.get(0,i)[2];

        //draw circle
        Scalar scalar=new Scalar(0, 255, 0);
        Point point=new Point();
        point.x=xx;
        point.y=yy;
        
        Core.circle(source, point, (int)circles.get(0,i)[2] , scalar, 10);
    	
    	}
       
    	Highgui.imwrite("E:\\final.jpg", source);  // after draw circle
    	
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font myFont = new Font("Serif", Font.BOLD, 20);
 		g.setFont(myFont);
 		g.drawString("ʶ������������Ϊ" + num+"��",100, 60);

		File f2=new File("E:\\final.jpg");
		BufferedImage bImage = null;
		if(f2 == null) return;
		try {
			bImage = ImageIO.read(f2);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sourceImage = bImage;
		if(sourceImage != null) {
			Image scaledImage = sourceImage.getScaledInstance(600, 500, Image.SCALE_FAST);
			g2.drawImage(scaledImage, 100, 70, 600, 500, null);
		}
	}
	
	
	
    class draw_Jpanel extends JPanel {

 	   public draw_Jpanel()
 	   {       		   
 	   }

}
}
