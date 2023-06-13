package goIt.com.http;

import java.net.http.HttpConnectTimeoutException;

public class HttpStatusChecker {

    Utils answer = new Utils();
    public String getStatusImage(int code) throws Exception {
        String result = null;
       // if((answer.getConnect(code) > 199) & (answer.getConnect(code)<600)){
            if(answer.getConnect(code) == 200){
            result = String.format("https://http.cat/%s.jpg",code);
        }else{
            throw new Exception(String.format("Error, there's not image for HTTP status <%s>",code));
        }
        return result;
    }
}
