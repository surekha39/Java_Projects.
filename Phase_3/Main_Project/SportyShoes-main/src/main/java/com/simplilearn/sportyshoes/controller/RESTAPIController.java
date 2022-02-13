package com.simplilearn.sportyshoes.controller;

import com.simplilearn.sportyshoes.model.Order;
import com.simplilearn.sportyshoes.model.Product;
import com.simplilearn.sportyshoes.model.User;
import com.simplilearn.sportyshoes.service.AuthService;
import com.simplilearn.sportyshoes.service.OrderService;
import com.simplilearn.sportyshoes.service.ProductService;
import com.simplilearn.sportyshoes.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RESTAPIController {
    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;
    private final AuthService authService;

    @Autowired
    public RESTAPIController(ProductService productService, UserService userService, OrderService orderService, AuthService authService) {
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
        this.authService = authService;
    }

    @Operation(summary = "Get all the products in stock", description = "Get a list of all the products in stock and filter by search criteria if provided.")
    @GetMapping("/products")
    public List<Product> getAllProducts(@Nullable @RequestBody Map<String, String> searchCriteria) {
        if (searchCriteria == null) return productService.getAllProducts();
        else return productService.getFilteredProducts(searchCriteria);
    }

    @Operation(summary = "Get a specific product", description = "Get a specific product by its ID")
    @GetMapping("/products/{id}")
    public Product getProductById(@Parameter(description = "ID of the product", required = true, name = "ID Value") @PathVariable int id) {
        return this.productService.getSingleById(id);
    }

    @Operation(summary = "Add a product", description = "Add a product to the database")
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(
            @io.swagger.v3.oas.annotations.parameters.
                    RequestBody(content = @Content(schema = @Schema(implementation = Product.class))) @RequestBody Map<String, String> rMap,
            @RequestHeader("Authorization") String auth) throws Exception {
        this.authenticateUser(auth);
        Product product = productService.getProductFromMap(rMap);
        productService.insert(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a product by ID", description = "Delete a specified product by its ID")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.removeProduct(id));
    }

    @Operation(summary = "Update a product by ID", description = "Update a specified product by its ID")
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Map<String, String> rMap, @RequestHeader("Authorization") String auth) throws Exception {
        this.authenticateUser(auth);
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productService.getProductFromMap(rMap)));
    }

    @Operation(summary = "Get all users", description = "Get all users. Requires admin authentication")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestHeader("Authorization") String auth) throws Exception {
        this.authenticateUser(auth);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @Operation(summary = "Get all purchase orders", description = "Get all purchase orders. Requires admin authentication")
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(@RequestHeader("Authorization") String auth, @Nullable @RequestBody Map<String, String> rMap) throws Exception {
        this.authenticateUser(auth);
        if (rMap == null) {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
        } else {
            String date = rMap.get("date");
            String category = rMap.get("category");
            return ResponseEntity.status(HttpStatus.OK).body(orderService.getFilteredOrders(date, category));
        }
    }

    @Operation(summary = "Change password", description = "Change password of a particular user")
    @PutMapping("/users/{username}")
    public ResponseEntity<String> changePassword(@PathVariable String username, @RequestHeader("Authorization") String auth, @RequestBody() Map<String, String> userDetailsMap) throws Exception {
        this.authenticateUser(auth);

        String newPassword = userDetailsMap.get("password");
        userService.changePassword(username, newPassword);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private void authenticateUser(String auth) throws Exception {
        String authCode = auth.substring("basic".length() + 1);
        byte[] byteCodes = Base64.getDecoder().decode(authCode);
        String[] credArray = new String(byteCodes, StandardCharsets.UTF_8).split(":");
        authService.authenticateUser(credArray[0], credArray[1]);
    }

}
