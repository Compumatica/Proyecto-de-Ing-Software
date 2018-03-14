# Metodología de trabajo

## 1. Formato de las versiones

Se seguirá una notación numérica compuesta por dos números separados por puntos, seguidos de un carácter opcional (b):

<p align="center">major.minor[b]</p>

Cada uno de estos números tienen el siguiente significado:

* major: Versión principal del software.
* minor: Funcionalidad menor cubierta en la versión de software.
* b: Bug-fixes: No se ha implementado ninguna funcionalidad, sólo se han eliminado algunos bugs.

El criterio a seguir para denotar una versión será el siguiente:

1. Si se ha añadido una funcionalidad muy importante, incrementamos el primer número (major) y el segundo pasa a ser un cero (minor). Por ejemplo, si la versión actual es 1.2, la nueva sería 2.0.

2. Si se ha añadido una funcionalidad que modifica ligeramente el software y no supone un gran cambio en el sistema, se incrementa sólo el segundo número (minor). Por ejemplo, si la versión actual es 0.29, la nueva versión sería 0.30.

3. Si no se ha añadido nada, pero se ha modificado el código para solucionar bugs, añadimos el carácter b al final del código de la versión. Por ejemplo, si la versión actual es 0.3, la nueva sería 0.3b.

4. Sería conveniente que el segundo número no fuera mayor que 20. Si lo fuera, se podría proceder como si se hubiera añadido una funcionalidad muy importante (véase el primer apartado).
