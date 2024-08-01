package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Type;
import com.Sunnxt.Functions.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/addtypes")
    public String createType(@RequestBody Type type) {
        typeService.saveType(type);
        return "Type created successfully!";
    }

    @GetMapping("/types")
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/types/{id}")
    public Type getTypeById(@PathVariable("id") int id) {
        Type type = typeService.getTypeById(id);
        if (type != null) {
            return type;
        } else {
            return null;
        }
    }

    @PutMapping("/updatetypes/{id}")
    public String updateType(@PathVariable("id") int id, @RequestBody Type updatedType) {
        Type type = typeService.getTypeById(id);
        if (type != null) {
            type.setUserId(updatedType.getUserId());
            type.setType(updatedType.getType());

            typeService.saveType(type);
            return "Type updated successfully!";
        } else {
            return "Type with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") int id) {
        Type type = typeService.getTypeById(id);
        if (type != null) {
            typeService.deleteTypeById(id);
            return "Type with ID " + id + " deleted successfully!";
        } else {
            return "Type with ID " + id + " not found.";
        }
    }
}