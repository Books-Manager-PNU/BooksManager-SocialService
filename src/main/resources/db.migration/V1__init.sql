CREATE TABLE IF NOT EXISTS forum (
    id BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS forum_comment (
    id BIGINT NOT NULL PRIMARY KEY,
    forum_id BIGINT NOT NULL,
    comment_text VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (forum_id) REFERENCES public.forum(id)
);

CREATE TABLE IF NOT EXISTS review (
    id BIGINT NOT NULL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    score INTEGER NOT NULL CHECK (score >= 0 AND score <= 10),
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS review_comment (
    id BIGINT NOT NULL PRIMARY KEY,
    review_id BIGINT NOT NULL,
    comment_text VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP NOT NULL,
    create_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (review_id) REFERENCES public.review(id)
);