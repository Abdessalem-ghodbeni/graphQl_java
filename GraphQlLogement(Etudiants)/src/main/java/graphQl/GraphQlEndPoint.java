package graphQl;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet("/graphQl")
public class GraphQlEndPoint extends SimpleGraphQLServlet {
    public GraphQlEndPoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
    RendezVousRepository redVous =new RendezVousRepository();
        LogementRepository logementRepository=new LogementRepository();
        return SchemaParser.newParser()
                .file("Schema.graphqls")
                .resolvers(new Querries(redVous,logementRepository), new Mutations(redVous,logementRepository))
                .build()
                .makeExecutableSchema();
    }
}
