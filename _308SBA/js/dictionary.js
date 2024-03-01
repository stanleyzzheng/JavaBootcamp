async function fetchDefinition(word){
  try{

  const url = `https://www.dictionaryapi.com/api/v3/references/collegiate/json/${word}?key=b3a2af44-22bc-438d-90bf-56351babdae1`;
  const response = await fetch(url);
  const data = await response.json();

    console.log(data);
  console.log(data[0]['shortdef']);
    const definitionsTableBody = document.querySelector('#definitionsTable tbody');
  definitionsTableBody.textContent='';
  data.map(x => displayContent(x['fl'], x['shortdef'],definitionsTableBody));


  }catch(e){
    console.log(e);
  }
}

document.querySelector('.search-form').addEventListener('submit', function(event){
  event.preventDefault();
  const searchInput = document.querySelector('.search-input')
  if(searchInput.value.trim() !== ''){
    fetchDefinition(searchInput.value.trim());
    document.querySelector(".word").textContent =searchInput.value.trim();
  }
  searchInput.value = '';

})
function displayContent(fl, definition, definitionsTableBody){
  definition.map(def =>{
    const row = definitionsTableBody.insertRow();
    const usageCell = row.insertCell();
    const definitionCell = row.insertCell();
    usageCell.textContent =fl;
    definitionCell.textContent = def;
  })


}
