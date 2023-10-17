package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdvReo;

    public Querries(RendezVousRepository rdvReo) {
        this.rdvReo = rdvReo;
    }

    public List<RendezVous> getRendezvousList(){
        return rdvReo.getListeRendezVous();
    }

}
