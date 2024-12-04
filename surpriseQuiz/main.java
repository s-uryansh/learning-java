import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

interface Saveable {
    ArrayList<String> saveValues();
    void readValues(ArrayList<String> values);
}

class Player implements Saveable {
    private String playerName;
    private int lvl;

    public Player(String name, int level) {
        this.playerName = name;
        this.lvl = level;
    }

    @Override
    public ArrayList<String> saveValues() {
        ArrayList<String> values = new ArrayList<>();
        values.add(playerName);
        values.add(String.valueOf(lvl));
        return values;
    }

    @Override
    public void readValues(ArrayList<String> values) {
        if (values != null && values.size() == 2) {
            this.playerName = values.get(0);
            this.lvl = Integer.parseInt(values.get(1));
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + playerName + "', level=" + lvl + "}";
    }
}
class Monster implements Saveable {
    private String monsterType;
    private int hp;

    public Monster(String type, int health) {
        this.monsterType = type;
        this.hp = health;
    }

    @Override
    public ArrayList<String> saveValues() {
        ArrayList<String> values = new ArrayList<>();
        values.add(monsterType);
        values.add(String.valueOf(hp));
        return values;
    }

    @Override
    public void readValues(ArrayList<String> values) {
        if (values != null && values.size() == 2) {
            this.monsterType = values.get(0);
            this.hp = Integer.parseInt(values.get(1));
        }
    }

    @Override
    public String toString() {
        return "Monster{type='" + monsterType + "', health=" + hp + "}";
    }
}

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String x=s.nextLine();
        System.out.println("Enter player level: ");
        int y=s.nextInt();
        s.nextLine();
        System.out.println("Enter monster type: ");
        String z=s.nextLine();
        System.out.println("Enter monster health: ");
        int a=s.nextInt();
        Player player = new Player(x, y);
        Monster monster = new Monster(z, a);

        saveObject(player);
        saveObject(monster);

        // Simulating reading values
        ArrayList<String> playerData = readValues("Warrior", "15");
        ArrayList<String> monsterData = readValues("Goblin", "50");

        player.readValues(playerData);
        monster.readValues(monsterData);

        System.out.println(player);
        System.out.println(monster);
    }

    public static void saveObject(Saveable object) {
        ArrayList<String> values = object.saveValues();
        System.out.println("Saving values: " + values);
    }

    public static ArrayList<String> readValues(String... values) {
        return new ArrayList<>(Arrays.asList(values));
    }
}