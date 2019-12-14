package si.fri.prpo.api.v1.viri;
import si.fri.prpo.entitete.Priporocilo;
import si.fri.prpo.storitve.PriporocilaZrno;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("priporocila")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PriporocilaVir {

    @Inject
    private PriporocilaZrno priporocilaZrno;

    @GET
    public Response pridobiPriporocila() {
        List<Priporocilo> priporocila = priporocilaZrno.vrniVsaPriporocila();
        return Response.ok(priporocila).build();
    }

    @GET
    @Path("{id}")
    public Response pridobiPriporocilo(@PathParam("id") int id) {
        return Response.ok(priporocilaZrno.vrniPriporocilo(id)).build();
    }

    @POST
    public Response dodajPriporocilo(Priporocilo priporocilo) {
        priporocilaZrno.dodajPriporocilo(priporocilo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response posodobiPriporocilo(@PathParam("id") int id, Priporocilo priporocilo) {
        priporocilaZrno.posodobiPriporocilo(id, priporocilo);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstraniPriporocilo(@PathParam("id") int id) {
        if(priporocilaZrno.vrniPriporocilo(id) != null) {
            priporocilaZrno.odstraniPriporocilo(id);
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}