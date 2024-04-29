package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Type;
import com.Sunnxt.Functions.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(int id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        return optionalType.orElse(null);
    }

    public void deleteTypeById(int id) {
        typeRepository.deleteById(id);
    }
}