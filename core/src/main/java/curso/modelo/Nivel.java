package curso.modelo;

public enum Nivel {
    INICIAL, MEDIO, AVANZADO;
    public static Nivel fromString(String nivel) {

        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel es obligatorio");
        }
        try {

            return Nivel.valueOf(nivel.toUpperCase());
        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException("El nivel debe ser Inicial, Medio o Avanzado");
        }
    }
}
