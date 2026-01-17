package com.PwnFeed.feedService.adapters.out.persistence.converter;

import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.synd.SyndImage;

import jakarta.persistence.AttributeConverter;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.JsonNodeException;

public class SyndContentConverter
        implements
        AttributeConverter<Content, String> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(
            Content attribute) {
        try {
            return OBJECT_MAPPER
                    .writeValueAsString(
                            attribute);
        } catch (JsonNodeException e) {
            throw new IllegalStateException(
                    "Failed to convert SyndImage to JSON",
                    e);
        }
    }

    @Override
    public Content convertToEntityAttribute(
            String dbData) {
        try {
            return OBJECT_MAPPER
                    .readValue(dbData,
                            Content.class);
        } catch (JsonNodeException e) {
            throw new IllegalStateException(
                    "Failed to convert SyndImage to JSON",
                    e);
        }
    }

}
