/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.zinah.tpbanquezinah.ejb;

/**
 *
 * @author Lenovo
 */
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.zinah.tpbanquezinah.entities.CompteBancaire;

@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",              // nom et
    password="for8EVER!", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="banque",
    properties = {
      "useSSL=false",
      "allowPublicKeyRetrieval=true"
    }
)
@Stateless  
public class GestionnaireCompte {
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
     public List<CompteBancaire> getAllComptes() {
       String s = "select e from CompteBancaire as e"; 
       TypedQuery<CompteBancaire> query = em.createQuery(s, CompteBancaire.class);
       return query.getResultList();
    }
     
    public int nbComptes(){
        String requete = "SELECT count(c) from CompteBancaire c";
        Query query = em.createQuery(requete);
        return ((Long)query.getSingleResult()).intValue();
    }
        
}
