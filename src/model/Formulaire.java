package model;

public abstract class Formulaire {
	private int jour;
	private int mois;
	private int identificationEntite;

	protected Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
		this.identificationEntite = 0;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getIdentificationEntite() {
		return identificationEntite;
	}

	public void setIdentificationEntite(int identificationEntite) {
		this.identificationEntite = identificationEntite;
	}
}