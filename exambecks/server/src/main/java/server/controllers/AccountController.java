package server.controllers;

import com.google.gson.Gson;
import server.model.Account;
import server.model.Customer;
import server.repository.AccountRepository;
import server.repository.CustomerRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Contains the endpoints for account operations.
 */
@Path("/accounts")
public class AccountController {

    //Todo: Add the needed account endpoints here.

    private AccountRepository accountRepository;

    public AccountController () { this.accountRepository = new AccountRepository();}

 /*
    @GET
    @Path("{id}")
    public Response getAccountsForCustomer(@PathParam("id") int customerId) {
        Account account = accountRepository.getAccountsForCustomer(customerId);
        String output = new Gson().toJson(account);
        System.out.println(output);

        return Response
                .status(200)
                .type("application/json")
                .entity(output)
                .build();
    }
    */
    @GET
    @Path("{id}")
    public Response getAccountsForCustomer (@PathParam("id") int customerId) {
        ArrayList<Account> account = accountRepository.getAccountsForCustomer(customerId);
        String output = new Gson().toJson(account);
        System.out.println(output);

        return Response.status(200).type("application/json").entity(output).build();
    }


    /**
     * Gets all accounts from the database
     * @return Response to the client.
     */
    @GET
    public Response getAccounts(){
        // Get a list of accounts
        ArrayList<Account> accounts = accountRepository.getAccounts();
        String out = new Gson().toJson(accounts);

        // Return the accounts with the status code 200
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity(out).build();
    }


    /**
     * Creates a account from a JSON encoded representation of a account object.
     * @param account The JSON encoded representation of a account object.
     * @return A response indicating if the creation went well.
     */
    @POST
    public Response createAccount(String account) {

        Account account1 = new Gson().fromJson(account, Account.class);

        accountRepository.createAccount(account1);

        return Response.status(200).type("application/json").entity("{\"userCreated\":\"true\"}").build();
    }


    /**
     * Updates a account from a JSON String representing a full JSON object.
     * Matches the account based on the primary key.
     * @param account A JSON String representing a account object.
     * @return A JSON Object with e
     */
    @PUT
    public Response withdraw(String account){
        Account account2 = new Gson().fromJson(account, Account.class);
        accountRepository.withdraw(account2);
        // accountRepository.despoit(account2);
        return Response.status(200).type("application/json").entity("{\"accountUpdated\":\"true\"}").build();

    }





}


