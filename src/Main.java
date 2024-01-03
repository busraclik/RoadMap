import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Town> townLinkedList = new LinkedList<>();

        townLinkedList.addFirst(new Town("Sydney", 0));
        addTowns1(townLinkedList , new Town("Adelaide", 1374));
        addTowns1(townLinkedList, new Town("Alice Springs", 2771));
        addTowns1(townLinkedList , new Town("Brisbane", 917));
        addTowns1(townLinkedList , new Town("Darwin", 3972));
        addTowns1(townLinkedList , new Town("Darwin", 3972));
        addTowns1(townLinkedList , new Town("darwin", 3972));
        addTowns1(townLinkedList , new Town("Melbourne", 877));
        addTowns1(townLinkedList , new Town("Perth", 3923));

        var iterator = townLinkedList.listIterator();
        boolean continueLoop = true;
        boolean forward = true;

        printMenu();
        while (continueLoop){
            //check location
            if (!iterator.hasPrevious()){
                System.out.println("\nStart location: "+ iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()){
                System.out.println("\nFinal location: "+ iterator.previous());
                forward = false;
            }

            String choice = scanner.nextLine().toUpperCase().substring(0,1);

            switch (choice){
                case "F" -> {
                    if (!forward){
                        forward = true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {
                    if (forward){
                        forward = false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }

                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                }
                case "L" -> System.out.println(townLinkedList);
                case "M" -> {
                  printMenu();
                }
                case "Q" -> {
                    System.out.println("Exit...");
                    continueLoop = false;
                }
                default -> printMenu();
            }
        }


    }

    public static void printMenu(){
     System.out.println("\nAvailable actions (select word or letter) :\n" +
                    "(F)orward\n" +
                    "(B)ackward\n" +
                    "(L)ist Places\n" +
                    "(M)enu\n" +
                    "(Q)uit\n ");

            System.out.println("Please enter your choice: ");

    }

//    public static void addTowns(LinkedList<Town> list, Town town){
//        for (Town p : list){
//            if (p.name().equalsIgnoreCase(town.name())){
//                System.out.println("Found duplicate: " + town);
//                return;
//            }
//        }
//        int index = 0;
//        for (Town t : list) {
//            if (town.distance() < t.distance()){
//                list.add(index, town);
//                return;
//            }
//            index++;
//        }
//       list.add(town);
//    }




    public static void addTowns1(LinkedList<Town> list, Town town) {

        for (Town t : list) {
            if (t.name().equalsIgnoreCase(town.name())) {
                System.out.println("Duplicate city: " + town);
                return;
            }
        }

        ListIterator<Town> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Town t = iterator.next();

            if (town.distance() < t.distance()) {
                iterator.previous();
                iterator.add(town);
                return;
            }
        }
        iterator.add(town);
    }


}