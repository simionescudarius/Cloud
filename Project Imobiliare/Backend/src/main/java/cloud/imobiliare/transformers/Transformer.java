package cloud.imobiliare.transformers;

public interface Transformer <T, T2> {
	T2 toDTO (T object);
	T toModel (T2 object);
}
