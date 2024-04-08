
INSERT INTO movies(title, screenedYear, description, id) VALUES ('The Shawshank Redemption', 1994, 'Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.', 0111161);
INSERT INTO movies(title, screenedYear, description, id) VALUES ('The Godfather', 1997, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 0068646);

INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('Tim', 'Robbins', 0000209, '1958-10-16');
INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('Morgan', 'Freeman', 0000151, '1937-06-01');
INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('Bob', 'Gunton', 0348409, '1945-11-15');

INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('Marlon', 'Brando', 0000008, '1924-04-03');
INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('Al', 'Pacino', 0000199, '1940-04-25');
INSERT INTO actors(firstName, lastName, id, bornDate) VALUES ('James', 'Caan', 0001001, '1940-03-26');

INSERT INTO movie_actor(movie_id, actor_id) VALUES (0111161, 0000209);
INSERT INTO movie_actor(movie_id, actor_id) VALUES (0111161, 0000151);
INSERT INTO movie_actor(movie_id, actor_id) VALUES (0111161, 0348409);

INSERT INTO movie_actor(movie_id, actor_id) VALUES (0068646, 0000008);
INSERT INTO movie_actor(movie_id, actor_id) VALUES (0068646, 0000199);
INSERT INTO movie_actor(movie_id, actor_id) VALUES (0068646, 0001001);
