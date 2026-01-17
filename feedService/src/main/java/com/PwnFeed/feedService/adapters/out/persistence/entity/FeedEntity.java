package com.PwnFeed.feedService.adapters.out.persistence.entity;

import java.util.List;

import com.PwnFeed.feedService.adapters.out.persistence.converter.RssUrlConverter;
import com.PwnFeed.feedService.domain.model.vo.RssUrl;
import com.rometools.rome.feed.synd.SyndImage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feeds")
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Convert(converter = RssUrlConverter.class)
    RssUrl rssUrl;
    String link;
    String title;
    String description;
    String lang;
    String image;
    String sourceName;
    String sourceHomepage;
    String eTag;
    String lastModified;
    String lastfetechedAt;
    String status;
    String createdAt;
    String createdBy;
    String createdByUserId;
    Integer followCount;
    @OneToMany(mappedBy = "feed",
          cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    List<FeedItemEntity> FeedItemEntity;
    
}
