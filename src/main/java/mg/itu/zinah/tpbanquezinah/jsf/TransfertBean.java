/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.zinah.tpbanquezinah.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import mg.itu.zinah.tpbanquezinah.ejb.GestionnaireCompte;

/**
 *
 * @author Lenovo
 */
@Named(value = "transfert")
@RequestScoped
public class TransfertBean {
    private Long idSource;
    private Long idDestination;
    private int montant;
    
    @EJB
    private GestionnaireCompte gc;

    /**
     * Creates a new instance of TransfertBean
     */
    public TransfertBean() {
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    public String transferer(){
        gc.transferer(gc.findCompte(idSource), gc.findCompte(idDestination), montant);
        return "listeComptes";
    }
    
}
