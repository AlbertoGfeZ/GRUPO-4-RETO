# Descripción detallada del código HTML: index

## Estructura básica del documento
- `<!DOCTYPE html>`: Declaración del tipo de documento como HTML5.
- `<html lang="es-ES">`: Elemento raíz del documento, indica el idioma del contenido como Español de España.

## Encabezado
- `<head>`: Contiene metadatos y enlaces a recursos externos.
  - `<meta charset="UTF-8" />`: Especifica el conjunto de caracteres como UTF-8 para admitir caracteres especiales.
  - `<meta name="viewport" content="width=device-width, initial-scale=1.0"/>`: Configura la escala inicial y el ancho del viewport para dispositivos móviles.
  - `<title>Actividades Extraescolares</title>`: Define el título de la página que se mostrará en la pestaña del navegador.
  - `<link rel="stylesheet" href="styles.css"/>`: Enlaza una hoja de estilos CSS local para estilizar el contenido de la página.
  - `<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>`: Enlaza la biblioteca Font Awesome para utilizar iconos.

## Cuerpo del documento
- `<header>`: Encabezado de la página que contiene el logotipo y el menú de navegación.
- `<div class="cuadro-imagen-edub-gob">`: Contenedor para mostrar dos imágenes enlazadas: educantabria y Gobierno de Cantabria.
- `<div class="cuadro-imagen-ins">`: Contenedor para una imagen del instituto.
- `<p class="introduccion-texto">Nuestras instalaciones</p>`: Párrafo introductorio que describe el contenido siguiente.
- `<div class="contenedor-galeria">`: Contenedor para una galería de imágenes de las instalaciones del instituto.
- `<div class="cuadro-izquierda">` y `<div class="cuadro-derecha">`: Cuadros de texto ubicados en los lados izquierdo y derecho de la página respectivamente.

## Pie de página
- `<footer>`: Pie de página de la página web que contiene información adicional.
  - Contiene secciones como "Sobre nosotros", "Horario", "Enlaces" y "Contáctanos" con información relevante y enlaces útiles.
- `<div class="copyrightText">`: Contiene el texto de derechos de autor que indica la propiedad del contenido.

## Enlaces
- Se utilizan elementos `<a>` para enlazar a diferentes páginas web o recursos.

## Imágenes
- Se utilizan elementos `<img>` para mostrar imágenes con sus atributos `src` para la fuente de la imagen y `alt` para descripción alternativa en caso de que la imagen no se cargue.

## Estilo
- Se hace referencia a un archivo CSS local (`styles.css`) y a la biblioteca Font Awesome a través de una URL externa para aplicar estilos y agregar iconos respectivamente.


# Descripción detallada del código HTML: Actividades

## Encabezado
- `<head>`: Contiene metadatos y enlaces a recursos externos.
  - `<meta charset="UTF-8">`: Especifica el conjunto de caracteres como UTF-8 para admitir caracteres especiales.
  - `<meta name="viewport" content="width=device-width, initial-scale=1.0">`: Configura la escala inicial y el ancho del viewport para dispositivos móviles.
  - `<title>Actividades</title>`: Define el título de la página que se mostrará en la pestaña del navegador.
  - `<link rel="stylesheet" href="styles.css">`: Enlaza una hoja de estilos CSS local para estilizar el contenido de la página.
  - `<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />`: Enlaza la biblioteca Font Awesome para utilizar iconos.

## Cuerpo del documento
- `<header>`: Encabezado de la página que contiene el logotipo y el menú de navegación.
- `<p class="intro-text">`: Párrafo introductorio que describe las actividades extraescolares en el Instituto IES Miguel Herrero.
- `<div class="contenedor-tarjetas">`: Contenedor para las tarjetas que muestran información sobre las actividades extraescolares.

## Tarjetas de actividades
- Cada actividad está representada por un `<div class="tarjeta">`, que incluye un párrafo con la descripción de la actividad, una imagen enlazada y detalles como el encargado, profesores participantes y horario.

## Pie de página
- `<footer>`: Pie de página de la página web que contiene información adicional.
  - Contiene secciones como "Sobre nosotros", "Horario", "Enlaces" y "Contáctanos" con información relevante y enlaces útiles.
- `<div class="copyrightText">`: Contiene el texto de derechos de autor que indica la propiedad del contenido.

## Enlaces
- Se utilizan elementos `<a>` para enlazar a diferentes páginas web o recursos.

## Imágenes
- Se utilizan elementos `<img>` para mostrar imágenes con sus atributos `src` para la fuente de la imagen y `alt` para descripción alternativa en caso de que la imagen no se cargue.

## Estilo
- Se hace referencia a un archivo CSS local (`styles.css`) y a la biblioteca Font Awesome a través de una URL externa para aplicar estilos y agregar iconos respectivamente.


# Descripción detallada del código HTML: Contacto

## Encabezado
- `<head>`: Contiene metadatos y enlaces a recursos externos.
  - `<meta charset="UTF-8">`: Especifica el conjunto de caracteres como UTF-8 para admitir caracteres especiales.
  - `<meta name="viewport" content="width=device-width, initial-scale=1.0">`: Configura la escala inicial y el ancho del viewport para dispositivos móviles.
  - `<title>Contacto</title>`: Define el título de la página que se mostrará en la pestaña del navegador.
  - `<link rel="stylesheet" href="styles.css">`: Enlaza una hoja de estilos CSS local para estilizar el contenido de la página.
  - `<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>`: Enlaza la biblioteca Font Awesome para utilizar iconos.

## Cuerpo del documento
- `<header>`: Encabezado de la página que contiene el logotipo y el menú de navegación.
- `<main>`: Contenedor principal que incluye el formulario de contacto y la información de contacto.
  - Formulario de contacto: Permite a los usuarios enviar mensajes al sitio web.
  - Información de contacto: Proporciona detalles de contacto como teléfono, correo electrónico y dirección.

## Pie de página
- `<footer>`: Pie de página de la página web que contiene información adicional.
  - Contiene secciones como "Sobre nosotros", "Horario", "Enlaces" y "Contáctanos" con información relevante y enlaces útiles.
- `<div class="copyrightText">`: Contiene el texto de derechos de autor que indica la propiedad del contenido.

## Enlaces y recursos adicionales
- Se utilizan elementos `<a>` para enlazar a diferentes páginas web o recursos.
- Se hace referencia a archivos CSS locales y a la biblioteca Font Awesome para aplicar estilos y agregar iconos respectivamente.


# Descripción detallada del código HTML: Términos y Condiciones

## Encabezado
- `<head>`: Contiene metadatos, enlaces a recursos externos y estilos CSS internos.
  - `<meta charset="UTF-8">`: Especifica el conjunto de caracteres como UTF-8 para admitir caracteres especiales.
  - `<meta name="viewport" content="width=device-width, initial-scale=1.0">`: Configura la escala inicial y el ancho del viewport para dispositivos móviles.
  - `<title>Términos y Condiciones</title>`: Define el título de la página que se mostrará en la pestaña del navegador.
  - `<link rel="stylesheet" href="styles.css">`: Enlaza una hoja de estilos CSS local para estilizar el contenido de la página.
  - `<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>`: Enlaza la biblioteca Font Awesome para utilizar iconos.
  - Estilos CSS internos: Se definen estilos adicionales para elementos específicos dentro de la página, como la alineación del texto y el color de los enlaces.

## Cuerpo del documento
- `<header>`: Encabezado de la página que contiene el logotipo y el menú de navegación.
- `<div class="contenedor_terminos">`: Contenedor que contiene la información de los términos y condiciones.
  - Contiene una serie de elementos `<h2>` y `<p>` que describen los términos y condiciones de uso del sitio web.

## Pie de página
- `<footer>`: Pie de página de la página web que contiene información adicional.
  - Contiene secciones como "Sobre nosotros", "Horario", "Enlaces" y "Contáctanos" con información relevante y enlaces útiles.

## Enlaces y recursos adicionales
- Se utilizan elementos `<a>` para enlazar a diferentes páginas web o recursos.
- Se hace referencia a archivos CSS locales y a la biblioteca Font Awesome para aplicar estilos y agregar iconos respectivamente.


# Descripción detallada del código HTML: Política de privacidad

## Encabezado
- `<head>`: Contiene metadatos, enlaces a recursos externos y estilos CSS internos.
  - `<meta charset="UTF-8">`: Especifica el conjunto de caracteres como UTF-8 para admitir caracteres especiales.
  - `<meta name="viewport" content="width=device-width, initial-scale=1.0">`: Configura la escala inicial y el ancho del viewport para dispositivos móviles.
  - `<title>Política de Privacidad</title>`: Define el título de la página que se mostrará en la pestaña del navegador.
  - `<link rel="stylesheet" href="styles.css">`: Enlaza una hoja de estilos CSS local para estilizar el contenido de la página.
  - `<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>`: Enlaza la biblioteca Font Awesome para utilizar iconos.
  - Estilos CSS internos: Se definen estilos adicionales para elementos específicos dentro de la página, como la alineación del texto y el color.

## Cuerpo del documento
- `<header>`: Encabezado de la página que contiene el logotipo y el menú de navegación.
- `<div class="contenedor_politica">`: Contenedor que contiene la información de la política de privacidad.
  - Contiene una serie de elementos `<h2>` y `<p>` que describen la política de privacidad del sitio web.

## Pie de página
- `<footer>`: Pie de página de la página web que contiene información adicional.
  - Contiene secciones como "Sobre nosotros", "Horario", "Enlaces" y "Contáctanos" con información relevante y enlaces útiles.

## Enlaces y recursos adicionales
- Se utilizan elementos `<a>` para enlazar a diferentes páginas web o recursos.
- Se hace referencia a archivos CSS locales y a la biblioteca Font Awesome para aplicar estilos y agregar iconos respectivamente.


# Descripción detallada del código CSS

## Importación de fuentes
- Se importa la fuente "Poppins" desde Google Fonts para utilizarla en el documento.

## Estilos generales
- `*`: Se establecen propiedades de borde, margen, relleno y lista predeterminadas para todos los elementos del documento.
- `body`: Se configuran estilos específicos para el cuerpo del documento, incluyendo la fuente, el color de fondo y la disposición flexbox.
- `header`: Estilos para el encabezado de la página, como fondo, altura y disposición flexbox.
- `.contenido-cabecera`, `.titulo-header`, `.contenido-nav`: Estilos específicos para diferentes partes del encabezado, como alineación, espaciado y colores.

## Animación de menú de navegación
- `@keyframes blink`: Definición de una animación de parpadeo para un efecto visual.
- `nav ul li a::after`: Estilos para el efecto de subrayado en los enlaces del menú de navegación.
- Media queries: Estilos específicos para pantallas de hasta 768px de ancho para ajustar el tamaño del texto del encabezado.

## Estilos para la galería de imágenes
- `.introduccion-texto`, `.contenedor-introduccion`, `.contenedor-galeria`, `.galeria`: Estilos para la introducción y visualización de la galería de imágenes.

## Estilos para los cuadros laterales
- `.cuadro-izquierda`, `.cuadro-derecha`: Estilos para los cuadros laterales, incluyendo posición, tamaño, relleno, color de fondo y borde.

## Estilos para el menú hamburguesa (para dispositivos móviles)
- Estilos específicos para mostrar un menú hamburguesa en dispositivos móviles, incluyendo transiciones y efectos visuales.

## Estilos para el formulario de contacto
- `.izquierda`, `.derecha`: Estilos para los lados izquierdo y derecho del formulario de contacto, incluyendo fondo, bordes y relleno.
- Estilos para etiquetas, campos de entrada y botón de envío del formulario.

## Estilos para la sección de actividades
- `.intro-text`, `.contenedor-introduccion`, `.contenedor-tarjetas`, `.tarjeta`: Estilos para la introducción y visualización de la sección de actividades.

## Estilos para el pie de página
- `footer`, `.contenedor`, `.copyrightText`: Estilos para el pie de página, incluyendo disposición, color de fondo, padding y borde.
- Estilos específicos para diferentes partes del pie de página, como enlaces, iconos de redes sociales y horario de atención.

## Media queries
- Media queries adicionales para ajustar estilos en dispositivos con una anchura máxima de 768px.