import { containerError, containerList } from "./components-page.js";
import { insertBookInList } from "./request-api.js";

const searchResult = document.getElementById("container-list");
const page = document.querySelector(".container-heading");

export function insertOnPage(book, userLists, bookIdx) {
  const {
    title,
    author,
    publisher,
    publishedDate,
    pagesNumber,
    imageLink,
    previewLink,
  } = book;
  const addBookInListDialogId = `add-list-book-dialodg-${bookIdx}`;
  const addInListComponentsData = [];

  searchResult.style.display = "flex";
  page.style.display = "none";

  const cardBook = $("<li>");
  cardBook.addClass("card");
  cardBook.html(`
        <img src="${imageLink}" class="card-img-top" onerror="this.src='/media/error-image';" alt="book image">
        <div class="card-body align-self-center" tabindex="0">
            <h5 class="card-title" aria-label="book title ${title}">${title}</h5>
            <p class="card-text"><em class="card__text__title">Author:</em> ${author}</p>
            <p class="card-text"><em class="card__text__title">Publisher:</em> ${publisher}</p>
            <p class="card-text"><em class="card__text__title">Published:</em> ${publishedDate}</p>
            <p class="card-text"><em class="card__text__title">Pages:</em> ${pagesNumber}</p>
            <a href="${previewLink}" class="btn link" aria-label="preview link in Google Books" tabindex="0">link</a>
            <button id="add-book-btn" class="btn link add-book-btn" aria-label="add book to a list" tabindex="0">adicionar a lista</button>
            <dialog id="${addBookInListDialogId}">
            <h3>Adicionar livro a lista</h3>
            <ul>
            ${userLists.map((list, listIdx) => {
              const addBookInListBtnId = `add-book-in-list-item-${bookIdx}-${listIdx}`;
              const html = `
                <li class='add-book-in-list-item'>
                    <div style='width: 100%'>${list.name}</div>
                    <button id="${addBookInListBtnId}">
                        <img class='plus' src='images/Plus (1).svg'>
                    </button>
                </li>`;
              addInListComponentsData.push({
                btnId: addBookInListBtnId,
                fn: async () => {
                  const isBookSaved = await insertBookInList(list.listId, book);
                  if (isBookSaved) {
                    alert("Livro salvo!");
                    window[addBookInListDialogId].close();
                  }
                },
              });
              return html;
            })}
            </ul>
            <button onclick="window.add-list-book-dialodg-${bookIdx}.close();" aria-label="close" class="x">❌</button>
        </dialog>
        </div>
        `);
  containerList.append(cardBook);
  return addInListComponentsData;
}

export function errorOnPage(errorMessage) {
  containerError.html("");
  const errorText = $("<p>");
  errorText.html(errorMessage);
  containerError.show();
  containerError.append(errorText);
}

export function chooseListToAddButton(bookData) {}
