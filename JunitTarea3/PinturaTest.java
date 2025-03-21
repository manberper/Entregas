package UD5Tarea3_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinturaTest {
    @Test
    public void testPintura(){
        Pintura pintura = new Pintura(250);
        Cilindro cilindro = new Cilindro("Cilindro1",2.2,3.3);
        Esfera esfera = new Esfera("Esfera1",1);
        Rectangulo rectangulo = new Rectangulo("Rectangulo1",4.4,5.5);

        assertEquals(0.304106168867492,pintura.pinturaNecesaria(cilindro));
        assertEquals(0.05026548245743669,pintura.pinturaNecesaria(esfera));
        assertEquals(0.09680000000000001,pintura.pinturaNecesaria(rectangulo));
    }

}