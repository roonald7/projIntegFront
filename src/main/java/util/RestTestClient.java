package main.java.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.java.entity.MedidorJson;

public class RestTestClient {

		public static void sendGet() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		//GET example
		ResteasyWebTarget getDummy = client.target("http://localhost:8080/api/medidores");
		
		Response getDummyResponse = getDummy.request().get();
		
		String value = getDummyResponse.readEntity(String.class);
        System.out.println(value);
        getDummyResponse.close();  
        
        Type listType = new TypeToken<ArrayList<MedidorJson>>(){}.getType();
		List<MedidorJson> medidorData = new Gson().fromJson(value, listType);
		
		System.out.println(medidorData);
		
        //POST example
		/*ResteasyWebTarget add = client.target("https://localhost:8080/RestEasy-Example/employee/add");
		MedidorJson emp = new MedidorJson();
		emp.setId(50);emp.setName("Rick");emp.setSalary(1000);
		Response addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
		System.out.println(addResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+addResponse.getStatus());
		addResponse.close();
		
		addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
		System.out.println(addResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+addResponse.getStatus());
		addResponse.close();
		
		//DELETE example
		ResteasyWebTarget delete = client.target("https://localhost:8080/RestEasy-Example/employee/50/delete");
		Response deleteResponse = delete.request().delete();
		System.out.println(deleteResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
		deleteResponse.close();
		
		deleteResponse = delete.request().delete();
		System.out.println(deleteResponse.readEntity(GenericResponse.class));
		System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
		deleteResponse.close();*/
		
		
		/*public void restPOST(MedidorToJson medidor) throws IOException {
		HttpURLConnection con = requestConnection(POST_URL, REST_POST);
		
		String jsonObj = new Gson().toJson(medidor);
		
		byte[] out = jsonObj.getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
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
	}*/
	}

}
