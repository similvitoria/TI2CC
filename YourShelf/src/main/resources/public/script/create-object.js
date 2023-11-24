import { loadingIcon, containerList } from "./components-page.js";
import { insertOnPage } from "./insert-page.js";

export function catchBookInfos(booksAllInfos, userLists){ 
    booksAllInfos.forEach((listOfBookInfo, idx) => {
        const book = createBookObject(listOfBookInfo.volumeInfo);
        const addInListComponentsData = insertOnPage(book, userLists, idx);
        loaded();
        addInListComponentsData.forEach(componentData => {
            window[componentData.addBookInListBtnId].onclick = componentData.addBookInListFn
            window[componentData.closeModalBtnId] = componentData.closeModalBtnFn
        })
    })
    attachOnClickFunction();
}

function attachOnClickFunction(){
    $("button[class*='add-book-btn']").each((idx, btn) => {
        btn.onclick = () => {
            window[`add-list-book-dialodg-${idx}`].showModal();
        }
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