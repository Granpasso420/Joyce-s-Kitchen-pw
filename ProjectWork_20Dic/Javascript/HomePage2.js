window.addEventListener('scroll', function(){
    const header = document.querySelector('header');
    header.classList.toggle("sticky", window.scrollY > 0);
})

function menu(){
var checkbox= document.getElementById("checkbox");
var navBar = document.getElementById('navBar');
var X=document.getElementById("X");
var panino= document.getElementById("panino");

if (checkbox.checked == true){
    navBar.classList.add("navbar3");
    X.classList.add("Xvisible");
    panino.classList.remove("paninoDopo");
    

} else{
    navBar.classList.remove("navbar3");
    X.classList.remove("Xvisible");
    panino.classList.add("paninoDopo");
}
}