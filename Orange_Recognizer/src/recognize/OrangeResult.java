
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
        //第四个参数，double类型的dp，累加器图像的分辨率和输入图像之比的倒数，且此参数允许创建一个比输入图像分辨率低的累加器。上述文字不好理解的话，来看例子吧。例如，如果dp= 1时，累加器和输入图像具有相同的分辨率。如果dp=2，累加器便有输入图像一半那么大的宽度和高度。
     //   第五个参数，double类型的minDist，为霍夫变换检测到的圆的圆心之间的最小距离，即让我们的算法能明显区分的两个不同圆之间的最小距离。这个参数如果太小的话，多个相邻的圆可能被错误地检测成了一个重合的圆。反之，这个参数设置太大的话，某些圆就不能被检测出来了。
   //     第六个参数，double类型的param1，有默认值100。它是第三个参数method设置的检测方法的对应的参数。对当前唯一的方法霍夫梯度法CV_HOUGH_GRADIENT，它表示传递给canny边缘检测算子的高阈值，而低阈值为它的一半。
  //      第七个参数，double类型的param2，也有默认值100。它是第三个参数method设置的检测方法的对应的参数。对当前唯一的方法霍夫梯度法CV_HOUGH_GRADIENT，它表示在检测阶段圆心的累加器阈值。它越小的话，就可以检测到更多的“假圆”，而它越大的话，能通过检测的圆就更加接近完美的圆形了。
     //   第八个参数，int类型的minRadius,有默认值0，表示圆半径的最小值。
        //第九个参数，int类型的maxRadius,也有默认值0，表示圆半径的最大值。
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
 		g.drawString("识别结果：柑橘数为" + num+"个",100, 60);

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
