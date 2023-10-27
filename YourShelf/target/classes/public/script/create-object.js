import { loadingIcon, containerList } from "./components-page.js";
import { insertOnPage } from "./insert-page.js";
import { insertBookInList } from "./request-api.js"

export function catchBookInfos(booksAllInfos){ 
    booksAllInfos.forEach(listOfBookInfo => {
        const book = createBookObject(listOfBookInfo.volumeInfo);
        insertOnPage(book);
        loaded();
    })
    attachOnClickFunction();
}

function attachOnClickFunction(){
    $("button[id|='add-book-btn']").each((_, btn) => {
        btn.onclick = () => {
            const encodedBook = btn.attributes['data-book'].nodeValue
            const book = JSON.parse(atob(encodedBook))
            insertBookInList('22cc433c-963e-4483-8938-9fc0adcebae2', book).then(() => console.log())
        }
        console.log(btn)
    })
}

function loaded() {
    loadingIcon.removeClass("active");
    containerList.addClass("loaded");
}

function createBookObject(bookInfo) {
    const bookObject = {
        title: bookInfo.title,
        author: bookInfo.authors && bookInfo.authors.length > 1 ? bookInfo.authors.join(" , ") : bookInfo.authors,
        publisher: bookInfo.publisher,
        publishedDate: bookInfo.publishedDate,
        pagesNumber: bookInfo.pageCount,
        imageLink: bookInfo.imageLinks ? bookInfo.imageLinks.thumbnail : " ",
        previewLink: bookInfo.previewLink,
        description: bookInfo.description
    }
    for (let element in bookObject) {
        if (bookObject[element] === undefined) bookObject[element] = " ";
    }
    return bookObject;
}