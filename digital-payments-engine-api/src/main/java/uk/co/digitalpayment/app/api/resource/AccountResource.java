package uk.co.digitalpayment.app.api.resource;

import io.quarkus.security.Authenticated;
import uk.co.digitalpayment.app.api.model.AccountModel;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitalpayment.service.AccountService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Authenticated
@ApplicationScoped
@Path("/api/accounts")
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create() {
        final Account account = accountService.create();
        final AccountModel accountModel = AccountModel.builder()
                .emailAddress(account.getEmailAddress())
                .locale(account.getLocale().toLanguageTag())
                .build();
        return Response.created(URI.create("/location"))
                .entity(accountModel)
                .build();
    }

    @GET
    public Response ping() {
        return Response.ok("UP", MediaType.TEXT_PLAIN).build();
    }

}
