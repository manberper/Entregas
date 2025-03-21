package UD5Tarea3_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaTest {
    @Test
    public void testToString(){
        Cilindro cilindro = new Cilindro("Cilindro1",2.2,3.3);
        Esfera esfera = new Esfera("Esfera1",1.1);
        Rectangulo rectangulo = new Rectangulo("Rectangulo1",4.4,5.5);
        assertEquals("Cilindro: nombre: Cilindro1 radio: 2.2 altura: 3.3", cilindro.toString());
        assertEquals("Esfera: nombre: Esfera1 radio: 1.1", esfera.toString());
        assertEquals("Rectangulo: nombre: Rectangulo1 longitud: 4.4 ancho: 5.5",rectangulo.toString());
    }

    @Test
    public void testArea(){
        Cilindro cilindro = new Cilindro("Cilindro1",2.2,3.3);
        Esfera esfera = new Esfera("Esfera1",1.1);
        Rectangulo rectangulo = new Rectangulo("Rectangulo1",4.4,5.5);
        assertEquals(76.026542216873,cilindro.area());
        assertEquals(15.205308443374602,esfera.area());
        assertEquals(24.200000000000003,rectangulo.area());
    }

}