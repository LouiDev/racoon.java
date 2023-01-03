package de.rdj.lib;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class RacoonImage {
	private String image;
	
	public RacoonImage(String image) {
		this.image = image;
	}
	
	public String asString() {
		return image;
	}
	
	public URL asURL() throws MalformedURLException {
		return new URL(image);
	}
	
	public Image asImage() throws MalformedURLException, IOException {
		return ImageIO.read(asURL());
	}
}
