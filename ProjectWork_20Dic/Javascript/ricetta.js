
let variabile;
    variabile=document.getElementById("titoloRicetta");

    window.addEventListener("scroll",sposta);
   
    function sposta(){
        console.log(window.scrollY)
        if (document.documentElement.scrollTop > 350) {
            window.scrollBy(0, 250);
        } 
    }


    window.addEventListener("scroll",function(){
        variabile.classList.toggle("titoloRicettascroll", window.scrollY > 1);
        })
    

