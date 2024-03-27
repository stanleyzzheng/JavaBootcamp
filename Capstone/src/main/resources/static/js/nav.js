console.log("hello world");
document.addEventListener("DOMContentLoaded", async function () {
    const navbarContainer = document.querySelector(".main-nav");
    const navbarHTML = await createNavbar();
    navbarContainer.innerHTML=navbarHTML;
})

async function createNavbar() {
    try{
        const response = await fetch('/html/nav.html')
        return response.text();
    }catch(e){
        console.error(e);
    }
}
