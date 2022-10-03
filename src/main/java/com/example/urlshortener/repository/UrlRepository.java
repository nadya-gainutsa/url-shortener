package com.example.urlshortener.repository;

import com.example.urlshortener.entity.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<ShortenedUrl, String> {
}
