package tema5.azure.cloud.transformers;

public interface Transformer <T, T2> {
	public T2 toDTO (T object);
	public T toModel (T2 object);
}
