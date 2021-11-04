import java.util.Calendar;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isValid=false;

        String password=scanner.nextLine();

        boolean firstRules=passwordLength(password,isValid);
        boolean secondRules=passwordConsists(password,isValid);
        boolean thirdRules=passwordHave2digits(password,isValid);

        if(firstRules&&secondRules&&thirdRules){
            System.out.println("Password is valid");
        }


    }

    private static boolean passwordLength(String password, boolean isValid) {
        if(password.length()>=6 && password.length()<=10){
            isValid=true;
        }else{
            System.out.println("Password must be between 6 and 10 characters");
        }
        return isValid;
    }

    private static boolean passwordConsists(String password, boolean isValid) {
        for (int i = 0; i <password.length() ; i++) {
            if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))){
                isValid=false;
                System.out.println("Password must consist only of letters and digits");
                break;
            }else{
                isValid=true;
            }

        }
        return isValid;
    }

    private static boolean passwordHave2digits(String password, boolean isValid) {
        int digitCounter=0;
        for (int i = 0; i <password.length() ; i++) {

            if(Character.isDigit(password.charAt(i))){
                digitCounter++;
            }
        }
        if(digitCounter>=2){
            isValid=true;
        }else{
            System.out.println("Password must have at least 2 digits");
        }
        return isValid;

    }
}
