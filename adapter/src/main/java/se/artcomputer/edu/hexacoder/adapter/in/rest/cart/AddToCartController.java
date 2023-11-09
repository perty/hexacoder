package se.artcomputer.edu.hexacoder.adapter.in.rest.cart;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.artcomputer.edu.hexacoder.application.port.in.cart.AddToCartUseCase;
import se.artcomputer.edu.hexacoder.application.service.product.ProductNotFoundException;
import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.cart.NotEnoughItemsInStockException;
import se.artcomputer.edu.hexacoder.model.cart.Quantity;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;
import se.artcomputer.edu.hexacoder.model.product.ProductId;

import static se.artcomputer.edu.hexacoder.adapter.in.rest.common.ControllerCommons.clientErrorException;
import static se.artcomputer.edu.hexacoder.adapter.in.rest.common.CustomerIdParser.parseCustomerId;
import static se.artcomputer.edu.hexacoder.adapter.in.rest.common.ProductIdParser.parseProductId;


@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class AddToCartController {

    private final AddToCartUseCase addToCartUseCase;

    public AddToCartController(AddToCartUseCase addToCartUseCase) {
        this.addToCartUseCase = addToCartUseCase;
    }

    @POST
    @Path("/{customerId}/line-items")
    public CartWebModel addLineItem(@PathParam("customerId") String customerIdString,
                                    @QueryParam("productId") String productIdString,
                                    @QueryParam("quantity") int quantity) {
        CustomerId customerId = parseCustomerId(customerIdString);
        ProductId productId = parseProductId(productIdString);

        try {
            Cart cart = addToCartUseCase.addToCart(customerId, productId, new Quantity(quantity));
            return CartWebModel.fromDomainModel(cart);
        } catch (ProductNotFoundException e) {
            throw clientErrorException(
                    Response.Status.BAD_REQUEST, "The requested product does not exist");
        } catch (NotEnoughItemsInStockException e) {
            throw clientErrorException(
                    Response.Status.BAD_REQUEST,
                    "Only %d items in stock".formatted(e.itemsInStock()));
        }
    }
}