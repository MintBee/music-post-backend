ALTER TABLE post
    ADD address VARCHAR(255);

ALTER TABLE post
    ADD location_name VARCHAR(255);

ALTER TABLE post
    ALTER COLUMN address SET NOT NULL;

ALTER TABLE music
    ADD music_url VARCHAR(255);

ALTER TABLE music
    ALTER COLUMN music_url SET NOT NULL;

ALTER TABLE post
    DROP COLUMN coordinate;

ALTER TABLE post
    ADD coordinate GEOMETRY(Point, 4326);