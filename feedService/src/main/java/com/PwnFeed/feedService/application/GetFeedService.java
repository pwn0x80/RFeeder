package com.PwnFeed.feedService.application;

import com.PwnFeed.feedService.adapters.out.http.HttpHelper;
import com.PwnFeed.feedService.adapters.out.rss.RssFeedParserFacade;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.PwnFeed.feedService.domain.ports.in.GetFeedPort;

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
            parserFacade.parseFacade(
                    mediaType)
                    .parse(rssUrl);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // repository.save(feed);
        // return null;

    }
}
