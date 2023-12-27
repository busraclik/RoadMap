import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedList<Town> townLinkedList = new LinkedList<>();
        addTowns(townLinkedList);


        var iterator = townLinkedList.listIterator();

        boolean flag = true;

        while (flag){
            System.out.println("Available actions (select word or letter) :\n" +
                    "(F)orward\n" +
                    "(B)ackward\n" +
                    "(L)ist Places\n" +
                    "(M)enu\n" +
                    "(Q)uit\n ");

            System.out.println("Please enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "f" -> {
                    if(iterator.hasNext()){
                        Town town = iterator.next();
                        System.out.println("city name: " + town.getName() + " distance:  " + town.getDistance());
                    }
                }
                case "b" -> {
                    if(iterator.hasPrevious()){
                        Town town = iterator.previous();
                        System.out.println("city name: " + town.getName() + " distance:  " + town.getDistance());
                    }
                }

                default -> System.out.println("Wrong choice.");
            }
        }


    }

    public static void printList(LinkedList<Town> list){
        var iterator = list.listIterator();

        while (iterator.hasNext()){
            Town town = iterator.next();
            System.out.println("city name: " + town.getName() + " distance:  " + town.getDistance());
        }
    }

    public static void addTowns(LinkedList<Town> list){
        list.add(new Town("Sydney", 0));
        list.add(new Town("Adelaide", 1374));
        list.add(new Town("Alice Springs", 2771));
        list.add(new Town("Brisbane", 917));
        list.add(new Town("Darwin", 3972));
        list.add(new Town("Malbourn", 877));
        list.add(new Town("Perth", 3923));
    }

}