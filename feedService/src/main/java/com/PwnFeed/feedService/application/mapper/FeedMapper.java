package com.PwnFeed.feedService.application.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeed;
import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeedItem;
import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.feed.FeedItem;

@Component
public class FeedMapper {

      public FeedMappingResult toDomain(ParsedFeed parsedFeed) {

        Feed feed = Feed.builder()
                .title(parsedFeed.title())
                .link(parsedFeed.link())
                .rssUrl(parsedFeed.rssUrl())
                .description(parsedFeed.description())
                .lang(parsedFeed.lang())
                .image(parsedFeed.image())
                .followCount(0)
                .build();

        List<FeedItem> feedItems =
                parsedFeed.parsedFeedItem()
                        .stream()
                        .map(item -> toFeedItem(feed, item))
                        .toList();

        return new FeedMappingResult(feed, feedItems);
    }

    private FeedItem toFeedItem(Feed feed, ParsedFeedItem item) {
        return FeedItem.builder()
                .feed(feed)        
                .author(item.author())
                .title(item.title())
                .link(item.link())
                .uri(item.uri())
                .build();
    }
}
