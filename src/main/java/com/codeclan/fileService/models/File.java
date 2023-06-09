package com.codeclan.fileService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String extension;
    private int size;
    @ManyToOne
    @JsonIgnoreProperties({"files"})
    @JoinColumn(name = "file_id", nullable = false)
    private Folder folder;

    public File() {
    }

    public File(String name, String extension, int size, Folder folder) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.folder = folder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
