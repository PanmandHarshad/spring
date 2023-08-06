package org.example.rest;

import org.example.model.SizeType;
import org.example.services.SizeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sizetype")
public class SizeTypeController {
    private final SizeTypeService sizeTypeService;

    @Autowired
    public SizeTypeController(SizeTypeService sizeTypeService) {
        this.sizeTypeService = sizeTypeService;
    }

    @GetMapping
    public ResponseEntity<List<SizeType>> getAllSizeTypes() {
        List<SizeType> allSizeTypes = sizeTypeService.getAllSizeTypes();
        return ResponseEntity.ok(allSizeTypes);
    }
}
