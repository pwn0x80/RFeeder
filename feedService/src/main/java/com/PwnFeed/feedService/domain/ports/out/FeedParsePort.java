package com.PwnFeed.feedService.domain.ports.out;

import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeed;
import com.PwnFeed.feedService.domain.model.feed.Feed;

import com.PwnFeed.feedService.domain.model.vo.RssUrl;


public interface FeedParsePort {
    ParsedFeed parse(RssUrl url);
}
