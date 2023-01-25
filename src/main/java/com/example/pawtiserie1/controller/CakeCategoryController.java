package com.example.pawtiserie1.controller;

import com.example.pawtiserie1.model.Cake;
import com.example.pawtiserie1.model.CakeCategory;
import com.example.pawtiserie1.repository.CakeCategoryRepository;
import com.example.pawtiserie1.service.CakeCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CakeCategoryController {
    private final CakeCategoryService cakeCategoryService;
    private final CakeCategoryRepository cakeCategoryRepository;

    public CakeCategoryController(CakeCategoryService cakeCategoryService,
                                  CakeCategoryRepository cakeCategoryRepository) {
        this.cakeCategoryService = cakeCategoryService;
        this.cakeCategoryRepository = cakeCategoryRepository;
    }
    @PostMapping("/add")
    public ResponseEntity<CakeCategory> saveCategory(@RequestBody CakeCategory cakeCategory){
        return ResponseEntity.ok().body(cakeCategoryService.saveNewCategory(cakeCategory));
    }
    @GetMapping
    public ResponseEntity<List<CakeCategory>> retrieveCategories(){
        return ResponseEntity.ok().body(cakeCategoryService.retrieveCategories());
    }
    @PutMapping("/new")
    public ResponseEntity<CakeCategory> addOrUpdate(@RequestBody CakeCategory cakeCategory){
        return ResponseEntity.ok().body(cakeCategoryService.saveNewCategory(cakeCategory));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CakeCategory> updateName(@RequestBody String name, @PathVariable int id){
        return ResponseEntity.ok().body(cakeCategoryService.updateName(name,id));
    }
}
