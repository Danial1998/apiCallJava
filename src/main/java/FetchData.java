import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {

    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/users";

        try {
            // Create a URL object
            URL url = new URL(urlString);
            // Open a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Set the request method to GET
            conn.setRequestMethod("GET");
            // Read the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Append each line of the response
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Print the response
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
