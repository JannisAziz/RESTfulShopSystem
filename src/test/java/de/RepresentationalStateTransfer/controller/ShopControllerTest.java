package de.RepresentationalStateTransfer.controller;

import de.RepresentationalStateTransfer.model.*;
import de.RepresentationalStateTransfer.service.IShopService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopControllerTest {

    private final static List<Product> mockProducts = Arrays.asList(
            new Product(1, "TESTPRODUCT_1"),
            new Product(2, "TESTPRODUCT_2"),
            new Product(3, "TESTPRODUCT_3")
    );

    final Product mockInvalidProduct = new Product(0, "INVALID_PRODUCT");

    final List<Order> mockOrders = Arrays.asList(
            new Order(1, mockProducts),
            new Order(2, mockProducts)
    );

    /// PRODUCTS ///

    @Test
    void getAllProducts() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getAllProducts()).thenReturn(mockProducts);

        // THEN
        assertArrayEquals(mockProducts.toArray(), shopController.getAllProducts().toArray());
    }

    @Test
    void getProductById() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getProductById(1)).thenReturn(mockProducts.get(0));

        // THEN
        assertEquals(mockProducts.get(0), shopController.getProductById(1));
    }

    @Test
    void getProductByName() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getProductByName("TESTPRODUCT_1")).thenReturn(mockProducts.get(0));

        // THEN
        assertEquals(mockProducts.get(0), shopController.getProductByName("TESTPRODUCT_1"));
    }

    @Test
    void addProducts() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.addNewProducts(mockProducts.get(0))).thenReturn("Added products!");

        // THEN
        assertEquals("Added products!", shopController.addProducts(mockProducts.get(0)));
    }

    @Test
    void removeProduct() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.removeProducts(mockProducts.get(0))).thenReturn("Removed products!");

        // THEN
        assertEquals("Removed products!", shopController.removeProducts(mockProducts.get(0)));
    }

    /// ORDERS ///

    @Test
    void getAllOrders() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getAllOrders()).thenReturn(mockOrders);

        // THEN
        assertEquals(mockOrders, shopController.getAllOrders());
    }

    @Test
    void getOrderById() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.getOrderById(1)).thenReturn(mockOrders.get(0));

        // THEN
        assertEquals(mockOrders.get(0), shopController.getOrderById(1));
    }

    @Test
    void createOrder() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Order mockOrder = new Order(1, mockProducts);
        Mockito.when(mockService.addOrders(mockOrder)).thenReturn("Created order!");

        // THEN
        assertEquals("Created order!", shopController.addOrders(mockOrder));
    }

    @Test
    void removeOrders() {
        // GIVEN
        IShopService mockService = Mockito.mock(IShopService.class);
        ShopController shopController = new ShopController(mockService);

        // WHEN
        Mockito.when(mockService.removeOrders()).thenReturn("Removed orders!");

        // THEN
        assertEquals("Removed orders!", shopController.removeOrders());
    }
}