-- Include table data insertion, updation, deletion and select scripts
-- Include table data insertion, updation, deletion and select scripts
INSERT INTO moviecrusier.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
	VALUES('Avatar', 2787965087, 'YES', '2017-03-15','Science Fiction', 'YES');
INSERT INTO moviecrusier.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
	VALUES('The Avengers', 1518812988, 'YES', '2017-12-23','Superhero', 'NO');
INSERT INTO moviecrusier.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
	VALUES('Titanic', 2187463944, 'YES','2018-03-13','Romance', 'NO');
INSERT INTO moviecrusier.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
	VALUES('Jurassic World', 1671713208, 'NO','2017-07-02','Science', 'YES');
INSERT INTO moviecrusier.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
	VALUES('Avengers: End Game', 2750760348,'YES','2022-11-02','Superhero', 'YES');

SELECT * FROM moviecrusier.movie;

SELECT * FROM moviecrusier.movie WHERE mv_date_of_launch<=CURRENT_DATE() AND mv_active =1;
SELECT * FROM moviecrusier.movie WHERE mv_id = 1;
UPDATE moviecrusier.movie SET 
mv_title='New Sandwhich',
mv_box_office=148,
mv_active=true,
mv_date_of_launch='2019-8-7',
mv_genre='Desert',
mv_has_teaser=false
WHERE mv_id = 1;

INSERT INTO moviecrusier.user(us_name) VALUES('Shubham');
INSERT INTO moviecrusier.user(us_name) VALUES('Customer 1');

INSERT INTO moviecrusier.favorites(fv_us_id) VALUES(1);
INSERT INTO moviecrusier.favorites(fv_us_id,fv_pr_id) VALUES(2,1);
INSERT INTO moviecrusier.favorites(fv_us_id,fv_pr_id) VALUES(2,2);
INSERT INTO moviecrusier.favorites(fv_us_id,fv_pr_id) VALUES(2,3);

SELECT movie.*
FROM favorites 
JOIN movie ON movie.mv_id = favorites.fv_pr_id
JOIN user ON user.us_id = favorites.fv_us_id
WHERE user.us_id=2;

SELECT COUNT(*) AS TOTAL FROM favorites WHERE fv_us_id=2; 

DELETE FROM favorites WHERE favorites.fv_us_id=2 AND favorites.fv_pr_id=1;
