package br.univel.classes;

public enum EstadoCivil {

	Solteiro,
	Casado,
	Viuvo;

	public static final EstadoCivil getPorCodigo(int value){
        for (EstadoCivil item : EstadoCivil.values()) {
            if (item.ordinal() == value) {
            	return item;
            }
        }
		throw new RuntimeException("Valor n�o encontrado: " + value);
	}
}
