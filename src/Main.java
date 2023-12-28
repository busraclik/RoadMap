import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Town> townLinkedList = new LinkedList<>();

        addTowns(townLinkedList , new Town("Sydney", 0));
        addTowns(townLinkedList , new Town("Adelaide", 1374));
        addTowns(townLinkedList , new Town("Alice Springs", 2771));
        addTowns(townLinkedList , new Town("Brisbane", 917));
        addTowns(townLinkedList , new Town("Darwin", 3972));
        addTowns(townLinkedList , new Town("Melbourne", 877));
        addTowns(townLinkedList , new Town("Perth", 3923));

        var iterator = townLinkedList.listIterator();
        boolean flag = true;
        boolean forward = true;

        while (flag){
            //check location
            if (!iterator.hasPrevious()){
                System.out.println("\nStart location: "+ iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()){
                System.out.println("\nFinal location: "+ iterator.previous());
                forward = false;
            }

            System.out.println("\nAvailable actions (select word or letter) :\n" +
                    "(F)orward\n" +
                    "(B)ackward\n" +
                    "(L)ist Places\n" +
                    "(M)enu\n" +
                    "(Q)uit\n ");

            System.out.println("Please enter your choice: ");
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
                  continue;
                }
                case "Q" -> {
                    System.out.println("Exit...");
                    flag = false;
                }
                default -> System.out.println("Wrong choice.");
            }
        }


    }

//    public static void printList(LinkedList<Town> list){
//        var iterator = list.listIterator();
//
//        while (iterator.hasNext()){
//            Town town = iterator.next();
//            System.out.println( town.getName() + " " + town.getDistance());
//        }
//    }

    public static void addTowns(LinkedList<Town> list, Town town){
        int index = 0;
        for (Town t : list) {
            if (town.getDistance()  < t.getDistance()){
                list.add(index, town);
                return;
            }
            index++;
        }
       list.add(town);
    }

}