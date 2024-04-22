package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Content;
import com.Sunnxt.Functions.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/uploadContent")
    public String uploadContent(@RequestBody Content content) {
        contentService.saveContent(content);
        return "Content uploaded successfully!";
    }

    @GetMapping("/contents")
    public List<Content> getAllContent() {
        return contentService.getAllContent();
    }

    @PutMapping("/contents/{id}")
    public String updateContent(@PathVariable("id") int id, @RequestBody Content updatedContent) {
        Content content = contentService.getContentById(id);
        if (content != null) {
            // Update the fields of the existing content with the new data
            content.setUploadedContentDetails(updatedContent.getUploadedContentDetails());
            content.setContentUploadHistory(updatedContent.getContentUploadHistory());
            content.setContentModificationHistory(updatedContent.getContentModificationHistory());
            content.setChannelId(updatedContent.getChannelId());

            contentService.saveContent(content);
            return "Content updated successfully!";
        } else {
            return "Content with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deletecontents/{id}")
    public String deleteContent(@PathVariable("id") int id) {
        Content content = contentService.getContentById(id);
        if (content != null) {
            contentService.deleteContentById(id);
            return "Content with ID " + id + " deleted successfully!";
        } else {
            return "Content with ID " + id + " not found.";
        }
    }

    // Add more controller methods as needed
}
