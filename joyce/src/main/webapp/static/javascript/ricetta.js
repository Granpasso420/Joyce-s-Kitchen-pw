
let variabile;
    variabile=document.getElementById("titoloRicetta");

    window.addEventListener("scroll",function(){
        variabile.classList.toggle("titoloRicettascroll", window.scrollY > 200);
        })

