/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.trackunit.cart.api;

import com.trackunit.cart.model.Cart;
import com.trackunit.cart.model.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-04T02:25:19.566167-04:00[America/Toronto]")
@Validated
@Tag(name = "cart", description = "the cart API")
@RequestMapping("${openapi.shoppintCartService.base-path:/api/v1}")
public interface CartApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /cart/{cartId}/item
     * Add item to cart
     *
     * @param cartId Cart ID (required)
     * @param item  (required)
     * @return Version history (status code 200)
     */
    @Operation(
            operationId = "addItem",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Version history", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/cart/{cartId}/item",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<Cart> addItem(
            @Min(0) @Parameter(name = "cartId", description = "Cart ID", required = true) @PathVariable("cartId") Integer cartId,
            @Parameter(name = "Item", description = "", required = true) @Valid @RequestBody Item item
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0, \"items\" : [ { \"price\" : { \"unit\" : \"USD\", \"amount\" : 1 }, \"active\" : true, \"id\" : 0, \"content\" : \"content\" }, { \"price\" : { \"unit\" : \"USD\", \"amount\" : 1 }, \"active\" : true, \"id\" : 0, \"content\" : \"content\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /cart
     * Create a new cart
     *
     * @return Successful create (status code 200)
     */
    @Operation(
            operationId = "createCart",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful create", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/cart",
            produces = { "application/json" }
    )
    default ResponseEntity<Integer> createCart(

    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /cart/{cartId}
     * List items in cart
     *
     * @param cartId Cart ID (required)
     * @return Cart object (status code 200)
     */
    @Operation(
            operationId = "listItems",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cart object", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cart/{cartId}",
            produces = { "application/json" }
    )
    default ResponseEntity<Cart> listItems(
            @Min(0) @Parameter(name = "cartId", description = "Cart ID", required = true) @PathVariable("cartId") Integer cartId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0, \"items\" : [ { \"price\" : { \"unit\" : \"USD\", \"amount\" : 1 }, \"active\" : true, \"id\" : 0, \"content\" : \"content\" }, { \"price\" : { \"unit\" : \"USD\", \"amount\" : 1 }, \"active\" : true, \"id\" : 0, \"content\" : \"content\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /cart/{cartId}/item/{itemId}
     * Update item
     *
     * @param cartId Cart ID (required)
     * @param itemId Item ID (required)
     * @param item  (required)
     * @return Version history (status code 200)
     */
    @Operation(
            operationId = "updateItem",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Version history", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/cart/{cartId}/item/{itemId}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<Item> updateItem(
            @Min(0) @Parameter(name = "cartId", description = "Cart ID", required = true) @PathVariable("cartId") Integer cartId,
            @Min(0) @Parameter(name = "itemId", description = "Item ID", required = true) @PathVariable("itemId") Integer itemId,
            @Parameter(name = "Item", description = "", required = true) @Valid @RequestBody Item item
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : { \"unit\" : \"USD\", \"amount\" : 1 }, \"active\" : true, \"id\" : 0, \"content\" : \"content\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
