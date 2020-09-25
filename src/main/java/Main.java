import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Country Lookup Service!" +
                "\n" +
                "\nWould you like to get Real-Time data, or use your local data?" +
                "\n" +
                "\n1: Real-Time" +
                "\n2: Local Data" +
                "\n");

        Scanner scan1 = new Scanner(System.in);

        int select = scan1.nextInt();

        while (select != 1 && select != 2) {
            System.out.println("Please choose 1 or 2");
            select = scan1.nextInt();
        }

        System.out.println("Please enter two-character country code");

        Scanner scan2 = new Scanner(System.in);

        String countryCode = scan2.nextLine().toUpperCase();

        Map map;

        boolean repeat = true;
        String prompt = "";


            switch (select) {
                case 1:

                    map = API_Utilities.mapFromURL();

                    while (repeat) {

                        while (!API_Utilities.countryListAsSet(map).contains(countryCode)) {
                            System.out.println("Please enter a valid country list from the list below");
                            API_Utilities.printCountryList(map);
                            countryCode = scan2.nextLine().toUpperCase();
                        }
                        API_Utilities.getData(countryCode, map);

                        System.out.println("\nWould you like to lookup for another country?" +
                                "\nY: Yes" +
                                "\nN: No" +
                                "\n");

                        prompt = scan2.nextLine().toLowerCase();

                        while(!prompt.equals("y") && !prompt.equals("n")) {
                            System.out.println("Please enter Y or N as response");
                            prompt = scan2.nextLine().toLowerCase();
                        }

                        if (prompt.equals("y")) {
                            repeat = true;

                            System.out.println("Please enter two-character country code");

                            countryCode = scan2.nextLine().toUpperCase();

                        } else if (prompt.equals("n")){
                            repeat = false;

                            System.out.println("\nThank you for using Country Lookup Service!");

                        }

                    }

                    break;

                case 2:

                    map = API_Utilities.mapFromFile();

                    while (repeat) {

                        while (!API_Utilities.countryListAsSet(map).contains(countryCode)) {
                            System.out.println("Please enter a valid country list from the list below");
                            API_Utilities.printCountryList(map);
                            countryCode = scan2.nextLine().toUpperCase();
                        }
                        API_Utilities.getData(countryCode, map);

                        System.out.println("\nWould you like to lookup for another country?" +
                                "\nY: Yes" +
                                "\nN: No" +
                                "\n");

                        prompt = scan2.nextLine().toLowerCase();

                        while(!prompt.equals("y") && !prompt.equals("n")) {
                            System.out.println("Please enter Y or N as response");
                            prompt = scan2.nextLine().toLowerCase();
                        }

                        if (prompt.equals("y")) {
                            repeat = true;

                            System.out.println("Please enter two-character country code");

                            countryCode = scan2.nextLine().toUpperCase();

                        } else if (prompt.equals("n")){
                            repeat = false;

                            System.out.println("\nThank you for using Country Lookup Service!");

                        }

                    }

                    break;

            }




    }
}
