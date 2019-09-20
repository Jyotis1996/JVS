// Get modal elements
var modal = document.getElementById('simple');
//Get open modal button
var modalBtn = document.getElementById('addBtn');
//Get Close button
var closeBtn = document.getElementsByClassName('close')[0];




//Listen for open click
modalBtn.addEventListener('click',openModal);

//Listen for close click
closeBtn.addEventListener('click',closeModal);



//for outside click

window.addEventListener('click',clickOutside);

//function to open modal
function openModal(){
    modal.style.display = 'block';
}

//function to close modal
function closeModal(){
  modal.style.display = 'none';
}


//function to close modal if outside click



function clickOutside(e){
  if(e.target == modal){
	  event.preventDefault();
    modal.style.display = 'none';
  }

}
