package dev.dhiraj.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service("stripeGateWay")
public class StripeGateway implements PaymentGateway {
    @Override
    public String getPaymentLink() {
        return "";
    }
}
