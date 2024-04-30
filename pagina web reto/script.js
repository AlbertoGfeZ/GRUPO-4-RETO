// MENU HAMBURGUESA

document.addEventListener('DOMContentLoaded', function () {
    const hamburguesa = document.querySelector('.menu-hamburguesa input');
    const menuNav = document.querySelector('.contenido-nav ul');

    hamburguesa.addEventListener('click', () => {
        hamburguesa.parentElement.classList.toggle('abierta');
        menuNav.classList.toggle('mostrar');
    });
});

