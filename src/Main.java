/**
 * Vigenère cipher
 * Created by david on 2015.01.02..
 */
public class Main {

    private static int ABC_OFFSET = 0;

    public static void main(String[] args) {


        if (args.length != 3) {
            System.out.println("mode[\"decode\"|\"encode\"] key input");
            System.exit(1);
        }

        String input = args[2];
        String key = args[1];
        String mode = args[0];

        String output = "";

        char matrix[][] = new char[25][25];

        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++) {
                matrix[x][y] = (char) (((ABC_OFFSET + x + y) % 25) + 97);
            }
        }

        if ("decode".equals(mode)) {
            for (int i = 0; i < input.length(); i++) {
                for (int x = 0; x < 25; x++) {
                    char tmp = matrix[x][key.charAt(i % key.length()) - 97];
                    if (tmp == input.charAt(i)) {
                        output += matrix[x][0];
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                output += matrix[input.charAt(i) - 97][key.charAt(i % key.length()) - 97];
            }
        }
        System.out.println("MODE: " + mode);
        System.out.println("KEY: " + key);
        System.out.println("INPUT: " + input);
        System.out.println();
        System.out.print("OUTPUT: " + output);
    }


}
