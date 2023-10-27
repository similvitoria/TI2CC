document.addEventListener("DOMContentLoaded", function () {
    const showPopupButton = document.getElementById("showPopupButton");
    const popupContainer = document.getElementById("popupContainer");
    const closePopupButton = document.getElementById("closePopup");

    showPopupButton.addEventListener("click", () => {
        popupContainer.style.display = "flex";
    });

    closePopupButton.addEventListener("click", () => {
        popupContainer.style.display = "none";
    });

    window.addEventListener("beforeunload", function () {
        popupContainer.style.display = "none";
    });
});





