/*
C07_HilosReloj
Qué hace:
  - Crea un hilo que imprime la hora cada segundo durante 10 segundos.
  - Muestra el ciclo de vida básico de un hilo (start, run, sleep).

Objetivo de aprendizaje de la clase:
  - Comprender concurrencia básica con Thread/Runnable.
  - Usar sleep y manejo de interrupciones.

Siguientes pasos para modificar (alumno):
  - Crear un temporizador que ejecute una tarea (p. ej., autoguardado).
  - Lanzar dos hilos y sincronizarlos (join).
  - Investigar Executors y ScheduledExecutorService.
*/

import java.time.LocalTime;

public class C07_HilosReloj {
    public static void main(String[] args) {
        Thread reloj = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hora: " + LocalTime.now());
                try {
                    Thread.sleep(1000); // 1 segundo
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido.");
                    return;
                }
            }
        });

        System.out.println("Iniciando hilo reloj...");
        reloj.start();
        try {
            reloj.join();
        } catch (InterruptedException e) {
            System.out.println("Join interrumpido.");
        }
        System.out.println("Hilo finalizado.");
    }
}
