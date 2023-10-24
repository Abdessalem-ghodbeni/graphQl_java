package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdvReo;
    public LogementRepository logementRepository;

    public Querries(RendezVousRepository rdvReo, LogementRepository logementRepository) {
        this.rdvReo = rdvReo;
        this.logementRepository=logementRepository;
    }

    public List<RendezVous> getRendezvousList(){
        return rdvReo.getListeRendezVous();
    }
    public List<Logement> getAllLogements() {
        return logementRepository.getAllLogements();
    }
    public  List<RendezVous> getAllRendzvousByLogement(int reflog){
        return rdvReo.getListeRendezVousByLogementRef(reflog);
    }
}
