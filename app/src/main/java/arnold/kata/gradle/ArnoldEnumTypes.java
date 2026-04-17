package arnold.kata.gradle;

/**
 * Hello world!
 */
public class ArnoldEnumTypes {
    public static void main(String[] args) {

        Double peso = 0.0;
        Planetas planetaConsola;

        if (args.length !=2){
            System.err.println("Longitud incorrecta. Debe haber 2 argumentos.");
            System.exit(0);
        }

        try {

            peso = Double.parseDouble(args[0]);
            planetaConsola = Planetas.valueOf(args[1].toUpperCase());

            System.out.println("Calculos en planeta seleccionado:");        
            String resultadoConsola = String.format("Tu peso en %s es %f", planetaConsola.name(), planetaConsola.pesoPersonaSuperficie(peso));
            System.out.println(resultadoConsola);
            System.out.println("------------------------------------------");
        } 
        catch (NumberFormatException exception){

            System.err.println("Peso incorrecto, no es un número.");
            System.out.println("--------------------------------------");
            System.out.println();
            peso = 1.0;
        }
        finally {

            peso = 1.0;
            System.out.println("Calculos de todos los planetas con el peso por defecto 1.0kg:");
            System.out.println();
            System.out.println("Tu peso en los planetas terrestres:");
            for(Planetas planeta : Planetas.getPlanetasTerrestres()){
                String resultado = String.format("Tu peso en %s es %f", planeta.name(), planeta.pesoPersonaSuperficie(peso));
                System.out.println(resultado);
            }


            System.out.println("Tu peso en los gigantes gaseosos:");
            for(Planetas planeta : Planetas.getGigantesGaseosos()){
                String resultado = String.format("Tu peso en %s es %f", planeta.name(), planeta.pesoPersonaSuperficie(peso));
                System.out.println(resultado); /* name() devuelve el nombre como string */
            }

            System.out.println("Tu peso en los gigantes de hielo:");
            for(Planetas planeta : Planetas.getPlanetasHelados()){
                String resultado = String.format("Tu peso en %s es %f", planeta.name(), planeta.pesoPersonaSuperficie(peso));
                System.out.println(resultado);
            }
        }
    }
}
