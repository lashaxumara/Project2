package Utils;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomGenerators {

    public static String randomString(int length) {
        String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random RANDOM = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String randomEmail() {
        String domain = "@gmail.com";
        String username = randomString(5);

        return username + domain;
    }

    public static String randomNumberString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateRandomDate() {
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        int year = random.nextInt(2023 - 1900 + 1) + 1900;

        DecimalFormat formatter = new DecimalFormat("00");
        String formattedMonth = formatter.format(month);
        String formattedDay = formatter.format(day);
        String formattedYear = Integer.toString(year);

        return formattedMonth + "-" + formattedDay + "-" + formattedYear;
    }
}
