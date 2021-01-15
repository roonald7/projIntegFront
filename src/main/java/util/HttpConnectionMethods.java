package main.java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.java.entity.MedidorJson;
import main.java.entity.MedidorToJson;

public class HttpConnectionMethods {
	
	private static final String GET_URL = "http://localhost:8080/api/medidores";

	private static final String POST_URL = "http://localhost:8080/api/medidor";
	
	private static final String REST_GET = "GET";
	
	private static final String REST_POST = "POST";
	
	public List<MedidorJson> restGET() throws IOException {
		HttpURLConnection con = requestConnection(GET_URL, REST_GET);

		int responseCode = con.getResponseCode();
		
		System.out.println("GET Response Code :: " + responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuilder builder = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				builder.append(inputLine + "\n");
			}
			in.close();

			Type listType = new TypeToken<ArrayList<MedidorJson>>(){}.getType();
			List<MedidorJson> medidorData = new Gson().fromJson(builder.toString(), listType);

			return medidorData;
	
		} else {
			System.out.println("GET request not worked");
			return null;
		}

	}
	
	public void restPOST(MedidorToJson medidor) throws IOException {
		HttpURLConnection con = requestConnection(POST_URL, REST_POST);
		
		String jsonObj = new Gson().toJson(medidor);
		
		byte[] out = jsonObj.getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
		// For POST only - START
		con.setDoOutput(true);

		con.setFixedLengthStreamingMode(length);
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		try(OutputStream os = con.getOutputStream()){
			os.write(out);
			os.flush();
			os.close();
		}

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}
	
	private static HttpURLConnection requestConnection(String methodURL, String method) throws IOException {
		URL obj = new URL(methodURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(method);
		return(con);
	}
	
}

