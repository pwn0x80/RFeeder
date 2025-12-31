package com.PwnFeed.feedService.adapters.out.dto.parser;
import com.rometools.rome.feed.rss.Content;

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
