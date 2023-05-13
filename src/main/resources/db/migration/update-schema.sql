CREATE SEQUENCE IF NOT EXISTS comment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS music_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS pin_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS post_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE comment
(
    id           BIGINT       NOT NULL,
    post_id      BIGINT       NOT NULL,
    commenter_id BIGINT       NOT NULL,
    comment_text VARCHAR(511) NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

CREATE TABLE music
(
    id        BIGINT       NOT NULL,
    genre     VARCHAR(64),
    artist    VARCHAR(255) NOT NULL,
    song_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_music PRIMARY KEY (id)
);

CREATE TABLE pin
(
    id         BIGINT NOT NULL,
    owner_id   BIGINT NOT NULL,
    coordinate BYTEA  NOT NULL,
    music_id   BIGINT,
    CONSTRAINT pk_pin PRIMARY KEY (id)
);

CREATE TABLE post
(
    id                 BIGINT            NOT NULL,
    original_poster_id BIGINT            NOT NULL,
    title              VARCHAR(255)      NOT NULL,
    description        VARCHAR(1023),
    like_count         INTEGER DEFAULT 0 NOT NULL,
    music_id           BIGINT,
    coordinate         BYTEA,
    CONSTRAINT pk_post PRIMARY KEY (id)
);

CREATE TABLE "user"
(
    id       BIGINT       NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_COMMENTER FOREIGN KEY (commenter_id) REFERENCES "user" (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (id);

ALTER TABLE pin
    ADD CONSTRAINT FK_PIN_ON_MUSIC FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE pin
    ADD CONSTRAINT FK_PIN_ON_OWNER FOREIGN KEY (owner_id) REFERENCES "user" (id);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_MUSIC FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_ORIGINAL_POSTER FOREIGN KEY (original_poster_id) REFERENCES "user" (id);