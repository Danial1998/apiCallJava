import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostData {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        String body = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

        try{
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json; utf-8");
//            conn.setRequestProperty("Accept", "application/json");
//            conn.setRequestProperty("Authorization", "Bearer your_token_here");
//            conn.setRequestProperty("Custom-Header", "CustomValue");
            conn.setDoOutput(true);

            // Write the JSON input string to the request body
            try(OutputStream os = conn.getOutputStream()){
                byte[] input = body.getBytes("utf-8");
                os.write(input,0, input.length);
            }



            //Read the response same like GET request
            try(BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                String inputLine;
                StringBuilder response = new StringBuilder();

                while((inputLine = in.readLine())!=null){
                    response.append(inputLine);
                }

                System.out.println(response);
            }

        } catch(Exception e){
            System.out.println(e);
        }

    }
}
