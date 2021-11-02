import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner Cylon = new Scanner(System.in);

        //Задача 9
        int n = Integer.parseInt(Cylon.nextLine());
        String input = Cylon.nextLine();

        int dnaLength,dnaCurrentLength, dnaSumMax = 0, dnaSum, dnaSequence = 0, dnaLengthMax = 0,
                indexDNA = 0, indexDNAMin = Integer.MIN_VALUE,
                bestDNASequence = 1;
        int[] bestDNASequenceArray = new int[n];

        while(!input.equals("Clone them!")) {
            dnaSum = 0;
            dnaLength = 0;
            dnaCurrentLength = 0;
            dnaSequence++;
            int[] dna = Arrays.stream(input.split("!+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

            if(dna.length-1 > n) {
                System.out.printf("Best DNA sample 1 with sum: 0.%n");
                for (int i = 0; i < n; i++) {
                    System.out.println("0 ");
                }
                return;
            }

            for (int i = 0; i < n; i++) { // loop elements

                if (dna[i] == 1) {
                    dnaCurrentLength++;
                    if (dnaCurrentLength > dnaLength) { // Inside "1" max length for multiple subchains
                        dnaLength = dnaCurrentLength;
                        indexDNA = i; // Index of LAST "1"
                    }
                } else {
                    dnaCurrentLength = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                if (dna[i] == 1) { dnaSum++; } // NO TOUCH
            }

            if (dnaLength > dnaLengthMax) { //Best Length
                dnaLengthMax = dnaLength;
                indexDNAMin = indexDNA;
                dnaSumMax = dnaSum;

                bestDNASequence = dnaSequence;
                bestDNASequenceArray = dna;
            } else if (indexDNA < indexDNAMin && dnaLength >= dnaLengthMax) { //Best First Index
                indexDNAMin = indexDNA;
                dnaSumMax = dnaSum;

                bestDNASequence = dnaSequence;
                bestDNASequenceArray = dna;
            } else if (dnaSum > dnaSumMax && dnaLength >= dnaLengthMax && indexDNA <= indexDNAMin) { //Best SUM
                dnaSumMax = dnaSum;

                bestDNASequence = dnaSequence;
                bestDNASequenceArray = dna;
            }


            input = Cylon.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNASequence, dnaSumMax);
        for (int i = 0; i < bestDNASequenceArray.length; i++) {
            System.out.printf("%d ", bestDNASequenceArray[i]);
        }




    }
}

