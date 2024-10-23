package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.dto.LoginRequest;
import com.app.dto.LoginResponse;
@Service   //@Transactional=not required because transactions are happening at net banking server
public class NetBankingClientServiceImpl implements INetBankingClientService {
 //instead of hardcoding the url we are putting it into the property file
	//SPEL: spring expression language
	@Value("${AUTH_URL}")
	private String authenticationURL;
	
	private RestTemplate template;//dependency is rest template not a dao layer 
  
  //RestTemplateBuilder is ready made bean supplied by spring framework 
  //RestTemplate: built by programmer using its builder
	//constr based D.I
  @Autowired //autowire=constructor
  public NetBankingClientServiceImpl(RestTemplateBuilder builder) {
	  //create RetTemplate from its builder
	  template=builder.build();
  }
	@Override
	public ResponseEntity<LoginResponse> authenticateBankCustomer(LoginRequest request) {
		// USE REST template API 
		//ResponseEntity<T> postForEntity(String url, Object request,class <T> responseType,Object... uriVars)
		System.out.println("auth url "+authenticationURL);
		ResponseEntity<LoginResponse> resp = template.postForEntity(authenticationURL, request, LoginResponse.class);
		return resp;
	}

}
