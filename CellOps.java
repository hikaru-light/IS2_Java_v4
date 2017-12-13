import java.lang.Math;
import java.util.Random;

class Cell {
  int count;
  String data;
  Cell next;

  Cell(String s) {
    count = 0;
    data = s;
    next = null;
  }
}

class CellOps {
  Cell header = new Cell("");
  Cell p;

  CellOps() {
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
    Cell x = new Cell(s);

    if (header.next == null){
      header.next = x;
      header.next.count = 1;
      p = header.next;
    }else{
      int total = p.count;
      p.next = x;
      p.next.count = total + 1;
      p = p.next;
    }
  }

  boolean search(String s) {
    Cell q = header.next;

    for(int i=0; i<p.count; i++){
      if(q.data == s) {
        return true;
      } else {
        q = q.next;
      }
    }

    return false;
  }

  String printList() {
    String s = "[ ";

    Cell cur = header.next;
    while(cur != null){
      s += cur.data + " ";
      cur = cur.next;
    }

    s += "]";
    return s;
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
    new CellOps();
    long memEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long timeEnd = System.currentTimeMillis();
    long memDif = memEnd - memStrt;
    long timeDif = timeEnd - timeStrt;
    System.out.println(memDif/1024+" KB");
    System.out.println(timeDif+" ms");
  }
}
