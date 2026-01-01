package com.PwnFeed.feedService.application;

import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeed;
import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeedItem;
import com.PwnFeed.feedService.adapters.out.http.HttpHelper;
import com.PwnFeed.feedService.adapters.out.rss.RssFeedParserFacade;
import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.feed.FeedItem;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.PwnFeed.feedService.domain.ports.in.GetFeedPort;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class GetFeedService
        implements GetFeedPort {
    private RssFeedParserFacade parserFacade;

    public GetFeedService(
            RssFeedParserFacade parser) {
        this.parserFacade = parser;
    }

    @Override
    public void getFeed(RssUrl rssUrl) {
        MediaType mediaType = HttpHelper
                .head(rssUrl.value())
                .getContentType();

        try {
            ParsedFeed feedParsePort = parserFacade
                    .parseFacade(mediaType)
                    .parse(rssUrl);

            List<FeedItem> feedItem = feedParsePort
                    .parsedFeedItem()
                    .stream()
                    .map((ParsedFeedItem entity) -> {
                        return FeedItem.builder()
                                .author(entity.author())
                                .link(entity.link())
                                .title(entity.title())
                                .uri(entity.uri())
                                .build();
                    })
                    .toList();
            System.out.println(feedItem);

            // Feed.builder()
            // .fee

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // repository.save(feed);
        // return null;

    }
}
