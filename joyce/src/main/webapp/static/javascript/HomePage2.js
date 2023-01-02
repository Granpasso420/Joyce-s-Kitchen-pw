window.addEventListener('scroll', function(){
    const header = document.querySelector('header');
    header.classList.toggle("sticky", window.scrollY > 0);
})

function menu(){
var navBar = document.getElementById('navBar');

var panino= document.getElementById("panino");

    navBar.classList.add("navbar3");
    X.classList.add("Xvisible");
    panino.classList.remove("paninoDopo");

}

function chiudere(){
    var X=document.getElementById("X");
    navBar.classList.remove("navbar3");
    X.classList.remove("Xvisible");
    panino.classList.add("paninoDopo");
}