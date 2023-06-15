package goIt.com.http;

public class Main {
    public static void main(String[] args) throws Exception {
       // new HttpStatusChecker().getStatusImage(207);
       // new HttpStatusImageDownloader().downloadStatusImage(368);
        new HttpImageStatusCli().askStatus();
    }
}