// to validate all fields
function myFunction() {
  var x = document.getElementById("myRadio").required;
  document.getElementById("demo").innerHTML = x;
  var selSex=document.getElementById('myRadio').value;
  
  var y = document.getElementById("year").required;
  document.getElementById("demo").innerHTML = y;
  var selyear = document.getElementById('year').value;
  
  var m = document.getElementById("month").required;
  document.getElementById("demo").innerHTML = m;
  var selmonth = document.getElementById('month').value;
  
  var d = document.getElementById("day").required;
  document.getElementById("demo").innerHTML = y;
  var seldate = document.getElementById('day').value;

}
function validate()
{

var sal=document.getElementById('scripts').value;
if((sal=="Mr.")&&(Registration.sex[0].checked == false ) )
    {
      alert ( "Please choose your Gender Properly: Male or Female" );
      return false;
    }
else if((sal=="Ms.")&&(Registration.sex[0].checked == true ) ){
  alert ( "Please choose your Gender Properly: Male or Female" );
  return false;
}



	var interest=document.getElementsByName('interest[]')
    var otherinterest=document.forms[0].elements["otherinterest"].value;
	otherinterest=otherinterest.trim();


	  if(!valthisform())
	   {
          if( otherinterest==""||otherinterest==null)
		   {
          alert('select any one interest or write into other interest');
		  return false;
           }
	   }
	   
	if( document.Registration.year.value == "select year")   
    {
     alert( "Please Select birth date!" );
     return false;
    }
	else if(document.Registration.month.value == "select month")
	{
	  alert( "Please Select birth date!" );
     return false;
	}
	else if(document.Registration.day.value == "select date")
	{
	  alert( "Please Select birth date!" );
     return false;
	}
	

   return( true );

}
// reset all text fields
function clearText()
{

	document.getElementById('Registration').reset();
}

// check all fields are filled then return true  then submit form
function valthisform() {
    var chkd = document.Registration.web.checked || document.Registration.database.checked||  document.Registration.swing.checked|| document.Registration.mobile.checked

    if (chkd)
	{
      return true; //Submit the form
    } else {

      return false; //not submitted
    }
  }
