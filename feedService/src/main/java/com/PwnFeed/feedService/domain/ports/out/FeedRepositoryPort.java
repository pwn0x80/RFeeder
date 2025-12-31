package com.PwnFeed.feedService.domain.ports.out;


import java.util.Optional;

import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;

public interface FeedRepositoryPort {

    Optional<Feed> findByUrl(RssUrl url);

  //  Feed save(Feed feed);
}