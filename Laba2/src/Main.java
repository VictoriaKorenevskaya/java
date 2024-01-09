
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String inputString = reader.readLine();
            System.out.println("Input String: " + inputString);

            System.out.print("Enter a string with delimiters: ");
            String delimiters = reader.readLine();

            String[] tokens = tokenize(inputString, delimiters);

            int[] octalNumbers = findOctalNumbers(tokens);
           
            processDates(tokens, writer); 
            addRandomNumber(tokens);
            removeShortestDigitEndingSubstring(tokens);

            writer.write("Integers in the 8th number system:\n");
            for (int i = 0; i < octalNumbers.length; i++) {
                writer.write(octalNumbers[i] + "\n");
            }

            writer.write("Tokens:\n");
            for (int i = 0; i < tokens.length; i++) {
                writer.write(tokens[i] + "\n");
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static String[] tokenize(String inputString, String delimiters) {
        return inputString.split("[" + delimiters + "]+");
    }

    
    private static int[] findOctalNumbers(String[] tokens) {
        List<Integer> octalNumbersList = new ArrayList<>();
        for (String token : tokens) {
            try {
                int octalNumber = Integer.parseInt(token, 8);
                octalNumbersList.add(octalNumber);
            } catch (NumberFormatException ignored) {
            }
        }
        int[] octalNumbersArray = new int[octalNumbersList.size()];
        for (int i = 0; i < octalNumbersList.size(); i++) {
            octalNumbersArray[i] = octalNumbersList.get(i);
        }
        return octalNumbersArray;
    }

    
    private static void processDates(String[] tokens, BufferedWriter writer) throws IOException {
        Pattern datePattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\:(0[1-9]|1[0-2])\\:\\d{2}$");
        for (int i = 0; i < tokens.length; i++) {
            Matcher matcher = datePattern.matcher(tokens[i]);
            if (matcher.matches()) {
                String dateFound = "Date found: " + tokens[i];
                System.out.println(dateFound);

                writer.write(dateFound + "\n");

                int randomNumber = new Random().nextInt(100);
                if (i < tokens.length - 1) {
                    tokens[i + 1] = randomNumber + tokens[i + 1];
                } else {
                    tokens[i] = tokens[i] + randomNumber;
                }
            }
        }
    }
    
    private static void addRandomNumber(String[] tokens) {
        if (!containsDate(tokens)) {
            int index = tokens.length / 2;
            int randomNumber = new Random().nextInt(100);
            tokens[index] = tokens[index] + randomNumber;
        }
    }

    
//    private static boolean containsDate(String[] tokens) {
//        Pattern datePattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\:(0[1-9]|1[0-2])\\:\\d{2}$");
//        for (String token : tokens) {
//            Matcher matcher = datePattern.matcher(token);
//            if (matcher.matches()) {
//                return true;
//            }
//        }
//        return false;
//    }

  
    private static boolean containsDate(String[] tokens) {
        for (String token : tokens) {
            if (isValidDate(token)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
   
    
    
    private static void removeShortestDigitEndingSubstring(String[] tokens) {
        String shortestSubstring = null;
        for (String token : tokens) {
            for (int i = 0; i < token.length(); i++) {
                if (Character.isDigit(token.charAt(i))) {
                    String substring = token.substring(0, i + 1);
                    if (shortestSubstring == null || substring.length() < shortestSubstring.length()) {
                        shortestSubstring = substring;
                    }
                }
            }
        }
        
        if (shortestSubstring != null) {
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].replace(shortestSubstring, "");
            }
        }
    }
}