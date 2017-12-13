import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;

class Node {
  int count;
  char data;
  ArrayList<Node> node = new ArrayList<Node>();

  Node(char c) {
    count = 1;
    data = c;
    for(int i=0; i<26; i++) {
      node.add(null);
    }
  }
}

class NodeOps {
  Node root = new Node('/');

  NodeOps() {
    insert("apple");
    insert("animal");
    insert("api");
    insert("block");
    insert("black");
    insert("blank");
    insert("car");
    insert("door");
    insert("computer");
    insert("homework");

    for(int i=0; i<30000; i++) {
      insert(genStr());
    }

    System.out.println(search("apple"));
    System.out.println(search("api"));
    System.out.println(search("blank"));
    System.out.println(search("train"));
    System.out.println(search("drink"));
    System.out.println(search("car"));
    System.out.println(search("blink"));
    System.out.println(search("homework"));
    System.out.println(search("salt"));
    System.out.println(search("sugar"));

    for(int i=0; i<30000; i++) {
      search(genStr());
    }
  }

  void insert(String s) {
    Node branch = root;

    for(int i=0; i<s.length(); i++) {
      int total = branch.count;

      char c = s.charAt(i);
      int num = Character.getNumericValue(c)-10;

      if(branch.node.get(num) == null) {
        branch.node.set(num, new Node(c));
        branch.node.get(num).count = total+1;
        branch = branch.node.get(num);
      } else {
        branch = branch.node.get(num);
      }
    }
  }

  boolean search(String s) {
    Node branch = root;

    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      int num = Character.getNumericValue(c)-10;

      if(branch.node.get(num) == null) {
        return false;
      }

      branch = branch.node.get(num);
    }

    return true;
  }

  String genStr() {
    String str = "";
    for(int i=0; i<(int)(Math.random()*10+1); i++) {
      char c = (char)(Math.floor(Math.random() * 26 + 97));
      String s = String.valueOf(c);
      str = str + s;
    }

    return str;
  }

  public static void main(String args[]) {
    long timeStrt = System.currentTimeMillis();
    long memStrt = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

    new NodeOps();

    long memEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long timeEnd = System.currentTimeMillis();

    long memDif = memEnd - memStrt;
    long timeDif = timeEnd - timeStrt;

    System.out.println(memDif/1024+" KB");
    System.out.println(timeDif+" ms");
  }
}
