package dev.dhiraj.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service("razorpayGateway")
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String getPaymentLink() {
        return "";
    }
}
