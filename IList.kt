/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto EAN Java Collections
 * @author UniversidadEAN
 * Fecha: Mar 05, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.listas

/**
 * Una lista es una estructura lineal compuesta por una secuencia de 0 o más elementos.
 * Esta interface representa las operaciones que las diversas implementaciones de la
 * lista debe realizar.
 * @param <T> Tipo de datos a almacenar en la lista. Los objetos de tipo T deben
 * tener bien definidos el método <b>equals</b>
 * @author UniversidadEAN
 */
interface IList<T> : Iterable<T> {

    /**
     * Retorna un iterador sobre los elementos de esta secuencia de elementos
     */
    override fun iterator(): Iterator<T>

    /**
     * Retorna `true` si la lista está vacía (no contiene elementos), `false` si tiene al menos un elemento
     */
    val isEmpty: Boolean

    /**
     * Retona el número de elementos que hacen parte de la lista
     */
    val size: Int

    /**
     * Verifica si el elemento especificado hace parte de la lista o no
     */
    operator fun contains(element: T): Boolean = indexOf(element) >= 0

    /**
     * Agrega un elemento al final de la lista
     */
    fun add(element: T): Unit

    /**
     * Agrega todos los elementos de la lista dada a esta lista
     */
    fun addAll(elements: IList<T>) {
        for (elem in elements) {
            this.add(elem)
        }
    }

    /**
     * Agrega un nuevo elemento al principio de la lista
     */
    fun addToHead(element: T)

    /**
     * Agrega un elemento en la posición específica de la lista
     */
    fun add(position: Int, element: T): Unit

    /**
     * Elimina el elemento que se encuentra en la posición indicada
     */
    fun remove(position: Int): Unit

    /**
     * Elimina el primer elemento de la lista
     */
    fun removeFirst()

    /**
     * Elimina el último elemento de la lista
     */
    fun removeLast()

    /**
     * Elimina la primera ocurrencia del elemento especificado
     */
    fun removeElement(element: T): Unit

    /**
     * Elimina todos los elementos de esta lista
     */
    fun clear(): Unit

    /**
     * Retorna el elemento que se encuentra una determinada posición de la lista
     */
    operator fun get(position: Int): T

    /**
     * Retorna el elemento que se encuentra en la primera posición de la lista
     *
     */
    fun head(): T

    val first:T
        get() = head()

    /**
     * Obtener el ultimo elemento de la lista
     */
    val last: T
        get() = get(size - 1)

    /**
     * Retorna la lista sin el primer elemento. Es una copia de esta lista, no modifica la lista que recibe el
     * mensaje correspondiente
     */
    fun tail(): IList<*>

    /**
     * Retorna el índice de la primer ocurrencia del elemento especificado en la lista, o -1 si el elemento dado no
     * existe en la lista
     */
    fun indexOf(element: T): Int

    /**
     * Retorna el índice de la última ocurrencia del elemento dado en la lista, o -1 si el elemento dado no existe en
     * la lista
     */
    fun lastIndexOf(element: T): Int

    /**
     * Reemplaza el elemento en la posición especificada en la lista por elemento dado
     *
     */
    operator fun set(position: Int, element: T)

    /**
     * Obtiene una copia idéntica de esta lista.
     */
    fun copy(): IList<T>

    /**
     * Obtiene un rango con los índices válidos de la lista actual
     */
    val indices: IntRange
        get() = IntRange(0, size - 1)
}
