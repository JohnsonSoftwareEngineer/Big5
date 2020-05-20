package com.johnsondev.big5;

public class Questions {

    private String[] question_green;
    private String[] question_red;

    public void init(){
        question_green = new String[15];
        question_red = new String[15];

        //    questions green

        question_green[0] = "Мне нравится заниматься физкультурой";
        question_green[1] = "Люди считают меня отзывчивым и доброжелательным человеком";
        question_green[2] = "Я во всем ценю чистоту и порядок";
        question_green[3] = "Меня часто беспокоит мысль, что что-нибудь может случиться";
        question_green[4] = "Все новое вызывает у меня интерес";
        question_green[5] = "Если я ничем не занят, то это меня беспокоит";
        question_green[6] = "Я стараюсь проявлять дружелюбие ко всем людям";
        question_green[7] = "Моя комната всегда аккуратно прибрана";
        question_green[8] = "Иногда я расстраиваюсь из-за пустяков";
        question_green[9] = "Мне нравятся неожиданности";
        question_green[10] = "Я не могу долго оставаться в неподвижности";
        question_green[11] = "Я тактичен по отношения к другим людям";
        question_green[12] = "Я методичен и пунктуален во всем ";
        question_green[13] = "Мои чувства легко уязвимы и ранимы";
        question_green[14] = "Мне не интересно, когда ответ ясен заранее";

        //    questions red

        question_red[0] = "Я не люблю физические нагрузки";
        question_red[1] = "Некоторые люди считают меня холодным и черствым";
        question_red[2] = "Иногда я позволяю себе быть неряшливым";
        question_red[3] = "«Мелочи жизни» меня не тревожат";
        question_red[4] = "Часто новое вызывает у меня раздражение";
        question_red[5] = "Я человек спокойный и не люблю суетиться";
        question_red[6] = "Я не всегда и не со всеми дружелюбный человек";
        question_red[7] = "Я не очень стараюсь следить за чистотой и порядком";
        question_red[8] = "Я не обращаю внимания на мелкие проблемы";
        question_red[9] = "Я люблю предсказуемость событий";
        question_red[10] = "Мне не нравится быстрый стиль жизни";
        question_red[11] = "Иногда в шутку я задеваю самолюбие других";
        question_red[12] = "Я не очень обязательный человек";
        question_red[13] = "Я редко тревожусь и редко чего-либо боюсь ";
        question_red[14] = "Я не интересуюсь вещами, которые мне не понятны";
    }

    public String getQuestion_green(int i) {
        return question_green[i];
    }

    public String getQuestion_red(int i) {
        return question_red[i];
    }
}
