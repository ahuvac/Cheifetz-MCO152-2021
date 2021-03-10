package cheifetz.scrabble;

import java.util.*;

public class LetterBag {
    private Stack<Character> stack;

    public LetterBag() {
        List<Character> list = Arrays.asList('A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
                                            'B', 'B',
                                            'C', 'C',
                                            'D','D','D','D',
                                            'E','E','E','E','E','E','E','E','E','E','E','E',
                                            'F','F',
                                            'G','G','G',
                                            'H','H',
                                            'I','I','I','I','I','I','I','I','I',
                                            'J',
                                            'K',
                                            'L','L','L','L',
                                            'M','M',
                                            'N','N','N','N','N','N',
                                            'O','O','O','O','O','O','O','O',
                                            'P','P',
                                            'Q',
                                            'R','R','R','R','R','R',
                                            'S','S','S','S',
                                            'T','T','T','T','T','T',
                                            'U','U','U','U',
                                            'V','V',
                                            'W','W',
                                            'X',
                                            'Y','Y',
                                            'Z');

        Collections.shuffle(list);
        stack = new Stack<>();
        stack.addAll(list);

    }

    public char nextLetter() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
