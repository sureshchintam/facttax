//package com.fact.tax.facttax;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.paypal.base.APICallPreHandler;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.OAuthTokenCredential;
//import com.paypal.base.rest.PayPalRESTException;
//
//@Configuration
//public class PaypallConfig {
//
//	@Value("${paypal.client.id}")
//	private String clientId;
//	@Value("${paypal.clinet.secret}")
//	private String clientSecret;
//	@Value("${paypal.mode}")
//	private String mode;
//	
//	@Bean
//	public Map<String,String> paypalSdkConfig()
//	{
//		
//		Map<String,String> configMap=new HashMap<>();
//		configMap.put("mode", mode);
//		return configMap;
//		
//	}
//	@Bean
//	public OAuthTokenCredential oAuthTokenCredentials()
//	{
//		
//		return new OAuthTokenCredential(clientId, clientSecret,paypalSdkConfig());
//	}
//	@Bean
//	public APIContext apiContext() throws PayPalRESTException
//	{
//		APIContext context=new APIContext(oAuthTokenCredentials().getAccessToken());
//		context.setConfigurationMap(paypalSdkConfig());
//		return context;
//	}
//	
//	
//	
//	
//}
