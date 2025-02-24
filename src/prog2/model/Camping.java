package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

import prog2.vista.ExcepcioReserva;

public class Camping implements InCamping {
    // Atributs
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Client> llistaClients;
    private LlistaReserves llistaReserves;

        // constructor
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new ArrayList<>();
        this.llistaClients = new ArrayList<>();
        this.llistaReserves = new LlistaReserves();

    }

    // implementacio dels mètodes de la interficie
    // Retorna el nom del càmping
    public String getNom() {
        return nom;
    }
    // Retorna la llista de reserves
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }
    // Retorna la llista d'allotjaments disponibles al càmping
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }
    // array.length -- arrayList.size()
    // Retorna la llista de clients registrats al càmping

    // Retorna el nombre total d'allotjaments

    // Retorna el nombre total de reserves

    // Retorna el nombre total de clients

    // Afegeix un nou client a la llista de clients

    // Afegeix una parcel·la com a nou allotjament

    // Afegeix un bungalow com a nou allotjament

    // Afegeix un bungalow premium com a nou allotjament

    // Afegeix un allotjament de tipus glamping

    // Afegeix un mobil home com a nou allotjament

    // Cerca un allotjament a la llista mitjançant el seu identificador -- cerca --for

    // Cerca un client a la llista mitjançant el seu DNI -- cerca -- = for

    // Determina si una data donada correspon a temporada alta o baixa

}
