package com.PwnFeed.feedService.domain.model.feed;

import com.PwnFeed.feedService.domain.model.vo.RssUrl;

import lombok.Builder;

@Builder
public record Feed(String feedId, RssUrl rssUrl, String description, String lang,
        String imageUrl, String sourceName, String sourceHomepage,
        String eTag, String lastModified, String lastfetechedAt, String status,
        String createdAt, String createdBy, String createdByUserId,
        String followCount) {


}
