package com.example.accessingdatamysql.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/create-checkout-session")
public class StripeCheckoutController {
    
    @PostMapping()
    public void StripeCheckout(HttpServletResponse response ) throws IOException, StripeException {
        Stripe.apiKey = "sk_test_51NHMmmIkE0aMnVBzzNbwHLrxjFmqjN7SELALwyPnStjdlRNUFeWsHbrMLQZQ9HUVsJzmCg0GMZJSZFHuLV28w9TI00rhn5XTsG";

        SessionCreateParams params =
        SessionCreateParams.builder()
          .setMode(SessionCreateParams.Mode.PAYMENT)
          .setSuccessUrl("http://localhost:8080/products/welcome")
          .setCancelUrl("http://localhost:8080/?canceled=true")
          .addLineItem(
          SessionCreateParams.LineItem.builder()
            .setQuantity(1L)
            .setPriceData(
              SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("aud")
                .setUnitAmount(35000L)
                .setProductData(
                  SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName("1bed1bath apartment")
                    .build())
                .build())
            .build())
          .build();

      Session session = Session.create(params);

      response.sendRedirect(session.getUrl().toString());
    }
}
