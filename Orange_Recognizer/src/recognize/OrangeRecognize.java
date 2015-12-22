package recognize;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class OrangeRecognize {
	private int x,y,w,h;
	private BufferedImage sourceImage;
//	private BufferedImage candidateImage;
	
	public OrangeRecognize(BufferedImage srcImage, BufferedImage canImage) {
		this.sourceImage = srcImage;
	//	this.candidateImage = canImage;
	}
	
	
	
	

	public int[][][] modelMatch() {
		int[] rgb = new int[3];
		int [][][]color = new int [1000][1000][3];
		int width=sourceImage.getWidth(); 
		int height=sourceImage.getHeight(); 
		int minx=sourceImage.getMinX(); 
		int miny=sourceImage.getMinY(); 
		
		
		System.out.println("width="+width+",height="+height+"."); 
		System.out.println("minx="+minx+",miniy="+miny+".");

		for(int i=minx;i<width;i++){ 
		for(int j=miny;j<height;j++){ 
		//System.out.print(bi.getRGB(jw, ih)); 
		int pixel=sourceImage.getRGB(i, j); 
		rgb[0] = (pixel & 0xff0000 ) >> 16 ; 
		rgb[1] = (pixel & 0xff00 ) >> 8 ; 
		rgb[2] = (pixel & 0xff ); 
		color [i][j][0] = rgb[0];
		color [i][j][1] = rgb[1];
		color [i][j][2] = rgb[2];
		System.out.println("i="+i+",j="+j+":("+rgb[0]+","+rgb[1]+","+rgb[2]+")");

		} 
		}
		
		

		return color;
	}
	

	public OrangeRecognize(int[][][] get_color_list) {
		// TODO Auto-generated constructor stub
	}



	public void OrangeRecognize (int b[][][]) throws IOException {
		int rgb;
		int k=0;
		int pix[] = new int[w * h];
		int index = 0;
		BufferedImage ImageNew = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<800;i++){
			for(int j=0;j<600;j++){
				if((b[i][j][0]>=200&&b[i][j][1]>=120))
				{	
					rgb=(b[i][j][0]*256+b[i][j][1])*256+b[i][j][2];
					
				}else if(b[i][j][0]>140&&b[i][j][0]<200&&b[i][j][1]>50&&b[i][j][1]<150&&b[i][j][2]<70){
					
					rgb=(b[i][j][0]*256+b[i][j][1])*256+b[i][j][2];
					
					}
				else 
				{
					rgb=16777215;
				}
				
			       
				    ImageNew.setRGB(i,j,rgb);//设置左半部分的RGB

			}
			}
	        for (int y = 0; y < h; y++) {
	            int red = (y * 255) / (h - 1);
	            for (int x = 0; x < w; x++) {
	                int blue = (x * 255) / (w - 1);
	                pix[index++] = (255 << 24) | (red << 16) | blue;
	            }
	        }
           File outFile = new File("E:\\out.JPG");
        ImageIO.write(ImageNew, "jpg", outFile);//写图片
    ImageProducer ip = new MemoryImageSource(800, 600, pix, 0,600);

    final Image im2 = java.awt.Toolkit.getDefaultToolkit().createImage(ip);

        
    
    
    /*
    JPanel panel = new JPanel() {
    	private static final long serialVersionUID = 1L;
    protected void paintComponent(Graphics g) {

      g.drawImage(im2, 0, 0, 800, 600, this);
     }
    };  */
   // this.add(panel);
  //  this.setSize(800,600);
   // setVisible(true);	
    }

	

	public void OrangeRecognize_2 (int b[][][]) throws IOException {
		int rgb;
		int k=0;
		int pix[] = new int[w * h];
		int index = 0;
		BufferedImage ImageNew = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<800;i++){
			for(int j=0;j<600;j++){
			
					rgb=(b[i][j][0]*256+b[i][j][1])*256+b[i][j][2];
					
			
				    ImageNew.setRGB(i,j,rgb);//设置左半部分的RGB

			}
			}
	        for (int y = 0; y < h; y++) {
	            int red = (y * 255) / (h - 1);
	            for (int x = 0; x < w; x++) {
	                int blue = (x * 255) / (w - 1);
	                pix[index++] = (255 << 24) | (red << 16) | blue;
	            }
	        }
           File outFile = new File("E:\\source.JPG");
        ImageIO.write(ImageNew, "jpg", outFile);//写图片
    ImageProducer ip = new MemoryImageSource(800, 600, pix, 0,600);

    final Image im2 = java.awt.Toolkit.getDefaultToolkit().createImage(ip);

        
    
    

    }
}
