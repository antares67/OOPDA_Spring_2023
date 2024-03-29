package serialize;

import java.io.Serializable;
import java.util.ArrayList;

/** Player class
 * 
 * @version 2.0
 * @author J. Myers
 *
 */
public class Player implements Serializable {
	
	//private static final long serialVersionUID = -8274170900300199913L; // v1 UID
	private static final long serialVersionUID = 7023486349133662975L;  // v2 UID
	
	/* This class is modeled to demonstrate serialization
	 * In version 1 of this class, the serialVersionUID was -8274170900300199913L
	 * (see commented line above).
	 * 
	 * When this class was updated to add the new role of SHAMAN, a new 
	 * serialVersionUID was established, namely 7023486349133662975L.
	 * 
	 * If you want to use this class to generate a version 1 object, you 
	 * need to reinstate the old code for serialVersionUID and Role.
	 * 
	 * Then you can test deserialization with a version 1 Player and a
	 * version 2 Player.
	 */
	
	private String name;	
	private Race race;
	private Role role;
	private char gender;
	private int level;
	private ArrayList<Statistic> stats;
	private Zone zone;
	
	public enum Race { HUMAN, DWARF, ELF, ORC, TROLL, GOBLIN }
	
	//public enum Role { WARRIOR, PRIEST, HUNTER, MAGE, PALADIN, WARLOCK, ROGUE }  // v1 Roles
	public enum Role { WARRIOR, PRIEST, HUNTER, MAGE, PALADIN, WARLOCK, ROGUE, SHAMAN }  // v2 Roles
	
	public Player(String name, Race race, Role role, char gender, int level,
			ArrayList<Statistic> stats, Zone zone) {
		this.name = name;
		this.race = race;
		this.setRole(role);
		this.gender = gender;
		this.level = level;
		this.stats = stats;
		this.zone = zone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ArrayList<Statistic> getStats() {
		return stats;
	}

	public void setStats(ArrayList<Statistic> stats) {
		this.stats = stats;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	};
	
	
}