package com.PwnFeed.feedService.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feed_items")
public class FeedItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String guid;
    String title;
    String link;
    @Lob
    @Column(columnDefinition = "TEXT")
    String description;
    String content;
    String author;
    String category;
    String imgUrl;
    String enclosureUrl;
    String enclosureType;
    @ManyToOne
    @JoinColumn(name = "feed_id")
    FeedEntity feed;
    String uri;
    int upvote;
    int downvote;
}
