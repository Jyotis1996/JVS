var audio = document.getElementById("audio"); 

function playAud() { 
  audio.play(); 
} 

function pauseAud() { 
  audio.pause(); 
} 

function volUp(){
    audio.volume = audio.volume + 0.1;
}

function volDown(){
    audio.volume = audio.volume - 0.1;
}
