import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner reader = new Scanner(System.in);
        char inputVersion;
        int version = 9;
        int versionIndex;
        boolean correctInput = false;
        String[] productCode = new String[10];
        int[] randomFourDigit = new int[4];

        while (!correctInput) {
            System.out.println("Select version: (S)tandard/(P)rofessional/(T)echnical/(E)nterprise:");
            try{
                inputVersion = reader.nextLine().charAt(0);
                correctInput = true;
                switch (inputVersion){
                    case 'S':
                        version = 9;
                        break;
                    case 'P':
                        version = 4;
                        break;
                    case 'T':
                        version = 2;
                        break;
                    case 'E':
                        version = 7;
                        break;
                    default:
                        correctInput = false;
                }
            }
            catch (Exception e){
                System.out.println("Enter first letter of selected version");
                correctInput = false;
            }
        }

        versionIndex = randomGenerator.nextInt(1,5) ;
        productCode[0] = String.valueOf(versionIndex + 1);
        productCode[versionIndex] = String.valueOf(version);

        int writeIndex = 1;
        int randomFourDigitSum = 0;
        for (int i = 0; i < randomFourDigit.length; i++) {
            int newNumber = randomGenerator.nextInt(9);
            randomFourDigit[i] = newNumber;
            while (writeIndex == versionIndex){
                writeIndex++;
            }
            productCode[writeIndex] = String.valueOf(newNumber);
            randomFourDigitSum += newNumber;
            writeIndex ++;
        }
        productCode[6] = String.valueOf(randomFourDigitSum % 9);

        for (int i = 0; i < 3; i++) {
            char randomChar = (char)(randomGenerator.nextInt(26) + 'a');
            productCode[7+i] = String.valueOf(randomChar).toUpperCase();
        }
    }
}
