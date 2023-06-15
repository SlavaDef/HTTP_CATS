package goIt.com.http;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) throws Exception {

        try {
            URL url = new URL(new HttpStatusChecker().getStatusImage(code));

            if (url == null) {
                throw new RuntimeException("Image not found for code " + code);

            } else {
                try (InputStream in = new BufferedInputStream(url.openStream());
                     FileOutputStream out = new FileOutputStream("img" + code + "jpg.");
                ) {
                    byte[] buf = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buf)) != -1) {
                        out.write(buf, 0, bytesRead);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Image not found for code " + code);
        }
    }
}