package recognize;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;


public class OrangeRecognizeUI extends JComponent implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton browseBtn;
	private JButton analyzeBtn;
	private JButton compareBtn;
	private Dimension mySize;
	
	// image operator
	private MediaTracker tracker;
	private BufferedImage sourceImage;  
	private BufferedImage candidateImage;
	private static int[][][]color;
	// command constants
	public final static String BROWSE_CMD = "打开";
	public final static String ANALYZE_CMD = "分析";
	public final static String COMPARE_CMD = "结果";
	
	public OrangeRecognizeUI () {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnPanel.setSize(300, 200);
		browseBtn = new JButton("打开");
		analyzeBtn = new JButton("分析");
		compareBtn = new JButton("结果");
		// buttons
		btnPanel.add(browseBtn);
		btnPanel.add(analyzeBtn);
		btnPanel.add(compareBtn);
		
		// setup listener...
		browseBtn.addActionListener(this);
		analyzeBtn.addActionListener(this);
		compareBtn.addActionListener(this);
		
		mySize = new Dimension(800, 600);   //w,h
		JFrame demoUI = new JFrame("Orange Recognizer");
		demoUI.getContentPane().setLayout(new BorderLayout());
		demoUI.getContentPane().add(this, BorderLayout.CENTER);
		demoUI.getContentPane().add(btnPanel, BorderLayout.SOUTH);
		demoUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demoUI.pack();
		demoUI.setVisible(true);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Font myFont = new Font("Serif", Font.BOLD, 26);
 		g.setFont(myFont);
 		g.drawString("欢迎使用柑橘识别系统" , 260, 40); //x,y
		if(sourceImage != null) {
			Image scaledImage = sourceImage.getScaledInstance(600, 500, Image.SCALE_FAST);
			g2.drawImage(scaledImage, 100, 70, 600, 500, null);
		}
		


	}
	
	public void actionPerformed(ActionEvent e) {
		if(BROWSE_CMD.equals(e.getActionCommand())) {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			BufferedImage bImage = null;
			if(f == null) return;
			try {
				bImage = ImageIO.read(f);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			repaint(); 
			tracker = new MediaTracker(this);
			tracker.addImage(bImage, 1);
			
			try {
				if (!tracker.waitForID(1, 10000)) {
					System.out.println("Load error.");
					System.exit(1);
				}// end if
			} catch (InterruptedException ine) {
				ine.printStackTrace();
				System.exit(1);
			} // end catch
			
			if(sourceImage == null) {
				sourceImage = bImage;
			}else {
				sourceImage = null;
				
			}
			//repaint(); 2
		} else if(ANALYZE_CMD.equals(e.getActionCommand())) {
			OrangeRecognize imageCom = new OrangeRecognize(sourceImage, candidateImage);
			color = imageCom.modelMatch();
			try {
				imageCom.OrangeRecognize(get_color_list());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				imageCom.OrangeRecognize_2(get_color_list());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();

		}else if(COMPARE_CMD.equals(e.getActionCommand())) 
		{
			OrangeResult imageCom = new OrangeResult(getmain_windows());
			imageCom.HoughCircle();
			repaint();
		} 
		
	}
	

	public OrangeRecognizeUI getOrangeRecognizeUI(){
		return this;
	}
	public Dimension getPreferredSize() {
		return mySize;
	}
	
	public Dimension getMinimumSize() {
		return mySize;
	}
	
	public Dimension getMaximumSize() {
		return mySize;
	}
	
    public static int[][][] get_color_list()
    {
  	  return color;
    }

   
    public OrangeRecognizeUI getmain_windows()
    {
  	  return this;
    }
    
	public static void main(String[] args) {
		new OrangeRecognizeUI ();
	}

	


}
