var lpfcLocation = document.location.toString();
var lpfcProtocol = "http";
if ((lpfcLocation != null) && (lpfcLocation.indexOf("https:") == 0))
	lpfcProtocol = "https";

if (typeof(lpServerName) == "undefined") 
	lpServerName = "server.iad.liveperson.net";
var lpDOM = (document.getElementById) ? true : false;
var lpEngageImage = new Image();

function lpGetDate()
{
	var d = new Date();

	return d.getTime();
}

function lpCheckImage() {
	if ((lpDOM) && (! lpEngageImage.complete))
		return false;
	var imageWidth = lpEngageImage.width;
	if (imageWidth > 0) {
		if (imageWidth == 82) {
			lpEngageForChat();
		}
		return true;
	}
	return false;
}

function lpLoopImage() {
	if (lpCheckImage())
		return;
	setTimeout("lpLoopImage()", 1000);
}

function lpCheckEngage() {
	lpEngageImage.src = lpfcProtocol + "://" + lpServerName + "/hc/?cmd=canEngage&site=" + lpNumber + "&yes=/hcp/width/img82.gif&no=/hcp/width/img81.gif" + "&d=" + lpGetDate();
	lpLoopImage();
}
	
function lpEngageForChat() {
	openChat("auto engage", lpCV, true);
}

setTimeout("lpCheckEngage()", lpEngageSeconds * 1000);

































