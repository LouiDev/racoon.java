package de.rdj.lib;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class RacoonImageList {
	private ArrayList<String> images;
	
	public RacoonImageList(ArrayList<String> images) {
		this.images = images;
	}
	
	public ArrayList<String> asStringList() {
		return images;
	}
	
	public ArrayList<URL> asURL() throws MalformedURLException {
		ArrayList<URL> result = new ArrayList<URL>();
		
		for(String s : images) {
			result.add(new URL(s));
		}
		
		return result;
	}
	
	public ArrayList<Image> asImages() throws MalformedURLException, IOException {
		ArrayList<Image> result = new ArrayList<Image>();
		
		for(String s : images) {
			result.add(ImageIO.read(new URL(s)));
		}
		
		return result;
	}
}
