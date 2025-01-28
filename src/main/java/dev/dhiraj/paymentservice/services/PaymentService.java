package dev.dhiraj.paymentservice.services;

import dev.dhiraj.paymentservice.services.paymentgateway.PaymentGateway;
import dev.dhiraj.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String generatePaymentLink() {
        //logic to initiate payment details to database..
         return paymentGatewaySelector.getPaymentGateway().getPaymentLink();
    }

}
