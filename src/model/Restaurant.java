package model;

public class Restaurant {
    private CentraleReservation<Table> centrale;

    public Restaurant() {
        centrale = new CentraleReservation<>(new Table[100]);
    }

    public int ajouterTable(int nbChaises) {
        Table table = new Table(nbChaises);
        return centrale.ajouterEntite(table);
    }

    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        return centrale.donnerPossibilites(formulaire);
    }

    public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
        return centrale.reserver(numEntite, formulaire);
    }
}