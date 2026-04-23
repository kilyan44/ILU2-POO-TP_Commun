package model;

public class Table extends EntiteReservable<FormulaireRestaurant> {
	private int nbChaises;
	private CalendrierAnnuel calendrierDeuxiemeService;

	public Table(int nbChaises) {
		super();
		this.nbChaises = nbChaises;
		this.calendrierDeuxiemeService = new CalendrierAnnuel();
	}

	@Override
	public boolean compatible(FormulaireRestaurant formulaire) {
	    boolean assezDeChaises = nbChaises >= formulaire.getNombrePersonnes();
	    boolean libre;
	    if (formulaire.getNumService() == 1) {
	        libre = getCalendrier().estLibre(formulaire.getJour(), formulaire.getMois());
	    } else {
	        libre = calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois());
	    }
	    return assezDeChaises && libre;
	}

	@Override
	public Reservation reserver(FormulaireRestaurant formulaire) {
		Reservation reservation = null;
		boolean reservationEffectuee;
		if (formulaire.getNumService() == 1) {
			reservationEffectuee = getCalendrier().reserver(formulaire.getJour(), formulaire.getMois());
		} else {
			reservationEffectuee = calendrierDeuxiemeService.reserver(formulaire.getJour(), formulaire.getMois());
		}
		if (reservationEffectuee) {
			reservation = new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(),
					formulaire.getNumService(), getNumero());
		}
		return reservation;
	}
}