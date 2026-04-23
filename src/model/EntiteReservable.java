package model;

public abstract class EntiteReservable<F extends Formulaire> {
	private CalendrierAnnuel calendrier;
	private int numero;

	protected EntiteReservable() {
		this.calendrier = new CalendrierAnnuel();
		this.numero = 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean estLibre(F formulaire) {
		return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
	}

	public CalendrierAnnuel getCalendrier() {
		return calendrier;
	}

	public abstract boolean compatible(F formulaire);

	public abstract Reservation reserver(F formulaire);
}