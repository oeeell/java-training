import java.util.ArrayList;
import java.util.Scanner;

// Abstract class for Pokemon
abstract class Pokemon {
  String name;
  int level;
  int hp;
  int attack;
  int defense;

  public abstract void attack(Pokemon enemy);
  public abstract void levelUp();
}