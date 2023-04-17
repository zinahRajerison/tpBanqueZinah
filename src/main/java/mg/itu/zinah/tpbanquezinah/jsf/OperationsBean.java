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
import mg.itu.zinah.tpbanquezinah.entities.OperationBancaire;

/**
 *
 * @author Lenovo
 */
@Named(value = "operation")
@ViewScoped
public class OperationsBean implements Serializable {
     private Long id;
     private CompteBancaire compte;
     
    @EJB
    private GestionnaireCompte gestionnaireCompte;

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
    /**
     * Creates a new instance of OperationsBean
     */
    public OperationsBean() {
    }
    
}
