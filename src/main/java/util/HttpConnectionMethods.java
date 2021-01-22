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


public class HttpConnectionMethods {
	
	private static final String GET_URL = "http://localhost:8080/api/medidores";
	public Response getMedidorResponse;

	public List<MedidorJson> restGET() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		ResteasyWebTarget getMedidor = client.target(GET_URL);

		Response getMedidorResponse = getMedidor.request().get();
		
		String value = getMedidorResponse.readEntity(String.class);
        getMedidorResponse.close();  
        
        Type listType = new TypeToken<ArrayList<MedidorJson>>(){}.getType();
        List<MedidorJson> medidorData = new Gson().fromJson(value, listType);

		return medidorData;
	}
}

