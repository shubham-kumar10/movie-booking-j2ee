// Include Movie Crusier form validation functions here
function validateMovieForm(){
	var title = document.movieForm.title.value;
    var boxOffice = document.movieForm.boxOffice.value;
    var date = document.movieForm.date.value;
    title = title.trim();
    boxOffice = boxOffice.trim();
    var len = title.length;
    var invalid = /\d/;
    if(title==null || title=="")
    {
        window.alert("Name cannot be empty.");
        return false;
    }
    else if(invalid.test(boxOffice)==false)
    {
        window.alert("Enter Box Office Collection (Can only have numbers).");
        return false;
    }
    else if(len<2||len>65)
    {
        window.alert("Name can only range from 2-65 characters.");
        return false;
    }
    else if(boxOffice.length==0)
    {
    	window.alert("Price cannot be empty");
    	return false;
	}
    else if(date.length==0)
    {
    	window.alert("Date of Launch is required");
    	return false;
	}
    else
    {
    	window.alert('Form Submitted Successfully');
    }
    //return(true);
}
