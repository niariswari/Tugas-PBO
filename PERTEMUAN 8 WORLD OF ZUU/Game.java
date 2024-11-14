public class Game {
    private Room currentRoom;

    public Game() {
        createRooms();
    }

    private void createRooms() {
        Room outside, theater, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the admin office");

        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() {
        printWelcome();
        boolean finished = false;
        while (!finished) {
            String command = Parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    private boolean processCommand(String command) {
        if (command.equals("help")) {
            printHelp();
        } else if (command.startsWith("go ")) {
            goRoom(command.substring(3));
        } else if (command.equals("quit")) {
            return true;
        } else {
            System.out.println("I don't understand that command...");
        }
        return false;
    }

    private void goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
}
