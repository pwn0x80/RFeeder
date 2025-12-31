package com.PwnFeed.feedService.domain.model.feed;

public record FeedItem(String FeedId, String guid, String title, String link,
        String description, String content, String author, String category,
        String imgUrl, String enclosureUrl, String enclosureType, int upvote,
        int downvote) {
}