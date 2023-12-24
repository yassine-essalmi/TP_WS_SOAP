package org.example;

import java.time.format.DateTimeFormatter;
import java.util.List;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();

        System.out.println(proxy.conversionEuroToDH(1));
        System.out.println("************************************************************");

        Compte compte = proxy.getCompte(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = compte.getDate().toGregorianCalendar().toZonedDateTime().format(formatter);
        System.out.println("compte : { code : " +compte.getCode()+" ,\n solde : "+compte.getSolde()+" ,\n date : "+formattedDate+"\n }");
        System.out.println("************************************************************");

        List<Compte> comptes = proxy.getComptes();
        comptes.forEach((compte1 -> {
            String formatted = compte1.getDate().toGregorianCalendar().toZonedDateTime().format(formatter);
            System.out.println("compte : { code : " +compte1.getCode()+" ,\n solde : "+compte1.getSolde()+" ,\n date : "+formatted+"\n }");
        }));
    }
}