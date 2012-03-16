function initScript(){
  	      clock();
    	  dateDisplay();
}


function clickDateTextBox(str,textbox){

    if(str == "Click to select Date"){
        textbox.value = "";
        textbox.style.color ='#000';

    }
}

function initDateTextBox(str,textbox){

    //alert(str);
    if(str == ""){
        textbox.value = "Click to select Date";
        textbox.style.color ="#999999";
    }
}