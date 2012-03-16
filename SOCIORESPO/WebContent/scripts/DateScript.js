

function dateDisplay(){
	var mydate=new Date()
	var year=mydate.getYear()
		if (year < 1000)
		year+=1900
	var day=mydate.getDay()
	var month=mydate.getMonth()
	var daym=mydate.getDate()
		if (daym<10)
		daym="0"+daym
	var dayarray=new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat")
	var montharray=new Array(" Jan  "," Feb  "," Mar  "," Apr  "," May  "," Jun  "," Jul  "," Aug  "," Sep  "," Oct  "," Nov  "," Dec  ")

	var string1=dayarray[day]

	                     dispDate = montharray[month] +"  "+ " "  + daym+",  "+ " " + year	                     
    //dispDate = dayarray[day]+ ", "+" " + montharray[month] +"  "+ " "  + daym+",  "+ " " + year
	//document.write(dayarray[day]+ ", "+" " + montharray[month] +"  "+ " "  + daym+",  "+ " " + year)
   document.getElementById('date').innerHTML = dispDate;
}