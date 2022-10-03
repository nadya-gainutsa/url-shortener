package com.example.urlshortener.service;

import com.example.urlshortener.dto.LongUrl;
import com.example.urlshortener.entity.ShortenedUrl;
import com.example.urlshortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UrlService {
    private UrlRepository urlRepository;

    public ShortenedUrl doShort(LongUrl longUrl) {
        String shortUrl = RandomString.make(5);
        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setId(shortUrl);
        shortenedUrl.setUrl(longUrl.url());
        shortenedUrl.setTitle(longUrl.title());
        urlRepository.save(shortenedUrl);

        return shortenedUrl;
    }
    public Optional<ShortenedUrl> getLongUrl(String shortUrl) {
        return urlRepository.findById(shortUrl);
    }
}
