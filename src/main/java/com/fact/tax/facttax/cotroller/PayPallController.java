//package com.fact.tax.facttax.cotroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fact.tax.facttax.model.Order;
//import com.fact.tax.facttax.service.PayPallService;
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//
//@RestController
//public class PayPallController {
//
//	@Autowired
//	PayPallService pallService;
//	
//	public static final String SUCCESS_URL="pay/success";
//	public static final String CANCEL_URL="pay/cancel";
//	
//	@GetMapping("/")
//	public String home()
//	{
//		return "home";
//	}
//	@PostMapping("/pay")
//	public String payment(@ModelAttribute Order order)
//	{
//		try
//		{
//		Payment payment=pallService.cratePayment(order.getPrice(), order.getCurrency(), order.getMethod(), order.getIntent(), order.getDescription(),"http://localhost:8080"+CANCEL_URL, "http://localhost:8080"+SUCCESS_URL);
//		for(Links link:payment.getLinks())
//		{
//		
//			if(link.getRel().equals("approval_url"))
//			{
//				return "redirect:"+link.getHref();
//				
//			}
//			
//		}
//		
//		}
//		catch(PayPalRESTException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return "redirect:/";
//	}
//	@GetMapping(value=CANCEL_URL)
//	public String cancelPay()
//	{
//	return "cancel";
//	}
//	@GetMapping(value=SUCCESS_URL)
//	public String successPay(@RequestParam("paymentId") String paymentId,@RequestParam("payerID") String payerId)
//	{
//		
//		try
//		{
//			Payment payment=pallService.executePayment(paymentId, payerId);
//			System.out.println(payment.toJSON());
//			if(payment.getState().equals("approved"))
//			{
//				return "success";
//			}
//		}
//		catch(PayPalRESTException e)
//		{
//		System.out.println(e.getMessage());
//			
//		}
//		
//		
//		return "redirect:/";
//	}
//	
//	
//	
//}
