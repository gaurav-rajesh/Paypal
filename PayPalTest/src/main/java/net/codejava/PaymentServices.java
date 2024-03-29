package net.codejava;
import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
public class PaymentServices {
	private static final String CLIENT_ID="AVlkFRN-cV9MjeYQer7SGum0ZqynuY38zmWylj4H4LzIPVX0_HTZyiiSifJXsvNCVSDS8t3GjXNreXsk";
	private static final String CLIENT_SECRET="EAP0cofywoIB4-ZN4_XrQsxots-aHdrWmqz9S5FVAEEhxCKF_XuXkpJSw_7tCkptl9Kf34BYK4RxLG0J";
	private static final String mode="sandbox";
	
	public String authorizePayment(OrderDetail orderdetail) throws PayPalRESTException {
		Payer payer=getPayerInfromation();
		RedirectUrls redirectUrls=getRedirectURLs();
		List<Transaction> listTransaction=getTransactionInfromation(orderdetail);
		
		Payment requestpayment = new Payment();
		requestpayment.setTransactions(listTransaction).setRedirectUrls(redirectUrls)
		.setPayer(payer)
		.setIntent("authorize");
		
		APIContext apiCOntext=new APIContext(CLIENT_ID,CLIENT_SECRET,mode);
		Payment approvedpayment=requestpayment.create(apiCOntext);
		System.out.println(approvedpayment);
		
		return getApprovalLink(approvedpayment);
	}
	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links=approvedPayment.getLinks();
		String approvalLink=null;
		for(Links link:links) {
			if(link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink=link.getHref();
			}
		}
		return approvalLink;
	}
	private List<Transaction> getTransactionInfromation(OrderDetail orderdetail){
		Details details=new Details();
		details.setShipping(orderdetail.getShipping());
		details.setSubtotal(orderdetail.getSubtotal());
		details.setTax(orderdetail.getTax());
		
		Amount amount=new Amount();
		amount.setCurrency("USD");
		amount.setTotal(orderdetail.getTotal());
		amount.setDetails(details);
		
		Transaction transaction =new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderdetail.getProductName());
		
		ItemList itemList =new ItemList();
		List<Item> items =new ArrayList<Item>();
		
		Item item=new Item();
		item.setCurrency("USD").setName(orderdetail.getProductName()).setPrice(orderdetail.getSubtotal())
		.setTax(orderdetail.getTax()).setQuantity("1");
		
		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);
		
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		listTransaction.add(transaction);
		
		return listTransaction;
	}
	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls=new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/PayPalTest/checkout.html");
		redirectUrls.setReturnUrl("http://localhost:8080/PayPalTest/review_Payment");
		return redirectUrls;
	}
	
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
	    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, mode);
	    return Payment.get(apiContext, paymentId);
	}
	
	public Payment executePayment(String paymentId, String payerId)
	        throws PayPalRESTException {
	    PaymentExecution paymentExecution = new PaymentExecution();
	    paymentExecution.setPayerId(payerId);
	 
	    Payment payment = new Payment().setId(paymentId);
	 
	    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, mode);
	 
	    return payment.execute(apiContext, paymentExecution);
	}

	private Payer getPayerInfromation() {
		Payer payer=new Payer();
		payer.setPaymentMethod("paypal");
		PayerInfo payerInfo=new PayerInfo();
		payerInfo.setFirstName("Bill").setLastName("Gates").setEmail("billgates@m.com");
		
		payer.setPayerInfo(payerInfo);
		return payer;
	}
}
