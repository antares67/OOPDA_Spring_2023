package serialize;

import java.io.*;
import java.util.ArrayList;


public class SerializePlayer1 {
	
	private static String FILE_NAME = "C://temp//player1.ser";
	
	public static void serializePlayer()	{
		
		ArrayList<Statistic> stats = new ArrayList<Statistic>();
		stats.add(new Statistic(Statistic.StatType.STRENGTH, 11));
		stats.add(new Statistic(Statistic.StatType.AGILITY, 11));
		stats.add(new Statistic(Statistic.StatType.STAMINA, 180));
		stats.add(new Statistic(Statistic.StatType.INTELLECT, 163));
		stats.add(new Statistic(Statistic.StatType.SPIRIT, 17));
		
		Player player = new Player("Jaxxon", Player.Race.ELF, Player.Role.MAGE,
				'M', 45, stats, Zone.SWAMP_OF_SORROWS);
		
		try {
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(player);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for player %s is saved in %s", 
					player.getName(), FILE_NAME);
		} 
		catch (IOException i) {
			i.printStackTrace();
		}
	}
}