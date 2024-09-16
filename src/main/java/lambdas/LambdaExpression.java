package lambdas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventListener;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {
        //create a new Thread. Note that Runnable is a Functional Interface
        Thread thread = new Thread(() -> System.out.println("Testing lambdas"));

        /**
         * addActionListener takes ActionListener as a parameter. ActionListener is a functional interface
         *          public interface ActionListener extends EventListener {
         *             public void actionPerformed(ActionEvent e);
         *          }
         */
        JButton button = new JButton();
        button.addActionListener((event) -> {
            System.out.println("Perform button clicked event");
        });

        /**
         * @FunctionalInterface
         * public interface Comparator<T> {
         *  int compare(T o1, T o2);
         * }
         */
        List<String> numbers = List.of();
        Comparator<String> stringComparator = (x, y) -> {
            return x.compareTo(y);
        };
        Collections.sort(numbers, stringComparator);
    }
}
