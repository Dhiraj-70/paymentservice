package dev.dhiraj.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    public RazorpayGateway razorpayGateWay;
    public StripeGateway stripeGateway;

    public PaymentGatewaySelector(RazorpayGateway razorpayGateWay, StripeGateway stripeGateway) {
        this.razorpayGateWay = razorpayGateWay;
        this.stripeGateway = stripeGateway;
    }

    public PaymentGateway getPaymentGateway() {
        //Logic for choosing Payment Gatway

        return razorpayGateWay;
    }
}
