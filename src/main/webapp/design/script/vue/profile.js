(function(e){function t(t){for(var a,r,i=t[0],l=t[1],s=t[2],u=0,d=[];u<i.length;u++)r=i[u],Object.prototype.hasOwnProperty.call(o,r)&&o[r]&&d.push(o[r][0]),o[r]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(e[a]=l[a]);h&&h(t);while(d.length)d.shift()();return c.push.apply(c,s||[]),n()}function n(){for(var e,t=0;t<c.length;t++){for(var n=c[t],a=!0,r=1;r<n.length;r++){var i=n[r];0!==o[i]&&(a=!1)}a&&(c.splice(t--,1),e=l(l.s=n[0]))}return e}var a={},r={profile:0,"chunk-2d0cf39f":0},o={profile:0,"chunk-2d0cf39f":0},c=[];function i(e){return l.p+"design/script/vue/"+e+".js"}function l(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,l),n.l=!0,n.exports}l.e=function(e){var t=[],n={"chunk-a302bc5a":1};r[e]?t.push(r[e]):0!==r[e]&&n[e]&&t.push(r[e]=new Promise((function(t,n){for(var a="design/style/sheet/vue/"+({}[e]||e)+".css",o=l.p+a,c=document.getElementsByTagName("link"),i=0;i<c.length;i++){var s=c[i],u=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(u===a||u===o))return t()}var d=document.getElementsByTagName("style");for(i=0;i<d.length;i++){s=d[i],u=s.getAttribute("data-href");if(u===a||u===o)return t()}var h=document.createElement("link");h.rel="stylesheet",h.type="text/css",h.onload=t,h.onerror=function(t){var a=t&&t.target&&t.target.src||o,c=new Error("Loading CSS chunk "+e+" failed.\n("+a+")");c.code="CSS_CHUNK_LOAD_FAILED",c.request=a,delete r[e],h.parentNode.removeChild(h),n(c)},h.href=o;var b=document.getElementsByTagName("head")[0];b.appendChild(h)})).then((function(){r[e]=0})));var a=o[e];if(0!==a)if(a)t.push(a[2]);else{var c=new Promise((function(t,n){a=o[e]=[t,n]}));t.push(a[2]=c);var s,u=document.createElement("script");u.charset="utf-8",u.timeout=120,l.nc&&u.setAttribute("nonce",l.nc),u.src=i(e);var d=new Error;s=function(t){u.onerror=u.onload=null,clearTimeout(h);var n=o[e];if(0!==n){if(n){var a=t&&("load"===t.type?"missing":t.type),r=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+a+": "+r+")",d.name="ChunkLoadError",d.type=a,d.request=r,n[1](d)}o[e]=void 0}};var h=setTimeout((function(){s({type:"timeout",target:u})}),12e4);u.onerror=u.onload=s,document.head.appendChild(u)}return Promise.all(t)},l.m=e,l.c=a,l.d=function(e,t,n){l.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},l.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},l.t=function(e,t){if(1&t&&(e=l(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(l.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)l.d(n,a,function(t){return e[t]}.bind(null,a));return n},l.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return l.d(t,"a",t),t},l.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},l.p="/",l.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=t,s=s.slice();for(var d=0;d<s.length;d++)t(s[d]);var h=u;c.push([3,"chunk-vendors"]),n()})({"279c":function(e,t,n){"use strict";n.d(t,"a",(function(){return G}));var a=n("7a23"),r=n("bc3a"),o=n.n(r);n("e1ae"),n("11f6"),n("4121"),n("bddf");function c(e,t,n,r,o,c){return Object(a["k"])(),Object(a["d"])("header")}const i={};i.render=c;var l=i;const s={class:"navbar navbar-expand-lg fixed-top navbar-dark"},u=Object(a["h"])("a",{class:"navbar-brand",href:"/"},[Object(a["h"])("img",{src:"/design/layout/image/logo/mensa-logo.png",width:"30",height:"30"})],-1),d=Object(a["h"])("button",{class:"navbar-toggler",type:"button","data-toggle":"collapse","data-target":"#collapsibleNavbar",id:"test"},[Object(a["h"])("div",{class:"navbar-toggler-icon-animated"},[Object(a["h"])("span"),Object(a["h"])("span"),Object(a["h"])("span")])],-1),h={class:"navbar-collapse collapse",id:"collapsibleNavbar"},b=Object(a["f"])('<ul class="navbar-nav"><li class="nav-item mx-auto"><a class="nav-link topBottomSlideIn" href="/">Welkom</a></li><li class="nav-item mx-auto"><a class="nav-link topBottomSlideIn" href="/test">IQ Test</a></li><li class="nav-item mx-auto"><a class="nav-link topBottomSlideIn" href="/member/events">Activiteiten</a></li></ul>',1),g={class:"navbar-nav ml-auto"},m={class:"nav-item mx-auto"},f=Object(a["h"])("img",{src:"/design/layout/image/icon/English.png",width:"25",height:"25"},null,-1),p={class:"nav-item mx-auto"},v=Object(a["h"])("img",{src:"/design/layout/image/icon/Dutch.png",width:"25",height:"25"},null,-1),j={class:"nav-item mx-auto"},O=Object(a["h"])("img",{src:"/design/layout/image/icon/French.png",width:"25",height:"25"},null,-1),k={class:"nav-item mx-auto"},y=Object(a["h"])("img",{src:"/design/layout/image/icon/German.png",width:"25",height:"25"},null,-1),w={key:0,class:"nav-item mx-auto"},I=Object(a["h"])("a",{href:"member",class:"nav-link roundLinkIcon"},[Object(a["h"])("img",{src:"/design/layout/image/icon/login.png",width:"25",height:"25"})],-1),L=Object(a["h"])("a",{href:"member",class:"nav-link topBottomSlideIn"},"Aanmelden",-1),x={key:1,class:"nav-item dropdown"},S=Object(a["h"])("a",{id:"navbarDropdownIcon",href:"#",class:"nav-link roundLinkIcon",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},[Object(a["h"])("img",{src:"/design/layout/image/icon/login.png",width:"25",height:"25"})],-1),E=Object(a["h"])("a",{id:"navbarDropdown",href:"#",class:"nav-link topBottomSlideIn",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},"Mijn Profiel",-1),T=Object(a["h"])("div",{class:"dropdown-menu","aria-labelledby":"navbarDropdown navbarDropdownIcon"},[Object(a["h"])("a",{href:"/member/profile",class:"dropdown-item topBottomSlideIn"},"Aanpassen"),Object(a["h"])("div",{class:"dropdown-divider"}),Object(a["h"])("a",{href:"/logout",class:"dropdown-item topBottomSlideIn"},"Afmelden")],-1);function C(e,t,n,r,o,c){return Object(a["k"])(),Object(a["d"])("nav",s,[u,d,Object(a["h"])("div",h,[b,Object(a["h"])("ul",g,[Object(a["h"])("li",m,[Object(a["h"])("a",{href:"",onClick:t[1]||(t[1]=e=>c.changeLanguage("english")),class:"nav-link roundLinkIcon"},[f]),Object(a["h"])("a",{href:"",onClick:t[2]||(t[2]=e=>c.changeLanguage("english")),class:"nav-link topBottomSlideIn"},"English")]),Object(a["h"])("li",p,[Object(a["h"])("a",{href:"",onClick:t[3]||(t[3]=e=>c.changeLanguage("nederlands")),class:"nav-link roundLinkIcon"},[v]),Object(a["h"])("a",{href:"",onClick:t[4]||(t[4]=e=>c.changeLanguage("nederlands")),class:"nav-link topBottomSlideIn"},"Nederlands")]),Object(a["h"])("li",j,[Object(a["h"])("a",{href:"",onClick:t[5]||(t[5]=e=>c.changeLanguage("francais")),class:"nav-link roundLinkIcon"},[O]),Object(a["h"])("a",{href:"",onClick:t[6]||(t[6]=e=>c.changeLanguage("francais")),class:"nav-link topBottomSlideIn"},"Français")]),Object(a["h"])("li",k,[Object(a["h"])("a",{href:"",onClick:t[7]||(t[7]=e=>c.changeLanguage("deutsch")),class:"nav-link roundLinkIcon"},[y]),Object(a["h"])("a",{href:"",onClick:t[8]||(t[8]=e=>c.changeLanguage("deutsch")),class:"nav-link topBottomSlideIn"},"Deutsch")]),o.loggedIn?Object(a["e"])("",!0):(Object(a["k"])(),Object(a["d"])("li",w,[I,L])),o.loggedIn?(Object(a["k"])(),Object(a["d"])("li",x,[S,E,T])):Object(a["e"])("",!0)])])])}var P=n("c1ed"),A={data(){return{loggedIn:!1}},created(){o.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/session/checkLoggedIn").then(e=>{this.loggedIn=e.data})},methods:{changeLanguage(e){Object(P["b"])(e)}}};A.render=C;var B=A;function M(e,t,n,r,o,c){return Object(a["k"])(),Object(a["d"])("h1",{class:"fadeInAndSlideInFromBottom",innerHTML:o.value},null,8,["innerHTML"])}var D={data(){return{value:null}},mounted(){this.value=this.title}};D.render=M;var _=D;function N(e,t,n,r,o,c){return Object(a["k"])(),Object(a["d"])("footer",null,"Copyright Mensa 2020 ©")}const F={};F.render=N;var U=F;const H={DEFAULT:"Mensa.be",PAGE:"Mensa - "};async function G(e,t,r,c){var i=await Object(P["a"])(t).then(e=>e.data);document.title=i?H.PAGE+i:H.DEFAULT,c&&o.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/session/logIn"),Object(a["c"])(l).mount("#header"),Object(a["c"])(B).mount("#navigation");const s=Object(a["c"])(_);s.config.globalProperties.title=await Object(P["a"])(r).then(e=>e.data),s.mount("#title"),Object(a["c"])(Object(a["i"])(()=>n("6eb8")("./"+e))).mount("#content"),Object(a["c"])(U).mount("#footer")}},3:function(e,t,n){e.exports=n("638d")},"638d":function(e,t,n){"use strict";n.r(t);var a=n("279c");const r="member/profile/Profile.vue",o="content.profile.documentTitle",c="content.profile.title";Object(a["a"])(r,o,c,!0)},"6eb8":function(e,t,n){var a={"./member/events/Events":["5b2e","chunk-2d0d2ef6"],"./member/events/Events.js":["5b2e","chunk-2d0d2ef6"],"./member/events/Events.vue":["1cd1","chunk-2d0b6715"],"./member/home/Member":["15bb","chunk-2d0aba5a"],"./member/home/Member.js":["15bb","chunk-2d0aba5a"],"./member/home/Member.vue":["f63b","chunk-5d46e06a"],"./member/profile/Profile":["638d","chunk-2d0cf39f"],"./member/profile/Profile.js":["638d","chunk-2d0cf39f"],"./member/profile/Profile.vue":["3efe","chunk-a302bc5a"],"./public/home/Home":["95c1","chunk-2d0e5d40"],"./public/home/Home.js":["95c1","chunk-2d0e5d40"],"./public/home/Home.vue":["f21f","chunk-62426f6e"],"./public/test/Test":["7837","chunk-2d0d79fb"],"./public/test/Test.js":["7837","chunk-2d0d79fb"],"./public/test/Test.vue":["9903","chunk-2d0e6619"]};function r(e){if(!n.o(a,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=a[e],r=t[0];return n.e(t[1]).then((function(){return n(r)}))}r.keys=function(){return Object.keys(a)},r.id="6eb8",e.exports=r},c1ed:function(e,t,n){"use strict";n.d(t,"a",(function(){return o})),n.d(t,"b",(function(){return l}));var a=n("bc3a"),r=n.n(a);function o(e){return r.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/user/language").then(t=>{var n;return t.data?(n=t.data,c("language",n)):n=""!=i("language")?i("language"):"english",r.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/translation/"+e+"/"+n)})}function c(e,t){var n=new Date;n.setTime(n.getTime()+31536e6);var a="expires="+n.toUTCString();document.cookie=e+"="+t+";"+a+";path=/"}function i(e){for(var t=e+"=",n=decodeURIComponent(document.cookie),a=n.split(";"),r=0;r<a.length;r++){var o=a[r];while(" "==o.charAt(0))o=o.substring(1);if(0==o.indexOf(t))return o.substring(t.length,o.length)}return""}async function l(e){await r.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/user/language").then(e=>e.data)&&r.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/user/changeLanguage/"+e),c("language",e)}}});