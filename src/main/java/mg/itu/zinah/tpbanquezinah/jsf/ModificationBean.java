/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.zinah.tpbanquezinah.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.zinah.tpbanquezinah.ejb.GestionnaireCompte;
import mg.itu.zinah.tpbanquezinah.entities.CompteBancaire;
import mg.itu.zinah.tpbanquezinah.jsf.util.Util;

/**
 *
 * @author Lenovo
 */
@Named(value = "modif")
@ViewScoped
public class ModificationBean implements Serializable {

    private Long id;
    private CompteBancaire compte;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of ModificationBean
     */
    public ModificationBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findCompte(id);
    }
    public String modifierCompte(){
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Modification enregistrée sur compte de " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
