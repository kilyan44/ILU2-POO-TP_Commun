package model;

public class CentraleReservation<E extends EntiteReservable<FormulaireRestaurant>> {
	private E[] entites;
	private int nbEntites;

	public CentraleReservation(E[] entites) {
		this.entites = entites;
		this.nbEntites = 0;
	}

	public int ajouterEntite(E entite) {
		entites[nbEntites] = entite;
		nbEntites++;
		entite.setNumero(nbEntites);
		return nbEntites;
	}

	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
	    int[] possibilites = new int[nbEntites];
	    for (int i = 0; i < nbEntites; i++) {
	        if (entites[i].compatible(formulaire)) {
	            possibilites[i] = entites[i].getNumero();
	        } else {
	            possibilites[i] = 0;
	        }
	    }
	    return possibilites;
	}

	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		E entite = null;
		for (int i = 0; i < nbEntites; i++) {
			if (entites[i].getNumero() == numEntite) {
				entite = entites[i];
			}
		}
		formulaire.setIdentificationEntite(entite.getNumero());
		return entite.reserver(formulaire);
	}
}