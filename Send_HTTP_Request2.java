//import org.json.JSONObject;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Send_HTTP_Request2 {
    public static void main(String[] args) {
        try {
            Send_HTTP_Request2.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {
        //String url = "https://api.pretendentas.lt/v1/orders/?api_key=5257357909999b05b55d41c6858df21b&_format=json";
        String url = "https://api.pretendentas.lt/v1/categories/?api_key=5257357909999b05b55d41c6858df21b";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());

	FileWriter myWriter = new FileWriter("filename.txt");
	myWriter.write(response.toString());
	myWriter.close();



        //Read JSON response and print
        
	////JSONObject myResponse = new JSONObject(response.toString());
        ////System.out.println("result after Reading JSON Response");
        ////System.out.println(myResponse);
        
	//System.out.println("statusCode- "+myResponse.getString("d"));
        //System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
        //System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
        //System.out.println("countryCode- "+myResponse.getString("countryCode"));
        //System.out.println("countryName- "+myResponse.getString("countryName"));
        //System.out.println("regionName- "+myResponse.getString("regionName"));
        //System.out.println("cityName- "+myResponse.getString("cityName"));
        //System.out.println("zipCode- "+myResponse.getString("zipCode"));
        //System.out.println("latitude- "+myResponse.getString("latitude"));
        //System.out.println("longitude- "+myResponse.getString("longitude"));
        //System.out.println("timeZone- "+myResponse.getString("timeZone"));
    }
}
