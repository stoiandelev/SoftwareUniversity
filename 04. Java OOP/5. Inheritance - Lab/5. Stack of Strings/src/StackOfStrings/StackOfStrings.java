package StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        return this.data.remove(0);
    }

    public String peek() {
        return String.format(this.data.get(0));
    }

    public boolean isEmpty() {
        return this.data.isEmpty();

    }

}
