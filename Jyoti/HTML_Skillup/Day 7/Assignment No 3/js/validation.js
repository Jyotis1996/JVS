function myFunction() {
  var x = document.getElementById("myRadio").required;
  document.getElementById("demo").innerHTML = x;
  var selSex=document.getElementById('myRadio').value;

}
/* drag and drop */
function drag(ev) {
  //set dragging data
  ev.dataTransfer.setData("text", ev.target.id);
}

function allowDrop(ev) {
  ev.preventDefault();
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  //appen data to drop
  ev.target.appendChild(document.getElementById(data));
}

/* function to check wether gender is selected as per salutation or not */
function validate()
{

   var sal=document.getElementById('salutation').value;
   if((sal=="Mr.")&&(registration.gender[0].checked == false ) )
    {
      alert ( "Please choose your Gender Properly: Male or Female" );
      return false;
    }
	else if((sal=="Ms.")&&(registration.gender[0].checked == true ) ){
	   alert ( "Please choose your Gender Properly: Male or Female" );
       return false;
    }
	
	var chkd = document.registration.web.checked || document.registration.database.checked||  document.registration.swing.checked|| document.StudentRegistration.mobile.checked

    if (chkd)
    {
        return true; //Submit the form
    } else {
        alert ("please select any one Interest")
        return false; //not submitted
    }
}

// reset all text fields
function clearText()
{
	document.getElementById('registration').reset();
}
