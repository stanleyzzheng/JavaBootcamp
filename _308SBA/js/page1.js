async function fetchTrending() {
  const storedData = JSON.parse(localStorage.getItem('trendingData'));
  const lastFetchTimestamp = localStorage.getItem('lastFetchTimestamp');
  const currentTimestamp = new Date().getTime();
  if(storedData && lastFetchTimestamp && (currentTimestamp - lastFetchTimestamp < 24*60*60*1000)){
    return storedData;
  }
  try {
    const response = await fetch("http://api.giphy.com/v1/gifs/trending?api_key=uTHCOwiMnN3hfaHCmO4arZcFKkp9DH60&limit=10")
    // if (!response.ok) {
    //   throw new Error('Network response was not ok');
    // }
    const data = await response.json();

    console.log(data);
    const trendingUrls =  data.data.map(gif => gif.images['downsized_medium']['url']);
    localStorage.setItem('trendingData', JSON.stringify(trendingUrls));
    localStorage.setItem('lastFetchTimestamp', currentTimestamp);

    return trendingUrls

  }catch(e){
    console.error(e);
  }
}
function generateHtml(urls){
  const container = document.querySelector('.container');
  urls.forEach(url => {
    const imgElement = document.createElement('img');
    imgElement.src=url;
    container.appendChild(imgElement);
  })
}
fetchTrending().then(trendingUrls =>{
  if(trendingUrls) generateHtml(trendingUrls);
})

