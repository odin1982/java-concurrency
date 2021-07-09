# Java 8 Concurrency Tutorial: Threads and Executors

## Concurrencia
    La propiedad de ejecutar multiples Threads y proceso al mismo tiempo

## Process
    Un grupo de Threads que pueden ser ejecutados en el mismo ambiente.

## Thread
    Unidad mas pequeña de ejecution que puede ser agendada por el sitema operativo.

## Task
    Code executed by the Thread, this is done with the Interface Runnable

## Runnable
    Functional Interface defining a single VOID NO-ARGS method run()
    - No retorna nada
    - Sin argumentos

    () -> System.out.println("Thread");         // OK
    () -> ""                                    //DOES NOT COMPILE return a String