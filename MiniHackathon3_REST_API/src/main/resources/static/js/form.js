const searchForm = document.querySelector(".search-form");
const searchInput = document.querySelector('.search-input');
console.log("hello world");
searchForm.addEventListener('submit', async event => {
    event.preventDefault();
    const movieName = searchInput.value;
    const url= `https://www.omdbapi.com/?apikey=b79fdda2&t=${movieName}`
    try{

    const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Failed to fetch data from OMDb API. Status: ${response.status}`);
        }
        const data = await response.json();
        console.log(data);
        const postData = {
            id: data['imdbID'],
            title: data['Title'],
            year: data['Year'],
            rated: data['Rated'],
            released: data['Released'],
            runtime: data['Runtime'],
            genre: data['Genre'],
            director: data['Director'],
            writer: data['Writer'],
            actors: data['Actors'],
            plot: data['Plot'],
            language: data['Language'],
            country: data['Country'],
            awards: data['Awards'],
            poster: data['Poster'],
            rottenTomatoesRating: data['Ratings'][1]['Value']
        }
        const postResponse = await fetch("http://localhost:8080/movie", {
            method:"POST",headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(postData)
        });
        if (!postResponse.ok) {
            throw new Error(`Failed to send data to the server. Status: ${postResponse.status}`);
        }
        window.location.href = '/movie-detail/' + postData.id;
    }catch(e){
        console.log(e);
    }

})