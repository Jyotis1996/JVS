window.onload = function () {
   document.getElementById("count").innerHTML= new Date().toLocaleTimeString();
}

var w;

function startTimer(){
  /* check worker is supported or not in your browser*/
  if(typeof(Worker !== "undefined"))
  {
    /* check existance of  an worker*/
    if(typeof(w)=="undefined")
    {
      //timedCount();
      w = new Worker("js/demo_workers.js");
    }
    w.onmessage = function(event){
      /*set value of returned data to output tag*/
      document.getElementById("count").innerHTML = event.data;
    };
  }
  else{

    document.getElementById("count").innerHTML = "Web Worker not supported in Your browser";
  }
}
function stopTimer()
{
   w.terminate();
   timerStart = true;
   w = null;
}
