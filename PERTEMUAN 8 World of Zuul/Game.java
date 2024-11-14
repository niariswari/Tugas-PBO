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
        printWelcome();  // Menampilkan pesan sambutan
        boolean finished = false;
        while (!finished) {
            String command = Parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    private boolean processCommand(String command) {
        if (command.equals("help")) {
            printHelp();  // Menampilkan bantuan
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

    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Type 'help' if you need help.");
        System.out.println(currentRoom.getLongDescription());
    }

    private void printHelp() {
        System.out.println("You are in a room. You can go to other rooms by typing 'go <direction>'.");
        System.out.println("Valid directions are: north, south, east, west.");
        System.out.println("Type 'quit' to end the game.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
