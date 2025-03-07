package prog2.model;

/**
 * Classe abstracta que implementa la interfície InAllotjament.
 * Aquesta classe serveix de base per a tots els tipus d'allotjament (Parcel·la, Bungalow, etc.).
 */
public abstract class Allotjament implements InAllotjament {

    // Atributs
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    // Constructor
    public Allotjament(String nom, String id, long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    // Implementació dels mètodes de la interfície InAllotjament
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) {
            return estadaMinimaALTA;
        } else {
            return estadaMinimaBAIXA;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    // El mètode correcteFuncionament serà implementat per les subclases
    @Override
    public abstract boolean correcteFuncionament();

    // To string per facilitar la visualització
    @Override
    public String toString() {
        return "Allotjament{" +
                "nom='" + nom + '\'' +
                ", id='" + id + '\'' +
                ", estadaMinimaALTA=" + estadaMinimaALTA +
                ", estadaMinimaBAIXA=" + estadaMinimaBAIXA +
                '}';
    }
}
