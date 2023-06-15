package com.example.accessingdatamysql.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.Repository.RoomRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import com.example.accessingdatamysql.Entity.Room;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/create-checkout-session/room/{id}")
public class StripeCheckoutController {
    @Autowired
    private RoomRepository roomRepository;
    
    //Receive post request for payment and send information to Stripe
    @PostMapping()
    public void StripeCheckout(HttpServletResponse response, @PathVariable Integer id ) throws IOException, StripeException {
        Stripe.apiKey = "sk_test_51NHMmmIkE0aMnVBzzNbwHLrxjFmqjN7SELALwyPnStjdlRNUFeWsHbrMLQZQ9HUVsJzmCg0GMZJSZFHuLV28w9TI00rhn5XTsG";

        Room roomRequest = roomRepository.findById(id).orElseThrow(() ->new RoomNotFoundException(id));

        long roomPrice = Math.round(roomRequest.getPrice()*100);

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
                .setUnitAmount(roomPrice)
                .setProductData(
                  SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName(roomRequest.getTitle())
                    .build())
                .build())
            .build())
          .build();

      Session session = Session.create(params);

      response.sendRedirect(session.getUrl().toString());
    }
}
