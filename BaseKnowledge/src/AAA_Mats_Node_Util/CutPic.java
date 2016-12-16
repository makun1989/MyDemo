package AAA_Mats_Node_Util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


public class CutPic {
	public static void main(String args[]) throws Exception {
		Rectangle rectangle;
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("/home/makun/Ocr-1.png"));
		} catch (IOException e) {
			System.out.println("jfkdafdoaj");
		}
		rectangle = new Rectangle(176, 329, 446, 43);
		cutStream(new File("/home/makun/Ocr-1.png"),"/home/makun/dest.png","png",rectangle );
		System.out.println("abc");
	}
	
	private static void cutStream(File capturedFile, String destPath, String suffix, Rectangle rectangle) throws Exception {
		File destFile = new File(destPath);
		FileInputStream srcStream = null;
		OutputStream destStream = null;
		ImageInputStream createImageInputStream = null;
		try {
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			srcStream = new FileInputStream(capturedFile);
			destStream = new FileOutputStream(destFile);
			createImageInputStream = ImageIO.createImageInputStream(srcStream);
			ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
			reader.setInput(createImageInputStream, true);
			ImageReadParam param = reader.getDefaultReadParam();
			param.setSourceRegion(rectangle);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, suffix, destStream);
		} catch (Exception e) {
			throw e;
		} finally {
			if (createImageInputStream != null) {
				try {
					createImageInputStream.close();
				} catch (IOException e) {
				}
			}
			if (destStream != null) {
				try {
					destStream.close();
				} catch (IOException e) {
				}
			}
			if (srcStream != null) {
				try {
					srcStream.close();
				} catch (IOException e) {
				}
			}

		}
	}
}	
