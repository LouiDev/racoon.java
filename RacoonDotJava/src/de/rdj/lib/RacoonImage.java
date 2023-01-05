package de.rdj.lib;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Object containing a single racoon image.
 * @author LouiDev
 *
 */
public class RacoonImage {
	private String image;
	
	public RacoonImage(String image) {
		this.image = image;
	}
	
	/**
	 * Returns the containing image as a String url.
	 * @return String
	 */
	public String asString() {
		return image;
	}
	
	/**
	 * Returns the containing image as an URL object.
	 * @return URL
	 * @throws MalformedURLException
	 */
	public URL asURL() {
		try {
			return new URL(image);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the containing image as an Image object.
	 * @return Image
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Image asImage() {
		try {
			return ImageIO.read(asURL());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the containing image as an URI object.
	 * @return URL
	 * @throws URISyntaxException
	 */
	public URI asURI() {
		try {
			return new URI(image);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
