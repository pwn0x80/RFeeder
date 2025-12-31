package com.PwnFeed.feedService.adapters.out.rss;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.PwnFeed.feedService.domain.ports.out.FeedParsePort;

@Component
public class RssFeedParserFacade {
        private static final Map<String, FeedParsePort> registry = new HashMap<>();

        public RssFeedParserFacade(
                        RomeFeedParserAdapter romeParser) {

                // parseMediaType to add extra media type
                // type of media type
                // https://mimetype.io/all-types
                // https://www.iana.org/assignments/media-types/media-types.xhtml

                Set<String> rssTypes = Set
                                .of(MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.TEXT_XML_VALUE,
                                                MediaType.APPLICATION_RSS_XML_VALUE,
                                                MediaType.APPLICATION_XHTML_XML_VALUE,
                                                MediaType.APPLICATION_PROBLEM_XML_VALUE,
                                                MediaType.APPLICATION_XML_VALUE);
                rssTypes.forEach(type -> registry.put(type,romeParser));
                        };        

        public FeedParsePort parseFacade(MediaType mediaType)
                        throws Exception {
                String normalizedType = mediaType
                                .getType()
                                + "/"
                                + mediaType.getSubtype();

                FeedParsePort parser = registry
                                .get(normalizedType);

                if (parser == null) {
                        throw new IllegalArgumentException(
                                        "Unsupported RSS media type: "
                                                        + normalizedType);
                }
                return parser;
        }
}
