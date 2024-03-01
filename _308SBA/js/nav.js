// fetch('nav.html')
//   .then(res => res.text())
//   .then(text => {
//     // let oldelem = document.querySelector("script#replace_with_navbar");
//     let oldelem = document.querySelector("#replace_with_navbar");
//     let newelem = document.createElement("div");
//     newelem.innerHTML = text;
//     oldelem.parentNode.replaceChild(newelem,oldelem);
//   })
document.addEventListener("DOMContentLoaded", async function () {
  const navbarContainer = document.querySelector(".main-nav");
  const navbarHTML = await createNavbar();
  navbarContainer.innerHTML=navbarHTML;
})

async function createNavbar() {
  try{
    const response = await fetch('nav.html')
    return response.text();
  }catch(e){
    console.error(e);
  }
  // return `
  // <a href="index.html">
  //   <img class="logo" alt="Stanley's website logo" src="img/logo.png" />
  // </a>
  // <ul class="main-nav-list">
  //
  //   <li><a class="main-nav-link" href="page1.html">Giphy Trending</a></li>
  //   <li><a class="main-nav-link" href="page2.html">Page 2</a></li>
  // </ul>
  // `;
}
