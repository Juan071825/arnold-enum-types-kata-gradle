package arnold.kata.gradle;

import java.util.EnumSet;

public enum Planetas {
    
    MERCURIO(3.303e+23, 2.4397e+6), /* Notación científica, se interpreta como 2,4397^6 */
    VENUS(4.869e+24, 6.0518e6),
    TIERRA(5.976e+24, 6.37814e6),
    MARTE(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27,   7.1492e7),
    SATURNO(5.688e+26, 6.0268e7),
    URANO(8.686e+25, 2.5559e7),
    NEPTUNO(1.024e+26, 2.4746e7);


    public static final double G = 6.67400e-11;

    private double masa; /* private impide que la información de cada planeta */
    private double radio; /* sea modificada una vez creada la instancia. */

    private Planetas(double masa, double radio){ /* debe de ser privado porque solo se tiene que crear una vez (Patrón Singleton) */
        this.masa = masa; /* this se refiere a una instancia en específico */
        this.radio = radio;
    }


    public double getMasa(){
        return this.masa;
    }

    public double getRadio(){
        return this.radio;
    }

    public double gravedadSuperficial(){
        return G * this.masa / Math.pow(this.radio, 2); /* Math.pow(base, exponente) */
    }

    public double gravedadSuperficial(Planetas planeta){ /* Sobrecarga de métodos, Java distingue ambos por los parámetros que recibe */
        return G * planeta.getMasa() / Math.pow(planeta.getRadio(), 2);
    }

    public double masaPersona(double peso){
        return peso / this.gravedadSuperficial(TIERRA);
    }

    public double pesoPersonaSuperficie(double peso){
        return masaPersona(peso) * this.gravedadSuperficial();
    }

    public static EnumSet<Planetas> getPlanetasTerrestres(){ /* EnumSet agrupa elementos de un enum */
        return EnumSet.range(MERCURIO, MARTE); /* EnumSet.range(inicio, fin) ambos inclusive */
    }

    public static EnumSet<Planetas> getGigantesGaseosos(){
        return EnumSet.range(JUPITER, SATURNO);
    }

    public static EnumSet<Planetas> getPlanetasHelados(){
        return EnumSet.range(URANO, NEPTUNO);
    }
}