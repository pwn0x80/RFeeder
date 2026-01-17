package com.PwnFeed.feedService.adapters.in.rest;

import com.PwnFeed.feedService.adapters.in.rest.dto.FeedResponseDto;
import com.PwnFeed.feedService.adapters.in.rest.dto.GetFeedRequestDto;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.PwnFeed.feedService.domain.ports.in.GetFeedPort;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FeedController {
    private final GetFeedPort getFeedPort;

    public FeedController(GetFeedPort getFeedPort) {
        this.getFeedPort = getFeedPort;
    }

    @PostMapping("/a")
    public FeedResponseDto getFeed(@RequestBody GetFeedRequestDto dtoRssUrl)
            throws SQLException {
        System.out.println("hioiiiiiiiiiiii");
        RssUrl rssUrl = new RssUrl(dtoRssUrl.rssUrl()); // v0
        getFeedPort.getFeed(rssUrl);
        // return new FeedResponseDto(feed.getTitle());
        return null;
    }
}
