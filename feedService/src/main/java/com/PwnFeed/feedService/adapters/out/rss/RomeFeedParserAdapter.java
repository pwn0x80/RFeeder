package com.PwnFeed.feedService.adapters.out.rss;

import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Component;

import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeed;
import com.PwnFeed.feedService.adapters.out.dto.parser.ParsedFeedItem;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.PwnFeed.feedService.domain.ports.out.FeedParsePort;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Component
public class RomeFeedParserAdapter
        implements FeedParsePort {
    @Override
    public ParsedFeed parse(RssUrl rssUrl) {
        try {
            URL rssUrlParse = new URL(
                    rssUrl.value());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input
                    .build(new XmlReader(
                            rssUrlParse));

          

            List<ParsedFeedItem> parsedFeedItemBuilder = syndFeed
                    .getEntries()
                    .stream()
                    .map(entry -> ParsedFeedItem
                            .builder()
                            .author(entry.getAuthor())
                            .link(entry.getLink())
                            .title(entry.getTitle())
                            .description(entry.getDescription().getValue())
                            .uri(entry.getUri())
                            .build())
                    .toList();

            ParsedFeed parsedFeedBuilder = ParsedFeed
                    .builder()
                    .parsedFeedItem(
                            parsedFeedItemBuilder)
                    .title(syndFeed
                            .getTitle())
                    .link(syndFeed.getLink())
                    .rssUrl(rssUrl)
                    .description(
                            syndFeed.getDescription())
                    .lang(syndFeed.getLanguage())
                    .image(syndFeed
                            .getImage())
                    .followCount(0)
                    .build();
            return parsedFeedBuilder;
        } catch (Exception e) {
            // TODO change to custom FeedParserException
            throw new RuntimeException(
                    "Failed to parse RSS feed: "
                            + rssUrl.value(),
                    e);
        }

    }
}
