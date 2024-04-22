package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "content")
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Content_ID")
    private int contentId;

    @Column(name = "Uploaded_Content_Details")
    private String uploadedContentDetails;

    @Column(name = "Content_Upload_History")
    @Temporal(TemporalType.DATE)
    private Date contentUploadHistory;

    @Column(name = "Content_Modification_History")
    @Temporal(TemporalType.DATE)
    private Date contentModificationHistory;

    @Column(name = "Channel_ID")
    private int channelId;

    // Add getters and setters if needed
}
