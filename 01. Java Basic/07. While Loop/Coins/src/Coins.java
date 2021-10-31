import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input=Double.parseDouble(scanner.nextLine());
        double inputInCoins=Math.floor(input*100);

        int count=0;

        while(inputInCoins>0){
            if(inputInCoins>=200){
                inputInCoins-=200;
                count++;
            }else if(inputInCoins>=100){
                inputInCoins-=100;
                count++;
            }else if(inputInCoins>=50){
                inputInCoins-=50;
                count++;
            }else if(inputInCoins>=20){
                inputInCoins-=20;
                count++;
            }else if(inputInCoins>=10){
                inputInCoins-=10;
                count++;
            }else if(inputInCoins>=5){
                inputInCoins-=5;
                count++;
            }else if(inputInCoins>=2){
                inputInCoins-=2;
                count++;
            }else if(inputInCoins>=1){
                inputInCoins-=1;
                count++;
            }
        }
        System.out.println(count);

















    }
}
