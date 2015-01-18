// https://code.google.com/p/newmuis-codeeval/source/browse/CodeEval.com/src/com/newmuis/open/codeeval/moderate/pangrams.java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class pangrams {
        /**
         * @param args should contain only one CLI argument: the path to an input file which specifies
         *            the input in the defined format.
         * @throws IOException if there is a problem reading the given input file.
         */
        public static void main(final String[] args) throws IOException {
                // Verify input argument length.
                if (args.length < 1) {
                        throw new RuntimeException("Must specify input file path.");
                } else if (args.length > 1) {
                        throw new RuntimeException("Illegal input arguments specified.");
                }

                // Read file from specified path.
                final BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
                String line;

                final char[] allCharacters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

                while ((line = reader.readLine()) != null) {
                        final TreeSet<Character> charactersPresent = new TreeSet<Character>();

                        // Parse the line into letters.
                        final char[] letters = line.toLowerCase().toCharArray();

                        // Keep a set of those that are present.
                        for (final char letter : letters) {
                                charactersPresent.add(letter);
                        }

                        // Print the letters present in the alphabet but not in the input.
                        final StringBuilder missingLettersBuilder = new StringBuilder();
                        for (final char character : allCharacters) {
                                if (!charactersPresent.contains(character)) {
                                        missingLettersBuilder.append(character);
                                }
                        }

                        if (missingLettersBuilder.length() == 0) {
                                System.out.println("NULL");
                        } else {
                                System.out.println(missingLettersBuilder.toString());
                        }
                }
        }
}

