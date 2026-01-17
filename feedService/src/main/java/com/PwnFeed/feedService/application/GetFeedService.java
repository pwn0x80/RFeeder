package com.PwnFeed.feedService.application;

import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeed;
import com.PwnFeed.feedService.adapters.out.http.HttpHelper;
import com.PwnFeed.feedService.adapters.out.persistence.JpaFeedRepositoryAdapter;
import com.PwnFeed.feedService.adapters.out.rss.RssFeedParserFacade;
import com.PwnFeed.feedService.application.mapper.FeedMapper;
import com.PwnFeed.feedService.application.mapper.FeedMappingResult;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.PwnFeed.feedService.domain.ports.in.GetFeedPort;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class GetFeedService
        implements GetFeedPort {
    private RssFeedParserFacade parserFacade;
    private FeedMapper feedMapper;
    private JpaFeedRepositoryAdapter jpaFeedRepositoryAdapter;

    public GetFeedService(
            RssFeedParserFacade parser,
            FeedMapper feedMapper,
            JpaFeedRepositoryAdapter jpaFeedRepositoryAdapter) {
        this.parserFacade = parser;
        this.feedMapper = feedMapper;
        this.jpaFeedRepositoryAdapter = jpaFeedRepositoryAdapter;
    }

    @Override
    public void getFeed(RssUrl rssUrl) {
        MediaType mediaType = HttpHelper
                .head(rssUrl.value())
                .getContentType();

        try {
            ParsedFeed feedParsePort = parserFacade
                    .parseFacade(
                            mediaType)
                    .parse(rssUrl);

            FeedMappingResult feedItem = feedMapper
                    .toDomain(
                            feedParsePort);
                            System.out.println(feedItem);
            
                    jpaFeedRepositoryAdapter.save(feedItem);

  
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // repository.save(feed);
        // return null;

    }
}
