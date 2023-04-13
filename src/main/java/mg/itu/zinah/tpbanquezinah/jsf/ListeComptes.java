/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.zinah.tpbanquezinah.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.zinah.tpbanquezinah.ejb.GestionnaireCompte;
import mg.itu.zinah.tpbanquezinah.entities.CompteBancaire;
import mg.itu.zinah.tpbanquezinah.jsf.util.Util;

/**
 *
 * @author Lenovo
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    private List<CompteBancaire> comptes;
    /**
     * Creates a new instance of ListeComptes
     */
    @EJB
    private GestionnaireCompte gc;

    public ListeComptes() {
    }

    public List<CompteBancaire> getComptes() {
        if (comptes == null) {
            comptes = gc.getAllComptes();
        }
        return comptes;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        gc.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }
}
