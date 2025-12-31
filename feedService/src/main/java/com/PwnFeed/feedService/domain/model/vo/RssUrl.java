//v0
package com.PwnFeed.feedService.domain.model.vo;
public record RssUrl(String value) {

    public RssUrl {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("RSS URL cannot be empty");
        }
        if (!value.startsWith("http")) {
            throw new IllegalArgumentException("Invalid RSS URL");
        }
    }
}
