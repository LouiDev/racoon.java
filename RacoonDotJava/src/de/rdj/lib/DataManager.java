package de.rdj.lib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import dev.mccue.json.Json;
import dev.mccue.json.JsonDecoder;
import dev.mccue.json.JsonObject;

/**
 * DataManager is the main class of Racoon.java library.
 * @author LouiDev
 *
 */
public class DataManager {
	
	private JsonObject obj;
	private List<String> images;
	private List<String> babyImages;
	private List<String> factsEn;
	private List<String> factsDe;
	
	/**
	 * Creates a new DataManager object. This allows access to every useful method this library has to offer.
	 * @throws IOException
	 */
	public DataManager() {
	    String content;
		try {
			content = new String(getClass().getClassLoader().getResourceAsStream("data.json").readAllBytes());
		    obj = (JsonObject) Json.readString(content);
		    images = JsonDecoder.field(obj, "images", JsonDecoder.array(JsonDecoder::string));
		    babyImages = JsonDecoder.field(obj, "babyImages", JsonDecoder.array(JsonDecoder::string));
		    factsEn = JsonDecoder.field(obj, "factsEn", JsonDecoder.array(JsonDecoder::string));
		    factsDe = JsonDecoder.field(obj, "factsDe", JsonDecoder.array(JsonDecoder::string));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new RacoonImageList object containing all normal racoon images this library has to offer.
	 * @return RacoonImageList
	 */
	public RacoonImageList getAllNormalImages() {
		return new RacoonImageList(images);
	}
	
	/**
	 * Creates a new RacoonImageList object containing all baby racoon images this library has to offer.
	 * @return RacoonImageList
	 */
	public RacoonImageList getAllBabyImages() {
		return new RacoonImageList(babyImages);
	}
	
	/**
	 * Creates a new RacoonImageList object containing all racoon images this library has to offer.
	 * @return RacoonImageList
	 */
	public RacoonImageList getAllImages() {
		List<String> result = new ArrayList<String>();
		result.addAll(getAllBabyImages().asStringList());
		result.addAll(getAllNormalImages().asStringList());
		return new RacoonImageList(result);
	}
	
	/**
	 * Creates a new RacoonFactList object containing all racoon facts in the given language this library has to offer.
	 * @param language
	 * @return RacoonFactList
	 */
	public RacoonFactList getAllFacts(Language language) {
		List<String> result = new ArrayList<String>();
		
		switch (language) {
			case ENGLISH: {
				for(int i = 0; i != factsEn.size(); i++) {
					result.add(factsEn.get(i));
				}
			}
			case GERMAN: {
				for(int i = 0; i != factsDe.size(); i++) {
					result.add(factsDe.get(i));
				}
			}
		}
		return new RacoonFactList(result);
	}
	
	/**
	 * Creates a new RacoonImage object containing a random racoon image.
	 * @return RacoonImage
	 */
	public RacoonImage getRandomImage() {
		List<String> images = getAllImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	/**
	 * Creates a new RacoonImage object containing a random normal racoon image.
	 * @return RacoonImage
	 */
	public RacoonImage getRandomNormalImage() {
		List<String> images = getAllNormalImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	/**
	 * Creates a new RacoonImage object containing a random baby racoon image.
	 * @return RacoonImage
	 */
	public RacoonImage getRandomBabyImage() {
		List<String> images = getAllBabyImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	/**
	 * Creates a new RacoonFactList object containing a random racoon fact in the given language.
	 * @param language
	 * @return RacoonFact
	 */
	public RacoonFact getRandomFact(Language language) {
		switch (language) {
			case ENGLISH: {
				int rnd = ThreadLocalRandom.current().nextInt(0, factsEn.size());
				return new RacoonFact(factsEn.get(rnd));
			}
			case GERMAN: {
				int rnd = ThreadLocalRandom.current().nextInt(0, factsDe.size());
				return new RacoonFact(factsDe.get(rnd));
			}

		}

		return null;
	}
	
}
