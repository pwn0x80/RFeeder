package com.PwnFeed.feedService.domain.ports.in;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;

public interface GetFeedPort {
    void getFeed(RssUrl url);
}
