package com.example.DMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DMS.Models.ProductReturn;
import com.example.DMS.Service.ProductReturnService;

@RestController
@RequestMapping("/returns")
public class ProductReturnController {
	@Autowired
    private ProductReturnService productReturnService;

    // Process product return
    @PostMapping
    public ProductReturn processReturn(@RequestParam String orderId,
                                       @RequestParam String productName,
                                       @RequestParam String reason,
                                       @RequestParam int quantity,
                                       @RequestParam int warehouseId) {
        return productReturnService.processReturn(orderId, productName, reason, quantity, warehouseId);
    }

    // Get all returned products
    @GetMapping
    public List<ProductReturn> getAllReturns() {
        return productReturnService.getAllReturns();
    }
}
