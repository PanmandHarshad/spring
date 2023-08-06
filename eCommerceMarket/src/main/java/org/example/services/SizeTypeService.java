package org.example.services;

import org.example.model.SizeType;
import org.example.repository.SizeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeTypeService {

    private final SizeTypeRepository sizeTypeRepository;

    @Autowired
    public SizeTypeService(SizeTypeRepository sizeTypeRepository) {
        this.sizeTypeRepository = sizeTypeRepository;
    }

    public List<SizeType> getAllSizeTypes(){
        return sizeTypeRepository.findAll();
    }
}
