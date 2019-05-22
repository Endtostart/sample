package pattern.chain;

import java.util.ArrayList;
import java.util.List;

public class DefaultFilterChain implements FilterChain {

    private static int postion ;
    private List<Filter> filters = new ArrayList<>();
    private static DefaultFilterChain chain = null;

    private DefaultFilterChain() {

    }

    public static FilterChain init(List<Filter> filters) {
        if (chain == null) {
            chain = new DefaultFilterChain();
        }
        chain.filters = filters;
        postion = 0;
        for (Filter filter : filters) {
            filter.init();
        }
        return chain;
    }

    @Override
    public void doFilter(String req, String res) {
        if (postion < filters.size()) {
            Filter currentFilter = filters.get(postion++);
            currentFilter.doFilter(req, res, this);
        }
    }
}
