/**
 * Vigenère cipher
 * Created by david on 2015.01.02..
 */
public class Main {

    public static void main(String[] args) {

        //check the args
        if (args.length != 3) {
            System.out.println("mode[\"decode\"|\"encode\"] key input");
            System.exit(1);
        }


        String input = args[2].toLowerCase();
        String key = args[1].toLowerCase();
        String mode = args[0];

        String output = "";

        //create alphabet table
        char matrix[][] = new char[25][25];

        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++) {
                matrix[x][y] = (char) (((x + y) % 25) + 97);
            }
        }

        if ("decode".equals(mode)) {
            for (int i = 0; i < input.length(); i++) {
                for (int x = 0; x < 25; x++) {
                    if (matrix[x][key.charAt(i % key.length()) - 97] == input.charAt(i)) {
                        output += (char) (x + 97);
                        break;
                    }
                }
            }
        } else if ("encode".equals(mode)) {
            for (int i = 0; i < input.length(); i++) {
                output += matrix[input.charAt(i) - 97][key.charAt(i % key.length()) - 97];
            }
        }
        System.out.println("MODE: " + mode);
        System.out.println("KEY: " + key);
        System.out.println("INPUT: " + input);
        System.out.println();
        System.out.print("OUTPUT: " + output);
        System.exit(0);
    }


}
