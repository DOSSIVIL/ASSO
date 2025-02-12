package com.ecommerce.paiement.web.controller;

import com.ecommerce.paiement.web.dto.CinetPayPaymentDto;
import com.ecommerce.paiement.web.service.CinetPayPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/cinetpaydeliverypayments")
public class CinetPayDeliveryPaymentController {
    @Autowired
    private CinetPayPaymentService cinetPayPaymentServiceDelivery;

    //Endpoint to get the data for a user's cinetpay payment
    @Operation(summary = "Récupération des informations d'un utilisateur à partir de son identifiant.",
            description = "Récupère les informations de l'utilisateur à partir de son identifiant au service de gestion des utilisateurs" +
                    " et les ajoute à un objet contenant les informations nécessaires pour initier un paiement des frais de livraison sa facture.")
    @GetMapping("/{user_id}/{order_id}")
    public CinetPayPaymentDto getCinetPayPaymentData(@PathVariable Integer user_id, @PathVariable int order_id) {
        return cinetPayPaymentServiceDelivery.getDataFromOrderUser(user_id, order_id);
    }
}
