// MENU HAMBURGUESA

document.addEventListener('DOMContentLoaded', function () {
    const hamburguesa = document.querySelector('.menu-hamburguesa input');
    const menuNav = document.querySelector('.contenido-nav ul');

    hamburguesa.addEventListener('click', () => {
        hamburguesa.parentElement.classList.toggle('abierta');
        menuNav.classList.toggle('mostrar');
    });
});



// huevo de pascua 1
var audio = null;

function playSound() {
    if (audio !== null) {
        audio.pause();
        audio.currentTime = 0;
    }
    audio = new Audio("https://www.myinstants.com/media/sounds/himno-real-madrid-5.mp3");
    audio.play();
}