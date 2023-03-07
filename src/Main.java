public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("Welcome", "What car do you wish to rent?",
                "\nClick 1. For Luxury car" +
                "\nClick 3. For family car" +
                "\nClick 4. For Sports car" +
                "\nClick 9. (End session)" + "\n" );
        menu.readchoice();


    }

}
