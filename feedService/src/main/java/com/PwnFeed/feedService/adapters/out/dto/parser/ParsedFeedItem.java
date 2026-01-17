package com.PwnFeed.feedService.adapters.out.dto.parser;
import com.PwnFeed.feedService.adapters.out.persistence.converter.SyndContentConverter;
import com.rometools.rome.feed.rss.Content;

import jakarta.persistence.Convert;
import lombok.Builder;

@Builder
public record ParsedFeedItem(
                String guid,
                String title,
                String link,
                String description,
                Content content,
                String author,
                String category,
                String imgUrl,
                String enclosureUrl,
                String enclosureType,
                String uri,
                int upvote,
                int downvote) {

}
