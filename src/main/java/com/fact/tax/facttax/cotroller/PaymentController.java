package com.fact.tax.facttax.cotroller;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fact.tax.facttax.model.PaytmDetails;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
public class PaymentController {
	
	@Autowired
	private PaytmDetails paytmDetails;
	@Autowired
	private Environment env;
	
	@RequestMapping(value="/")
	public String getBase() {
		return "TxnTest";
	}
	
	@RequestMapping(value="/pgredirect")
//	public ModelAndView getRedirect(@RequestParam(name="CUST_ID") String customerId,
//			@RequestParam(name="TXN_AMOUNT") String transactionAmount,
//			@RequestParam(name="ORDER_ID") String orderId) throws Exception {
//		
	public ModelAndView getRedirect() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("redirect:"+paytmDetails.getPaytmUrl());
		TreeMap<String, String> parameters = new TreeMap<>();
		paytmDetails.getDetails().forEach((k,v)-> parameters.put(k, v));
		//adding env -- change if u want env and email phone
		parameters.put("MOBILE_NO",env.getProperty("paytm.mobile"));
		parameters.put("EMAIL",env.getProperty("paytm.email"));
		//int orderNum=Math.random(100);
		parameters.put("ORDER_ID","ORD_124544");
		parameters.put("TXN_AMOUNT","1");
		parameters.put("CUST_ID","CustomerID24");
		String checkSum =  getCheckSum(parameters);
		parameters.put("CHECKSUMHASH",checkSum);
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.
				getCheckSumServiceHelper().
				genrateCheckSum(paytmDetails.getMerchantKey(), parameters);
	}
	
	@ResponseBody
	@RequestMapping(value="/pgresponse")
	public String getResponseRedirect(HttpServletRequest request,Model model) {
		
		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String,String> parameters = new TreeMap<String,String>();
		mapData.forEach((key,val)-> parameters.put(key, val[0]));
		String paytmChecksum =  "";
		if(mapData.containsKey("CHECKSUMHASH"))
		{
			paytmChecksum = mapData.get("CHECKSUMHASH")[0];
		}
		String result;
		
		boolean isValideChecksum = false;
		try{
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if(isValideChecksum && parameters.containsKey("RESPCODE")){
				if(parameters.get("RESPCODE").equals("01")){
					result = parameters.toString();
				}else{
					result="<b>Payment Failed.</b>";
				}
			}else{
				result="<b>Checksum mismatched.</b>";
			}
		}catch(Exception e){
			result=e.toString();
		}
		
		
		
		return result;
	}

	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return CheckSumServiceHelper.
				getCheckSumServiceHelper().
				verifycheckSum(paytmDetails.getMerchantKey(),parameters,paytmChecksum);
	}
}
