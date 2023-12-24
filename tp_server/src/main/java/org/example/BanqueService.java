package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "ConversionEuroToDH")
    public double conversion (@WebParam(name = "montant") double montant) {
        return montant * 11;
    }

    @WebMethod(operationName = "getCompte")
    public Compte getCompte (@WebParam(name = "code") int code) {
        return Compte.builder().code(code).solde(10000).date(new Date()).build();
    }

    @WebMethod(operationName = "getComptes")
    public List<Compte> getComptes () {
        return List.of(Compte.builder().code(1).solde(10000).date(new Date()).build(),
                Compte.builder().code(2).solde(20000).date(new Date()).build(),
                Compte.builder().code(3).solde(30000).date(new Date()).build());
    }

}
