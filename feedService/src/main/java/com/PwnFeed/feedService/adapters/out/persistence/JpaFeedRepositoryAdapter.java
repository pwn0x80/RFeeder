package com.PwnFeed.feedService.adapters.out.persistence;

import org.springframework.stereotype.Repository;

import com.PwnFeed.feedService.adapters.out.persistence.entity.FeedEntity;
import com.PwnFeed.feedService.adapters.out.persistence.entity.FeedItemEntity;
import com.PwnFeed.feedService.adapters.out.persistence.repository.JpaFeedRepository;
import com.PwnFeed.feedService.application.mapper.FeedMappingResult;
import com.PwnFeed.feedService.domain.model.feed.Feed;
import com.PwnFeed.feedService.domain.model.feed.FeedItem;
import com.PwnFeed.feedService.domain.ports.out.FeedRepositoryPort;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class JpaFeedRepositoryAdapter implements FeedRepositoryPort {

    private final JpaFeedRepository jpaFeedRepository;

    public JpaFeedRepositoryAdapter(JpaFeedRepository jpaFeedRepository) {
        this.jpaFeedRepository = jpaFeedRepository;
    }

    @Override
    @Transactional
    public void save(FeedMappingResult mappingResult) {

        FeedEntity feedEntity = toEntity(mappingResult);

        jpaFeedRepository.save(feedEntity);
    }

    /* ------------------ MAPPERS ------------------ */

    private FeedEntity toEntity(FeedMappingResult result) {

        Feed feed = result.feed();

        FeedEntity entity = new FeedEntity();
        entity.setTitle(feed.title());
        entity.setLink(feed.link());
        entity.setDescription(feed.description());
        entity.setLang(feed.lang());
        //entity.setImage(feed.image());
        entity.setRssUrl(feed.rssUrl());
        entity.setFollowCount(feed.followCount());

        List<FeedItemEntity> items =
                result.feedItems()
                      .stream()
                      .map(item -> toItemEntity(item, entity))
                      .toList();

        entity.setFeedItemEntity(items);

        return entity;
    }

    private FeedItemEntity toItemEntity(FeedItem item, FeedEntity feedEntity) {

        FeedItemEntity entity = new FeedItemEntity();
        entity.setTitle(item.title());
        entity.setLink(item.link());
        entity.setDescription(item.description());
        entity.setAuthor(item.author());
        entity.setUri(item.uri());
        entity.setFeed(feedEntity); 

        return entity;
    }
}
