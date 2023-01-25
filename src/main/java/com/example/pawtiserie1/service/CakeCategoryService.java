package com.example.pawtiserie1.service;

import com.example.pawtiserie1.model.Cake;
import com.example.pawtiserie1.model.CakeCategory;
import com.example.pawtiserie1.repository.CakeCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeCategoryService {
    private CakeCategoryRepository cakeCategoryRepository;

    public CakeCategoryService(CakeCategoryRepository cakeCategoryRepository) {
        this.cakeCategoryRepository = cakeCategoryRepository;
    }

    public CakeCategory saveNewCategory(CakeCategory cakeCategory) {
        return cakeCategoryRepository.save(cakeCategory);
    }

    public List<CakeCategory> retrieveCategories(){
        return cakeCategoryRepository.findAll();
    }

    public CakeCategory updateName(String name, int id) {
        CakeCategory ns = new CakeCategory();
        ns = cakeCategoryRepository.findById(id).get();
        if (name.contains(">=")){
            name = name.substring(12,name.length()-4);
        }
        ns.setCategoryName(name);
        return cakeCategoryRepository.save(ns);
    }
}
