function timedCount() {

  //Increments the counter variable by 1
  postMessage(new Date().toLocaleTimeString());
  //return the current i value
  setTimeout("timedCount()",10);
  //set maximun timeout limit
}
timedCount();