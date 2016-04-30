package br.univel.classes;

public enum EstadoCivil {

	Solteiro,
	Casado,
	Viuvo;

	public static final EstadoCivil getPorid(int valor){
        for (EstadoCivil ec : EstadoCivil.values()) {
            if (ec.ordinal() == valor) {
            	return ec;
            }
        }
		throw new RuntimeException("Valor não encontrado: " + valor);
	}
}
