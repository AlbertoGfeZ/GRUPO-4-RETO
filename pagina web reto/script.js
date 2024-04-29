// MENU HAMBURGUESA

document.addEventListener('DOMContentLoaded', function () {
    const hamburguesa = document.querySelector('.menu-hamburguesa input');
    const menuNav = document.querySelector('.contenido-nav ul');

    hamburguesa.addEventListener('click', () => {
        hamburguesa.parentElement.classList.toggle('abierta');
        menuNav.classList.toggle('mostrar');
    });
});


// TEXTO HEADER

const textoanimado = document.getElementById('textoanimado');
    const textsToAnimate = ['Actividades Extraescolares', 'Excursiones', 'Viajes Fin De Curso']; // Lista de textos a mostrar
    let currentIndex = 0;

    function animateText() {
      const currentText = textsToAnimate[currentIndex];
      const textLength = currentText.length;

      textoanimado.textContent = ''; // Borra el texto actual

      // Muestra el texto letra por letra
      for (let i = 0; i <= textLength; i++) {
        setTimeout(() => {
          textoanimado.textContent = currentText.substring(0, i);
        }, i * 100);
      }

      // Espera 3 segundos antes de iniciar el borrado
      setTimeout(() => {
        // Borrar letra por letra desde la última hasta la primera o hasta la letra que desees
        for (let i = textLength; i >= 0; i--) {
          setTimeout(() => {
            textoanimado.textContent = currentText.substring(0, i);
          }, (textLength - i) * 100);
        }

        // Incrementa el índice o reinicia si llegamos al final de la lista
        currentIndex = (currentIndex + 1) % textsToAnimate.length;

        // Llama a la función recursivamente después de borrar
        setTimeout(animateText, (textLength + 2) * 100);
      }, (textLength + 1) * 100 + 3000); // 3000 milisegundos (3 segundos) de espera adicional
    }

    // Inicia la animación
    animateText();