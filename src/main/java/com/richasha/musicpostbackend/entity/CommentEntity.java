package com.richasha.musicpostbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, orphanRemoval = true)
    @JoinColumn(name = "commenter_id", nullable = false)
    private UserEntity commenter;

    @Column(name = "comment_text", nullable = false, length = 511)
    private String commentText;

}
