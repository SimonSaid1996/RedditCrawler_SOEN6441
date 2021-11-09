function getType(form) {
	
	const text = document.getElementsByName("searchKey")[0].value;
	const absoluteUrl = "http://localhost:9000";
	console.log("Text: ",text);
	if(text) {
		return form.action = absoluteUrl+"/search/"+text;
	}
	
	return form.action = absoluteUrl;
}