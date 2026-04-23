package model;

public class CalendrierAnnuel {

    private static class Mois {
        private String nom;
        private boolean[] jours;

        private Mois(String nom, int nbJours) {
            this.nom = nom;
            this.jours = new boolean[nbJours + 1];
        }

        private boolean estLibre(int jour) {
            return !jours[jour];
        }

        private void reserver(int jour) {
            if (!estLibre(jour)) {
                throw new IllegalStateException("Ce jour est déjà réservé !");
            }
            jours[jour] = true;
        }
    }

    private Mois[] calendrier;

    public CalendrierAnnuel() {
        calendrier = new Mois[13];
        calendrier[1]  = new Mois("Janvier",   31);
        calendrier[2]  = new Mois("Février",   28);
        calendrier[3]  = new Mois("Mars",      31);
        calendrier[4]  = new Mois("Avril",     30);
        calendrier[5]  = new Mois("Mai",       31);
        calendrier[6]  = new Mois("Juin",      30);
        calendrier[7]  = new Mois("Juillet",   31);
        calendrier[8]  = new Mois("Août",      31);
        calendrier[9]  = new Mois("Septembre", 30);
        calendrier[10] = new Mois("Octobre",   31);
        calendrier[11] = new Mois("Novembre",  30);
        calendrier[12] = new Mois("Décembre",  31);
    }

    public boolean estLibre(int jour, int mois) {
        return calendrier[mois].estLibre(jour);
    }

    public boolean reserver(int jour, int mois) {
        if (!estLibre(jour, mois)) {
            return false;
        }
        calendrier[mois].reserver(jour);
        return true;
    }
}