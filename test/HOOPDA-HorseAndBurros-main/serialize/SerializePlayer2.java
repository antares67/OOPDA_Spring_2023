package serialize;

import java.io.*;
import java.util.ArrayList;

public class SerializePlayer2 {
	
	private static String FILE_NAME = "C://temp//player2.ser";
	
	public static void serializePlayer()	{
		
		ArrayList<Statistic> stats = new ArrayList<Statistic>();
		stats.add(new Statistic(Statistic.StatType.STRENGTH, 7));
		stats.add(new Statistic(Statistic.StatType.AGILITY, 7));
		stats.add(new Statistic(Statistic.StatType.STAMINA, 134));
		stats.add(new Statistic(Statistic.StatType.INTELLECT, 114));
		stats.add(new Statistic(Statistic.StatType.SPIRIT, 59));
		
		Player player = new Player("Trysta", Player.Race.ELF, Player.Role.PRIEST,
				'F', 40, stats, Zone.TANAAN_JUNGLE);
		
		try {
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(player);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for player %s is saved in %s", 
					player.getName(), FILE_NAME);		} 
		catch (IOException i) {
			i.printStackTrace();
		}
	}
}