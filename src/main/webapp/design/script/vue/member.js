(function(e){function t(t){for(var a,o,l=t[0],i=t[1],s=t[2],d=0,u=[];d<l.length;d++)o=l[d],Object.prototype.hasOwnProperty.call(c,o)&&c[o]&&u.push(c[o][0]),c[o]=0;for(a in i)Object.prototype.hasOwnProperty.call(i,a)&&(e[a]=i[a]);b&&b(t);while(u.length)u.shift()();return r.push.apply(r,s||[]),n()}function n(){for(var e,t=0;t<r.length;t++){for(var n=r[t],a=!0,o=1;o<n.length;o++){var l=n[o];0!==c[l]&&(a=!1)}a&&(r.splice(t--,1),e=i(i.s=n[0]))}return e}var a={},o={member:0,"chunk-2d0aba5a":0},c={member:0,"chunk-2d0aba5a":0},r=[];function l(e){return i.p+"design/script/vue/"+e+".js"}function i(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n={"chunk-19e287dd":1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var a="design/style/sheet/vue/"+({}[e]||e)+".css",c=i.p+a,r=document.getElementsByTagName("link"),l=0;l<r.length;l++){var s=r[l],d=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(d===a||d===c))return t()}var u=document.getElementsByTagName("style");for(l=0;l<u.length;l++){s=u[l],d=s.getAttribute("data-href");if(d===a||d===c)return t()}var b=document.createElement("link");b.rel="stylesheet",b.type="text/css",b.onload=t,b.onerror=function(t){var a=t&&t.target&&t.target.src||c,r=new Error("Loading CSS chunk "+e+" failed.\n("+a+")");r.code="CSS_CHUNK_LOAD_FAILED",r.request=a,delete o[e],b.parentNode.removeChild(b),n(r)},b.href=c;var g=document.getElementsByTagName("head")[0];g.appendChild(b)})).then((function(){o[e]=0})));var a=c[e];if(0!==a)if(a)t.push(a[2]);else{var r=new Promise((function(t,n){a=c[e]=[t,n]}));t.push(a[2]=r);var s,d=document.createElement("script");d.charset="utf-8",d.timeout=120,i.nc&&d.setAttribute("nonce",i.nc),d.src=l(e);var u=new Error;s=function(t){d.onerror=d.onload=null,clearTimeout(b);var n=c[e];if(0!==n){if(n){var a=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;u.message="Loading chunk "+e+" failed.\n("+a+": "+o+")",u.name="ChunkLoadError",u.type=a,u.request=o,n[1](u)}c[e]=void 0}};var b=setTimeout((function(){s({type:"timeout",target:d})}),12e4);d.onerror=d.onload=s,document.head.appendChild(d)}return Promise.all(t)},i.m=e,i.c=a,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)i.d(n,a,function(t){return e[t]}.bind(null,a));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],d=s.push.bind(s);s.push=t,s=s.slice();for(var u=0;u<s.length;u++)t(s[u]);var b=d;r.push([3,"chunk-vendors"]),n()})({"15bb":function(e,t,n){"use strict";n.r(t);var a=n("279c");Object(a["a"])("member/home/Member.vue","member",!0)},"279c":function(e,t,n){"use strict";n.d(t,"a",(function(){return ce}));var a=n("7a23"),o=n("bc3a"),c=n.n(o),r=(n("e1ae"),n("65d1")),l=n.n(r),i=n("6060"),s=n.n(i),d=n("8459"),u=n.n(d);n("1639"),n("4121"),n("bddf");const b=Object(a["withScopeId"])("data-v-77e47008");Object(a["pushScopeId"])("data-v-77e47008");const g={id:"particles-js",ref:"particles"};Object(a["popScopeId"])();const h=b((e,t,n,o,c,r)=>(Object(a["openBlock"])(),Object(a["createBlock"])("header",null,[Object(a["createVNode"])("div",g,null,512)])));var m={mounted(){let e=document.createElement("script");e.setAttribute("src","/design/script/particles/particles.js"),this.$refs.particles.appendChild(e);let t=document.createElement("script");t.setAttribute("src","/design/script/particles/app.js"),this.$refs.particles.appendChild(t)}};n("e2df");m.render=h,m.__scopeId="data-v-77e47008";var p=m;const f={class:"navbar navbar-expand-lg fixed-top navbar-dark"},v=Object(a["createVNode"])("a",{class:"navbar-brand",href:"/"},[Object(a["createVNode"])("img",{src:"/design/layout/image/logo/mensa-logo.png",width:"50",height:"50"})],-1),j=Object(a["createVNode"])("button",{class:"navbar-toggler",type:"button","data-toggle":"collapse","data-target":"#collapsibleNavbar",id:"test"},[Object(a["createVNode"])("div",{class:"navbar-toggler-icon-animated"},[Object(a["createVNode"])("span"),Object(a["createVNode"])("span"),Object(a["createVNode"])("span")])],-1),O={class:"navbar-collapse collapse",id:"collapsibleNavbar"},k={class:"navbar-nav"},y={class:"nav-item mx-auto"},N={class:"nav-link topBottomSlideIn",href:"/"},V={class:"nav-item mx-auto"},w={class:"nav-link topBottomSlideIn",href:"/test"},I={class:"nav-item mx-auto"},S={class:"nav-link topBottomSlideIn",href:"/member/events"},T={class:"navbar-nav ml-auto"},L={class:"nav-item mx-auto"},C=Object(a["createVNode"])("img",{src:"/design/layout/image/icon/English.png",width:"25",height:"25"},null,-1),E={class:"nav-item mx-auto"},A=Object(a["createVNode"])("img",{src:"/design/layout/image/icon/Dutch.png",width:"25",height:"25"},null,-1),B={class:"nav-item mx-auto"},D=Object(a["createVNode"])("img",{src:"/design/layout/image/icon/French.png",width:"25",height:"25"},null,-1),x={class:"nav-item mx-auto"},M=Object(a["createVNode"])("img",{src:"/design/layout/image/icon/German.png",width:"25",height:"25"},null,-1),P={key:0,class:"nav-item mx-auto"},_=Object(a["createVNode"])("a",{href:"member",class:"nav-link roundLinkIcon"},[Object(a["createVNode"])("img",{src:"/design/layout/image/icon/login.png",width:"25",height:"25"})],-1),F={href:"member",class:"nav-link topBottomSlideIn"},U={key:1,class:"nav-item dropdown"},H=Object(a["createVNode"])("a",{id:"navbarDropdownIcon",href:"#",class:"nav-link roundLinkIcon",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},[Object(a["createVNode"])("img",{src:"/design/layout/image/icon/login.png",width:"25",height:"25"})],-1),J={id:"navbarDropdown",href:"#",class:"nav-link topBottomSlideIn",role:"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"},G={class:"dropdown-menu","aria-labelledby":"navbarDropdown navbarDropdownIcon"},q={href:"/member/profile",class:"dropdown-item topBottomSlideIn"},z=Object(a["createVNode"])("div",{class:"dropdown-divider"},null,-1),R={href:"/logout",class:"dropdown-item topBottomSlideIn"};function $(e,t,n,o,c,r){return Object(a["openBlock"])(),Object(a["createBlock"])("nav",f,[v,j,Object(a["createVNode"])("div",O,[Object(a["createVNode"])("ul",k,[Object(a["createVNode"])("li",y,[Object(a["createVNode"])("a",N,Object(a["toDisplayString"])(c.label.home),1)]),Object(a["createVNode"])("li",V,[Object(a["createVNode"])("a",w,Object(a["toDisplayString"])(c.label.test),1)]),Object(a["createVNode"])("li",I,[Object(a["createVNode"])("a",S,Object(a["toDisplayString"])(c.label.events),1)])]),Object(a["createVNode"])("ul",T,[Object(a["createVNode"])("li",L,[Object(a["createVNode"])("a",{href:"",onClick:t[1]||(t[1]=e=>r.changeLanguage("english")),class:"nav-link roundLinkIcon"},[C]),Object(a["createVNode"])("a",{href:"",onClick:t[2]||(t[2]=e=>r.changeLanguage("english")),class:"nav-link topBottomSlideIn"},Object(a["toDisplayString"])(c.label.english),1)]),Object(a["createVNode"])("li",E,[Object(a["createVNode"])("a",{href:"",onClick:t[3]||(t[3]=e=>r.changeLanguage("dutch")),class:"nav-link roundLinkIcon"},[A]),Object(a["createVNode"])("a",{href:"",onClick:t[4]||(t[4]=e=>r.changeLanguage("dutch")),class:"nav-link topBottomSlideIn"},Object(a["toDisplayString"])(c.label.dutch),1)]),Object(a["createVNode"])("li",B,[Object(a["createVNode"])("a",{href:"",onClick:t[5]||(t[5]=e=>r.changeLanguage("french")),class:"nav-link roundLinkIcon"},[D]),Object(a["createVNode"])("a",{href:"",onClick:t[6]||(t[6]=e=>r.changeLanguage("french")),class:"nav-link topBottomSlideIn"},Object(a["toDisplayString"])(c.label.french),1)]),Object(a["createVNode"])("li",x,[Object(a["createVNode"])("a",{href:"",onClick:t[7]||(t[7]=e=>r.changeLanguage("german")),class:"nav-link roundLinkIcon"},[M]),Object(a["createVNode"])("a",{href:"",onClick:t[8]||(t[8]=e=>r.changeLanguage("german")),class:"nav-link topBottomSlideIn"},Object(a["toDisplayString"])(c.label.german),1)]),c.loggedIn?Object(a["createCommentVNode"])("",!0):(Object(a["openBlock"])(),Object(a["createBlock"])("li",P,[_,Object(a["createVNode"])("a",F,Object(a["toDisplayString"])(c.label.login),1)])),c.loggedIn?(Object(a["openBlock"])(),Object(a["createBlock"])("li",U,[H,Object(a["createVNode"])("a",J,Object(a["toDisplayString"])(c.label.profile),1),Object(a["createVNode"])("div",G,[Object(a["createVNode"])("a",q,Object(a["toDisplayString"])(c.label.edit),1),z,Object(a["createVNode"])("a",R,Object(a["toDisplayString"])(c.label.logout),1)])])):Object(a["createCommentVNode"])("",!0)])])])}var K=n("c1ed"),Q={data(){return{loggedIn:!1,label:{home:null,test:null,events:null,profile:null,english:null,dutch:null,french:null,german:null,login:null,edit:null,logout:null}}},created(){Object(K["a"])("label.common.navigation.page.home").then(e=>this.label.home=e.data),Object(K["a"])("label.common.navigation.page.test").then(e=>this.label.test=e.data),Object(K["a"])("label.common.navigation.page.events").then(e=>this.label.events=e.data),Object(K["a"])("label.common.navigation.page.profile").then(e=>this.label.profile=e.data),Object(K["a"])("label.common.navigation.language.english").then(e=>this.label.english=e.data),Object(K["a"])("label.common.navigation.language.dutch").then(e=>this.label.dutch=e.data),Object(K["a"])("label.common.navigation.language.french").then(e=>this.label.french=e.data),Object(K["a"])("label.common.navigation.language.german").then(e=>this.label.german=e.data),Object(K["a"])("label.common.navigation.profile.login").then(e=>this.label.login=e.data),Object(K["a"])("label.common.navigation.profile.edit").then(e=>this.label.edit=e.data),Object(K["a"])("label.common.navigation.profile.logout").then(e=>this.label.logout=e.data),c.a.get("http://mensa-be-dev.atl.jelastic.vps-host.net/rest/session/checkLoggedIn").then(e=>{this.loggedIn=e.data})},methods:{changeLanguage(e){Object(K["b"])(e)}}};Q.render=$;var W=Q;function X(e,t,n,o,c,r){return Object(a["openBlock"])(),Object(a["createBlock"])("h1",{class:"fadeInAndSlideInFromBottom",innerHTML:c.value},null,8,["innerHTML"])}var Y={data(){return{value:null}},mounted(){this.value=this.title}};Y.render=X;var Z=Y;function ee(e,t){return Object(a["openBlock"])(),Object(a["createBlock"])("footer",null,"Copyright Mensa 2020 ©")}const te={};te.render=ee;var ne=te;c.a.defaults.baseURL="/rest",c.a.defaults.headers.post["Content-Type"]="application/json";const ae={DEFAULT:"Mensa.be",PAGE:"Mensa - "},oe={DOCUMENT_TITLE:"label.document.title.",TITLE_CONTENT:"content.title."};async function ce(e,t,o){var r=await Object(K["a"])(oe.DOCUMENT_TITLE+t).then(e=>e.data);document.title=r?ae.PAGE+r:ae.DEFAULT,o&&(c.a.get("session/logIn"),console.log("member log in")),Object(a["createApp"])(p).mount("#header"),Object(a["createApp"])(W).mount("#navigation");const i=Object(a["createApp"])(Z);i.config.globalProperties.title=await Object(K["a"])(oe.TITLE_CONTENT+t).then(e=>e.data),i.mount("#title");const d=Object(a["createApp"])(Object(a["defineAsyncComponent"])(()=>n("6eb8")("./"+e)));d.use(u.a),d.use(l.a,{locale:{dateFormat:"dd/mm/yy",monthNames:["January","February","March","April","May","June","July","August","September","October","November","Dezzember"]}}),d.component("Toast",s.a),d.mount("#content"),Object(a["createApp"])(ne).mount("#footer")}},"2a77":function(e,t,n){},3:function(e,t,n){e.exports=n("15bb")},"6eb8":function(e,t,n){var a={"./authentication/Authentication":["24fc","chunk-2d0b2b75"],"./authentication/Authentication.js":["24fc","chunk-2d0b2b75"],"./authentication/Authentication.vue":["894b","chunk-2d0df265"],"./authentication/AuthenticationFailed":["2ac4","chunk-2d0bd3d6"],"./authentication/AuthenticationFailed.js":["2ac4","chunk-2d0bd3d6"],"./authentication/AuthenticationFailed.vue":["3269","chunk-2d0b9258"],"./member/events/Events":["5b2e","chunk-2d0d2ef6"],"./member/events/Events.js":["5b2e","chunk-2d0d2ef6"],"./member/events/Events.vue":["1cd1","chunk-19e287dd"],"./member/home/Member":["15bb","chunk-2d0aba5a"],"./member/home/Member.js":["15bb","chunk-2d0aba5a"],"./member/home/Member.vue":["f63b","chunk-0cdf848b"],"./member/profile/Profile":["638d","chunk-2d0cf39f"],"./member/profile/Profile.js":["638d","chunk-2d0cf39f"],"./member/profile/Profile.vue":["3efe","chunk-d5c40a2e"],"./public/home/Home":["95c1","chunk-2d0e5d40"],"./public/home/Home.js":["95c1","chunk-2d0e5d40"],"./public/home/Home.vue":["f21f","chunk-2d22c0d7"],"./public/test/Test":["7837","chunk-2d0d79fb"],"./public/test/Test.js":["7837","chunk-2d0d79fb"],"./public/test/Test.vue":["9903","chunk-2d0e6619"]};function o(e){if(!n.o(a,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=a[e],o=t[0];return n.e(t[1]).then((function(){return n(o)}))}o.keys=function(){return Object.keys(a)},o.id="6eb8",e.exports=o},c1ed:function(e,t,n){"use strict";n.d(t,"a",(function(){return c})),n.d(t,"b",(function(){return i}));var a=n("bc3a"),o=n.n(a);function c(e){return o.a.get("user/language").then(t=>{var n;return t.data?(n=t.data,r("language",n)):n=""!=l("language")?l("language"):"english",console.log(">> translating: "+e+" for language: "+n+"<<"),o.a.get("translation/"+n+"/"+e)})}function r(e,t){var n=new Date;n.setTime(n.getTime()+31536e6);var a="expires="+n.toUTCString();document.cookie=e+"="+t+";"+a+";path=/"}function l(e){for(var t=e+"=",n=decodeURIComponent(document.cookie),a=n.split(";"),o=0;o<a.length;o++){var c=a[o];while(" "==c.charAt(0))c=c.substring(1);if(0==c.indexOf(t))return c.substring(t.length,c.length)}return""}async function i(e){r("language",e),await o.a.get("user/language").then(e=>e.data)&&o.a.get("user/changeLanguage/"+e)}},e2df:function(e,t,n){"use strict";n("2a77")}});