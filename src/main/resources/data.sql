
INSERT INTO post (title, content, created_at)
VALUES
('java', 'spring boot', CURRENT_TIMESTAMP),
('java1', 'spring boot1', CURRENT_TIMESTAMP);

INSERT IGNORE INTO user (email, username, password, role, created_at)
VALUES
('admin@gmail.com', 'admin', '123456', 'ADMIN', CURRENT_TIMESTAMP),
('emp@gmail.com', 'employee', '123456', 'EMPLOYEE', CURRENT_TIMESTAMP);

INSERT INTO comment (content, post_id, created_at)
VALUES
('hihi',1, CURRENT_TIMESTAMP),
('haha',2, CURRENT_TIMESTAMP);