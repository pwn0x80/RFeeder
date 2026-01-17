package com.PwnFeed.feedService.domain.model.feed;

import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.rometools.rome.feed.synd.SyndImage;

import lombok.Builder;

@Builder
public record Feed(String feedId,

        RssUrl rssUrl,
         String link,
        String title,
        String description,
        String lang,
        SyndImage image,
        String sourceName,
        String sourceHomepage,
        String eTag,
        String lastModified,
        String lastfetechedAt,
        String status,
        String createdAt,
        String createdBy,
        String createdByUserId,
        Integer followCount) {

}
