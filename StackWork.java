import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StackWork {
    public static void main(String[] args) {
        String path = "file.txt";
        String text = read(path);
        Stack stek = new Stack(10);
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            switch (ch) {
                case '(':
                    stek.push(ch);
                    break;
                case ')':
                    if (!stek.isEmpty()) {
                        if (stek.pop()!='(') System.out.println("Error. Excessive right bracket.");
                    } else System.out.println("Error. Excessive right bracket.");
                    break;
                default:
                    break;
            }
        }
        if (!stek.isEmpty()) {
            System.out.println("Error. At least one not closed bracket.");
        }
    }


    static String read(String Path)
    {
        StringBuilder sb = new StringBuilder();

        try (Stream <String> stream = Files.lines( Paths.get(Path), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> sb.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

}

class Stack {
    private int stackSize;
    private char[] stackArray;
    private int top;

    public Stack(int n){
        this.stackSize=n;
        this.stackArray = new char[stackSize];
        this.top = -1;
    }

    public void push(char ch){
        stackArray[++top] = ch;
    }

    public char pop(){
        return stackArray[top--];
    }

    public char top(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == - 1;
    }

    public boolean isFull(){
        return top == stackSize-1;
    }

}