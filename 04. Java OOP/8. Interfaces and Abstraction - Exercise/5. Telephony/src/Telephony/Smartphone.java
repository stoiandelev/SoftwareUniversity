package Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean hasADigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    hasADigit = true;
                    break;
                }
            }
            if (!hasADigit) sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean hasANonDigit = false;
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    hasANonDigit = true;
                    break;
                }
            }
            if (!hasANonDigit) sb.append("Calling... ").append(number).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

