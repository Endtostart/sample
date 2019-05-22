package pattern.chain;

public interface Filter {

    public void init();

    public void doFilter(String req, String res, FilterChain chain);
}
