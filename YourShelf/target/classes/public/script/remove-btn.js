import { input } from "./components-page.js";

const removeBtn = $("#remove-btn");
const searchResult = document.getElementById("container-list");
const page = document.querySelector(".container-heading");


input.on('input', () => {
    if (input.val() === "") return closeRemoveBtn();
    else if (removeBtn.hasClass("active")) return;
    removeBtn.addClass("active");
})

removeBtn.click (() => {
    input.val("");
    input.focus();
    closeRemoveBtn();
})

export function closeRemoveBtn() {
    removeBtn.removeClass("active");
    searchResult.style.display = 'none';
    page.style.display = 'grid';
}
