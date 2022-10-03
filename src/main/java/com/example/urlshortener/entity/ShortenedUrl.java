package com.example.urlshortener.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "shortened_urls")
public class ShortenedUrl {
    @Id
    private String id;
    @Column(name = "original_url")
    private String url;
    private String title;
}
