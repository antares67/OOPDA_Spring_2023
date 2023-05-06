package serialize;

import java.io.*;

public class DeserializeDemo {

	private static String FILE_NAME_1 = "C://temp//player1.ser";
	private static String FILE_NAME_2 = "C://temp//player2.ser";
	
	public static void deserializePlayers() {
		Player player1, player2;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		
		System.out.println("Deserializing player 1...\n");
		try {
			fileIn = new FileInputStream(FILE_NAME_1);
			in = new ObjectInputStream(fileIn);
			player1 = (Player) in.readObject();
			in.close();
			fileIn.close();
			displayPlayer(player1);
		} 
		catch (ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return;
		}
		catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		}
		finally {
			try {
				in.close();
				fileIn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}
		
		System.out.println("Deserializing player 2...\n");		
		try {
			fileIn = new FileInputStream(FILE_NAME_2);
			in = new ObjectInputStream(fileIn);
			player2 = (Player) in.readObject();
			in.close();
			fileIn.close();
			displayPlayer(player2);
		} 
		catch (IOException i) {
			i.printStackTrace();
			return;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return;
		}
		catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		}
		finally {
			try {
				in.close();
				fileIn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}



	}
	
	private static void displayPlayer(Player p) {
		System.out.println("  Name: " + p.getName());
		System.out.println("Gender: " + p.getGender());	
		System.out.println(" Level: " + p.getLevel());		
		System.out.println("  Race: " + p.getRace());
		System.out.println("  Role: " + p.getRole());
		System.out.println("  Zone: " + p.getZone());
		System.out.print  (" Stats:");
		for (Statistic s : p.getStats()) {
			System.out.println("\t" + s.getType() + ": " + s.getValue());
		}
	}
}