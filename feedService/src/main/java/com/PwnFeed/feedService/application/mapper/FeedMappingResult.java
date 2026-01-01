package com.PwnFeed.feedService.application.mapper;

import java.util.List;

import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.feed.FeedItem;

public record FeedMappingResult(
    Feed feed,
    List<FeedItem> feedItems
) {}
