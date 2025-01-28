package dev.dhiraj.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String getPaymentLink() {
        PaymentLink payment = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_GgiKXog4dIs3LP", "vXTCLEo3S1UnHDx9LkHwaW3L");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
//        paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("expire_by",1738161199);
            paymentLinkRequest.put("reference_id","TS19890011");
            paymentLinkRequest.put("description","Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("name","Dhiraj");
            customer.put("contact","+917899034560");
            customer.put("email","Dhiraj@example.com");
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);

            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);

            JSONObject notes = new JSONObject();
            notes.put("policy_name","Jeevan Bima");
            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url","https://google.com/");
            paymentLinkRequest.put("callback_method","get");
            payment = razorpay.paymentLink.create(paymentLinkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment.toString();
    }
}
