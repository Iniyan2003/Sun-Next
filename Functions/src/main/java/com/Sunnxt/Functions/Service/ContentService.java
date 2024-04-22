package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Content;
import com.Sunnxt.Functions.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    public Content getContentById(int id) {
        Optional<Content> optionalContent = contentRepository.findById(id);
        return optionalContent.orElse(null);
    }

    public void deleteContentById(int id) {
        contentRepository.deleteById(id);
    }

    // Add more service methods as needed
}
