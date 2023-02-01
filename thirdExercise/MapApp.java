package thirdExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapApp {
	public static void main(String[] args) throws IOException {
		Map<String, String> player = readFile("PokerHands.csv");

	}

	private static void printMap(Map<String, String> player, int counter) {
		for(Map.Entry<String, String> players : player.entrySet()) {
			System.out.println(players.getKey() + counter);
		}
	}
	
	 public static Map<String, String> readFile(String fileName) throws IOException{
		BufferedReader br = null;
		String line;
		Map<String, String> player = new HashMap<String, String>();
		Integer counter = Integer.valueOf(1);
		try {
			br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while((line = br.readLine())!= null) {
				String[] values = line.split(",");
				String key = values[0];
				String value = values[1];
				if(player.containsKey(key)) {
					counter = player.get(key) + 1;
				}
				player.put(key,value);			
			}
		}finally {
//			printMap(player, counter);
			br.close();
		}
		
		return player;
		
	}
	public static void updateKey() {
		
	}
	public static void print() {
		
	}
	public static void updateValue() {
		
	}
	public static void removeItem() {
		
	}


}
