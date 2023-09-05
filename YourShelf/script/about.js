const title = document.querySelector(".title");
const coloredTitle = document.querySelector("#colored-text");
const arrow = document.querySelector("#arrow");
const img = document.querySelector("#img");
const headingText = document.querySelector("#text");

let index = 1;
const img_src = [ "images/cat lying on books.png", "images/boy carrying books.png", "images/Bookcase with books and plants.png"]
const colored_phrases = [ "Comece ", "Mantenha ", "Conheça "];
const title_phrases = [ " novos hábitos", " seu ritmo", " o novo"];
const phrases = [ "Se não souber por onde começar, nos construimos para você! Com o YourShelf o acompanhemento da sua leitura fica fácil! Tenha uma lista randômica com a quantidade de livros que você quiser para começar seu novo hábito. Criar sua trilha fará com que você consiga se sentir ainda mais imerso en sua leitura, comece agora.",
"Crie listas quando quiser e com o seu ritmo, fuja da ressaca literaria com o YourShelf. Adicione e exclua livros, crie sua trilha e tenha uma leitura divertida e organizada, manter seu ritmo nunca foi tão fácil!",
"Abra novos caminhos. Com a funcionalidade lista randômica novas obras serão indicadas para você, conheça novos artistas e se apaixone ainda mais pela literatura."]



arrow.addEventListener("click", () => {
    if ( index > 2 ) {
        index = 0;
    }

    coloredTitle.innerText = colored_phrases[index];
    title.innerText = title_phrases[index];
    headingText.innerText = phrases[index];
    img.src = img_src[index];


    if ( index == 1 ) {
        img.style.width = '40%';
        img.style.marginRight = '12rem';
    }
    else if ( index == 2 ) {
        img.style.width = '60%';
        img.style.marginRight = '10rem';
    }
    else {
        img.style.width = '80%';
        img.style.marginRight = '0rem';
    }

    index++;
});