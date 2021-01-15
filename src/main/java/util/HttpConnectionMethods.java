package main.java.util;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.java.entity.MedidorJson;
import main.java.entity.MedidorToJson;

public class HttpConnectionMethods {
	
	private static final String GET_URL = "http://localhost:8080/api/medidores";
	private static final String POST_URL = "http://localhost:8080/api/medidor";
	
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
	
	public static void restPOST(MedidorToJson medidor) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		ResteasyWebTarget add = client.target(POST_URL);
		
		Response addResponse = add.request().post(Entity.entity(medidor, MediaType.APPLICATION_JSON));
		System.out.println(addResponse.readEntity(MedidorToJson.class));
		System.out.println("HTTP Response Code:"+addResponse.getStatus());
		addResponse.close();
	}
	
	
	
}

