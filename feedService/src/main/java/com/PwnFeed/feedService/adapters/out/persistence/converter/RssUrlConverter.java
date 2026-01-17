package com.PwnFeed.feedService.adapters.out.persistence.converter;

import com.PwnFeed.feedService.domain.model.vo.RssUrl;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class RssUrlConverter implements AttributeConverter<RssUrl, String> {

    @Override
    public String convertToDatabaseColumn(RssUrl attribute) {
        return attribute == null ? null : attribute.value();
    }

    @Override
    public RssUrl convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new RssUrl(dbData);
    }
}