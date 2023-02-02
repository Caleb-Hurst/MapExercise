package thirdExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapApp {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> player = readFile("PokerHands.csv");
		printMap(player);
		updateKey(player,"Rita Repulsa","Zordon");
		printMap(player);
		updateValue(player,"He Man", 1);
		printMap(player);
		removeItem(player, "He Man");
		printMap(player);
	}

	private static void printMap(Map<String, Integer> player) {
		for (Map.Entry<String, Integer> players : player.entrySet()) {
			System.out.println(players.getKey() + players.getValue());
		}
		System.out.println("-----");
	}

	public static Map<String, Integer> readFile(String fileName) throws IOException {
		BufferedReader br = null;
		String line;
		String flush = "FLUSH";
		Map<String, Integer> player = new HashMap<>();
		try {
			br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String name = values[0];
				String hand = values[1];
				if (hand.equals(flush)) {
					if (player.containsKey(name)) {
						int count = player.get(name);
						player.put(name, count + 1);
					} else {
						player.put(name, 1);
					}
				}
			}
		} finally {
			br.close();
		}

		return player;

	}

	public static void updateKey(Map<String,Integer>player, String oldName,String newName) {
		Integer hand = null;
		for(Map.Entry<String, Integer> players : player.entrySet()) {
			if(players.getKey().equals(oldName)) {
				hand = players.getValue();
			}
		}
		player.put(newName, hand);
		player.remove(oldName);
	}

	public static void updateValue(Map<String,Integer> player,String name,int value) {
		int hand ;
		for(Map.Entry<String, Integer> players : player.entrySet()) {
			if(players.getKey().equals(name)) {
				hand = players.getValue() + value;
				player.put(name, hand);			
			}
		}

	}

	public static void removeItem(Map<String,Integer> player, String name) {
		for(Map.Entry<String, Integer> players : player.entrySet()) {
			if(players.getKey().equals(name)) {
				player.remove(name);
			}
		}
	}

}
