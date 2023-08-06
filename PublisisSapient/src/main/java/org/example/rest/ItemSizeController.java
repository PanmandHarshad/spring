package org.example.rest;

import org.example.model.ItemSize;
import org.example.services.ItemSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/size")
public class ItemSizeController {
    private final ItemSizeService itemSizeService;

    @Autowired
    public ItemSizeController(ItemSizeService itemSizeService) {
        this.itemSizeService = itemSizeService;
    }

    @GetMapping
    public ResponseEntity<List<ItemSize>> getAllSizes() {
        List<ItemSize> allItemSizes = itemSizeService.getAllSizes();
        return ResponseEntity.ok(allItemSizes);
    }
}
