public interface DataParser<T> {
    T parse(String line) throws Exception;
}
