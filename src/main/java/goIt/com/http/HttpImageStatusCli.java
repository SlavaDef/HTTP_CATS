package goIt.com.http;

import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter HTTP status code");
            String userInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userInput)) {
                break;
            } else {
                try {
                    int code = Integer.parseInt(userInput.strip());
                    String url = new HttpStatusChecker().getStatusImage(code);
                    if (url == null) {
                        System.out.println("There is not image for HTTP status " + userInput);
                    }else {
                        new HttpStatusImageDownloader().downloadStatusImage(code);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid number or exit!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
