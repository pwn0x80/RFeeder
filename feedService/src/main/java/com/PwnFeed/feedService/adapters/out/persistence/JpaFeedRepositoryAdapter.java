// package com.PwnFeed.feedService.adapters.out.persistence;

// import org.springframework.stereotype.Repository;

// import com.PwnFeed.feedService.adapters.out.persistence.entity.FeedEntity;
// import com.PwnFeed.feedService.adapters.out.persistence.repository.JpaFeedRepository;
// import com.PwnFeed.feedService.domain.model.Feed;
// import com.PwnFeed.feedService.domain.model.RssUrl;
// import com.PwnFeed.feedService.domain.ports.out.FeedRepositoryPort;

// import java.util.Optional;

// // @Repository
// public class JpaFeedRepositoryAdapter implements FeedRepositoryPort {

//     private final JpaFeedRepository jpaRepository;

//     public JpaFeedRepositoryAdapter(JpaFeedRepository jpaRepository) {
//         this.jpaRepository = jpaRepository;
//     }

//     @Override
//     public Optional<Feed> findByUrl(RssUrl url) {
//         // return jpaRepository.findByUrl(url.value())
//         //         .map(this::toDomain);
//         return null;
//     }

//     @Override
//     public Feed save(Feed feed) {
//         FeedEntity entity = toEntity(feed);
//         FeedEntity saved = jpaRepository.save(entity);
//         // return toDomain(saved);
//         return null;
//     }

//     /* ------------------ MAPPERS ------------------ */

//     private FeedEntity toEntity(Feed feed) {
//         return new FeedEntity(
//           //  feed.getUrl().value(),
//            // feed.getTitle()
//         );
//     }

//     private void toDomain(FeedEntity entity) {
//         // return new Feed(
//         //     new RssUrl(entity.getUrl()),
//         //     entity.getTitle()
//         // );
//     }

    
// }