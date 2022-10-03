package com.example.urlshortener.controller;

import com.example.urlshortener.dto.LongUrl;
import com.example.urlshortener.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("short/")
@AllArgsConstructor
public class Controller {
    private UrlService urlService;

    @PostMapping()
    public ResponseEntity<String> shortUrl(@RequestBody LongUrl longUrl) {
        var shortUrl = urlService.doShort(longUrl);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", shortUrl.getId())
                .build();

    }

    @GetMapping("/{shortenUrlId}")
    public ResponseEntity<Object> getLongUrl(@PathVariable String shortenUrlId) {
        var entity = urlService.getLongUrl(shortenUrlId);
        return entity.map(shortenedUrl -> ResponseEntity
                    .status(HttpStatus.PERMANENT_REDIRECT)
                    .location(URI.create(shortenedUrl.getUrl()))
                    .build())
                .orElseGet(() -> ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build());
    }
}


