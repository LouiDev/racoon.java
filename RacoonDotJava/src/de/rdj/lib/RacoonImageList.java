package de.rdj.lib;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Object containing a list of racoon images.
 * @author LouiDev
 *
 */
public class RacoonImageList {
	private ArrayList<String> images;
	
	public RacoonImageList(ArrayList<String> images) {
		this.images = images;
	}
	
	/**
	 * Returns the containing image list as a String list.
	 * @return String ArrayList
	 */
	public ArrayList<String> asStringList() {
		return images;
	}
	
	/**
	 * Returns the containing image list as an URL list.
	 * @return URL ArrayList
	 * @throws MalformedURLException
	 */
	public ArrayList<URL> asURLList() throws MalformedURLException {
		ArrayList<URL> result = new ArrayList<URL>();
		
		for(String s : images) {
			result.add(new URL(s));
		}
		
		return result;
	}
	
	/**
	 * Returns the containing image list as an Image list.
	 * @return Image ArrayList
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public ArrayList<Image> asImageList() throws MalformedURLException, IOException {
		ArrayList<Image> result = new ArrayList<Image>();
		
		for(String s : images) {
			result.add(ImageIO.read(new URL(s)));
		}
		
		return result;
	}
	
	/**
	 * Returns the containing image list as an URI list.
	 * @return URI ArrayList
	 * @throws URISyntaxException
	 */
	public ArrayList<URI> asURIList() throws URISyntaxException {
		ArrayList<URI> result = new ArrayList<URI>();
		
		for(String s : images) {
			result.add(new URI(s));
		}
		
		return result;
	}
}
