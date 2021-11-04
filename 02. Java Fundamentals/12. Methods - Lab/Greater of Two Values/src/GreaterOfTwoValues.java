import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type=scanner.nextLine();
        String a=scanner.nextLine();
        String b=scanner.nextLine();

        switch (type){
            case "int":
                System.out.println(GetMax(Integer.parseInt(a),Integer.parseInt(b)));
                break;
            case "char":
                System.out.println(GetMax(a.charAt(0),b.charAt(0)));
                break;
            case "string":
                System.out.println(GetMax(a,b));
                break;

        }
    }

    private static int GetMax(int firstNum, int secondNum) {
        return Math.max(firstNum,secondNum);
    }

    private static char GetMax(char firstChar, char secondChar) {
        if(firstChar>=secondChar){
            return firstChar;
        }else {
            return secondChar;
        }
    }

    private static String GetMax(String first, String second){
        if(first.compareTo(second)>=0){
            return first;
        }else{
            return second;
        }
    }


}
