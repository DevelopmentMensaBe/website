import axios from "axios";

export function translate(name) {

  // should store in cookie or session when language.data is empty!
  return axios.get(process.env.VUE_APP_HOST_REST + "user/language").then(l => {

    var language

    // console.log(">>user language: " + l.data + "<<")
    // console.log(">>cookie: " + getCookie("language") + "<<")

    if (l.data) {

      language = l.data

      setCookie("language", language)

    } else {

      if (getCookie("language") != "") {

        language = getCookie("language")

      } else {

        language = "english"
      }
    }

    return axios
      .get(
        process.env.VUE_APP_HOST_REST +
        "translation/" +
        name +
        "/" + language
      )
  })
}
// Cookie for one year
function setCookie(cname, cvalue) {
  var d = new Date();
  d.setTime(d.getTime() + (365 * 24 * 60 * 60 * 1000));
  var expires = "expires=" + d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

export async function updateLanguage(language) {

  if (await axios.get(process.env.VUE_APP_HOST_REST + "user/language").then(l => { return l.data })) {

    axios.get(process.env.VUE_APP_HOST_REST + "user/changeLanguage/" + language)
  }

  setCookie("language", language)
}