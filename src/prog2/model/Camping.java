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
    @Override
    public String getNom() {
        return nom;
    }
    // Retorna la llista de reserves
    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }
    // Retorna la llista d'allotjaments disponibles al càmping
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }
    // array.length -- arrayList.size()
    // Retorna la llista de clients registrats al càmping
    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }
    // Retorna el nombre total d'allotjament
    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    // Retorna el nombre total de reserves
    @Override
    public int getNumReserves() {
        return llistaReserves.getNumReserves();
    }

    // Retorna el nombre total de clients
    @Override
    public int getNumClients() {
        return llistaClients.size();
    }
    // Afegeix un nou client a la llista de clients
    @Override
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client nouClient = new Client(nom_, dni_);
        llistaClients.add(nouClient);
    }
    // Afegeix una parcel·la com a nou allotjament
    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        llistaAllotjaments.add(new Parcela(nom_, idAllotjament_, metres, connexioElectrica));
    }
    // Afegeix un bungalow com a nou allotjament
    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow nouBungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
    }

    // Afegeix un bungalow premium com a nou allotjament
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) {
        llistaAllotjaments.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi));
    }
    // Afegeix un allotjament de tipus glamping
    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) {
        llistaAllotjaments.add(new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota));
    }
    // Afegeix un mobil home com a nou allotjament
    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) {
        llistaAllotjaments.add(new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa));
    }
    // Cerca un allotjament a la llista mitjançant el seu identificador -- cerca --for
    @Override
    public Allotjament buscarAllotjament(String id) {
        for (Allotjament a : llistaAllotjaments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    // Cerca un client a la llista mitjançant el seu DNI -- cerca -- = for

    @Override
    public Client buscarClient(String dni) {
        for (Client c : llistaClients) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }
    // Afegeir una nova reserva al càmping segons el id d'allotjament i id de Client
    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);

        if (allotjament == null) {
            throw new ExcepcioReserva("Error: No s'ha trobat l'allotjament amb ID " + id_);
        }
        if (client == null) {
            throw new ExcepcioReserva("Error: No s'ha trobat el client amb DNI " + dni_);
        }

        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    //Calcula mida total de totes les parcel·les del càmping
    @Override
    public float calculMidaTotalParceles() {
        float midaTotal = 0;
        for (Allotjament a : llistaAllotjaments) {
            if (a instanceof Parcela) {
                midaTotal += ((Parcela) a).getMetres();
            }
        }
        return midaTotal;
    }
    // Calcula el nombre d'allotjaments operatius
    @Override
    public int calculAllotjamentsOperatius() {
        int count = 0;
        for (Allotjament a : llistaAllotjaments) {
            if (a.correcteFuncionament()) {
                count++;
            }
        }
        return count;
    }
    // Retorna l'allotjament amb l'estada mínima més curta en temporada baixa
    @Override
    public Allotjament getAllotjamentEstadaMesCurta() {
        Allotjament minAllotjament = null;
        int minDies = Long.MAX_VALUE;

        for (Allotjament a : llistaAllotjaments) {
            long estadaMinimaBaixa = a.getEstadaMinima(InAllotjament.Temp.BAIXA); // Obtenir l'estada mínima en temporada baixa
            if (estadaMinimaBaixa < minDies) {
                minDies = estadaMinimaBaixa;
                minAllotjament = a;
            }
        }
        return minAllotjament;
    }
    // Determina si una data donada correspon a temporada alta o baixa
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        LocalDate iniciAlta = LocalDate.of(data.getYear(), 3, 21);
        LocalDate fiAlta = LocalDate.of(data.getYear(), 9, 20);

        if (!data.isBefore(iniciAlta) && !data.isAfter(fiAlta)) {
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }
}


