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
	public URL asURL() throws MalformedURLException {
		return new URL(image);
	}
	
	/**
	 * Returns the containing image as an Image object.
	 * @return Image
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Image asImage() throws MalformedURLException, IOException {
		return ImageIO.read(asURL());
	}
	
	/**
	 * Returns the containing image as an URI object.
	 * @return URL
	 * @throws URISyntaxException
	 */
	public URI asURI() throws URISyntaxException {
		return new URI(image);
	}
}
