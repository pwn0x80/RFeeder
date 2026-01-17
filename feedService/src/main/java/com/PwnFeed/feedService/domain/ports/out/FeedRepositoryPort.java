package com.PwnFeed.feedService.domain.ports.out;


import java.util.Optional;

import com.PwnFeed.feedService.application.mapper.FeedMappingResult;
import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;

public interface FeedRepositoryPort {
    void save(FeedMappingResult feed);
   // Optional<Feed> findByUrl(RssUrl url);

  //  Feed save(Feed feed);
}