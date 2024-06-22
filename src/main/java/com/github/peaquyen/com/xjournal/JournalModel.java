package com.github.peaquyen.com.xjournal;

public class JournalModel {
    private int id;
    private String title;
    private String description;
    private String feeling;
    private String images;
    private String date;
    private int ownerId;

    // Constructor with all fields
    public JournalModel(int id, String title, String description, String feeling, String images, String date, int ownerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.feeling = feeling;
        this.images = images;
        this.date = date;
        this.ownerId = ownerId;
    }

    // Constructor without id (used for creation)
    public JournalModel(String title, String description, String feeling, String images, String date, int ownerId) {
        this.title = title;
        this.description = description;
        this.feeling = feeling;
        this.images = images;
        this.date = date;
        this.ownerId = ownerId;
    }

    JournalModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", feeling='" + feeling + '\'' +
                ", images='" + images + '\'' +
                ", date='" + date + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
