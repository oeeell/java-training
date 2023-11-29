import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  Scanner scanner = new Scanner(System.in);
  ArrayList<Pokemon> party = new ArrayList<Pokemon>();

// Class for Charmander, a Fire-type Pokemon
class Charmander extends Pokemon implements FireType {
  public Charmander() {
    name = "Charmander";
    level = 5;
    hp = 20;
    attack = 10;
    defense = 5;
  }

  @Override
  public void attack(Pokemon enemy) {
    enemy.hp -= this.attack;
  }

  @Override
  public void levelUp() {
    level++;
    hp += 5;
    attack += 2;
    defense += 1;
  }

  @Override
  public void fireBlast() {
    System.out.println(name + " used Fire Blast!");
  }
}

// Class for Squirtle, a Water-type Pokemon
class Squirtle extends Pokemon {
  public Squirtle() {
    name = "Squirtle";
    level = 5;
    hp = 25;
    attack = 8;
    defense = 7;
  }

  @Override
  public void attack(Pokemon enemy) {
    enemy.hp -= this.attack;
  }

  @Override
  public void levelUp() {
    level++;
    hp += 5;
    attack += 2;
    defense += 1;
  }
}


 Main(){
 
  party.add(new Charmander());
  party.add(new Squirtle());

  while (true) {
    System.out.println("Select a Pokemon (1 or 2):");
    int selection = scanner.nextInt();
    Pokemon selectedPokemon = party.get(selection - 1);

    System.out.println("1. Attack");
    System.out.println("2. Level up");
    int action = scanner.nextInt();

    if (action == 1) {
      selectedPokemon.attack(party.get(1 - selection));
    } else if (action == 2) {
      selectedPokemon.levelUp();
    }

    System.out.println("Charmander HP: " + party.get(0).hp);
    System.out.println("Squirtle HP: " + party.get(1).hp);
  }
 }
 
  public static void main(String[] args) {
   new Main();
  }
}
