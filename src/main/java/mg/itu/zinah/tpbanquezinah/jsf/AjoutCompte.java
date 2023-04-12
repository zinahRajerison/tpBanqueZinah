/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.zinah.tpbanquezinah.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.zinah.tpbanquezinah.ejb.GestionnaireCompte;
import mg.itu.zinah.tpbanquezinah.entities.CompteBancaire;
import mg.itu.zinah.tpbanquezinah.jsf.util.Util;
/**
 *
 * @author Lenovo
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    private String nom;

    @PositiveOrZero
    private int solde;

    @EJB
    private GestionnaireCompte gc;

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String ajoutCompte () {
        boolean erreur = false;

        if (solde <= 0) {
            // Message d'erreur associé au composant source ; form:source est l'id client
            // si l'id du formulaire est "form" et l'id du champ de saisie de l'id de la source est "source"
            // dans la page JSF qui lance le transfert.
            Util.messageErreur("Solde doit etre positif!", "Solde doit etre positif !", "form:solde");
            erreur = true;
        }
        if (erreur) { // en cas d'erreur, rester sur la même page
            return null;
        }
        gc.creerCompte(new CompteBancaire(nom, solde));
// Message de succès ; addFlash à cause de la redirection.
        Util.addFlashInfoMessage("Compte cree avec succes");
        return "listeComptes?faces-redirect=true";
    }
}
