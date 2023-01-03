package de.rdj.lib;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import dev.mccue.json.Json;
import dev.mccue.json.JsonArray;
import dev.mccue.json.JsonDecoder;
import dev.mccue.json.JsonObject;

public class DataManager {
	
	private JsonObject obj;
	private JsonArray images;
	private JsonArray babyImages;
	private JsonArray factsEn;
	private JsonArray factsDe;

	public DataManager() throws IOException {
	    String content = new String(DataManager.class.getResourceAsStream("data.json").readAllBytes());
	    obj = (JsonObject) Json.readString(content);
	    images = (JsonArray) obj.get("images");
	    babyImages = (JsonArray) obj.get("babyImages");
	    factsEn = (JsonArray) obj.get("factsEn");
	    factsDe = (JsonArray) obj.get("factsDe");
	}
	
	public RacoonImageList getAllNormalImages() {
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i = 0; i != images.size(); i++) {
			result.add(JsonDecoder.string(images.get(i)));
		}
		
		return new RacoonImageList(result);
	}
	
	public RacoonImageList getAllBabyImages() {
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i = 0; i != babyImages.size(); i++) {
			result.add(JsonDecoder.string(babyImages.get(i)));
		}
		
		return new RacoonImageList(result);
	}
	
	public RacoonImageList getAllImages() {
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(getAllBabyImages().asStringList());
		result.addAll(getAllNormalImages().asStringList());
		return new RacoonImageList(result);
	}
	
	public RacoonFactList getAllFacts(Language language) {
		ArrayList<String> result = new ArrayList<String>();
		
		if(language.equals(Language.GERMAN)) {
			for(int i = 0; i != factsDe.size(); i++) {
				result.add(JsonDecoder.string(factsDe.get(i)));
			}
		} else if(language.equals(Language.ENGLISH)) {
			for(int i = 0; i != factsEn.size(); i++) {
				result.add(JsonDecoder.string(factsEn.get(i)));
			}
		}
		return new RacoonFactList(result);
	}
	
	public RacoonImage getRandomImage() {
		ArrayList<String> images = getAllImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	public RacoonImage getRandomNormalImage() {
		ArrayList<String> images = getAllNormalImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	public RacoonImage getRandomBabyImage() {
		ArrayList<String> images = getAllBabyImages().asStringList();
		int rnd = ThreadLocalRandom.current().nextInt(0, images.size());
		return new RacoonImage(images.get(rnd));
	}
	
	public RacoonFact getRandomFact(Language language) {
		if(language.equals(Language.GERMAN)) {
			int rnd = ThreadLocalRandom.current().nextInt(0, factsDe.size());
			return new RacoonFact(JsonDecoder.string(factsDe.get(rnd)));
		} else if(language.equals(Language.ENGLISH)) {
			int rnd = ThreadLocalRandom.current().nextInt(0, factsEn.size());
			return new RacoonFact(JsonDecoder.string(factsEn.get(rnd)));
		}
		return null;
	}
	
}
