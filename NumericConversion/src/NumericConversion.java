import java.util.Scanner;
public class NumericConversion {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        int hex = 0;
        boolean quit = false;
        String stringConversion = "";
        char charConversion[];


        //Helps it do a full loop so it never stops until you pick menu option 4
        while (quit == false) {

            Menu();
            choice = scanner.nextInt();

            if (choice != 4){
                System.out.println("Please enter the numeric string to convert:");
                stringConversion = scanner.next();
                stringConversion = stringConversion.toLowerCase();
            }

            // switch over if because its much more organized
            switch (choice) {

                //Decode hexadecimal menu option
                case 1: {

                    if (stringConversion.length() == 1) {
                        charConversion = stringConversion.toCharArray();
                        System.out.println("Result:" + hexCharDecode(charConversion[0]));
                    } else {
                        System.out.println("Result: " + hexStringDecode(stringConversion));
                    }
                    break;
                }

                //Decode binary menu option
                case 2: {

                    System.out.println("Result:" + binaryStringDecode(stringConversion));

                    break;
                }

                //Binary to hexadecimal menu option
                case 3: {

                    System.out.println("Result:" + binaryToHex(stringConversion));

                    break;

                }

                // Quit menu option
                case 4: {
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                }
                default: {
                    Menu();
                    choice = scanner.nextInt();
                }
            }
        }
     }

        //Decodes an entire hexadecimal string and returns its value but with strings
        public static long hexStringDecode (String hex){
            if (hex.charAt(0) == '0' && hex.charAt(1) == 'x') {
                return Long.parseLong(hex.substring(2), 16);
            }
                else {
                    return Long.parseLong(hex, 16);
                }
        }

        //Decodes a single hexadecimal digit and returns its value but with char
        public static short hexCharDecode (char digit){
            short value = 0;
            if (Character.getNumericValue(digit) <= 9 && Character.getNumericValue(digit) >= 0) {
                value = (short) Character.getNumericValue(digit);
            } else {
                switch (digit) {
                    case ('a'):
                        value = 10;
                        break;
                    case ('b'):
                        value = 11;
                        break;
                    case ('c'):
                        value = 12;
                        break;
                    case ('d'):
                        value = 13;
                        break;
                    case ('e'):
                        value = 14;
                        break;
                    case ('f'):
                        value = 15;
                        break;
                    case ('A'):
                        value = 10;
                        break;
                    case ('B'):
                        value = 11;
                        break;
                    case ('C'):
                        value = 12;
                        break;
                    case ('D'):
                        value = 13;
                        break;
                    case ('E'):
                        value = 14;
                        break;
                    case ('F'):
                        value = 15;
                        break;
                }
            }
            return value;
        }

        //Decodes a binary string and return its value
        public static short binaryStringDecode (String binary){
            String binaryConvert;
            short value = 0;
            short valueTotal = 0;
            binaryConvert = binary.toLowerCase();
            if (binaryConvert.startsWith("0b")) {
                binaryConvert = binaryConvert.substring(2);
            }
            for (int a = binaryConvert.length(); a > 0; a--) {
                if (Character.getNumericValue(binaryConvert.charAt(a - 1)) <= 1 && Character.getNumericValue(binaryConvert.charAt(a - 1)) >= 0) {
                    value = (short) (Character.getNumericValue(binaryConvert.charAt(a - 1)) * Math.pow(2, (binaryConvert.length() - a)));
                }
                valueTotal += value;
            }
            return valueTotal;

        }

        //Decode a binary string
        //Re-encoded it as hexadecimal, and returns the hexadecimal string
        public static String binaryToHex (String binary){
            String binaryConvert = binary.toLowerCase();
            if (binaryConvert.startsWith("0b")) {
                binaryConvert = binaryConvert.substring(2);
            }
            int decimal = binaryStringDecode(binaryConvert);
            int rem;
            String result = "";

            //hexdecimal number system
            char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

            while (decimal > 0) {
                rem = decimal % 16;
                result = hex[rem] + result;
                decimal = decimal / 16;
            }
            return result;

        }
    // Doing the menu this way makes it easier to make the menu repeat whenever needed
    public static void Menu() {
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println("Please enter an option: ");
    }
}
