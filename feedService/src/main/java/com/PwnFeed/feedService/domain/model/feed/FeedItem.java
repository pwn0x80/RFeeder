package com.PwnFeed.feedService.domain.model.feed;

import com.rometools.rome.feed.rss.Content;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder

public record FeedItem(
                Feed feed,
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