package uk.co.digitalpayment.merchant.api;

import uk.co.digitalpayment.merchant.core.exception.MerchantAlreadyRegisteredException;
import uk.co.digitalpayment.merchant.core.model.MerchantModel;
import uk.co.digitalpayment.merchant.core.port.MerchantService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
@Path("/api/merchants")
public class MerchantResource {

    private MerchantService merchantService;

    @Inject
    public MerchantResource(final MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final MerchantModel model) {
        try {
            final Long id = merchantService.registerMerchant(model);
            return Response.created(URI.create(String.format("/api/merchants/%s", id))).build();
        }
        catch (MerchantAlreadyRegisteredException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
