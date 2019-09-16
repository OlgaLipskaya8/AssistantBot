drop schema if exists bot;
create schema bot;
use bot;

CREATE TABLE city (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE info (
	id INTEGER NOT NULL AUTO_INCREMENT,
	text VARCHAR(255) NOT NULL,
    city_id INTEGER NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE info ADD CONSTRAINT fk_info_cityid FOREIGN KEY (city_id) REFERENCES city (id) ON DELETE CASCADE;

INSERT INTO city (name) VALUES ('Бангкок');
INSERT INTO city (name) VALUES ('Лондон');
INSERT INTO city (name) VALUES ('Париж');
INSERT INTO city (name) VALUES ('Дубай');
INSERT INTO city (name) VALUES ('Сингапур');
INSERT INTO city (name) VALUES ('Берлин');
INSERT INTO city (name) VALUES ('Токио');
INSERT INTO city (name) VALUES ('Барселона');
INSERT INTO city (name) VALUES ('Милан');
INSERT INTO city (name) VALUES ('Москва');

INSERT INTO info (text, city_id) VALUES ('Обязательно посмотрите Ват Сакет, Гигантские качели, Као Сан роад, Ват Арун, Ват По. ', 1);
INSERT INTO info (text, city_id) VALUES ('Окиньте взором Королевский дворец и прокатитесь по рекам и каналам Чао Прайя. ', 1);
INSERT INTO info (text, city_id) VALUES ('Не забудьте отведать знаменитый Том-Ям! ', 1);

INSERT INTO info (text, city_id) VALUES ('Вы должны увидеть своими глазами: Биг Бен, Букингемский дворец, Тауэрский мост, Лондонский глаз.', 2);
INSERT INTO info (text, city_id) VALUES ('Посетить Вестминстерское аббатство, Музей мадам Тюссо, Оксфорд стрит, Трафальгарскую площадь.', 2);
INSERT INTO info (text, city_id) VALUES ('Не забудьте сфотографироваться на Эбби роуд!', 2);

INSERT INTO info (text, city_id) VALUES ('Обязательно посмотрите на легендарную Эйфелеву башню и загляните на Монмартр! ', 3);
INSERT INTO info (text, city_id) VALUES ('Посетите Лувр, Елисейские поля, Версаль, Музей Орсе, Люксембургский сад, остров Сите.', 3);
INSERT INTO info (text, city_id) VALUES ('Полюбуйтесь на множественные триумфальные арки и проникнитесь атмосферой Парижа!', 3);

INSERT INTO info (text, city_id) VALUES ('Посмотрите своими глазами на Бурдж-Халифа, Бурдж аль-Араб, Emirates Towers. ', 4);
INSERT INTO info (text, city_id) VALUES ('Посетите острова Пальм, the World - строящийся архипелаг, Бастакию - старинную часть Дубая.', 4);
INSERT INTO info (text, city_id) VALUES ('Проникнитесь атмосферой арабского мира!', 4);

INSERT INTO info (text, city_id) VALUES ('В этом городе-государстве стоит увидеть аэропорт Чанги, Гардэнс бай Бэй.', 5);
INSERT INTO info (text, city_id) VALUES ('Посетить Сингапурский зоопарк, парк птиц Джуронг, заповедник "Букит Тима".', 5);
INSERT INTO info (text, city_id) VALUES ('Обязательно загляните на остров развлечений - Сентоса.', 5);

INSERT INTO info (text, city_id) VALUES ('Стоит увидеть Бранденбургские ворота, Рейхстаг, Кафедральный собор, Александерплатц.', 6);
INSERT INTO info (text, city_id) VALUES ('Посетите знаменитый Берлинский зоопарк, Жандарменмаркт, Замок Шарлоттенбург, прогуляйтесь по Унтер-ден-Линден.', 6);
INSERT INTO info (text, city_id) VALUES ('И, конечно же, сфотографируйтесь около Берлинской стены!', 6);

INSERT INTO info (text, city_id) VALUES ('Посетите Сэнсодзи(древний храм), Tokyo Skytree, Одайба(музей науки).', 7);
INSERT INTO info (text, city_id) VALUES ('Прогуляйтесь по множеству парков и прокатитесь на самых экстремальных аттракционах.', 7);
INSERT INTO info (text, city_id) VALUES ('И узнайте секрет долголетия японцев!', 7);

INSERT INTO info (text, city_id) VALUES ('Обязательно посмотрите на легендарные произведения архитектурного искусства великого Гауди: ', 8);
INSERT INTO info (text, city_id) VALUES ('Храм Святого Семейства, Парк Гуэля, Дом Бальо.', 8);
INSERT INTO info (text, city_id) VALUES ('Посетите Рамблу, Готический квартал, Монтжуик, Тибидабо(парк аттракционов).', 8);

INSERT INTO info (text, city_id) VALUES ('Взгляните на Миланский собор, кастелло Сфорцеско, Ла Скала', 9);
INSERT INTO info (text, city_id) VALUES ('Прогуляйтесь по парку Семпионе, Виа Монтенаполеоне и кварталу моды.', 9);
INSERT INTO info (text, city_id) VALUES ('Не забудьте увидеть Тайную вечеря Леонардо да Винчи.', 9);

INSERT INTO info (text, city_id) VALUES ('Вы не были в Москве, если не были на Красной площади, не видели Кремль или Храм Василия Блаженого.', 10);
INSERT INTO info (text, city_id) VALUES ('Не заглянули в Третьяковскую галерею, на Воробьевы горы, не прогулялись по множеству парков и прониклись ритмом этого города.', 10);
INSERT INTO info (text, city_id) VALUES ('И не захотели снова вернуться!', 10);

select * from city;
select * from info;