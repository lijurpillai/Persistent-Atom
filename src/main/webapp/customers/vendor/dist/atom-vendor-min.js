// Version: 3.5.3.1
(function(){
function q(){return function(){}}
window.JSON&&window.JSON.stringify||function(){function b(){try{return this.valueOf()}catch(a){return null}}function c(b){a.lastIndex=0;return a.test(b)?'"'+b.replace(a,function(a){var b=m[a];return"string"===typeof b?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+b+'"'}function d(a,m){var r,h,k,n,p,z=e,l=m[a];l&&"object"===typeof l&&(l=b.call(l));"function"===typeof x&&(l=x.call(m,a,l));switch(typeof l){case "string":return c(l);case "number":return isFinite(l)?String(l):"null";
case "boolean":case "null":return String(l);case "object":if(!l)return"null";e+=v;p=[];if("[object Array]"===Object.prototype.toString.apply(l)){n=l.length;for(r=0;r<n;r+=1)p[r]=d(r,l)||"null";k=0===p.length?"[]":e?"[\n"+e+p.join(",\n"+e)+"\n"+z+"]":"["+p.join(",")+"]";e=z;return k}if(x&&"object"===typeof x)for(n=x.length,r=0;r<n;r+=1)h=x[r],"string"===typeof h&&(k=d(h,l))&&p.push(c(h)+(e?": ":":")+k);else for(h in l)Object.hasOwnProperty.call(l,h)&&(k=d(h,l))&&p.push(c(h)+(e?": ":":")+k);k=0===p.length?
"{}":e?"{\n"+e+p.join(",\n"+e)+"\n"+z+"}":"{"+p.join(",")+"}";e=z;return k}}window.JSON||(window.JSON={});var a=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,e,v,m={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},x;"function"!==typeof JSON.stringify&&(JSON.stringify=function(a,b,c){var h;v=e="";if("number"===typeof c)for(h=0;h<c;h+=1)v+=" ";else"string"===typeof c&&(v=c);if((x=b)&&"function"!==
typeof b&&("object"!==typeof b||"number"!==typeof b.length))throw Error("JSON.stringify");return d("",{"":a})});"function"!==typeof JSON.parse&&(JSON.parse=function(a){return eval("("+a+")")})}();var aa=1,w=!1,B=[],I="-pnpres",ba=10,L=1E4,ca=310,da=60,M=1E3,ea="/",fa="&",ga=/{([\w\-]+)}/g;function P(){return"x"+ ++aa+""+ +new Date}function Q(){return+new Date}
var S=function(){var b=Math.floor(20*Math.random());return function(c,d){return 0<c.indexOf("pubsub.")&&c.replace("pubsub","ps"+(d?R().split("-")[0]:20>++b?b:b=1))||c}}();function T(b,c){var d=b.join(ea),a=[];if(!c)return d;V(c,function(b,c){a.push(b+"="+W(c))});return d+="?"+a.join(fa)}function ha(b,c){function d(){e+c>Q()?(clearTimeout(a),a=setTimeout(d,c)):(e=Q(),b())}var a,e=0;return d}function ia(b,c){var d=[];V(b||[],function(a){c(a)&&d.push(a)});return d}
function ja(b,c){return b.replace(ga,function(b,a){return c[a]||b})}function R(b){var c="xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g,function(b){var a=16*Math.random()|0;return("x"==b?a:a&3|8).toString(16)});b&&b(c);return c}function V(b,c){if(b&&c)if("undefined"!=typeof b[0])for(var d=0,a=b.length;d<a;)c.call(b[d],b[d],d++);else for(d in b)b.hasOwnProperty&&b.hasOwnProperty(d)&&c.call(b[d],d,b[d])}function X(b,c){var d=[];V(b||[],function(a,b){d.push(c(a,b))});return d}
function W(b){return X(encodeURIComponent(b).split(""),function(b){return 0>"-_.!~*'()".indexOf(b)?b:"%"+b.charCodeAt(0).toString(16).toUpperCase()}).join("")}function Y(b){var c=[];V(b,function(b,a){a.j&&c.push(b)});return c.sort()}function Z(){setTimeout(function(){w||(w=1,V(B,function(b){b()}))},M)}
function ka(b){function c(){}function d(a){a&&(s.h=0);!s.h&&s.length&&(s.h=1,G(s.shift()))}function a(a){var b=0;V(Y(g),function(f){if(f=g[f])b++,(a||q())(f)});return b}function e(){t()||m(1);setTimeout(e,M)}function v(){C.time(function(a){a||m(1);setTimeout(v,E)})}function m(a){A&&A(a);A=null}var x=+b.windowing||ba,O=(+b.timeout||ca)*M,E=(+b.keepalive||da)*M,r=b.noleave||0,h=b.publish_key||"",k=b.subscribe_key||"",n=b.auth_key||"",p=b.ssl?"s":"",z="http"+p+"://"+(b.origin||"pubsub.pubnub.com"),l=
S(z),N=S(z),s=[],F=0,H=0,A=0,f=0,y=0,g={},G=b.xdr,u=b.error||q(),t=b._is_online||function(){return 1},J=b.jsonp_cb||function(){return 0},K=b.db||{get:q(),set:q()},D=b.uuid||K&&K.get(k+"uuid")||"",C={LEAVE:function(a,b){var f={uuid:D,auth:n},c=S(z),g=J();0<a.indexOf(I)||r||("0"!=g&&(f.callback=g),G({g:b||p,timeout:2E3,a:g,data:f,url:[c,"v2","presence","sub_key",k,"channel",W(a),"leave"]}))},history:function(a,b){b=a.callback||b;var f=a.count||a.limit||100,c=a.reverse||"false",g=a.error||q(),y=a.channel,
d=a.start,e=a.end,h={},m=J();if(!y)return u("Missing Channel");if(!b)return u("Missing Callback");if(!k)return u("Missing Subscribe Key");h.stringtoken="true";h.count=f;h.reverse=c;h.auth=n;m&&(h.callback=m);d&&(h.start=d);e&&(h.end=e);G({a:m,data:h,c:function(a){b(a)},b:g,url:[l,"v2","history","sub-key",k,"channel",W(y)]})},replay:function(a){var b=b||a.callback||q(),f=a.source,c=a.destination,g=a.stop,y=a.start,d=a.end,e=a.reverse;a=a.limit;var m=J(),t={};if(!f)return u("Missing Source Channel");
if(!c)return u("Missing Destination Channel");if(!h)return u("Missing Publish Key");if(!k)return u("Missing Subscribe Key");"0"!=m&&(t.callback=m);g&&(t.stop="all");e&&(t.reverse="true");y&&(t.start=y);d&&(t.end=d);a&&(t.count=a);t.auth=n;G({a:m,c:function(a){b(a)},b:function(){b([0,"Disconnected"])},url:[l,"v1","replay",h,k,f,c],data:t})},auth:function(a){n=a;c()},time:function(a){var b=J();G({a:b,data:{uuid:D,auth:n},timeout:5*M,url:[l,"time",b],c:function(b){a(b[0])},b:function(){a(0)}})},publish:function(a,
b){b=b||a.callback||q();var f=a.message,c=a.channel,g=J();if(!f)return u("Missing Message");if(!c)return u("Missing Channel");if(!h)return u("Missing Publish Key");if(!k)return u("Missing Subscribe Key");f=JSON.stringify(f);c=[l,"publish",h,k,0,W(c),g,W(f)];s.push({a:g,timeout:5*M,url:c,data:{uuid:D,auth:n},c:function(a){b(a);d(1)},b:function(){b([0,"Failed",f]);d(1)}});d()},unsubscribe:function(a){a=a.channel;y=0;f=1;a=X((a.join?a.join(","):""+a).split(","),function(a){return a+","+a+I}).join(",");
V(a.split(","),function(a){w&&C.LEAVE(a,0);g[a]=0});c()},subscribe:function(b,d){function e(b){b?setTimeout(c,M):(l=S(z,1),N=S(z,1),setTimeout(function(){C.time(e)},M));a(function(a){if(b&&a.d)return a.d=0,a.l(a.name);b||a.d||(a.d=1,a.disconnect(a.name))})}function h(){var b=J(),d=Y(g).join(",");d&&(m(),A=G({timeout:ma,a:b,b:function(){A=null;C.time(e)},data:{uuid:D,auth:n},url:[N,"subscribe",k,W(d),b,y],c:function(b){A=null;if(!b||"object"==typeof b&&"error"in b&&!b.error)return s(b),setTimeout(c,
U);y=!y&&f&&K.get(k)||b[1];a(function(a){a.f||(a.f=1,a.k(a.name))});$&&(y=1E4,$=0);K.set(k,b[1]);var d=function(){var a=(2<b.length?b[2]:X(g,function(a){return X(Array(b[0].length).join(",").split(","),function(){return a})}).join(",")).split(",");return function(){var b=a.shift()||H;return[(g[b]||{}).a||F,b.split(I)[0]]}}();V(b[0],function(a){var f=d();f[0](a,b,f[1])});setTimeout(h,U)}}))}var t=b.channel;d=(d=d||b.callback)||b.message;var r=b.connect||q(),p=b.reconnect||q(),v=b.disconnect||q(),s=
b.error||q(),E=b.presence||0,la=b.noheresync||0,$=b.backfill||0,na=b.timetoken||0,ma=b.timeout||O,U=b.windowing||x;f=b.restore;y=na;if(!t)return u("Missing Channel");if(!d)return u("Missing Callback");if(!k)return u("Missing Subscribe Key");V((t.join?t.join(","):""+t).split(","),function(a){var b=g[a]||{};g[H=a]={name:a,f:b.f,d:b.d,j:1,a:F=d,k:r,disconnect:v,l:p};E&&(C.subscribe({channel:a+I,callback:E}),b.j||la||C.here_now({channel:a,callback:function(b){V("uuids"in b?b.uuids:[],function(f){E({action:"join",
uuid:f,timestamp:Q(),occupancy:b.occupancy||1},b,a)})}}))});c=function(){m();setTimeout(h,U)};if(!w)return B.push(c);c()},here_now:function(a,b){b=a.callback||b;var f=a.error||q(),c=a.channel,g=J(),d={uuid:D,auth:n};if(!c)return u("Missing Channel");if(!b)return u("Missing Callback");if(!k)return u("Missing Subscribe Key");"0"!=g&&(d.callback=g);G({a:g,data:d,c:function(a){b(a,c)},b:f,url:[l,"v2","presence","sub_key",k,"channel",W(c)]})},xdr:G,ready:Z,db:K,uuid:R,map:X,each:V,"each-channel":a,grep:ia,
offline:function(){m(1)},supplant:ja,now:Q,unique:P,updater:ha};D||(D=C.uuid());K.set(k+"uuid",D);setTimeout(e,M);setTimeout(v,E);C.time(q());return C}
window.PUBNUB||function(){function b(f){f.jsonp&&(l=0);var y=f.subscribe_key||"";f.uuid||N.get(y+"uuid");f.xdr=r;f.db=N;f.error=d;f._is_online=k;f.jsonp_cb=E;var g=ka(f);g.css=x;g.$=c;g.create=O;g.bind=e;g.head=v;g.search=a;g.attr=m;g.events=s;g.init=b;e("beforeunload",window,function(){g["each-channel"](function(a){g.LEAVE(a.name,0)});return!0});if(f.notest)return g;e("offline",window,g.offline);e("offline",document,g.offline);return g}function c(a){return document.getElementById(a)}function d(a){console.error(a)}
function a(a,b){var c=[];V(a.split(/\s+/),function(a){V((b||document).getElementsByTagName(a),function(a){c.push(a)})});return c}function e(a,b,c){V(a.split(","),function(a){function f(a){a||(a=window.event);c(a)||(a.cancelBubble=!0,a.returnValue=!1,a.preventDefault&&a.preventDefault(),a.stopPropagation&&a.stopPropagation())}b.addEventListener?b.addEventListener(a,f,!1):b.attachEvent?b.attachEvent("on"+a,f):b["on"+a]=f})}function v(){return a("head")[0]}function m(a,b,c){if(c)a.setAttribute(b,c);
else return a&&a.getAttribute&&a.getAttribute(b)}function x(a,b){for(var c in b)if(b.hasOwnProperty(c))try{a.style[c]=b[c]+(0<"|width|height|top|left|".indexOf(c)&&"number"==typeof b[c]?"px":"")}catch(d){}}function O(a){return document.createElement(a)}function E(){return l||n()?0:P()}function r(a){function b(a,f){t||(t=1,d.onerror=null,clearTimeout(r),a||!f||C(f),setTimeout(function(){a&&s();var b=c(k),f=b&&b.parentNode;f&&f.removeChild(b)},M))}if(l||n())return h(a);var d=O("script"),e=a.a,k=P(),
t=0,r=setTimeout(function(){b(1)},a.timeout||L),s=a.b||q(),D=a.data||{},C=a.c||q();window[e]=function(a){b(0,a)};a.g||(d[p]=p);d.onerror=function(){b(1)};D.pnsdk=z;d.src=T(a.url,D);m(d,"id",k);v().appendChild(d);return b}function h(a){function b(a){h||(h=1,clearTimeout(p),d&&(d.onerror=d.onload=null,d.abort&&d.abort(),d=null),a&&s())}function c(){if(!k){k=1;clearTimeout(p);try{e=JSON.parse(d.responseText)}catch(a){return b(1)}h=1;x(e)}}var d,e,h=0,k=0,m=a.timeout||L,p=setTimeout(function(){b(1)},
m),s=a.b||q(),v=a.data||{},x=a.c||q(),A="undefined"===typeof a.g;try{d=n()||window.XDomainRequest&&new XDomainRequest||new XMLHttpRequest;d.onerror=d.onabort=function(){b(1)};d.onload=d.onloadend=c;A&&(d.timeout=m);v.pnsdk=z;var E=T(a.url,v);d.open("GET",E,A);d.send()}catch(F){return b(0),l=0,r(a)}return b}function k(){return"onLine"in navigator?navigator.onLine:1}function n(){if(!A||!A.get)return 0;var a={id:n.id++,send:q(),abort:function(){a.id={}},open:function(b,c){n[a.id]=a;A.get(a.id,c)}};return a}
var p="async",z="PubNub-JS-Web/3.5.3.1",l=-1==navigator.userAgent.indexOf("MSIE 6");window.console||(window.console=window.console||{});console.log||(console.log=console.error=(window.opera||{}).postError||q());var N=function(){var a=window.localStorage;return{get:function(b){try{return a?a.getItem(b):-1==document.cookie.indexOf(b)?null:((document.cookie||"").match(RegExp(b+"=([^;]+)"))||[])[1]||null}catch(c){}},set:function(b,c){try{if(a)return a.setItem(b,c)&&0;document.cookie=b+"="+c+"; expires=Thu, 1 Aug 2030 20:00:00 UTC; path=/"}catch(d){}}}}(),
s={list:{},unbind:function(a){s.list[a]=[]},bind:function(a,b){(s.list[a]=s.list[a]||[]).push(b)},fire:function(a,b){V(s.list[a]||[],function(a){a(b)})}},F=c("pubnub")||0;e("load",window,function(){setTimeout(Z,0)});var H=F||{};PUBNUB=b({notest:1,publish_key:m(H,"pub-key"),subscribe_key:m(H,"sub-key"),ssl:!document.location.href.indexOf("https")||"on"==m(H,"ssl"),origin:m(H,"origin"),uuid:m(H,"uuid")});window.jQuery&&(window.jQuery.PUBNUB=PUBNUB);"undefined"!==typeof module&&(module.exports=PUBNUB)&&
Z();var A=c("pubnubs")||0;if(F){x(F,{position:"absolute",top:-M});if("opera"in window||m(F,"flash"))F.innerHTML="<object id=pubnubs data=https://pubnub.a.ssl.fastly.net/pubnub.swf><param name=movie value=https://pubnub.a.ssl.fastly.net/pubnub.swf><param name=allowscriptaccess value=always></object>";PUBNUB.rdx=function(a,b){if(!b)return n[a].onerror();n[a].responseText=unescape(b);n[a].onload()};n.id=M}}();
(function(){var b=PUBNUB.ws=function(c,d){if(!(this instanceof b))return new b(c,d);var a=this;c=a.url=c||"";a.protocol=d||"Sec-WebSocket-Protocol";var e=c.split("/"),e={ssl:"wss:"===e[0],origin:e[2],publish_key:e[3],subscribe_key:e[4],channel:e[5]};a.CONNECTING=0;a.OPEN=1;a.CLOSING=2;a.CLOSED=3;a.CLOSE_NORMAL=1E3;a.CLOSE_GOING_AWAY=1001;a.CLOSE_PROTOCOL_ERROR=1002;a.CLOSE_UNSUPPORTED=1003;a.CLOSE_TOO_LARGE=1004;a.CLOSE_NO_STATUS=1005;a.CLOSE_ABNORMAL=1006;a.onclose=a.onerror=a.onmessage=a.onopen=
a.onsend=q();a.binaryType="";a.extensions="";a.bufferedAmount=0;a.trasnmitting=!1;a.buffer=[];a.readyState=a.CONNECTING;if(!c)return a.readyState=a.CLOSED,a.onclose({code:a.CLOSE_ABNORMAL,reason:"Missing URL",wasClean:!0}),a;a.e=PUBNUB.init(e);a.e.i=e;a.i=e;a.e.subscribe({restore:!1,channel:e.channel,disconnect:a.onerror,reconnect:a.onopen,error:function(){a.onclose({code:a.CLOSE_ABNORMAL,reason:"Missing URL",wasClean:!1})},callback:function(b){a.onmessage({data:b})},connect:function(){a.readyState=
a.OPEN;a.onopen()}})};b.prototype.send=function(b){var d=this;d.e.publish({channel:d.e.i.channel,message:b,callback:function(a){d.onsend({data:a})}})}})();
})();
/*
 * fingerprintJS 0.4 - Fast browser fingerprint library
 * https://github.com/Valve/fingerprintjs
 * Copyright (c) 2013 Valentin Vasilyev (iamvalentin@gmail.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */
!function(t){"use strict";var e=function(t){var e=Array.prototype.forEach,a=Array.prototype.map;this.each=function(t,a,n){if(null!==t)if(e&&t.forEach===e)t.forEach(a,n);else if(t.length===+t.length){for(var r=0,o=t.length;o>r;r++)if(a.call(n,t[r],r,t)==={})return}else for(var i in t)if(t.hasOwnProperty(i)&&a.call(n,t[i],i,t)==={})return},this.map=function(t,e,n){var r=[];return null==t?r:a&&t.map===a?t.map(e,n):(this.each(t,function(t,a,o){r[r.length]=e.call(n,t,a,o)}),r)},"object"==typeof t?(this.hasher=t.hasher,this.canvas=t.canvas):"function"==typeof t&&(this.hasher=t)};e.prototype={get:function(){var e=[];e.push(navigator.userAgent),e.push(navigator.language),e.push(screen.colorDepth),e.push((new Date).getTimezoneOffset()),e.push(!!t.sessionStorage),e.push(this.hasLocalStorage()),e.push(!!window.indexedDB),e.push(typeof document.body.addBehavior),e.push(typeof window.openDatabase),e.push(navigator.cpuClass),e.push(navigator.platform),e.push(navigator.doNotTrack);var a=this.map(navigator.plugins,function(t){var e=this.map(t,function(t){return[t.type,t.suffixes].join("~")}).join(",");return[t.name,t.description,e].join("::")},this).join(";");return e.push(a),this.canvas&&this.isCanvasSupported()&&e.push(this.getCanvasFingerprint()),this.hasher?this.hasher(e.join("###"),31):this.murmurhash3_32_gc(e.join("###"),31)},murmurhash3_32_gc:function(t,e){var a,n,r,o,i,s,h,c;for(a=3&t.length,n=t.length-a,r=e,i=3432918353,s=461845907,c=0;n>c;)h=255&t.charCodeAt(c)|(255&t.charCodeAt(++c))<<8|(255&t.charCodeAt(++c))<<16|(255&t.charCodeAt(++c))<<24,++c,h=4294967295&(65535&h)*i+((65535&(h>>>16)*i)<<16),h=h<<15|h>>>17,h=4294967295&(65535&h)*s+((65535&(h>>>16)*s)<<16),r^=h,r=r<<13|r>>>19,o=4294967295&5*(65535&r)+((65535&5*(r>>>16))<<16),r=(65535&o)+27492+((65535&(o>>>16)+58964)<<16);switch(h=0,a){case 3:h^=(255&t.charCodeAt(c+2))<<16;case 2:h^=(255&t.charCodeAt(c+1))<<8;case 1:h^=255&t.charCodeAt(c),h=4294967295&(65535&h)*i+((65535&(h>>>16)*i)<<16),h=h<<15|h>>>17,h=4294967295&(65535&h)*s+((65535&(h>>>16)*s)<<16),r^=h}return r^=t.length,r^=r>>>16,r=4294967295&2246822507*(65535&r)+((65535&2246822507*(r>>>16))<<16),r^=r>>>13,r=4294967295&3266489909*(65535&r)+((65535&3266489909*(r>>>16))<<16),r^=r>>>16,r>>>0},hasLocalStorage:function(){try{return!!t.localStorage}catch(e){return!0}},isCanvasSupported:function(){var t=document.createElement("canvas");return!(!t.getContext||!t.getContext("2d"))},getCanvasFingerprint:function(){var t=document.createElement("canvas"),e=t.getContext("2d"),a="valve.github.io";return e.textBaseline="top",e.font="14px 'Arial'",e.textBaseline="alphabetic",e.fillStyle="#f60",e.fillRect(125,1,62,20),e.fillStyle="#069",e.fillText(a,2,15),e.fillStyle="rgba(102, 204, 0, 0.7)",e.fillText(a,4,17),t.toDataURL()}},t.Fingerprint=e}(window);
/*!
 * jQuery Cookie Plugin v1.4.0
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2013 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD. Register as anonymous module.
		define(['jquery'], factory);
	} else {
		// Browser globals.
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
		} catch(e) {
			return;
		}

		try {
			// If we can't parse the cookie, ignore it, it's unusable.
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write
		if (value !== undefined && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {};

		// To prevent the for loop in the first place assign an empty array
		// in case there are no cookies at all. Also prevents odd result when
		// calling $.cookie().
		var cookies = document.cookie ? document.cookie.split('; ') : [];

		for (var i = 0, l = cookies.length; i < l; i++) {
			var parts = cookies[i].split('=');
			var name = decode(parts.shift());
			var cookie = parts.join('=');

			if (key && key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		if ($.cookie(key) !== undefined) {
			// Must not alter options, thus extending a fresh object...
			$.cookie(key, '', $.extend({}, options, { expires: -1 }));
			return true;
		}
		return false;
	};

}));
var jQ = jQuery.noConflict();