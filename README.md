[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/t19xNtmg)
CS(20)

d.4 - Quand plusieurs CompteARebours (par ex. 10) s’exécutent en parallèle :
    La classe DummyTimeServiceImpl parcourt la même liste de listeners (LinkedList) pendant que certains s’y désinscrivent.
    Cela peut provoquer une ConcurrentModificationException.

    