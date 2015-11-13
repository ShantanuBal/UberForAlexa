import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {
	public static void main(String args[]) throws IOException, JSONException {
		System.out.println("Hello World!");
		
		String url = "https://api.uber.com/v1/products?server_token=BKYQvDBHqGST82NeyoAY9gaTC3E85jxN6IpK7tRY&latitude=37.775818&longitude=-122.418028";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

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

		//print result
		System.out.println(response.toString());
		JSONObject jsonObj = new JSONObject(response.toString());
		JSONArray arr = jsonObj.getJSONArray("products");
		for (int i = 0; i < arr.length(); i++) {
			  JSONObject each = arr.getJSONObject(i);
			  System.out.print(each.getString("display_name") + ", ");
		}
	}
}
