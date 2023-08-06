package org.example.services;

import org.example.model.ItemSize;
import org.example.repository.ItemSizeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ItemSizeService {

    private final ItemSizeRepository itemSizeRepository;


    public ItemSizeService(ItemSizeRepository itemSizeRepository) {
        this.itemSizeRepository = itemSizeRepository;
    }

    @GetMapping
    public List<ItemSize> getAllSizes() {
        return itemSizeRepository.findAll();
    }

}
