
delete from `profile` where id != 0;
insert into `profile` (`email`, `password`, `firstname`, `lastname`) values
(
    'iohana.linhares@catolicasc.edu.br',
    MD5('P4$$W0rRrD'),
    'Iohana',
    'Linhares'
),
(
    'lavinia.kuhn@catolicasc.edu.br',
    MD5('P4$$W0rRrD'),
    'Lavínia Vitória',
    'Kuhn'
),
(
    'leonardo.cech@catolicasc.edu.br',
    MD5('P4$$W0rRrD'),
    'Leonardo',
    'Cech'
);


delete from `media_type` where id != 0;
insert into `media_type` (`name`, `format`) values 
( 'filme', 'vídeo'),
( 'série', 'vídeo'),
( 'música', 'som'),
( 'livro', 'literatura');


delete from `media` where id != 0;
insert into `media` (`media_type_id`, `name`, `links`)
values (
    (select `id` from `media_type` where `name` = 'filme' limit 1),
    'Velozes e Furiosos 7',
    '{
        "poster": "https://pt.wikipedia.org/wiki/Ficheiro:Furious_7_poster.jpg",
        "wikipedia": "https://pt.wikipedia.org/wiki/Furious_7",
        "watch": {
            "starplus": "https://www.starplus.com/pt-br/movies/velozes-e-furiosos-7/2RoXKpB3yFAS"
        }
    }'
);


delete from `review` where id != 0;
insert into `review` (`profile_id`, `media_id`, `stars`, `text`)
values (
	(select id from `profile` where firstname = 'Iohana' limit 1), 1, 5, 
    'O filme foi extremamente emocionante, por conta da homenagem à morte do Paul Walker, chorei muito, depois disso a franquia perdeu o sentido');

