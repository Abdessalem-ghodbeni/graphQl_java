package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutations implements GraphQLRootResolver {
    public RendezVousRepository rendezVousRepository;
    public LogementRepository logementRepository;

    public Mutations(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public boolean CreateRendezVous(int id, String date, String heure, int refLog, String numTel) {
        Logement log = logementRepository.getLogementsByReference((refLog));
        RendezVous rend = new RendezVous(id, date, heure, log, numTel);
        return rendezVousRepository.addRendezVous(rend);
    }

    public boolean UpdateRendezVous(int id, String date, String heure, String numTel) {
        Logement logement = rendezVousRepository.getLogementByRDV(id);
        RendezVous updateRendezVous = new RendezVous(id, date, heure, logement, numTel);
        return rendezVousRepository.updateRendezVous(updateRendezVous);

    }
}
