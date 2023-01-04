package de.rdj.lib;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Object containing a list of racoon images.
 * @author LouiDev
 *
 */
public class RacoonImageList {
	private List<String> images;
	
	public RacoonImageList(List<String> images) {
		this.images = images;
	}
	
	/**
	 * Returns the containing image list as a String list.
	 * @return String List
	 */
	public List<String> asStringList() {
		return images;
	}
	
	/**
	 * Returns the containing image list as an URL list.
	 * @return URL List
	 * @throws MalformedURLException
	 */
	public List<URL> asURLList() throws MalformedURLException {
		List<URL> result = new ArrayList<URL>();
		
		for(String s : images) {
			result.add(new URL(s));
		}
		
		return result;
	}
	
	/**
	 * Returns the containing image list as an Image list.
	 * @return Image List
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public List<Image> asImageList() throws MalformedURLException, IOException {
		List<Image> result = new ArrayList<Image>();
		
		for(String s : images) {
			result.add(ImageIO.read(new URL(s)));
		}
		
		return result;
	}
	
	/**
	 * Returns the containing image list as an URI list.
	 * @return URI List
	 * @throws URISyntaxException
	 */
	public List<URI> asURIList() throws URISyntaxException {
		List<URI> result = new ArrayList<URI>();
		
		for(String s : images) {
			result.add(new URI(s));
		}
		
		return result;
	}
}
