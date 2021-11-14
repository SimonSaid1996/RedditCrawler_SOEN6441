function getType(form) {
	
	var text = document.getElementsByName("searchKey")[0].value;
	const absoluteUrl = "http://localhost:9000";
	console.log("Text: ",text);
	
	var guid = navigator.mimeTypes.length;
	guid = guid + navigator.userAgent.replace(/\D+/g, '');
    guid += navigator.plugins.length;
	
	text = text +'--guid' + guid;
	console.log("Text: ",text);
	
	if(text) {
		return form.action = absoluteUrl+"/search/"+text;
	}
	
	return form.action = absoluteUrl;
}



function getDistWord(form){
	
	const absoluteUrl = "http://localhost:9000";
	
	
	
	if(guid) {
		return form.action = absoluteUrl+"/DistW/"+guid;
	}
	
	return form.action = absoluteUrl;

}