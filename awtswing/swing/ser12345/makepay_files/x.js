var SCRIPT_VERSION = "1.1";

if (typeof(lpNumber) == "undefined")
    lpNumber = '41878286';

var lpUseFirstParty = ("true" == "false");
var lpUseSecureCookies = ("true" == "false");
var lpUseSessionCookies = ("true" == "false");

var LPLOCALVIDCOOKIE = lpNumber + '-VID';
var LPLOCALSKEYCOOKIE = lpNumber + '-SKEY';

var maxImg30SequenceAllowed = 2;
var maxAllowedIDFetch = 2;

if (typeof(lpCustomInvitationTitle) == "undefined")
    lpCustomInvitationTitle = "invitation popup window for live chat with an online representative";
if (typeof(lpCustomInvitationCloseTitle) == "undefined")
    lpCustomInvitationCloseTitle = "Close Chat Invitation";

if (typeof(lpCustomInvitationLinkTitle) == "undefined")
    lpCustomInvitationLinkTitle = "invitation popup window for live chat with an online representative";

var hcUseRejectStatusCookie = ((typeof(lpSaveRejectStatus) != "undefined") && lpSaveRejectStatus);

var hcUpdateState = 0;

var pageLocation = document.location.toString();

var lpfcLocation = document.location.toString();
var lpfcProtocol = "http";
if ((lpfcLocation != null) && (lpfcLocation.indexOf("https:") == 0))
	lpfcProtocol = "https";

var hcBase = lpfcProtocol + '://server.iad.liveperson.net/hc/'+lpNumber+'/';
var hcImageURL = lpFixProtocol("http://img.shaadi.com/imgs/help-invitation/");
if (typeof(lpCustomImageURL) != "undefined")
    hcImageURL = lpFixProtocol(lpCustomImageURL);
var hcStaticImageURL = hcImageURL;

var hcControlImage;
var hcIsImage = false;
var hcCounter = 0;
var hcCmd = "knockPage";
var scriptType = "SERVERBASED";
var hcTimeout = 5;
var hcSendCounter = 0;

if (typeof(hcPageID) == "undefined")
    hcPageID = null;

var hcLeft = -1;
var hcTop = -1;

var hcNS = (document.layers) ? true : false;
var hcIE = (document.all) ? true : false;
var hcDOM = (document.getElementById) ? true : false;
var hcSafari = (navigator.userAgent) && (navigator.userAgent.toUpperCase().indexOf("SAFARI") >= 0);

if (hcIE)
	hcDOM = false;
var hcMAC = (navigator.platform) && (navigator.platform.toUpperCase().indexOf("MAC") >= 0);
if (hcNS)
	hcMAC = false;
var hcShowImage = false;

var hcPos = - 30;
var HumanStep = 3;
var hcDir = HumanStep;
var hcBorder = 100;
var hcAnimate = false;
var hcAnimateTimer = null;
var hcOrigHcPos = null;
var hcOrigHumanStep = null;

var hcNeedImage;
var hcCloseImage;
var hcImageFetched = false;

var hcimage = hcGetImage("hcIcon");
var hcicon = null;
if (hcimage) {
	if (!(hcimage.length)) {
		var _lptemp = hcimage;
		hcimage = new Array();
		hcimage[0] = _lptemp;
	}
	hcicon = new Array();
	for (i = 0; i < hcimage.length; i++) {
		hcicon[i] = hcimage[i].src;
	}
}

var hcParam = null;
var hcOpenVars = null;

var hcLoadingImage = false;

var hcLayerWidth = 400;
var hcLayerHeight = 300;

var hcClickURL;

var HCinit = true;

var lpForcePopup = ("{forcePopup}" == "true");

var	visitorStatus = "INSITE_STATUS";
var	lpActivePlugin = "none";
var lpTopFrame = null;

var	hcRejected = false;

var hcFocusFlag = false;
var lpIsVisitor = false;

var lpVoiceEngageFlag = false;

if ("{newChannel}" == "true") {
	var lpPosY = 100;
	var lpPosX = 100;
	var lpOperatorViewable= 'true';
	var lpOperatorPageType= 'CoBrowse';
}

if (hcDOM)
{
	hcControlImage = document.createElement('IMG');
	hcControlImage.style.visibility = "hidden";
	document.body.appendChild(hcControlImage);
} else
if (hcMAC)
{
	document.writeln("<div style='visibility:hidden'><img src='" + lpfcProtocol + "://server.iad.liveperson.net/hcp/window/common/spacer.gif' id='hcControlImage' name='hcControlImage'></div>");
	hcControlImage = document.hcControlImage;
}

function lpFixProtocol(str) {
    if ((str != null) && (str.indexOf("http:") == 0) && (lpfcProtocol == "https"))
        return lpfcProtocol + str.substring(4);
	return str;
}

function hcGetObj(id)
{
	if (document.getElementById)
		return document.getElementById(id);
	else
	if (document.all)
		return document.all(id);
}

function hcObjShow(obj)
{
	if (hcNS)
		obj.visibility="show";
	else
		obj.style.visibility="visible";
}

function hcDate()
{
	var d = new Date();

	return d.getTime();
}
function isJavaEnabled()
{
	var rc = false;
	var agent = navigator.appName;
	ver= parseInt(navigator.appVersion);
	if (agent == "Microsoft Internet Explorer") {
		if ((ver >= 4) && navigator.javaEnabled())
			rc = true;
	} else {
        for (i=0; i < navigator.plugins.length; i++)
            rc = rc || (navigator.plugins[i].name.toUpperCase().indexOf("JAVA")	!= -1);
	}

	return rc;
}


function lpFindCookie(key) {
    var s = document.cookie;
    var allCookies = s.split("; ");
    for (i = 0; i < allCookies.length; i++) {
        var keyval = allCookies[i].split("=");
        if (keyval != null && keyval.length == 2 && key == keyval[0])
            return keyval[1];
    }
    return "";
}

function lpParseLocalVisitorID() {
    return lpFindCookie(LPLOCALVIDCOOKIE);
}
function lpParseLocalSessionKey() {
    return lpFindCookie(LPLOCALSKEYCOOKIE);
}

function lpSetOneFPCookie(name, value, expiry) {
    var mainDomain = lpParseDomain();
    var cookieSet = name + "=" + value + ";path=/" + (lpUseSecureCookies ? ";secure" : "") + (expiry == null ? "" : (";expires=" + expiry)) + (mainDomain == null ? "" : (";domain=" + mainDomain));
    document.cookie = cookieSet;
}

function lpParseDomain() {
    var mainDomain = null;
    try {
    var dom = document.location.host;
        
    var ar = dom.split(".");
    mainDomain = ar.length > 1? ("." + ar[ar.length-2]+ "." + ar[ar.length-1]) : null;
    if (mainDomain != null && mainDomain.indexOf(":") > 0)
         mainDomain = mainDomain.substring(0, mainDomain.indexOf(":"));
    }
    catch (e) { mainDomain = null; }
    return mainDomain;
}

var lpFPCookieSet = false;
function lpSetFPCookies(id, skey) {
    var d = new Date();
	var newD = new Date(d.getTime() + (1000*60*60*24*365));
    var expirydate = lpUseSessionCookies ? null : newD.toGMTString();
    if (id != "-")
        lpSetOneFPCookie(LPLOCALVIDCOOKIE,id,expirydate);
    if (skey != "-")
        lpSetOneFPCookie(LPLOCALSKEYCOOKIE,skey,null);
    lpFPCookieSet = true;
}

function lpTestSetCookies() {
    var d = new Date();
    var curTime = d.getTime();
    var newD = new Date(curTime + (1000*10));
    var expirydate = lpUseSessionCookies ? null : newD.toGMTString();
    lpSetOneFPCookie("lptest", new String(curTime), expirydate); // set
    var ok = lpFindCookie("lptest") == new String(curTime); // check
    lpSetOneFPCookie("lptest", new String(curTime), "Thu, 1 Jan 1970 00:00:01 UTC"); // delete
    return ok;
}

var lpCanSetFPCookies = lpTestSetCookies();
var lpJavaSupport = isJavaEnabled();

function lpCreateScriptTag(srcURL) {
  if (! document.getElementsByTagName) return;
	var body = document.getElementsByTagName("body");
	var scriptTag = document.createElement('script');
	scriptTag.src= srcURL;
	if (document.body.firstChild != null)
		document.body.insertBefore(scriptTag, document.body.firstChild);
	else
		body.appendChild(scriptTag);
}

function lpAppendVisitorCookies(url) {
    var index = url.indexOf("?");
    if (index == -1) {
				var needsAmp = url.indexOf("&") != 0;
        url = '&visitor=' + lpParseLocalVisitorID() + '&msessionkey=' + lpParseLocalSessionKey() + ( needsAmp ? "&" : "") + url;
    } else {
        var firstChunk = url.substring(0, index + 1);
        var secondChunk = url.substring(index + 1);
				var needsAmp = secondChunk.indexOf("&") != 0;
        url = firstChunk + 'visitor=' + lpParseLocalVisitorID() + '&msessionkey=' + lpParseLocalSessionKey() + ( needsAmp ? "&" : "") + secondChunk;
    }
    return url;
}

var lpFetchReTries = 0;
var lpFetchScriptCounter = 0;
function lpVerifyFPCookie() {
    if (! lpFPCookieSet) {
        if (lpFetchScriptCounter-- <= 0) {
            if (lpFetchReTries++ > maxAllowedIDFetch)
                return;
            // we need to fetch the visitor ID before we can continue
            var tagSrc = hcBase + "?site=" + lpNumber + "&cmd=fetchVisitorID&callbackFunc=lpSetFPCookies('~id~', '~skey~');&d=" + hcDate();
            tagSrc = lpAppendVisitorCookies(tagSrc);
            lpFetchScriptCounter = 5;
            lpCreateScriptTag(tagSrc);
        }
        setTimeout('lpVerifyFPCookie()', 1000);
    } else {
        if (hcCmd == "knockPage")
            hcCmd = "startPage";
        hcloop();
    }
}

function hcSendRequest()
{
	hcSendCounter++;
	if (hcSendCounter == 5)
		hcIsImage = false;

	if (! hcIsImage) {
		if (hcDOM) {
			document.body.removeChild(hcControlImage);
			hcControlImage = document.createElement('IMG');
			hcControlImage.style.visibility = "hidden";
			hcControlImage.style.position = "absolute";
			hcControlImage.style.top = "0px";
			hcControlImage.style.left = "-5000px";
			document.body.appendChild(hcControlImage);
		} else
		if (! hcMAC)
			hcControlImage= new Image;
		
		if (hcPageID==null) hcPageID=Math.round(Math.random()*9999999999);
		var windowname = lpTopFrame.name;
		if (windowname.length > 256)
			windowname = windowname.substring(0, 255);
		var u = hcBase + '?site=' + lpNumber +
					'&cmd=' + hcCmd +
					'&page=' + escape(pageLocation) +
					'&visitorStatus=' + escape(visitorStatus) +
					'&activePlugin=' + escape(lpTopFrame.lpActivePlugin) +
					'&pageWindowName=' + escape(windowname) +
					'&javaSupport=' + (lpJavaSupport ? "true" : "false") +
					'&id=' + hcPageID +
					'&scriptVersion=' + SCRIPT_VERSION +
                    '&d=' + hcDate();
        u = lpAppendVisitorCookies(u);
        if (hcCmd == "knockPage")
			hcCmd = "startPage";
        else {
			if ((typeof(tagVars) != "undefined") && (tagVars != "")) {
				u = u + "&" + tagVars;
			}
			if ((typeof(customCommands) != "undefined") && (customCommands != "")) {
				u = u + "&" + customCommands;
				customCommands = "";
			}
			if ((typeof(customStaticCommands) != "undefined") && (customStaticCommands != "")) {
				u = u + "&" + customStaticCommands;
			}
			var activateCobrowse = false;
			if ( false ) {
				u = u + "&cobrowse=true";
				activateCobrowse = true;
			}

	        if ( (typeof(lpOperatorViewable) != "undefined") && (lpOperatorViewable == "true") ) {
				if (! activateCobrowse) {
					u = u + "&cobrowse=true";
					activateCobrowse = true;
				}
	            if (typeof(lpOperatorPageType) != "undefined") {
	                u = u  + "&cobrowsetitle=" + escape(lpOperatorPageType);
	            }
	            if (typeof(lpOperatorPageUrl) != "undefined") {
	                u = u  + "&cobrowseurl=" + escape(lpOperatorPageUrl);
	            }
	        }
			if (scriptType != null) {
				u = u + "&scriptType=" + scriptType;
				scriptType = null;
			}
			hcCmd = "inPage";
			if (activateCobrowse) {
				var cookies = document.cookie;
				if ((typeof(cookies) == "undefined") || (cookies == null))
					cookies = "";
				if (u.length <= 1990)
					while (escape(cookies).length + u.length > 1990) {
						var idx = cookies.lastIndexOf(";");
						if (idx >= 0)
							cookies = cookies.substring(0, idx);
						else
							cookies = "";
					}
				u = u + "&cookie=" + escape(cookies);
			}
		}
		if(typeof(document.title)!="undefined" && document.title.length>0){
    		u = u + '&title=' + escape(document.title);
	    	if(u.length>1990) u = u.substring(0,1990);
		}
		u = u + '&referrer=';
		var ref = escape(document.referrer);
		if (u.length + ref.length < 1990)
			u = u + ref;
		hcControlImage.src = u;
		hcIsImage = true;
		hcSendCounter = 0;
	}
}
function hcPlaceLayersIE()
{
}
function hcPlaceLayersNS()
{
}
function hcHandlePopup(w, h)
{
}



var hcImg30Sequence = 0;
var hclastW = -1;
var hclastH = -1;
function hcHandleWidthHeight(w,h)
{
	if (hcMAC && (hclastH == h) && (hclastW == w) && !(w == 30 && h == 1) && !(w == 80 && h == 1))
		return;
	hclastH = h;
	hclastW = w;
    if (h==1) {
        var wCode = w-w%2;
        var more = w%2;
        if (wCode > 30 && hcCmd=="inPage") {
            if (typeof(lpVisitorDependantCode) != "undefined") {
                for (i = 0; i < lpVisitorDependantCode.length; i++) {
                    var tempfunc = lpVisitorDependantCode[i];
                    tempfunc();
                }
                lpVisitorDependantCode = new Array();
            }
        }
        if (wCode == 30) {
			hcImg30Sequence++;
			if (hcImg30Sequence == maxImg30SequenceAllowed)
				hcTimeout = -1;
        } else if (wCode == 40) {
		hcTimeout = 10;
        } else if (wCode == 42) {
		// do nothing response
        } else if (wCode == 50) {
		hcTimeout = 30;
        } else if (wCode == 60) {
            openChat(null, null, true);
        } else if (wCode == 70) {
            lpVoiceEngageFlag = false;
            openEngageChat("engage", null);
        } else if (wCode == 72) {
            lpVoiceEngageFlag = false;
            openCustomEngageChat("engage", null);
        } else if (wCode == 74) {
            openEngageVoice("engage", null);
        } else if (wCode == 76) {
            openCustomEngageVoice("engage", null);
        } else if (wCode == 80) {
			hcReloadIcon();
		} else if (wCode == 90) {
            hcCounter=0;
            hcTimeout = 1;
		} else if (wCode == 100) {
			lpTopFrame.lpActivePlugin = "none";
			lpTopFrame.cb_bInjecting = false;
		} else if (wCode == 110) {
			lpTopFrame.lpActivePlugin = "PCB";
			setTimeout('activateCobrowsePlugin()', Math.round(Math.random()*100));
		} else if (wCode == 130) {
			handleRedirectCommand(false);
		} else if (wCode == 132) {
			handleRedirectCommand(true);
        } else if (wCode == 140) {
            openChat(null, "Pushed=true", true);
        } else if (wCode == 150) {
            visitorStatus = "INSITE_STATUS";
			hcHideTheImage();
        } else if (wCode == 152) {
            visitorStatus = "CHAT_STATUS";
            lpClearRejectState();
			hcHideTheImage();
        } else if (wCode == 154) {
            visitorStatus = "REJECT_STATUS";
            saveLPReject();
            hcHideTheImage();
        } else if (wCode == 156) {
            visitorStatus = "ENGAGE_STATUS";
		}
		if (wCode != 30){
		    hcImg30Sequence = 0;
		    if(hcCmd=="inPage") {
    		    tagVars = "";
		        lpIsVisitor = true;
	        }
        }
        if (more==1) {
            hcCounter=0;
            hcTimeout=1;
        }
    } else {
	    var modLength=1000;
	    var wLength=w%modLength;
	    var hLength=h%modLength;
	    var wCode=(w-wLength)/modLength;
	    var hCode=(h-hLength)/modLength;
		if (wCode == 4) {
			if (visitorStatus == "ENGAGE_STATUS")
				setTimeout('hcInvitationTimeout()', 1000 * wLength + 10);
		} else
		    if (typeof(hcHandlePopup) != "undefined")
			hcHandlePopup(w, h);
	}
}

function lpClearRejectState() {
    LPsetCookie("REJECT", "");
}

function saveLPReject() {
    if (! hcUseRejectStatusCookie) return;
    if (typeof(lpRejectStateTimeout) != "undefined")
        LPsetCookie("REJECT", new String(new Date().getTime() + (lpRejectStateTimeout * 1000)));
    else
        LPsetCookie("REJECT", "TRUE");
}

function getLPReject() {
    if (! hcUseRejectStatusCookie) return "";
    return LPgetCookie("REJECT");
}

function lpIsNumber(a) {
    return typeof a == 'number' && isFinite(a);
}

function hasValidLPRejectedCookie() {
    if (! hcUseRejectStatusCookie) return false;
    var cook = getLPReject();
    if (cook == "TRUE") return true;
    if (cook == null || cook == "") return false;
    var timeout = parseInt(cook);
    if (lpIsNumber(timeout)) {
        return new Date().getTime() < timeout;
    } else return false;
}

function LPgetCookie(lpCookieSuffixName)
{
	var search = "BEGIN" + lpCookieSuffixName + "=";
	if (document.cookie.length > 0)
	{
		offset = document.cookie.indexOf(search);
		if (offset != -1)
		{
			offset += search.length
			var endstr = "END" + lpCookieSuffixName;
			end = document.cookie.indexOf(endstr, offset);
			var retval = document.cookie.substring(offset, end);
			return retval;
		}
	}
	return "";
}
function LPsetCookie(lpCookieSuffixName, value)
{
    if (! hcUseRejectStatusCookie) return;
    var search = "BEGIN" + lpCookieSuffixName + "=";
	var endstr = "END" + lpCookieSuffixName;
	var newval = search+value+endstr;
	document.cookie = newval;
}


function handleRedirectCommand(newPage) {
	var s = hcBase + '?site='+lpNumber +
					'&cmd=visitorRedirect' +
					'&defaultURL=' + escape(document.location) +
					'&d=' + hcDate();
    s = lpAppendVisitorCookies(s);
	if (newPage) {
        var attr = "screenX=0,screenY=0,left=0,top=0,scrollbars=1,alwaysLowered=0,alwaysRaised=0,channelmode=0,dependent=0,directories=0,fullscreen=0,hotkeys=1,location=1,menubar=1,toolbar=1,status=1,titlebar=1,z-lock=0,resizable=1";
        attr = attr + ",height=" + (screen.availHeight - 120) + ",width=" + (screen.availWidth - (document.all ? 20 : 10));
	    window.open(s, "HCPushWindow", attr);
    }
    else
	    document.location = s;
}

function activateCobrowsePlugin() {
    with (lpTopFrame) {
        if (typeof(cb_bInjecting)!="undefined" && cb_bInjecting) return;
        cb_bInjecting = true;
        if ((typeof(document["CBAgent"])=="undefined") || (document["CBAgent"] == null)) {
            var scrtag1 = '<scr'+'ipt language="JavaScript" src="' + lpfcProtocol + '://server.iad.liveperson.net/hcp/html/lpcbtop.js" defer></scr'+'ipt>';
            var scrtag2 = '<scr'+'ipt language="JavaScript" src="' + lpfcProtocol + '://server.iad.liveperson.net/hcp/html/lpcb.js" defer></scr'+'ipt>';
            var screlem1=document.createElement(scrtag1);
            var screlem2=document.createElement(scrtag2);
            var tag = '<applet code="CBAgent.class" codeBase="' + lpfcProtocol + '://server.iad.liveperson.net/applets/v7.8" archive="cbagent.jar" name="CBAgent" width=0 height=0 style="LEFT: 0px; TOP: 0px; POSITION: absolute" mayscript></applet>';
            var elem = document.createElement(tag);
            elem["site"] =     lpNumber;
            elem["charSet"] =  "ISO-8859-1";
            elem["encoding"] = "{encoding}";
            elem["connectionType"]="https";
            elem["loglevel"]="{cbDebug}";
            elem["cabbase"]="cbagent.cab";
            if (name == "") {
                name = "LPCB" + (new Date().getTime());
            }
            var appletInstanceID = new String(name);
            elem["appletInstanceID"] = new String(escape(appletInstanceID));
            document.body.appendChild(screlem1);
            document.body.appendChild(screlem2);
            document.body.appendChild(elem);
        } else {
            cb_bInjecting = false;
            var o = document["CBAgent"];
            if (typeof(o.connect)!="undefined")
                o.connect()
            else
                if (typeof(o.length) != "undefined" &&  o.length>0)
                    o.item(0).connect();
        }
	}
}


function lpGetTopFrame() {
    if (hcIE && document.getElementById) {
        var w = null;
        eval("try {if (top && typeof(top.document)!='undefined') {var n=''+top.name; w=top;}} catch (e) {w=null;};");
        if (w != null)
            return w;
    }
    return window;
}

function hcCheckImages()
{
	if (hcIsImage) {
		if (((hcDOM) || (hcMAC)) && (! hcControlImage.complete) && (! hcSafari))
		{
			hcLoadingImage = true;
			return;
		}
		var w = hcControlImage.width;
		var h = hcControlImage.height;
		hcLoadingImage = false;

		if (w == 0)
			return;
		hcIsImage = false;
		hcHandleWidthHeight(w,h);
	}
}

var hcLoadTimer = 0;

function hcloop()
{
	if (hcTimeout < 0)
		return;

	if (hcCounter == 0)
	{
		if (! hcLoadingImage)
		{
			hcSendRequest();
			hcLoadTimer = 0;
		}
		else
		{
			hcLoadTimer++;
			if (hcLoadTimer == 5)
			{
				hcIsImage = false;
				hcSendRequest();
				hcLoadTimer = 0;
			}
		}
	}
	hcCounter = (hcCounter + 1) % hcTimeout;
	hcCheckImages();

	setTimeout('hcloop()', 1000);
}

function hcReloadIcon()
{
	if (hcimage)
		for (i = 0; i < hcimage.length; i++)
			hcimage[i].src = hcicon[i] + "&monitor=1&d=" + hcDate();
}

function openChat(param, openVars, isAuto)
{
    if (typeof(isAuto) == "undefined")
        isAuto = false;

	visitorStatus = "CHAT_STATUS";
	var s = document.location;
	if (param != null)
		s = "(" + param + ") " + s;
	s = escape(s);

    var oparms = "";
    if (openVars != null)
        oparms = oparms + "&" + openVars;

    var url;
    var name;
    if (lpVoiceEngageFlag)
    {
        url = hcBase + '?cmd=file&file=visitorWantsToTalk' + oparms + '&site='+lpNumber+'&d=' + hcDate()+'&referrer='+s;
        url = lpAppendVisitorCookies(url);
        name = 'call'+lpNumber;
    } else
    {
        url = hcBase + '?cmd=file&file=visitorWantsToChat' + oparms + '&site='+lpNumber+'&channel=web'+'&d=' + hcDate()+'&referrer='+s;
        url = lpAppendVisitorCookies(url);
        name = 'chat'+lpNumber;
    }

    var params = 'width=472,height=320,menubar=no,scrollbars=0';
    if (lpVoiceEngageFlag && (typeof(lpOpenVoice) == "function")) {
        lpOpenVoice(url, name, params);
    } else
    if ((! lpVoiceEngageFlag) && (typeof(lpOpenChat) == "function")) {
        lpOpenChat(url, name, params);
    } else {
        var ow = window.open(url, name, params);
        if ((ow == null) && isAuto)
            openEngageChat("engage", null);
    }
}

function openCredit()
{
	document.location = lpFixProtocol("http://www.liveperson.com/ref/lppb.asp");
}

function openEngageVoice(param, openVars) {
    lpVoiceEngageFlag = true;
    openEngageChat(param, openVars);
}

function openEngageChat(param, openVars) {
	if (hcRejected || hasValidLPRejectedCookie()) {
		hcRejectCall();
		return;
	}
	hcParam = param;
	hcOpenVars = openVars;
	if ((! lpForcePopup) && (hcIE || hcNS || hcDOM)) {
		hcShowTheImage();
	} else {
        var url = hcBase+'?cmd=file&file=wantsToChat&site='+lpNumber+'&d=' + hcDate();
        url = lpAppendVisitorCookies(url);
		window.open(url, 'wanttochat'+lpNumber, ',,menubar=no,scrollbars=no');
	}
}

function openCustomEngageChat(param, openVars) {
	hcImageURL = hcBase+"?cmd=ruleRedirect&site="+lpNumber+"&rulecmd=ShowCustomInvite&inviteDir=" + escape(hcStaticImageURL) + "&d=" + hcDate() + "&inviteImage=";
    hcImageURL = lpAppendVisitorCookies(hcImageURL);
	openEngageChat(param, openVars);
}

function openCustomEngageVoice(param, openVars) {
	hcImageURL = hcBase+"?cmd=ruleRedirect&site="+lpNumber+"&rulecmd=ShowCustomInvite&inviteDir=" + escape(hcStaticImageURL) + "&d=" + hcDate() + "&inviteImage=";
    hcImageURL = lpAppendVisitorCookies(hcImageURL);
	openEngageVoice(param, openVars);
}

function openWantsToChat()
{
	openEngageChat(null, null);
}

function hcPreload()
{
	hcNeedImage = new Image();
	hcNeedImage.src = hcImageURL + "need_help_on.gif";

	hcCloseImage = new Image();
	hcCloseImage.src = hcImageURL + "close_on.gif";
}

function hcSetImageGo(name, image, go)
{
	hcAnimate = go;
	hcSetImage(name, image);
}
function hcSetImage(name, image)
{
    if (hcGetImage(name) != null)
	    hcGetImage(name).src = hcImageURL + (lpVoiceEngageFlag ? "voice_" : "") + image;
}


function hcWriteDoc(str)
{
	document.writeln(str);
}

if (hcIE || hcDOM) {
	hcWriteDoc('<div name="mylayer" id="mylayer" style="z-index:90;position:absolute;visibility:hidden;left:10px;top:10px">');
	hcWriteDoc('<table border="0" cellspacing="0" cellpadding="0">');
	hcWriteDoc('<tr><td><a name="needRef" id="needRef" href="#" title="' + lpCustomInvitationLinkTitle + '" onClick="return hcAcceptCall()" target="_self" onmouseover=hcSetImageGo("need_help","need_help_on.gif",false) onmouseout=hcSetImageGo("need_help","need_help_off.gif",true)><img name="need_help" id="need_help" onload="hcFloatIconLoaded()" alt="' + lpCustomInvitationTitle + '" border="0" style="display: block"></a>');
	hcWriteDoc('<a href="#" onClick="return hcRejectCall()" target="_self" onmouseover=hcSetImageGo("need_close","close_on.gif",false) onmouseout=hcSetImageGo("need_close","close_off.gif",true)><img name="need_close" id="need_close" border="0" alt="' + lpCustomInvitationCloseTitle + '" style="display: block"></a></td></tr>');
	hcWriteDoc('</table></div>');
	hcPlaceLayersIE();
} else if (hcNS) {
	hcWriteDoc('<layer name="mylayer" id="mylayer" z-index="90" left="10px" top="10px" visibility="hidden">');
	hcWriteDoc('<table border="0" cellspacing="0" cellpadding="0">');
	hcWriteDoc('<tr><td><a href="#" name="needRef" id="needRef" title="' + lpCustomInvitationLinkTitle + '" onClick="return hcAcceptCall()" target="_self" onmouseover=hcSetImageGo("need_help","need_help_on.gif",false) onmouseout=hcSetImageGo("need_help","need_help_off.gif",true)><img name="need_help" id="need_help" src="' + hcImageURL + 'need_help_off.gif" onload="hcFloatIconLoaded()" alt="' + lpCustomInvitationTitle + '" border="0" style="display: block"></a>');
	hcWriteDoc('<a href="#" onClick="return hcRejectCall()" target="_self" onmouseover=hcSetImageGo("need_close","close_on.gif",false) onmouseout=hcSetImageGo("need_close","close_off.gif",true)><img name="need_close" src="' + hcImageURL + 'close_off.gif" border="0" alt="' + lpCustomInvitationCloseTitle + '" style="display: block"></a></td></tr>');
	hcWriteDoc('</table></layer>');
	hcPlaceLayersNS();
}
function hcFloatIconLoaded()
{
	hcImageFetched = true;
}

function hcImageTimer()
{
	if (hcShowImage && hcImageFetched) {
		var top;
		var left;

		if (hcIE) {
		    scrollPosY = 0;
		    scrollPosX = 0;
            eval('try {' +
                'if (typeof(document.documentElement) != "undefined") {' +
                    'scrollPosY = document.documentElement.scrollTop;' +
                    'scrollPosX = document.documentElement.scrollLeft;' +
                '}' +
            '} catch (e) {}');
            if ((typeof(scrollPosX) != "undefined") || isNaN(scrollPosX))
                scrollPosX = 0;
             if ((typeof(scrollPosY) != "undefined") || isNaN(scrollPosY))
                scrollPosY = 0;
            scrollPosY = Math.max(document.body.scrollTop, scrollPosY);
            scrollPosX = Math.max(document.body.scrollLeft, scrollPosX);
            top = scrollPosY;
            left = scrollPosX;
			if ((hcTop < 0) || ((hcTop == top) && (hcLeft == left))) {
				document.all.mylayer.style.visibility = "visible";
				if(!hcFocusFlag){ 
					document.all.needRef.focus();
					hcFocusFlag = true;
				}
			} else {
				document.all.mylayer.style.visibility = "hidden";
			}

		} else if (hcNS) {

			top = pageYOffset;
			left = pageXOffset;

			if ((hcTop < 0) || ((hcTop == top) && (hcLeft == left))) {
				document.layers.mylayer.visibility = "visible";
			} else {
				document.layers.mylayer.visibility = "hidden";
			}
		} else if (hcDOM){
			top = pageYOffset;
			left = pageXOffset;
			if ((hcTop < 0) || ((hcTop == top) && (hcLeft == left))) {
				hcGetObj("mylayer").style.visibility = "visible";
				if(!hcFocusFlag){ 
					hcGetObj("needRef").focus();
					hcFocusFlag = true;
				}
			} else {
				hcGetObj("mylayer").style.visibility = "hidden";
			}
		}

		hcPlaceImage();

		hcTop = top;
		hcLeft = left;
	}

	setTimeout('hcImageTimer()', 250);
}

function hcAcceptCall()
{
    openChat(hcParam, hcOpenVars);
	hcHideTheImage();

	return false;
}

function hcRejectCall()
{
    var lpWasVoice = lpVoiceEngageFlag;
	hcRejected = true;
	saveLPReject();
	hcHideTheImage();
	visitorStatus = "REJECT_STATUS";
	hcCmd = "rejectChat"+"&channel=" + (lpWasVoice ? "voice":"web");
	hcCounter = 0;

	return false;
}

function hcInvitationTimeout()
{
	if (visitorStatus != "ENGAGE_STATUS")
		return;

	visitorStatus = "TIMEOUT_STATUS";
	hcHideTheImage();
	hcCounter = 0;

	return false;
}

function hcHideTheImage()
{
	hcShowImage = false;
    lpVoiceEngageFlag = false;

    if (hcAnimateTimer!=null) clearTimeout(hcAnimateTimer);
    
    if (hcIE) {
		document.all.mylayer.style.visibility = "hidden";
	} else if (hcNS) {
		document.layers.mylayer.visibility = "hidden";
	} else if (hcDOM) {
		hcGetObj("mylayer").style.visibility = "hidden";
	}
}

function inviteShown(channel) {
	hcCmd = "inviteShown" +((typeof(lpInviteTimeout) != "undefined") && (lpInviteTimeout != "") && (lpInviteTimeout > 0) ? ("&scripttimeout=" + lpInviteTimeout) : "");
    hcCmd += "&channel=" + channel;
    hcCounter = 0;
}


function hcShowTheImage()
{
	visitorStatus = "ENGAGE_STATUS";
    var channel = (lpVoiceEngageFlag) ? "voice" : "web";
    setTimeout("inviteShown('" + channel + "')", 5000);

	hcShowImage = true;

	hcSetImage("need_help","need_help_off.gif");
	hcSetImage("need_close","close_off.gif");

	hcAnimate = true;

    if (hcOrigHcPos == null) hcOrigHcPos = hcPos;
    if (hcOrigHumanStep == null) hcOrigHumanStep = HumanStep;

    hcPos = hcOrigHcPos;
    HumanStep = hcOrigHumanStep;
    hcDir = HumanStep;

    hcPreload();

	hcAnimateStart();
}

function hcAnimateStart()
{
	if (hcIE) {
		hcBorder = document.body.clientWidth;
	} else if (hcNS) {
		hcBorder = window.innerWidth;
	} else if (hcDOM) {
		hcBorder = window.innerWidth;
	}



    hcAnimateImage();
}

function getImageWidth(name)
{
	if (hcDOM)
		return (document.getElementsByTagName("IMG")[name]).width;
	else
	if (hcIE)
		return (document.all(name)).width;
	else
	if (hcNS)
		return (document[name]).width;
	else
		return null;
}

function hcAnimateImage()
{
	if (hcImageFetched && hcAnimate)
		hcPos = hcPos + hcDir;

	if (hcPos > hcBorder - 160)
		hcDir = - HumanStep;

	hcPlaceImage();

	if ((hcPos > 30) || (hcDir > 0)) {
		hcAnimateTimer = setTimeout("hcAnimateImage()", 20);
    }
}

function hcPlaceImage()
{
	var y = 40;
	var x = hcPos;
	if (typeof(lpPosX) != "undefined")
		x = lpPosX;
	if (typeof(lpPosY) != "undefined")
		y = lpPosY;
	var obj = null;
	if (hcIE) {
		obj = document.all.mylayer.style;
	} else if (hcNS) {
		obj = document.layers.mylayer;
	} else if (hcDOM) {
		obj = hcGetObj("mylayer").style;
	}
    if (typeof(lpPlacementFunctionHook) == "function") {
		lpPlacementFunctionHook(obj);
 	} else {
		if (hcIE) {
		    scrollPosY = 0;
		    scrollPosX = 0;
            eval('try {' +
                'if (typeof(document.documentElement) != "undefined") {' +
                    'scrollPosY = document.documentElement.scrollTop;' +
                    'scrollPosX = document.documentElement.scrollLeft;' +
                '}' +
            '} catch (e) {' +
            '    scrollPosX = 0;' +
            '    scrollPosY = 0;' +
            '}');
            if ((typeof(scrollPosX) != "undefined") || isNaN(scrollPosX))
                scrollPosX = 0;
             if ((typeof(scrollPosY) != "undefined") || isNaN(scrollPosY))
                scrollPosY = 0;
			var scrollObj;
			if (document.documentElement && document.documentElement.scrollTop)
				scrollObj = document.documentElement;
			else
				scrollObj = document.body;
            scrollPosY = Math.max(scrollObj.scrollTop, scrollPosY);
            scrollPosX = Math.max(scrollObj.scrollLeft, scrollPosX);
			obj.left = scrollPosX + x + "px";
			obj.top = scrollPosY + y + "px";
		} else if (hcNS) {
			obj.left = pageXOffset + x;
			obj.top = pageYOffset + y;
		} else if (hcDOM) {
			obj.left = pageXOffset + x + "px";
			obj.top = pageYOffset + y + "px";
		}
	}
}

function hcGetImage(name)
{
	return hcFindImage(document, name);
}

function hcFindImage(doc, name)
{
	if (hcDOM) {
		var elements = doc.getElementsByTagName("IMG");
		var i = 0;
		var collection = new Array();
		for (i = 0; i < elements.length; i++)
			if ((typeof(elements[i].name) != "undefined") &&
				(elements[i].name == name))
				collection[collection.length] = elements[i];
		if (collection.length == 0)
			return null;
		if (collection.length == 1)
			return collection[0];
		return collection;
    }
	var lays = doc.layers;

	if (! lays)
		return doc[name];

	for (var i = 0; i < doc.images.length; i++) {
		if (doc.images[i].name == name)
			return doc.images[i];
	}

	for (var l = 0; l < lays.length; l++) {
		img = hcFindImage(lays[l].document, name);
		if (img != null)
			return img;
	}

	return null;
}


function hcgo()
{
    var startAfter=1;
    var x = new String(document.location).indexOf("lpAutoChat=1");
    if (x >= 0)
        startAfter = 10000;

	if (typeof(lpCobrowsedPage) != "undefined")
		return;
	lpTopFrame = lpGetTopFrame();
    if (typeof(lpTopFrame.lpActivePlugin)=="undefined")
        lpTopFrame.lpActivePlugin = "none";

	setTimeout('lpTestAndGo()', startAfter);
	setTimeout('hcImageTimer()', 250);
}
function lpTestAndGo() {
    if (lpUseFirstParty)
        lpVerifyFPCookie();
    else
        hcloop();
}

function hcLegalPage() {
	return true;
}


if (true && (! lpUseFirstParty || lpCanSetFPCookies)) {
	if (hcLegalPage()) hcgo();
}

